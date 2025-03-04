package com.wadimbap.customer.api.spring.webmvc;

import com.wadimbap.customer.api.FindProductCategoryApi;
import com.wadimbap.customer.api.spring.webmvc.presentation.ProductCategoryPresentationV1;
import com.wadimbap.customer.id.ProductCategoryId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerFindProductCategoryRestController {

    private final FindProductCategoryApi findProductCategoryApi;

    public CustomerFindProductCategoryRestController(FindProductCategoryApi findProductCategoryApi) {
        this.findProductCategoryApi = findProductCategoryApi;
    }

    @GetMapping(path = "/customer-api/catalogue/product-categories/{id:\\d+}",
            produces = "application/vnd.selmag.customer.product-category.v1+json")
    public ResponseEntity<ProductCategoryPresentationV1> findProductCategory(@PathVariable("id") long id) {
        return findProductCategoryApi.findProductCategory(new ProductCategoryId(id))
                .map(category -> ResponseEntity.ok(new ProductCategoryPresentationV1(
                        category.id().value(),
                        category.title(),
                        category.details()))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
