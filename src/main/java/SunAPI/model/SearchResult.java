package SunAPI.model;

//import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ColumnResult;
//import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;

//@SqlResultSetMapping(name="searchResultMapping",
//        //classes ={
//                //@ConstructorResult(targetClass=SearchResult.class,
//                        columns={
//                                @ColumnResult(name="hotelid"),
//                                @ColumnResult(name="contractid"),
//                                @ColumnResult(name="room_typeid"),
//                                @ColumnResult(name ="room_type_name"),
//                                @ColumnResult(name="cost"),
//                                @ColumnResult(name="number_available"),
//                                @ColumnResult(name="number_of_rooms"),
//                                @ColumnResult(name="max_adults"),
//                                @ColumnResult(name="hotel_name"),
//                                @ColumnResult(name="province"),
//                                @ColumnResult(name="start_date"),
//                                @ColumnResult(name="end_date"),
//                                @ColumnResult(name="markup")
//                        }//)}
//)


public class SearchResult {

    private Integer hotelid;
    private Integer contractid;
    private Integer room_typeid;
    private String room_type_name;
    private Float cost;
    private Integer number_available;
    private Integer number_of_rooms;
    private Integer max_adults;
    private String hotel_name;
    private String province;
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date start_date;
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date end_date;
    private Float markup;

    public SearchResult(){
        super();
    }
    public SearchResult(Integer hotelid, Integer contractid, Integer room_typeid, String room_type_name, Float cost, Integer number_available, Integer number_of_rooms, Integer max_adults, String hotel_name, String province, Date start_date, Date end_date, Float markup) {
        this.hotelid = hotelid;
        this.contractid = contractid;
        this.room_typeid = room_typeid;
        this.room_type_name = room_type_name;
        this.cost = cost;
        this.number_available = number_available;
        this.number_of_rooms = number_of_rooms;
        this.max_adults = max_adults;
        this.hotel_name = hotel_name;
        this.province = province;
        this.start_date = start_date;
        this.end_date = end_date;
        this.markup = markup;
    }
//public SearchResult(Object[] columns) {
//    this.hotelid = hotelid;
//    this.contractid = contractid;
//    this.room_typeid = room_typeid;
//    this.room_type_name = room_type_name;
//    this.cost = cost;
//    this.number_available = number_available;
//    this.number_of_rooms = number_of_rooms;
//    this.max_adults = max_adults;
//    this.hotel_name = hotel_name;
//    this.province = province;
//    this.start_date = start_date;
//    this.end_date = end_date;
//    this.markup = markup;
//}


    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public Integer getRoom_typeid() {
        return room_typeid;
    }

    public void setRoom_typeid(Integer room_typeid) {
        this.room_typeid = room_typeid;
    }

    public String getRoom_type_name() {
        return room_type_name;
    }

    public void setRoom_type_name(String room_type_name) {
        this.room_type_name = room_type_name;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getNumber_available() {
        return number_available;
    }

    public void setNumber_available(Integer number_available) {
        this.number_available = number_available;
    }

    public Integer getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(Integer number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    public Integer getMax_adults() {
        return max_adults;
    }

    public void setMax_adults(Integer max_adults) {
        this.max_adults = max_adults;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Float getMarkup() {
        return markup;
    }

    public void setMarkup(Float markup) {
        this.markup = markup;
    }
}
