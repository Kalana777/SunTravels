package SunAPI.controller;

import SunAPI.Services.HotelService;
import SunAPI.model.Contract;
import SunAPI.model.CurrentContract;
import SunAPI.model.Hotel;
import SunAPI.model.RoomType;
import SunAPI.repository.ContractRepository;
import SunAPI.repository.CurrentContractRepo;
import SunAPI.repository.HotelRepository;
import SunAPI.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(path="/contract")
public class ContractController {

    ArrayList ar = new ArrayList<>();

    @Autowired
    private HotelRepository hotRep;

    @Autowired
    private ContractRepository contractRep;

    @Autowired
    private RoomTypeRepository roomTypeRep;

    @Autowired
    private CurrentContractRepo currContRep;


    private HotelService hotService = new HotelService();


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Contract> getAllContracts() {
        // This returns a JSON or XML with the users
        return contractRep.findAll();
    }

    @PostMapping(path ="/newHotel")
    public @ResponseBody String addContract(/*@RequestParam Integer hotelID,*/ @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date startDate, @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date endDate, @RequestParam Float markup, @RequestParam ArrayList<RoomType> roomTypeDetails, @RequestParam String regNo, @RequestParam String hotelName, @RequestParam String hotelAddress, @RequestParam Integer hotelTp, @RequestParam String province){

        Hotel hot = new Hotel();
        hot.setRegNo(regNo);
        hot.setProvince(province);
        hot.setHotelAddress(hotelAddress);
        hot.setHotelName(hotelName);
        hot.setHotelTp(hotelTp);
        hotRep.save(hot);

        Contract cont = new Contract();
        cont.setEndDate(endDate);
        cont.setStartDate(startDate);
        cont.setMarkup(markup);
        cont.setHotelID(hot.getHotelID());
        contractRep.save(cont);

        CurrentContract currCont = new CurrentContract();
        if (hotService.checkDuplicate(hot)==null){
            currCont.setHotelID(hot.getHotelID());
            currCont.setContractID(cont.getContractID());
            currContRep.save(currCont);
        }
        else {
            currContRep.updateCurrentContract(cont.getContractID(), hot.getHotelID());
        }

        for (RoomType roomType: roomTypeDetails) {
            //roomType.setContractID(cont.getContractID());
            roomTypeRep.save(roomType);
        }



        return "Saved";
    }

}
