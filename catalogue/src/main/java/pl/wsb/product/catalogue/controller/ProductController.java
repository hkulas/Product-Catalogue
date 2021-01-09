package pl.wsb.product.catalogue.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wsb.product.catalogue.model.CategoriesWrapper;
import pl.wsb.product.catalogue.model.Product;
import pl.wsb.product.catalogue.service.ProductService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> save(@Valid @RequestBody Product clothing){
        return ResponseEntity.ok(productService.save(clothing));
    }
    @GetMapping()
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findALl());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping("/category")
    public ResponseEntity<List<Document>> categories(@RequestBody CategoriesWrapper body){
        return ResponseEntity.ok(productService.findByCategory(body.getCategories()));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Document>> search(@RequestParam String searchText){
        return ResponseEntity.ok(productService.search(searchText));
    }
}
