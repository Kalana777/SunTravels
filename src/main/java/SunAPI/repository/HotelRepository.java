package SunAPI.repository;

import SunAPI.model.SearchResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import SunAPI.model.Hotel;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    String sqlQuery = "SELECT cc.hotelid, cc.contractid, rt.room_typeid, rt.room_type_name, rt.cost, rt.number_available, rt.number_of_rooms, rt.max_adults, h.hotel_name, h.province, c.start_date,c.end_date, c.markup FROM current_contract cc JOIN room_type rt ON cc.contractid= rt.contractid JOIN hotel h ON cc.hotelid = h.hotelid JOIN contract c ON cc.contractid = c.contractid";

    @Query(value = "SELECT hotel_name FROM hotel", nativeQuery = true)
    public Iterable<String> getAllHotelNames();

    @Query(value = "SELECT hotelID FROM hotel where hotel_name =:hot_name", nativeQuery = true)
    public Integer searchHotelByName(@Param("hot_name") String hot_name);


    //@NamedNativeQuery(name = "options", query = sqlQuery, resultSetMapping = "searchResultMapping")
    @Query(value = sqlQuery, nativeQuery = true)
    public List<Object> getAllOptions();
}
