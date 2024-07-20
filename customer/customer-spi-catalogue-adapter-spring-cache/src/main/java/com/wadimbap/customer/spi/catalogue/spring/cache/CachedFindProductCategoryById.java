package com.wadimbap.customer.spi.catalogue.spring.cache;

import com.wadimbap.customer.dto.ProductCategoryData;
import com.wadimbap.customer.id.ProductCategoryId;
import com.wadimbap.customer.spi.catalogue.FindProductCategoryByIdSpi;
import org.springframework.cache.Cache;

import java.util.Optional;

public class CachedFindProductCategoryById implements FindProductCategoryByIdSpi {

    private final FindProductCategoryByIdSpi delegate;
    private final Cache cache;

    public CachedFindProductCategoryById(FindProductCategoryByIdSpi delegate, Cache cache) {
        this.delegate = delegate;
        this.cache = cache;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return Optional.ofNullable(cache.get(id.value(), ProductCategoryData.class))
                .or(() -> delegate.findProductCategoryById(id)
                        .map(category -> {
                            cache.put(category.id().value(), category);
                            return category;
                        }));
    }
}
