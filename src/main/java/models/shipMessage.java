package models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class shipMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String text;


    private String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;

    public shipMessage() {
    }

    public shipMessage(String text, String timeStamp, Ship ship) {
        this.text = text;
        this.timeStamp = timeStamp;
        this.ship = ship;
    }

    public shipMessage(String text) {
        this.text = text;
    }

    public shipMessage(String text, String timeStamp) {
        this.text = text;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
