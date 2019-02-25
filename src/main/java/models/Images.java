package models;


import javax.persistence.*;

@Entity
public class Images {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Images(String name, String image, Ship ship) {
        this.name = name;
        this.image = image;
        this.ship = ship;
    }

    private String name;

    public Images(String name, String image) {
        this.name = name;
        this.image = image;
    }

    private String image;

    public Images() {
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
