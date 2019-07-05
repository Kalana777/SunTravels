package SunAPI.repository;

import SunAPI.model.CurrentContract;
import SunAPI.model.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CurrentContractRepo extends CrudRepository<CurrentContract, Integer> {

    @Query(value = "update current_contract cc set cc.contractID = :contID where cc.hotelID = :hotID", nativeQuery =true)
    public void updateCurrentContract(@Param("contID") Integer contractID, @Param("hotID") Integer hotID);

    @Query(value = "SELECT hotelID FROM current_contract cc WHERE cc.hotelID =:hotID", nativeQuery = true)
    public Integer currentContractDuplicateCheck(@Param("hotID") Integer hotID);


}
