package pl.wsb.product.catalogue.model;

import java.util.List;

public class CategoriesWrapper {

    private List<String> categories;

    public CategoriesWrapper() {
    }

    public CategoriesWrapper(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getCategories() {
        return categories;
    }
}
