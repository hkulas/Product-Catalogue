package pl.wsb.product.catalogue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wsb.product.catalogue.model.Clothing;

public interface ClothingRepository extends MongoRepository<Clothing, String> {

    Clothing findByCategory(String category);
}
