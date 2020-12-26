package pl.wsb.product.catalogue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wsb.product.catalogue.model.Clothing;

import java.util.List;

public interface ClothingRepository extends MongoRepository<Clothing, String> {

    List<Clothing> findByCategory(String category);
}
