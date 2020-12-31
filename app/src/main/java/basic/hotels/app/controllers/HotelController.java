package basic.hotels.app.controllers;

import java.util.List;
import java.util.Optional;

import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import basic.hotels.app.documents.Hotel;
import basic.hotels.app.documents.QHotel;
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

    @PutMapping
    public void insert(@RequestBody Hotel hotel){
        hotelRepository.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Optional<Hotel> optHotel  = hotelRepository.findById(id);
        if(optHotel.isPresent())
            return hotelRepository.findById(id).get();
        else
            return null;
    }


    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        return hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        return hotelRepository.findByCity(city);
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        // Create a query class
        QHotel qHotel = new QHotel("Hotel");
        // Using the query class we can create a filter
        BooleanExpression filterByCountry = qHotel.adress.country.eq(country);
        // We passe the filter to findAll method
        return (List<Hotel>)hotelRepository.findAll(filterByCountry);
    } 

    @GetMapping("/recommended")
    public List<Hotel> getRecommanded(){
        final int maxPrice = 100;
        final int minRating = 7;
        // Create a query class
        QHotel qHotel = new QHotel("Hotel");
        // Using the query class we can create a filter
        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);
        // We passe the filter to findAll method
        return (List<Hotel>)hotelRepository.findAll(filterByPrice.and(filterByRating));
    }
}

