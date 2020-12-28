package pl.wsb.product.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<ShopLocation>> findByLocationNear(@PathVariable Point point) {
        return ResponseEntity.ok(shopLocationService.findByLocationNear(point));
    }

//@GetMapping("/{id}")
//    public ResponseEntity<Product> findById(@PathVariable String id){
//        return ResponseEntity.ok(productService.findById(id));
//    }
//
//    @GetMapping("/{point}")
//    public ResponseEntity<ShopLocation> findByPosition(@PathVariable Point point) {
//        return ResponseEntity.ok(shopLocationService.findByPosition(point));
//    }
//

}
