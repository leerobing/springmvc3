package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void clearStore() {

        itemRepository.clearStore();
    }


    @Test
    void save(){

        //given
        Item item = new Item();
        item.setItemName("book");
        item.setPrice(1000);
        item.setQuantity(30);
        //when
        Item saveItem = itemRepository.save(item);
        Item byId = itemRepository.findById(saveItem.getId());

        //then
        Assertions.assertThat(byId).isEqualTo(saveItem);

    }
    @Test
    void findById() {
        //given
        Item item = new Item();
        item.setItemName("book");
        item.setPrice(1000);
        item.setQuantity(30);

        Item item2 = new Item();
        item.setItemName("cake");
        item.setPrice(2000);
        item.setQuantity(10);

        Item save1 = itemRepository.save(item);
        Item save2 = itemRepository.save(item2);

        Item byId = itemRepository.findById(save1.getId());

        Assertions.assertThat(byId).isEqualTo(save1);

    }

    @Test
    void findAll() {

    }

    @Test
    void update() {
        //g
        Item item = new Item();
        item.setItemName("book");
        item.setPrice(1000);
        item.setQuantity(30);

        Item saveItem = itemRepository.save(item);


        //w
        Item updateParam = new Item();
        updateParam.setItemName("e-book");
        updateParam.setPrice(2000);
        updateParam.setQuantity(500);

        Item updateItem = itemRepository.update(saveItem.getId(), updateParam);

        //t
        Assertions.assertThat(updateItem.getId()).isEqualTo(saveItem.getId());
    }


}