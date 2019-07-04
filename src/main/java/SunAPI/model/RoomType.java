package SunAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "roomType")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roomTypeID;

    private Integer contractID;

    private Integer maxAdults;

    private String roomTypeName;

    private Integer numberOfRooms;

    private Integer numberAvailable;

    private Float cost;


}
