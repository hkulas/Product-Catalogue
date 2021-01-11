package pl.wsb.product.catalogue.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Document
@Data
public class Product {
    @Id
    private String id;
    @NotNull
    private String category;
    @NotNull
    private String manufacturer;
    @NotNull
    private String name;
    @NotEmpty
    private List<String> photosUrls;

    private String description;

    private Map<String, Integer> sizes;
    private Map<String, String> otherParameters;
}
