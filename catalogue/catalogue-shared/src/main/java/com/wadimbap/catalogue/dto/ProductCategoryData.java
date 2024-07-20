package com.wadimbap.catalogue.dto;

import com.wadimbap.catalogue.id.ProductCategoryId;

public record ProductCategoryData(
        ProductCategoryId id,
        String title,
        String details,
        ProductCategoryId parentId,
        int version) {
}
