package SunAPI.model;

import java.util.ArrayList;
import java.util.List;

public class FrontEndResult {

    private String hotelName;
    private Float markup;
    private ArrayList<RoomType> roomTypesArray;


    public FrontEndResult() {
       super();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Float getMarkup() {
        return markup;
    }

    public void setMarkup(Float markup) {
        this.markup = markup;
    }

    public ArrayList<RoomType> getRoomTypesArray() {
        return roomTypesArray;
    }

    public void setRoomTypesArray(ArrayList<RoomType> roomTypesArray) {

//        for(int x=0; x==roomTypesArray.size()/2; x++){
//            roomTypesArray.remove(x);
//        }

        this.roomTypesArray = roomTypesArray;
    }
}
