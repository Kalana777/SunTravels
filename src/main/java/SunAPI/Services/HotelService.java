package SunAPI.Services;

import SunAPI.model.Hotel;
import SunAPI.repository.CurrentContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

        /*Integer i =currContRep.currentContractDuplicateCheck(hot.getHotelID());


        if (i ==null){
            System.out.println("doestn exist");
            return null;
        }

            return i;

*/
        return i;
    }
}
