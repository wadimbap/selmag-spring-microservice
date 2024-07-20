package com.wadimbap.customer.api.usecase;

import com.wadimbap.customer.api.FindProductCategoryApi;
import com.wadimbap.customer.dto.ProductCategoryData;
import com.wadimbap.customer.id.ProductCategoryId;
import com.wadimbap.customer.spi.catalogue.FindProductCategoryByIdSpi;

import java.util.Optional;

public class CustomerFindProductCategoryUseCase implements FindProductCategoryApi {

    private final FindProductCategoryByIdSpi findProductCategoryByIdSpi;

    public CustomerFindProductCategoryUseCase(FindProductCategoryByIdSpi findProductCategoryByIdSpi) {
        this.findProductCategoryByIdSpi = findProductCategoryByIdSpi;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategory(ProductCategoryId id) {
        return findProductCategoryByIdSpi.findProductCategoryById(id);
    }
}
