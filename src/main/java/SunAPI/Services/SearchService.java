package SunAPI.Services;

import SunAPI.model.SearchForm;
import SunAPI.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class SearchService {

    public ArrayList<SearchResult> filterResults(ArrayList<SearchResult> sr, SearchForm sf){

        for(SearchResult results: sr){
            if(!results.getProvince().equals( sf.getProvince())){
                sr.remove(results);
            }
        }
        for (SearchResult results: sr){
            long diffInMillies1 = Math.abs(sf.getCheckIn().getTime() - results.getStart_date().getTime());
            long diff1 = TimeUnit.DAYS.convert(diffInMillies1, TimeUnit.MILLISECONDS);

            long diffInMillies2 = Math.abs(results.getEnd_date().getTime() - sf.getCheckIn().getTime());
            long diff2 = TimeUnit.DAYS.convert(diffInMillies2, TimeUnit.MILLISECONDS);

            long diffInMillies3 = Math.abs(results.getEnd_date().getTime() - sf.getCheckOut().getTime());
            long diff3 = TimeUnit.DAYS.convert(diffInMillies3, TimeUnit.MILLISECONDS);

            long diffInMillies4 = Math.abs(sf.getCheckOut().getTime() - results.getStart_date().getTime());
            long diff4 = TimeUnit.DAYS.convert(diffInMillies4, TimeUnit.MILLISECONDS);

            if(diff1<0 || diff2<0 || diff3<0 || diff4<0){
                sr.remove(results);
            }
        }


        return sr;
    }
}
