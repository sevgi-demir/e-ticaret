package com.kodluyoruz.eticaret.Service;
import com.kodluyoruz.eticaret.Dto.ItemRequestDto;
import com.kodluyoruz.eticaret.Dto.ItemResponseDto;
import com.kodluyoruz.eticaret.Dto.ItemUpdateRequestDto;
import com.kodluyoruz.eticaret.Model.Category;
import com.kodluyoruz.eticaret.Model.Item;
import com.kodluyoruz.eticaret.Repository.CategoryRepository;
import com.kodluyoruz.eticaret.Repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sevgidemir
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;


    public Item saveItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setItemName(itemRequestDto.getItemName());
        item.setItemNo(itemRequestDto.getItemNo());
        item.setItemPrice(itemRequestDto.getItemPrice());
        item.setItemStock(itemRequestDto.getItemStock());

        Category category=this.categoryRepository.findByCategoryId(itemRequestDto.getCategoryId());
        item.setCategory(category);


        return itemRepository.save(item);

    }

    public List<ItemResponseDto> getAllItem (){
        List<Item> items=this.itemRepository.findAll();
        List<ItemResponseDto> responseDtoList=this.itemListConverToDtoList(items);
        return responseDtoList;
    }

    public ItemResponseDto getItem(int itemId) {
        Item item = itemRepository.findAll().get(itemId-1);
        ItemResponseDto itemResponseDto=this.modelMapper.map(item,ItemResponseDto.class);
        return itemResponseDto;
    }

    public String deleteItem(int id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            itemRepository.delete(item.get());
            return "Record Deleted!!";
        }
        return null;
    }

    public String updateItem(ItemUpdateRequestDto itemUpdateRequestDto) {
        if (this.itemRepository.findAll().get(itemUpdateRequestDto.getItemId()) == null) {
            return "You are not have this {" + itemUpdateRequestDto.getItemName() + "} product.";
        }
        Item item=this.itemRepository.findAll().get(itemUpdateRequestDto.getItemId());
        item.setItemName(itemUpdateRequestDto.getItemName());
        item.setItemNo(itemUpdateRequestDto.getItemNo());
        item.setItemPrice(itemUpdateRequestDto.getItemPrice());
        item.setItemStock(itemUpdateRequestDto.getItemStock());
        Category category=this.categoryRepository.findAll().get(itemUpdateRequestDto.getCategoryId());
        item.setCategory(category);
        this.itemRepository.save(item);
        return "Successful";
    }

    public List<ItemResponseDto> getAllByCategoryId(long id){
        List<Item> items=this.itemRepository.getAllByCategory_CategoryId(id);
        List<ItemResponseDto> responseDtoList=this.itemListConverToDtoList(items);
        return responseDtoList;
    }

    List<ItemResponseDto> itemListConverToDtoList(List<Item> items){
        List<ItemResponseDto> itemResponseDtoList=new ArrayList<>();
        for (Item item : items) {
            ItemResponseDto itemResponseDto=this.modelMapper.map(item,ItemResponseDto.class);
            itemResponseDtoList.add(itemResponseDto);
        }
        return itemResponseDtoList;

        //return items.stream().map(x->modelMapper.map(x,ItemResponseDto.class)).collect(Collectors.toList());
    }

}

