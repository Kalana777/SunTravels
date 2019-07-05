package SunAPI.repository;

import SunAPI.model.RoomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoomTypeRepository extends CrudRepository<RoomType, Integer> {


}
