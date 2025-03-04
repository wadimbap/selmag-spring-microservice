package com.wadimbap;

import com.wadimbap.catalogue.api.usecase.FindProductCategoryUseCase;
import com.wadimbap.catalogue.spi.spring.jdbc.MappingSqlQueryFindProductCategoryById;
import com.wadimbap.customer.api.usecase.CustomerFindProductCategoryUseCase;
import com.wadimbap.customer.spi.catalogue.DirectFindProductCategoryByIdSpi;
import com.wadimbap.customer.spi.catalogue.spring.cache.CachedFindProductCategoryById;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@EnableCaching
@SpringBootApplication
public class SelmagFullApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelmagFullApplication.class, args);
    }

    @Bean
    FindProductCategoryUseCase findProductCategoryUseCase(DataSource dataSource) {
        return new FindProductCategoryUseCase(
                new MappingSqlQueryFindProductCategoryById(dataSource)
        );
    }

    @Bean
    CustomerFindProductCategoryUseCase customerFindProductCategoryUseCase(
            FindProductCategoryUseCase findProductCategoryUseCase,
            CacheManager cacheManager) {
        return new CustomerFindProductCategoryUseCase(
                new CachedFindProductCategoryById(
                        new DirectFindProductCategoryByIdSpi(findProductCategoryUseCase),
                        cacheManager.getCache("customer/product-categories/by-id"))
        );
    }
}
