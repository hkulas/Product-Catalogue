package pl.wsb.product.catalogue.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ShopLocation {

    @Id
    private String id;

    private Double[] location;


}
