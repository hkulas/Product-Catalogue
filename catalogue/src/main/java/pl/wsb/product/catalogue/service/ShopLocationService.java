package pl.wsb.product.catalogue.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.stereotype.Service;
import pl.wsb.product.catalogue.model.ShopLocation;
import pl.wsb.product.catalogue.repository.ShopLocationRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ShopLocationService {

    @Autowired
    private ShopLocationRepository shopLocationRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    private void createGeoIndex() {
        mongoTemplate
                .indexOps(ShopLocation.class)
                .ensureIndex(new GeospatialIndex("location").typed(GeoSpatialIndexType.GEO_2DSPHERE));
    }

    public ShopLocation save(ShopLocation shopLocation) {
        return shopLocationRepository.save(shopLocation);
    }

    public List<ShopLocation> findAll() {
        return shopLocationRepository.findAll();
    }

    public ShopLocation findById(String id) {
        return shopLocationRepository.findById(id).orElse(null);

    }


    public GeoResults<ShopLocation> findByLocationNear(Point point, Double distance) {
        Optional<Double> distanceOptional = Optional.ofNullable(distance);
        if (distanceOptional.isEmpty()) {
            distance = 0.0;
        }
        return shopLocationRepository.findByLocationNear(point, new Distance(distance, Metrics.KILOMETERS));
    }

    public void deleteById(String id) {
        shopLocationRepository.deleteById(id);
    }


}

