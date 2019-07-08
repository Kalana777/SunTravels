package SunAPI.repository;

import SunAPI.model.Hotel;
import SunAPI.model.SearchResult;
import SunAPI.model.SimpleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface SearchRepository extends CrudRepository<Hotel, Integer> {

    String sqlQuery = "SELECT  cc.hotelid, cc.contractid, rt.room_typeid, rt.room_type_name, rt.cost, rt.number_available, rt.number_of_rooms, rt.max_adults, h.hotel_name, h.province, c.start_date,c.end_date, c.markup FROM current_contract cc , room_type rt , hotel h, contract c WHERE cc.contractid= rt.contractid AND cc.hotelid = h.hotelid AND cc.contractid = c.contractid";
    @Query( value= sqlQuery, nativeQuery = true)
    public Iterable<Object[]> getAllOptions();

    @Query(value = "SELECT new SunAPI.model.SimpleModel(cc.contractid, h.hotelid) FROM current_contract cc JOIN hotel h;", nativeQuery = true)
    public Iterable<SimpleModel> getSimpleModels();
}
