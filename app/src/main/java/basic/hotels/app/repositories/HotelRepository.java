package basic.hotels.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import basic.hotels.app.documents.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> , QuerydslPredicateExecutor<Hotel>{
    List<Hotel> findByPricePerNightLessThan(int max);

    @Query(value = "{'adress.city':?0}")
    List<Hotel> findByCity(String city);
}

