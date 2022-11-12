package com.kodluyoruz.eticaret.Service;
import com.kodluyoruz.eticaret.Dto.OrderRequestDto;
import com.kodluyoruz.eticaret.Dto.OrderResponseDto;
import com.kodluyoruz.eticaret.Model.Item;
import com.kodluyoruz.eticaret.Model.Order;
import com.kodluyoruz.eticaret.Model.User;
import com.kodluyoruz.eticaret.Repository.ItemRepository;
import com.kodluyoruz.eticaret.Repository.OrderRepository;
import com.kodluyoruz.eticaret.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author sevgidemir
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Order> getAllOrder(){

        return orderRepository.findAll();
    }

    public Order saveOrder (OrderRequestDto orderRequestDto){

        User user=this.userRepository.findByUserId(orderRequestDto.getUserId());
        Order order=new Order();
        order.setItemId(orderRequestDto.getItemId());
        order.setNumberOfOrder(orderRequestDto.getNumberOfOrder());
        order.setUser(user);
        return orderRepository.save(order);
    }

    public String deleteOrder(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.delete(order.get());
            return "Record Deleted!!";
        }
        return null;
    }

    public OrderResponseDto getOrder(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            Optional<Item> items = itemRepository.findById(order.get().getItemId());
            Optional<User> user = userRepository.findById(order.get().getUser().getUserId());
            String itemName = items.isPresent() ? items.get().getItemName() : null;
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setItemName(itemName);
            orderResponseDto.setItemId(order.get().getItemId());
            orderResponseDto.setName(user.get().getName());
            orderResponseDto.setMobile(user.get().getMobile());
            orderResponseDto.setUserEmail(order.get().getUser().getEmail());
            return orderResponseDto;
        }
        else {
            return null;
        }
    }

}
