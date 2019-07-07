package SunAPI.model;

import java.util.Date;

public class SearchForm {

    private Integer singleRooms;
    private Integer doubleRooms;
    private Integer tripleRooms;
    private String province;
    private Date checkIn;
    private Date checkOut;
    //private Integer nights;


    public Integer getSingleRooms() {
        return singleRooms;
    }

    public void setSingleRooms(Integer singleRooms) {
        this.singleRooms = singleRooms;
    }

    public Integer getDoubleRooms() {
        return doubleRooms;
    }

    public void setDoubleRooms(Integer doubleRooms) {
        this.doubleRooms = doubleRooms;
    }

    public Integer getTripleRooms() {
        return tripleRooms;
    }

    public void setTripleRooms(Integer tripleRooms) {
        this.tripleRooms = tripleRooms;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

//    public Integer getNights() {
//        return nights;
//    }
//
//    public void setNights(Integer nights) {
//        this.nights = nights;
//    }
}
