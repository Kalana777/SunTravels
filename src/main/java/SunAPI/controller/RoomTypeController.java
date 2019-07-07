package SunAPI.controller;

import SunAPI.model.Form;
import SunAPI.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(path="/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRep;

    @GetMapping(path ="/getDistinct")
    public @ResponseBody Iterable<String> getDistinct(){

        return roomTypeRep.getDistinctRoomTypes();
    }
}
