package com.kodluyoruz.eticaret.Controller;

import com.kodluyoruz.eticaret.Dto.ItemRequestDto;
import com.kodluyoruz.eticaret.Dto.ItemUpdateRequestDto;
import com.kodluyoruz.eticaret.Model.Item;
import com.kodluyoruz.eticaret.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author sevgidemir
 */

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemRequestDto item) {
        this.itemService.saveItem(item);
        return "Add product successful!";
    }


    @GetMapping("/getAll")
    public List<Item> getAllItems() {
        return itemService.getAllItem();
    }

    @GetMapping("/itemId")
    public ResponseEntity<?> getItem(@RequestParam int itemId){
        Item items = itemService.getItem(itemId);
        return ( items != null )
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Available!");
    }

    @DeleteMapping("/itemId")
    public ResponseEntity<?> deleteItem(@RequestParam int itemId){
        String res = itemService.deleteItem(itemId);
        return ( res != null )
                ? new ResponseEntity<>(res, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Record Not Found!");
    }

    @PutMapping("/itemId")
    public ResponseEntity<?> updateItem(@RequestBody ItemUpdateRequestDto itemUpdateRequestDTO, @PathVariable int itemId) {
        Item items =  itemService.updateItem(itemUpdateRequestDTO, itemId);
        return (items != null)
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Record Not Found!");
    }

}
