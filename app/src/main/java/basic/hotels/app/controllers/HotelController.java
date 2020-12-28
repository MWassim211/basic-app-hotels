package basic.hotels.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import basic.hotels.app.documents.Hotel;
import basic.hotels.app.repositories.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    
    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping("/all")
    public List<Hotel> getAll(){
        return hotelRepository.findAll();
    }
}
