package com.wadimbap.catalogue.api;

import com.wadimbap.catalogue.dto.ProductCategoryData;
import com.wadimbap.catalogue.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {

    Optional<ProductCategoryData> findProductCategory(ProductCategoryId id);
}
