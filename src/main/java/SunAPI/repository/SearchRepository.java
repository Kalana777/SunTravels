//package SunAPI.repository;
//
//import SunAPI.model.SearchResult;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//public interface SearchRepository extends CrudRepository<SearchResult, Integer> {
//
//    String sqlQuery = "SELECT new SunAPI.model.SearchResult( cc.hotelid, cc.contractid, rt.room_typeid, rt.room_type_name, rt.cost, rt.number_available, rt.number_of_rooms, rt.max_adults, h.hotel_name, h.province, c.start_date,c.end_date, c.markup) FROM current_contract cc JOIN room_type rt ON cc.contractid= rt.contractid JOIN hotel h ON cc.hotelid = h.hotelid JOIN contract c ON cc.contractid = c.contractid";
//    @Query(value = sqlQuery, nativeQuery = true)
//    public Iterable<SearchResult> getAllOptions();
//}
