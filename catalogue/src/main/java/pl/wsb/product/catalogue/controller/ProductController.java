package pl.wsb.product.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wsb.product.catalogue.model.Product;
import pl.wsb.product.catalogue.service.ProductService;

import javax.validation.Valid;
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
    @GetMapping("/category")
    public ResponseEntity<List<Product>> findByCategory(@RequestParam String category){
        return ResponseEntity.ok(productService.findByCategory(category));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam String searchText){
        return ResponseEntity.ok(productService.search(searchText));
    }
}
