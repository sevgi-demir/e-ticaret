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

    @PostMapping("/save")
    public String saveOrder(@RequestBody OrderRequestDto order) {
        this.orderService.saveOrder(order);
        return "Add order successful!";
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOrder(@RequestParam int orderId){
        String orders = orderService.deleteOrder(orderId);
        return ( orders != null )
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Record Not Found!");
    }

    @GetMapping("/fetchById")
    public ResponseEntity<?> getOrder(@RequestParam int orderId){
        OrderResponseDto orderResponseDto =  orderService.getOrder(orderId);
        return ( orderResponseDto != null )
                ? new ResponseEntity<>(orderResponseDto, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Record Not Found!");
    }
}
