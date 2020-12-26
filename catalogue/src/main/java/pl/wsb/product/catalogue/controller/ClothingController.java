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
@RequestMapping("/clothing")
public class ClothingController {

    @Autowired
    ClothingService clothingService;

    @PostMapping()
    public ResponseEntity<Clothing> save(@Valid @RequestBody Clothing clothing){
        return ResponseEntity.ok(clothingService.save(clothing));
    }
    @GetMapping()
    public ResponseEntity<List<Clothing>> findAll(){
        return ResponseEntity.ok(clothingService.findALl());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Clothing> findById(@PathVariable String id){
        return ResponseEntity.ok(clothingService.findById(id));
    }
    @GetMapping()
    public ResponseEntity<List<Clothing>> findByCategory(@RequestParam String category){
        return ResponseEntity.ok(clothingService.findByCategory(category));
    }
}
