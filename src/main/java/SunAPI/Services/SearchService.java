package SunAPI.Services;

import SunAPI.model.FrontEndResult;
import SunAPI.model.RoomType;
import SunAPI.model.SearchForm;
import SunAPI.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class SearchService {

    public ArrayList<SearchResult> createSearchResultsObjects(Iterable<Object[]> iterableObjectList){
        ArrayList<SearchResult> searchResultsArrayList =new ArrayList<>();
        for(Object[] s: iterableObjectList ) {
            SearchResult tempObj = new SearchResult((Integer) s[0], (Integer)s[1],(Integer) s[2],(String)s[3],(Float)s[4],(Integer)s[5],(Integer) s[6], (Integer) s[7],(String)s[8],(String) s[9],(Date) s[10],(Date)s[11],(Float)s[12]);
            searchResultsArrayList.add(tempObj);
        }
        return searchResultsArrayList;
    }

    public ArrayList<SearchResult> filterResultsbyProvinceDate(ArrayList<SearchResult> availableOptions, SearchForm sf){

        ArrayList<SearchResult> provinceChecked = new ArrayList<>();
        for(SearchResult results: availableOptions){
            if(results.getProvince().equals( sf.getProvince())){
                provinceChecked.add(results);
            }
        }
        System.out.println(sf.getProvince());
        ArrayList<SearchResult> dateAndProvinceChecked = new ArrayList<>();
        for (SearchResult results: provinceChecked){
            long diffInMillies1 = (sf.getCheckIn().getTime() - results.getStart_date().getTime());
            long diff1 = TimeUnit.DAYS.convert(diffInMillies1, TimeUnit.MILLISECONDS);

            long diffInMillies2 = Math.abs(results.getEnd_date().getTime() - sf.getCheckIn().getTime());
            long diff2 = TimeUnit.DAYS.convert(diffInMillies2, TimeUnit.MILLISECONDS);

            long diffInMillies3 = Math.abs(results.getEnd_date().getTime() - sf.getCheckOut().getTime());
            long diff3 = TimeUnit.DAYS.convert(diffInMillies3, TimeUnit.MILLISECONDS);

            long diffInMillies4 = Math.abs(sf.getCheckOut().getTime() - results.getStart_date().getTime());
            long diff4 = TimeUnit.DAYS.convert(diffInMillies4, TimeUnit.MILLISECONDS);

            if(diff1>=0 && diff2>=0 && diff3>=0 && diff4>=0){
                dateAndProvinceChecked.add(results);
            }
        }
        return dateAndProvinceChecked;
    }

    public ArrayList<FrontEndResult> createFrontEndResultsArray(ArrayList<SearchResult> availableOptions){

        ArrayList<String> hotelNames = new ArrayList<>();
        for(SearchResult sr: availableOptions){
            if(!hotelNames.contains(sr.getHotel_name())){
                hotelNames.add(sr.getHotel_name());
            }
        }

        ArrayList<FrontEndResult> frontEndResultArrayList = new ArrayList<>();
        for(String hotel_name: hotelNames){

            FrontEndResult fer = new FrontEndResult();
            fer.setHotelName(hotel_name);

            //ArrayList<RoomType> hotelRoomTypes = new ArrayList<>();
            fer.setRoomTypesArray(new ArrayList<RoomType>());

            for(SearchResult sr: availableOptions){
                if(hotel_name.equals(sr.getHotel_name())){


                    RoomType rt = new RoomType();
                    rt.setContractID(sr.getContractid());
                    rt.setCost(sr.getCost());
                    rt.setMaxAdults(sr.getMax_adults());
                    rt.setNumberAvailable(sr.getNumber_available());
                    rt.setNumberOfRooms(sr.getNumber_of_rooms());
                    rt.setRoomTypeName(sr.getRoom_type_name());

                    fer.setMarkup(sr.getMarkup());
                    fer.getRoomTypesArray().add(rt);

                }
            }
            //fer.setRoomTypesArray(hotelRoomTypes);
            frontEndResultArrayList.add(fer);
        }
//        for(FrontEndResult fre: frontEndResultArrayList){
//            int i =fre.getRoomTypesArray().size()/2;
//            System.out.println(fre.getRoomTypesArray().size());
//            for(int x =0; x==i; x++ ){
//                fre.getRoomTypesArray().remove(x);
//            }
//            System.out.println(fre.getRoomTypesArray().size());
//        }
        return frontEndResultArrayList;
    }

    public ArrayList<FrontEndResult> filterResultsByRoomAvailability(ArrayList<FrontEndResult> frontEndResultArrayList, SearchForm sf){

        ArrayList<FrontEndResult> finalFREList = new ArrayList<>();

        for(FrontEndResult fre:frontEndResultArrayList){

            int quadCount = 0;
            int tripCount = 0;
            int doubCount = 0;
            int singCount =0;

            for(RoomType rt : fre.getRoomTypesArray()){
                if(rt.getMaxAdults()==4){
                    quadCount += rt.getNumberAvailable();
                }
                else if(rt.getMaxAdults()==3){
                    tripCount += rt.getNumberAvailable();
                }
                else if(rt.getMaxAdults()==2){
                    doubCount += rt.getNumberAvailable();
                }
                else if(rt.getMaxAdults()==1){
                    singCount += rt.getNumberAvailable();
                }
            }

            if(sf.getQuadrupleRooms() <= quadCount && (sf.getTripleRooms() <= tripCount || sf.getTripleRooms() <= (tripCount + quadCount - sf.getQuadrupleRooms()))){
                if(sf.getDoubleRooms() <= doubCount || sf.getDoubleRooms() <= (doubCount + tripCount - sf.getTripleRooms() + quadCount - sf.getQuadrupleRooms())){
                    if(sf.getSingleRooms() <= singCount || sf.getSingleRooms() <= (singCount + doubCount - sf.getDoubleRooms() + tripCount - sf.getTripleRooms() + quadCount - sf.getQuadrupleRooms())){
                        finalFREList.add(fre);
                    }
                }
            }


        }

        return finalFREList;
    }
}
