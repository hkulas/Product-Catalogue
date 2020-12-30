package pl.wsb.product.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wsb.product.catalogue.model.ShopLocation;
import pl.wsb.product.catalogue.service.ShopLocationService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/location")
public class ShopLocationController {

    @Autowired
    private ShopLocationService shopLocationService;

    @PostMapping()
    public ResponseEntity<ShopLocation> save(@Valid @RequestBody ShopLocation shopLocation) {
        return ResponseEntity.ok(shopLocationService.save(shopLocation));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShopLocation>> findAll() {
        return ResponseEntity.ok(shopLocationService.findAll());
    }

    @GetMapping("/near/{point}")
    public ResponseEntity<GeoResults<ShopLocation>> findByLocationNear(@PathVariable Point point,
                                                                       @RequestParam(required = false) Double distance) {
        return ResponseEntity.ok(shopLocationService.findByLocationNear(point, distance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopLocation> findById(@PathVariable String id) {
        return ResponseEntity.ok(shopLocationService.findById(id));
    }

}
