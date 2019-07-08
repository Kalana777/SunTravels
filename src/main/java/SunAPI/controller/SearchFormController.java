package SunAPI.controller;


import SunAPI.Services.SearchService;
import SunAPI.model.SearchForm;
import SunAPI.model.SearchResult;
import SunAPI.model.SimpleModel;
import SunAPI.repository.HotelRepository;
//import SunAPI.repository.SearchRepository;
//import SunAPI.repository.SearchRepository;
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

    @GetMapping(path ="/newSearch")
    public @ResponseBody ArrayList<SearchResult> getAllOptionss(SearchForm SF) throws ParseException {

        ArrayList<SearchResult> ss =new ArrayList<>();
        for(Object[] s: searchRep.getAllOptions()) {
            SearchResult srs = new SearchResult((Integer) s[0], (Integer)s[1],(Integer) s[2],(String)s[3],(Float)s[4],(Integer)s[5],(Integer) s[6], (Integer) s[7],(String)s[8],(String) s[9],(Date) s[10],(Date)s[11],(Float)s[12]);
            ss.add(srs);

        }


        searchServ.filterResults(ss, SF);


        return ss;
        /*hotRep.getAllOptions();*/

    }
}
