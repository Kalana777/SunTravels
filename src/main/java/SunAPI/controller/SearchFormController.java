package SunAPI.controller;


import SunAPI.Services.SearchService;
import SunAPI.model.FrontEndResult;
import SunAPI.model.SearchForm;
import SunAPI.model.SearchResult;
import SunAPI.repository.HotelRepository;
import SunAPI.repository.SearchRepository;
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



    @Autowired
    private SearchService searchServ;
    @Autowired
    SearchRepository searchRep;

    @PostMapping(path ="/newSearch")
    public @ResponseBody ArrayList<FrontEndResult> getAllOptions(@RequestBody SearchForm SF) {

        searchServ.createSearchResultsObjects(searchRep.getAllOptions());


        ArrayList<SearchResult> ss =searchServ.filterResultsbyProvinceDate(searchServ.createSearchResultsObjects(searchRep.getAllOptions()), SF);



        return searchServ.filterResultsByRoomAvailability(searchServ.createFrontEndResultsArray(ss), SF);

    }
}
