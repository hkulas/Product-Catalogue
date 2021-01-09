package pl.wsb.product.catalogue.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
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

    private MongoCollection<Document> getCollection() {
        MongoDatabase database = mongoClient.getDatabase("catalogue");
        return database.getCollection("product");
    }

    private List<Document> getDocumentsFromCursor(MongoCursor<Document> cursor) {
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

    public List<Document> findProductBySearchText(String searchText) {
        MongoCollection<Document> collection = getCollection();

        MongoCursor<Document> cursor = collection.find(Filters.text(searchText)).iterator();

        return getDocumentsFromCursor(cursor);
    }

    public List<Document> findByCategories(List<String> categories) {
        MongoCollection<Document> collection = getCollection();

        BasicDBObject inQuery = new BasicDBObject();
        inQuery.put("category", new BasicDBObject("$in", categories));

        MongoCursor<Document> cursor = collection.find(inQuery).iterator();

        return getDocumentsFromCursor(cursor);
    }
}
