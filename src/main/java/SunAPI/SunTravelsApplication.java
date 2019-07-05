package SunAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SunTravelsApplication {

    static ArrayList ar = new ArrayList<>();
    static List li[];


    public static void main(String[] args) {
        SpringApplication.run(SunTravelsApplication.class, args);
        ar.add("lsd");
        ar.add(1);



        for(Object o:ar){
            System.out.println(o);
            System.out.println(ar.get(1));
        }

    }


}
