package com.kodluyoruz.eticaret.Service;
import com.kodluyoruz.eticaret.Dto.OrderRequestDto;
import com.kodluyoruz.eticaret.Dto.OrderResponseDto;
import com.kodluyoruz.eticaret.Model.Item;
import com.kodluyoruz.eticaret.Model.Order;
import com.kodluyoruz.eticaret.Model.User;
import com.kodluyoruz.eticaret.Repository.ItemRepository;
import com.kodluyoruz.eticaret.Repository.OrderRepository;
import com.kodluyoruz.eticaret.Repository.UserRepository;
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

    public List<Order> getAllOrder(){
        List<Order> orders = orderRepository.findAll();
        return null;
    }

    public Order saveOrder (OrderRequestDto orderRequestDto){
        Order orders = new Order();
        orders.setItemId(orderRequestDto.getItemId());
        orders.setNoOfOrder(orderRequestDto.getNoOfOrder());
        return orderRepository.save(orders);
    }

    public OrderResponseDto getOrder(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            Optional<Item> items = itemRepository.findById(order.get().getItemId());
            Optional<User> user = userRepository.findById(order.get().getUserId());
            String itemName = items.isPresent() ? items.get().getItemName() : null;
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setItemName(itemName);
            orderResponseDto.setItemId(order.get().getItemId());
            orderResponseDto.setName(user.get().getName());
            orderResponseDto.setMobile(user.get().getMobile());
            orderResponseDto.setUserEmail(order.get().getUserEmail());
            return orderResponseDto;
        }
        else {
            return null;
        }
    }


}
