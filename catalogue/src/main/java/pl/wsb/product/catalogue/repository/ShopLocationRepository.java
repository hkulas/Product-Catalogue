package pl.wsb.product.catalogue.repository;

import org.springframework.data.geo.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wsb.product.catalogue.model.ShopLocation;

import java.util.List;

public interface ShopLocationRepository extends MongoRepository<ShopLocation, String> {

//    GeoResult<ShopLocation> findByPosition(Point position);
//
    List<ShopLocation> findByLocationNear(Point point, Distance distance);


}
