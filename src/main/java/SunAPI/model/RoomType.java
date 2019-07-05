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


    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public Integer getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(Integer maxAdults) {
        this.maxAdults = maxAdults;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(Integer numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
