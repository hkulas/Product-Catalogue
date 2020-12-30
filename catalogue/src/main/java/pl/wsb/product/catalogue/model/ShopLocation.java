package pl.wsb.product.catalogue.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class ShopLocation {

    @Id
    private String id;

    private String address;

    private Double[] location;


}
