package com.wadimbap.catalogue.api.usecase;

import com.wadimbap.catalogue.api.FindProductCategoryApi;
import com.wadimbap.catalogue.dto.ProductCategoryData;
import com.wadimbap.catalogue.id.ProductCategoryId;
import com.wadimbap.catalogue.spi.FindProductCategoryByIdSpi;

import java.util.Optional;

public class FindProductCategoryUseCase implements FindProductCategoryApi {

    private final FindProductCategoryByIdSpi findProductCategoryByIdSpi;

    public FindProductCategoryUseCase(FindProductCategoryByIdSpi findProductCategoryByIdSpi) {
        this.findProductCategoryByIdSpi = findProductCategoryByIdSpi;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategory(ProductCategoryId id) {
        return findProductCategoryByIdSpi.findProductCategoryById(id);
    }
}
