package SunAPI.controller;

import SunAPI.model.Contract;
import SunAPI.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(path="/contract")
public class ContractController {

    @Autowired
    private ContractRepository contractRep;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Contract> getAllContracts() {
        // This returns a JSON or XML with the users
        return contractRep.findAll();
    }


}
