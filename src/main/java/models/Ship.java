package models;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shipname;
    private String description;
    private String img;
    private String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());







    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "ship",orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Images> images = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "ship",orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<shipMessage> shipmessage = new ArrayList<>();

    public List<shipMessage> getShipmessage() {
        return shipmessage;
    }

    public void setShipmessage(List<shipMessage> shipmessage) {
        this.shipmessage = shipmessage;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getTimeStamp() {
        return timeStamp;
    }


    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Ship(String shipname, String description, String img, String timeStamp) {
        this.shipname = shipname;
        this.description = description;
        this.img = img;
        this.timeStamp = timeStamp;
    }

    public Ship(String shipname, String description) {
        this.shipname = shipname;
        this.description = description;
    }

    public Ship(String shipname, String description, String timeStamp) {
        this.shipname = shipname;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    public Ship() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
