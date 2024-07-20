package com.wadimbap.customer.api;

import com.wadimbap.customer.dto.ProductCategoryData;
import com.wadimbap.customer.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {
    Optional<ProductCategoryData> findProductCategory(ProductCategoryId id);
}
