package SunAPI.controller;

import SunAPI.Services.HotelService;
import SunAPI.model.*;
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

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(path="/contractForm")
public class FormController {

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
    public @ResponseBody
    Iterable<Contract> getAllContracts() {
        // This returns a JSON or XML with the users
        return contractRep.findAll();
    }

    @PostMapping(path ="/newHotel")
    public @ResponseBody String addContract(@RequestBody Form form){

        Hotel hot = new Hotel();
        hot.setRegNo(form.getRegNo());
        hot.setProvince(form.getProvince());
        hot.setHotelAddress(form.getHotelAddress());
        hot.setHotelName(form.getHotelName());
        hot.setHotelTp(form.getHotelTp());
        hotRep.save(hot);

        Contract cont = new Contract();
        cont.setEndDate(form.getEndDate());
        cont.setStartDate(form.getStartDate());
        cont.setMarkup(form.getMarkup());
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

        for (RoomType roomType: form.getRoomTypeDetails()) {
            roomType.setContractID(cont.getContractID());
            roomTypeRep.save(roomType);
        }



        return "Saved";
    }
}
