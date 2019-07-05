package SunAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "current_contract")
public class CurrentContract {

    @Id
    private Integer hotelID;

    private Integer contractID;


    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }
}
