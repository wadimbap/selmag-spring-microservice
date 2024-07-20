package com.wadimbap.catalogue.id;

public record ProductCategoryId(long value) {
    public static ProductCategoryId fromLong(long value) {
        return value > 0 ? new ProductCategoryId(value) : null;
    }
}
