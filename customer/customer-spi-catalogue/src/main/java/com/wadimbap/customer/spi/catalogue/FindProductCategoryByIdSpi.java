package com.wadimbap.customer.spi.catalogue;

import com.wadimbap.customer.dto.ProductCategoryData;
import com.wadimbap.customer.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {

    Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id);
}
