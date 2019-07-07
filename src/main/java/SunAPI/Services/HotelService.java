package SunAPI.Services;

import SunAPI.model.Hotel;
import SunAPI.repository.CurrentContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class HotelService  {

    @Autowired
    private CurrentContractRepo currContRep;


    public Integer checkDuplicate(Hotel hot){
        Integer i=null;
        try{
             i = currContRep.currentContractDuplicateCheck(hot.getHotelID());

            return i;
        }catch(NullPointerException e){
            System.out.println("caught");
        }
        return i;
    }


}
