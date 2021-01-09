package pl.wsb.product.catalogue.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.stereotype.Service;
import pl.wsb.product.catalogue.model.Product;
import pl.wsb.product.catalogue.model.ShopLocation;
import pl.wsb.product.catalogue.repository.CustomProductRepository;
import pl.wsb.product.catalogue.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository clothingRepository;
    @Autowired
    private CustomProductRepository customRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    private void createIndex() {
        System.out.println("CREATING INDEX");
        TextIndexDefinition textIndex = new TextIndexDefinition.TextIndexDefinitionBuilder()
                .onField("category")
                .onField("manufacturer")
                .onField("name")
                .onField("description")
                .build();

        mongoTemplate
            .indexOps(Product.class)
            .ensureIndex(textIndex);
    }

    public List<Document> findByCategory(List<String> categories){
        return customRepo.findByCategories(categories);
    }

    public List<Document> search(String searchText){
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
