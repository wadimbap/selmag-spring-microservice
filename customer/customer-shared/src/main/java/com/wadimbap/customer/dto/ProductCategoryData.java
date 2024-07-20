package com.wadimbap.customer.dto;

import com.wadimbap.customer.id.ProductCategoryId;

public record ProductCategoryData(ProductCategoryId id, String title, String details) {
}
