package pl.wsb.product.catalogue.repository;

import org.springframework.data.geo.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wsb.product.catalogue.model.ShopLocation;


public interface ShopLocationRepository extends MongoRepository<ShopLocation, String> {

    GeoResults<ShopLocation> findByLocationNear(Point point, Distance distance);

}
