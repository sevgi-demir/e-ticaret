package com.kodluyoruz.eticaret.Controller;
import com.kodluyoruz.eticaret.Dto.ItemRequestDto;
import com.kodluyoruz.eticaret.Dto.ItemResponseDto;
import com.kodluyoruz.eticaret.Dto.ItemUpdateRequestDto;
import com.kodluyoruz.eticaret.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public String saveItem(@Valid @RequestBody ItemRequestDto item) {
        this.itemService.saveItem(item);
        return "Add product successful!";
    }

    @GetMapping("/getAll")
    public List<ItemResponseDto> getAllItems() {
        return itemService.getAllItem();
    }

    @GetMapping("/fetchById")
    public ResponseEntity<?> getItem(@RequestParam int itemId){
        ItemResponseDto item = itemService.getItem(itemId);
        return ( item != null )
                ? new ResponseEntity<>(item, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Available!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteItem(@RequestParam int itemId){
        String item = itemService.deleteItem(itemId);
        return ( item != null )
                ? new ResponseEntity<>(item, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Record Not Found!");
    }

    @PostMapping("/update")
    public String updateItem(@RequestBody ItemUpdateRequestDto itemUpdateRequestDto){
        return this.itemService.updateItem(itemUpdateRequestDto);
    }

    @GetMapping("/getallbyid")
    public List<ItemResponseDto> getAllByCategory(@RequestParam  long id){
        return this.itemService.getAllByCategoryId(id);
    }

}
