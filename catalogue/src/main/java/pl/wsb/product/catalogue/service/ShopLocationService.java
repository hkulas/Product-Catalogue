package pl.wsb.product.catalogue.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.stereotype.Service;
import pl.wsb.product.catalogue.model.ShopLocation;
import pl.wsb.product.catalogue.repository.ShopLocationRepository;

import java.util.List;

@Service
public class ShopLocationService{

    @Autowired
    private ShopLocationRepository shopLocationRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ShopLocation save(ShopLocation shopLocation){

        mongoTemplate
                .indexOps(ShopLocation.class)
                .ensureIndex(new GeospatialIndex("location").typed(GeoSpatialIndexType.GEO_2DSPHERE));
        return shopLocationRepository.save(shopLocation);
    }

    public List<ShopLocation> findAll(){
        return shopLocationRepository.findAll();
    }

    //    public ShopLocation findByPosition(Point point){
//        return shopLocationRepository.findByPosition(point);
//    }
//
    public List<ShopLocation> findByLocationNear(Point point){
        return shopLocationRepository.findByLocationNear(point, new Distance(50, Metrics.KILOMETERS));
    }


}

