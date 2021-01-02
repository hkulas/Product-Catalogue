package pl.wsb.product.catalogue.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.wsb.product.catalogue.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomProductRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    MongoClient mongoClient;

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

    public List<Document> findByCategories(List<String> categories) {
        MongoDatabase database = mongoClient.getDatabase("catalogue");
        MongoCollection<Document> collection = database.getCollection("product");

        BasicDBObject inQuery = new BasicDBObject();
        inQuery.put("category", new BasicDBObject("$in", categories));

        MongoCursor<Document> cursor = collection.find(inQuery).iterator();

        List<Document> documents = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        } finally {
            cursor.close();
        }

        return documents;
    }
}
