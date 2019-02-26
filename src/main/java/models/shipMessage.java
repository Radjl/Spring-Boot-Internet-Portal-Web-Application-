package models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class shipMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String getEnglishtext() {
        return englishtext;
    }

    public void setEnglishtext(String englishtext) {
        this.englishtext = englishtext;
    }

    private String text;
    private String englishtext = "";

    private String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    public shipMessage(String text, String englishtext, String timeStamp, Ship ship) {
        this.text = text;
        this.englishtext = englishtext;
        this.timeStamp = timeStamp;
        this.ship = ship;
    }

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
