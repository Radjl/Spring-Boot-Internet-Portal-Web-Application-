package services;


import models.ItemIt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.InventoryItRepo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ItemsService {
    @Autowired
    private InventoryItRepo inventoryIt;



    public Iterable<ItemIt> findall() {

        return inventoryIt.findAll();

    }

    public void addItem(String name, MultipartFile file, String uploadPath) throws IOException {
        ItemIt itemIt = new ItemIt(name);


       // String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
       // Ship ship = new Ship(timeStamp,shipname,description);

        if (file !=null){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String result = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + result));
            itemIt.setImg(result);
        }

        inventoryIt.save(itemIt);


    }




    public void deleteItemById(String id) {

        Long id2 = Long.valueOf(id);
        inventoryIt.deleteById(id2);



    }
}
