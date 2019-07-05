package SunAPI.model;

import java.util.ArrayList;
import java.util.Date;

public class Form {

    private Date startDate;
    private Date endDate;
    private Float markup;
    private ArrayList<RoomType> roomTypeDetails;
    private String regNo;
    private String hotelName;
    private String hotelAddress;
    private Integer hotelTp;
    private String province;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getMarkup() {
        return markup;
    }

    public void setMarkup(Float markup) {
        this.markup = markup;
    }

    public ArrayList<RoomType> getRoomTypeDetails() {
        return roomTypeDetails;
    }

    public void setRoomTypeDetails(ArrayList<RoomType> roomTypeDetails) {
        this.roomTypeDetails = roomTypeDetails;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public Integer getHotelTp() {
        return hotelTp;
    }

    public void setHotelTp(Integer hotelTp) {
        this.hotelTp = hotelTp;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
