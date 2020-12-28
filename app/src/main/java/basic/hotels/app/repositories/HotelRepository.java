package basic.hotels.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import basic.hotels.app.documents.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String>{
    
}
