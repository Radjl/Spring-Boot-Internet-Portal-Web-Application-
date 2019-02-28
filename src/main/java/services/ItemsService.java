package services;


import models.ItemIt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InventoryItRepo;

@Service
public class ItemsService {
    @Autowired
    private InventoryItRepo inventoryIt;



    public Iterable<ItemIt> findall() {

        return inventoryIt.findAll();

    }

    public void addItem(String name) {
        ItemIt itemIt = new ItemIt(name);
        inventoryIt.save(itemIt);



    }

    public void deleteItemById(String id) {

        Long id2 = Long.valueOf(id);
        inventoryIt.deleteById(id2);



    }
}
