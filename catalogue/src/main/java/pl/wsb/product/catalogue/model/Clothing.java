package pl.wsb.product.catalogue.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
public class Clothing {
    @Id
    private String id;

    @NotNull
    private String category;
}
