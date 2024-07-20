package com.wadimbap.catalogue.spi;

import com.wadimbap.catalogue.dto.ProductCategoryData;
import com.wadimbap.catalogue.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {

    Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id);
}
