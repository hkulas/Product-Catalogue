package pl.wsb.product.catalogue.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wsb.product.catalogue.model.Clothing;
import pl.wsb.product.catalogue.service.ClothingService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ClothingController {

    @Autowired
    ClothingService clothingService;

    @PostMapping("/clothing")
    public ResponseEntity<Clothing> save(@Valid @RequestBody Clothing clothing){
        clothingService.save(clothing);
        return ResponseEntity.ok(clothing);
    }
    @GetMapping("/clothing")
    public ResponseEntity<List<Clothing>> findAll(){
        List<Clothing> clothingList = clothingService.findALl();
        return ResponseEntity.ok(clothingList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Clothing> findByCategory(@PathVariable String category){
        Clothing clothingByCategory = clothingService.findByCategory(category);
                return ResponseEntity.ok(clothingByCategory);
    }
}
