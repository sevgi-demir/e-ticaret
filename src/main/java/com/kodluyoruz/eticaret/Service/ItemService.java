package com.kodluyoruz.eticaret.Service;
import com.kodluyoruz.eticaret.Dto.ItemRequestDto;
import com.kodluyoruz.eticaret.Dto.ItemUpdateRequestDto;
import com.kodluyoruz.eticaret.Model.Item;
import com.kodluyoruz.eticaret.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author sevgidemir
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item saveItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setItemName(itemRequestDto.getItemName());
        item.setItemNo(itemRequestDto.getItemNo());
        item.setItemPrice(itemRequestDto.getItemPrice());
        item.setNoOfItem(itemRequestDto.getNoOfItem());
        Item items;

        return itemRepository.save(item);

    }

    public List<Item> getAllItem (){
        return itemRepository.findAll();
    }

    public Item getItem(int itemId) {
        Optional<Item> items = itemRepository.findById(itemId);
        return items.isPresent() ? items.get() : null;
    }

    public String deleteItem(int id) {
        Optional<Item> items = itemRepository.findById(id);
        if (items.isPresent()) {
            itemRepository.delete(items.get());
            return "Record Deleted!!";
        }
        return null;
    }

    public Item updateItem(ItemUpdateRequestDto itemUpdateRequestDto, int id) {
        Optional<Item> items = itemRepository.findById(id);
        if (items.isPresent()) {
            items.get().setNoOfItem(itemUpdateRequestDto.getNoOfItem());
            items.get().setItemPrice(itemUpdateRequestDto.getItemPrice());
            return itemRepository.save(items.get());
        }
        return null;
    }


}
