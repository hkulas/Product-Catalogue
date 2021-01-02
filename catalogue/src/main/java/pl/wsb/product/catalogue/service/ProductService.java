package pl.wsb.product.catalogue.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.product.catalogue.model.Product;
import pl.wsb.product.catalogue.repository.CustomProductRepository;
import pl.wsb.product.catalogue.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository clothingRepository;
    @Autowired
    private CustomProductRepository customRepo;

    public List<Document> findByCategory(List<String> categories){
        return customRepo.findByCategories(categories);
    }

    public List<Product> search(String searchText){
        return customRepo.findProductBySearchText(searchText);
    }

    public Product findById(String id){
        return clothingRepository.findById(id).orElse(null);
    }

    public List<Product> findALl(){
        return clothingRepository.findAll();
    }

    public Product save(Product clothing){
        return clothingRepository.save(clothing);
    }
}
