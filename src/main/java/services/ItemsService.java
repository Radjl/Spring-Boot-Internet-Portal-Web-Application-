package services;


import models.ItemIt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.InventoryItRepo;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class ItemsService {
    @Autowired
    private InventoryItRepo inventoryIt;


    @Value("${upload.pathinventory}")
    private String uploadPath;

    public Iterable<ItemIt> findall() {

        return inventoryIt.findAll();

    }

    public void addItem(String name, MultipartFile file, String uploadPath, int usefulllife, String date, String invent, String serial , String dislocation) throws IOException, ParseException {
        ItemIt itemIt = new ItemIt();
        itemIt.setName(name);
        itemIt.setSrokEkspluatacii(usefulllife);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        itemIt.setVvodEkspluatacii(sdf.parse(date));
        itemIt.setInventoryNumber(invent);
        itemIt.setSerialNumber(serial);
        itemIt.setDislocation(dislocation);






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




    public void deleteItemById(int id) {


        inventoryIt.deleteById((long) id);



    }

    public void updateDeatil(Boolean checkbox, ItemIt itemIt,String first,String second,String third, MultipartFile file) throws IOException {

        ItemIt item = inventoryIt.findItemItById(itemIt.getId());



        if (checkbox){
            item.setBroken(true);
        }else
            item.setBroken(false);

        if (first!=null){
            item.setFirstBroke(first);
        }

        if (second!=null){
            item.setSecondBroke(second);
        }

        if (third!=null){
            item.setThirdBroke(third);
        }

       if (!file.isEmpty()){
           String uuidFile = UUID.randomUUID().toString();
           String result = uuidFile + "." + file.getOriginalFilename();

           file.transferTo(new File(uploadPath + "/" + result));
           item.setImg(result);
       }



        inventoryIt.save(item);


    }
}
