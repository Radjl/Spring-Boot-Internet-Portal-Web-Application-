package models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItemIt {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ItemIt(String name) {
        this.name = name;
    }


    private String firstBroke;
    private String secondBroke;
    private String thirdBroke;

    public String getFirstBroke() {
        return firstBroke;
    }

    public void setFirstBroke(String firstBroke) {
        this.firstBroke = firstBroke;
    }

    public String getSecondBroke() {
        return secondBroke;
    }

    public void setSecondBroke(String secondBroke) {
        this.secondBroke = secondBroke;
    }

    public String getThirdBroke() {
        return thirdBroke;
    }

    public void setThirdBroke(String thirdBroke) {
        this.thirdBroke = thirdBroke;
    }

    private boolean broken = false;
    private String name;
    private int srokEkspluatacii;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date VvodEkspluatacii;

    private String  inventoryNumber;
    private String serialNumber;
    private String dislocation;


    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public ItemIt(boolean broken, String name, int srokEkspluatacii, Date vvodEkspluatacii, String inventoryNumber, String serialNumber, String dislocation, String img) {
        this.broken = broken;
        this.name = name;
        this.srokEkspluatacii = srokEkspluatacii;
        VvodEkspluatacii = vvodEkspluatacii;
        this.inventoryNumber = inventoryNumber;
        this.serialNumber = serialNumber;
        this.dislocation = dislocation;
        this.img = img;
    }

    public ItemIt(String firstBroke, String secondBroke, String thirdBroke, boolean broken, String name, int srokEkspluatacii, Date vvodEkspluatacii, String inventoryNumber, String serialNumber, String dislocation, String img) {
        this.firstBroke = firstBroke;
        this.secondBroke = secondBroke;
        this.thirdBroke = thirdBroke;
        this.broken = broken;
        this.name = name;
        this.srokEkspluatacii = srokEkspluatacii;
        VvodEkspluatacii = vvodEkspluatacii;
        this.inventoryNumber = inventoryNumber;
        this.serialNumber = serialNumber;
        this.dislocation = dislocation;
        this.img = img;
    }

    public ItemIt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSrokEkspluatacii() {
        return srokEkspluatacii;
    }

    public void setSrokEkspluatacii(int srokEkspluatacii) {
        this.srokEkspluatacii = srokEkspluatacii;
    }

    public Date getVvodEkspluatacii() {
        return VvodEkspluatacii;
    }

    public void setVvodEkspluatacii(Date vvodEkspluatacii) {
        VvodEkspluatacii = vvodEkspluatacii;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDislocation() {
        return dislocation;
    }

    public void setDislocation(String dislocation) {
        this.dislocation = dislocation;
    }
}
