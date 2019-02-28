package models;


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

    private String name;
    private int srokEkspluatacii;
    private Date VvodEkspluatacii;
    private int inventoryNumber;
    private int serialNumber;
    private String dislocation;


    public ItemIt(String name, int srokEkspluatacii, Date vvodEkspluatacii, int inventoryNumber, int serialNumber, String dislocation) {
        this.name = name;
        this.srokEkspluatacii = srokEkspluatacii;
        VvodEkspluatacii = vvodEkspluatacii;
        this.inventoryNumber = inventoryNumber;
        this.serialNumber = serialNumber;
        this.dislocation = dislocation;
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

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDislocation() {
        return dislocation;
    }

    public void setDislocation(String dislocation) {
        this.dislocation = dislocation;
    }
}
