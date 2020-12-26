package pl.wsb.product.catalogue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wsb.product.catalogue.model.Product;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByCategory(String category);
}
