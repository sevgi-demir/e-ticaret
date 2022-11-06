package com.kodluyoruz.eticaret.Controller;
import com.kodluyoruz.eticaret.Dto.OrderRequestDto;
import com.kodluyoruz.eticaret.Dto.OrderResponseDto;
import com.kodluyoruz.eticaret.Model.Order;
import com.kodluyoruz.eticaret.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author sevgidemir
 */

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/save")
    public Order saveOrder(@RequestBody OrderRequestDto order) {
        return orderService.saveOrder(order);
    }


    @GetMapping("/getAll")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/orderId")
    public ResponseEntity<?> getOrder(@RequestParam int orderId){
        OrderResponseDto orderResponseDto =  orderService.getOrder(orderId);
        return ( orderResponseDto != null )
                ? new ResponseEntity<>(orderResponseDto, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Record Not Found!");
    }
}
