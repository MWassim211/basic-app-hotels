package basic.hotels.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import basic.hotels.app.documents.Adress;
import basic.hotels.app.documents.Hotel;
import basic.hotels.app.documents.Review;
import basic.hotels.app.repositories.HotelRepository;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot  = new Hotel(
            "Marriot",
            120,
            new Adress("Paris","France"),
            Arrays.asList(
                new Review("John",8,true),
                new Review("Marc",7,false)
            )
        );
        Hotel ibis  = new Hotel(
            "Ibis",
            90,
            new Adress("Madrid","Spain"),
            Arrays.asList(
                new Review("Marie",8,true)
            )
        );
        Hotel sofitel  = new Hotel(
            "Sofitel",
            200,
            new Adress("Rome","Italy"),
            new ArrayList<>()
        );

        // drop all hotel
        hotelRepository.deleteAll();

        // add hotels 
        List<Hotel> hotels = Arrays.asList(marriot,ibis,sofitel);
        hotelRepository.saveAll(hotels);
    }
    
}
