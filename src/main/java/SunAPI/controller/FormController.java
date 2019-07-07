package SunAPI.controller;

import SunAPI.Services.ContractFormService;
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
    private ContractRepository contractRep;

    @Autowired
    private ContractFormService contFormServ;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Contract> getAllContracts() {
        // This returns a JSON or XML with the users
        return contractRep.findAll();
    }

    @PostMapping(path ="/newHotel")
    public void/*@ResponseBody String*/ addContract(@RequestBody Form form){
        System.out.println("logger");
         contFormServ.addContractWithNewHotel(form);
    }
    @PostMapping(path ="/existingHotel")
    public void/*@ResponseBody String*/ addForExisting(@RequestBody Form form){
        System.out.println("logger2");
        contFormServ.addContractExistingNewHotel(form);
    }
}
