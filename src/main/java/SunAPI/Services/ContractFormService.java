package SunAPI.Services;


import SunAPI.model.*;
import SunAPI.repository.ContractRepository;
import SunAPI.repository.CurrentContractRepo;
import SunAPI.repository.HotelRepository;
import SunAPI.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class ContractFormService {


    @Autowired
    private HotelRepository hotRep;

    @Autowired
    private ContractRepository contractRep;

    @Autowired
    private RoomTypeRepository roomTypeRep;

    @Autowired
    private CurrentContractRepo currContRep;

    @Autowired
    private HotelService hotService;


    public void /*String*/ addContractWithNewHotel(Form form){
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
        //return "saved";

    }


    public void /*String*/ addContractExistingNewHotel(Form form){

        Integer hot_id =hotRep.searchHotelByName(form.getHotelName());
        System.out.println(form.getHotelName());
        System.out.println(hot_id);
//        Hotel hot = new Hotel();
//        hot.setRegNo(form.getRegNo());
//        hot.setProvince(form.getProvince());
//        hot.setHotelAddress(form.getHotelAddress());
//        hot.setHotelName(form.getHotelName());
//        hot.setHotelTp(form.getHotelTp());
//        hotRep.save(hot);

        Contract cont = new Contract();
        cont.setEndDate(form.getEndDate());
        cont.setStartDate(form.getStartDate());
        cont.setMarkup(form.getMarkup());
        cont.setHotelID(hot_id);
        contractRep.save(cont);

        CurrentContract currCont = new CurrentContract();

            currCont.setHotelID(hot_id);
            currCont.setContractID(cont.getContractID());
            currContRep.save(currCont);



        for (RoomType roomType: form.getRoomTypeDetails()) {
            roomType.setContractID(cont.getContractID());
            roomTypeRep.save(roomType);
        }
        //return "saved";

    }

}
