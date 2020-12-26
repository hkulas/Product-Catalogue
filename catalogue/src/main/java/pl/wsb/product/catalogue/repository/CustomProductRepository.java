package pl.wsb.product.catalogue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.wsb.product.catalogue.model.Product;

import java.util.List;

@Repository
public class CustomProductRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Product> findProductBySearchText(String searchText) {
        String searchTextRegex = "\\" + searchText + "\\";

        Query query = new Query();
        query.addCriteria(
            Criteria.where("name").regex(searchTextRegex).orOperator(
                Criteria.where("manufacturer").regex(searchTextRegex).orOperator((
                    Criteria.where("category").regex(searchTextRegex)
                ))
            )
        );

        return mongoTemplate.find(query, Product.class);
    }
}
