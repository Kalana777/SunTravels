package SunAPI.controller;


import SunAPI.Services.SearchService;
import SunAPI.model.SearchForm;
import SunAPI.model.SearchResult;
import SunAPI.repository.HotelRepository;
//import SunAPI.repository.SearchRepository;
//import SunAPI.repository.SearchRepository;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(path="/searchForm")
public class SearchFormController {

    private ArrayList<SearchResult> searches;

    @Autowired
    private SearchService searchServ;
    @Autowired
    private HotelRepository hotelRep;
//    @Autowired
//    private SearchRepository searchRep;

//    @PostMapping(path ="/newSearch")
//    public Iterable<SearchResult> getAllOptions(){
//        String sqlQuery = "SELECT cc.hotelid, cc.contractid, rt.room_typeid, rt.room_type_name, rt.cost, rt.number_available, rt.number_of_rooms, rt.max_adults, h.hotel_name, h.province, c.start_date,c.end_date, c.markup FROM current_contract cc JOIN room_type rt ON cc.contractid= rt.contractid JOIN hotel h ON cc.hotelid = h.hotelid JOIN contract c ON cc.contractid = c.contractid";
//        Query q = em.createNativeQuery(sqlQuery/*,"searchResultMapping"*/);
//        Iterable<Array> sr = q.getResultList();
//
//
//        for(Object s: sr){
//            System.out.println(s);
//        }
//        return  q.getResultList();
//
//    }
    @GetMapping(path ="/newSearch")
    public @ResponseBody List<Object> getAllOptionss(SearchForm SF) throws ParseException {
//        for(Object o: hotelRep.getAllOptions()){
//            for(int x=0; x<13; x++){
//                System.out.println(o[x]);
//            }
//        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2019-01-01");
        Date date2 = dateFormat.parse("2020-01-01");

        SearchResult sr1 = new SearchResult(3, 3,
                    5,
                    "Deluxe",
                    10000.0,
                    10,
                    10,
                    2,
                    "Cinnamon Lakeside",
                    "western",
                    date1,
                    date2,
                    0.25);

        SearchResult sr2 = new SearchResult( 3,
                3,
                6,
                "Deluxe",
                20000.0,
                10,
                10,
                3,
                "Cinnamon Lakeside",
                "western",
                date1,
                date2,
                0.25);

        searches.add(sr1);
        searches.add(sr2);

        searchServ.filterResults(searches, SF);

        return  hotelRep.getAllOptions();

    }
}
