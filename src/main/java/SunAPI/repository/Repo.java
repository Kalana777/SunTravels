//package SunAPI.repository;
//
//
//import SunAPI.model.SearchResult;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public class Repo {
//
//    @PersistenceContext
//    EntityManager em;
//
//    public List<SearchResult> getOptions(){
//
//        Query query = em.createQuery("SELECT  cc.hotelid, cc.contractid, rt.room_typeid, rt.room_type_name, rt.cost, rt.number_available, rt.number_of_rooms, rt.max_adults, h.hotel_name, h.province, c.start_date,c.end_date, c.markup FROM current_contract cc , room_type rt , hotel h, contract c WHERE cc.contractid= rt.contractid AND cc.hotelid = h.hotelid AND cc.contractid = c.contractid");
//        for (int i=0; i<query.getResultList().size();i++){
//            SearchResult sr = new SearchResult((Object[]) query.getResultList().get(i))
//        }
//
//    }
//}
