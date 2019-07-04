package SunAPI.controller;

import SunAPI.model.Hotel;
import SunAPI.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(path="/hotel")
public class HotelController {
    @Autowired
    private HotelRepository hotRep;

    @PostMapping(path="/add")
    public @ResponseBody String addNewHotel (@RequestParam String regNo, @RequestParam String hotelName, @RequestParam String hotelAddress, @RequestParam Integer hotelTp, @RequestParam String province){

        Hotel hotel = new Hotel();

        hotel.setRegNo(regNo);
        hotel.setProvince(province);
        hotel.setHotelAddress(hotelAddress);
        hotel.setHotelName(hotelName);
        hotel.setHotelTp(hotelTp);
        hotRep.save(hotel);

        return "saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Hotel> getAllUsers() {
        // This returns a JSON or XML with the users
        return hotRep.findAll();
    }


}
