package pl.wsb.product.catalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.product.catalogue.model.Clothing;
import pl.wsb.product.catalogue.repository.ClothingRepository;

import java.util.List;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;


    public List<Clothing> findByCategory(String category){
        return clothingRepository.findByCategory(category);
    }

    public Clothing findById(String id){
        return clothingRepository.findById(id).orElse(null);
    }

    public List<Clothing> findALl(){
        return clothingRepository.findAll();
    }

    public Clothing save(Clothing clothing){
        return clothingRepository.save(clothing);
    }
}
