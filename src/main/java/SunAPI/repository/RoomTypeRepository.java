package SunAPI.repository;

import SunAPI.model.RoomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends CrudRepository<RoomType, Integer> {

    @Query(value = "SELECT DISTINCT room_type_name FROM room_type", nativeQuery = true)
    public Iterable<String> getDistinctRoomTypes();
}
