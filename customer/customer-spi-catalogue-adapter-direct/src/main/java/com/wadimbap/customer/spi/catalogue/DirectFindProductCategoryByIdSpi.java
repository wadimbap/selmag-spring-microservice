package com.wadimbap.customer.spi.catalogue;

import com.wadimbap.catalogue.api.FindProductCategoryApi;
import com.wadimbap.customer.dto.ProductCategoryData;
import com.wadimbap.customer.id.ProductCategoryId;

import java.util.Optional;

public class DirectFindProductCategoryByIdSpi implements FindProductCategoryByIdSpi {

    private final FindProductCategoryApi findProductCategoryApi;

    public DirectFindProductCategoryByIdSpi(FindProductCategoryApi findProductCategoryApi) {
        this.findProductCategoryApi = findProductCategoryApi;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return findProductCategoryApi.findProductCategory(new com.wadimbap.catalogue.id.ProductCategoryId(id.value()))
                .map(category -> new ProductCategoryData(new ProductCategoryId(
                        category.id().value()),
                        category.title(),
                        category.details()));
    }
}
