package SunAPI.controller;

import SunAPI.model.Contract;
import SunAPI.model.Hotel;
import SunAPI.repository.ContractRepository;
import SunAPI.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(path="/contract")
public class ContractController {

    @Autowired
    private HotelRepository hotRep;

    @Autowired
    private ContractRepository contractRep;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Contract> getAllContracts() {
        // This returns a JSON or XML with the users
        return contractRep.findAll();
    }

    @PostMapping(path ="/newHotel")
    public @ResponseBody String addContract(/*@RequestParam Integer hotelID,*/ @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date startDate, @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date endDate, @RequestParam Float markup, /*@RequestParam ArrayList roomTypeDetails*/ @RequestParam String regNo, @RequestParam String hotelName, @RequestParam String hotelAddress, @RequestParam Integer hotelTp, @RequestParam String province){

        Hotel hot = new Hotel();
        hot.setRegNo(regNo);
        hot.setProvince(province);
        hot.setHotelAddress(hotelAddress);
        hot.setHotelName(hotelName);
        hot.setHotelTp(hotelTp);
        hotRep.save(hot);
        System.out.println(hot.getHotelID());

        Contract cont = new Contract();
        cont.setEndDate(endDate);
        cont.setStartDate(startDate);
        cont.setMarkup(markup);
        cont.setHotelID(hot.getHotelID());
        contractRep.save(cont);



        return "Saved";
    }

}
