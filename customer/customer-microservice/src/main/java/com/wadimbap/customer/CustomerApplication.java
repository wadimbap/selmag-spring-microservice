package com.wadimbap.customer;

import com.wadimbap.customer.api.FindProductCategoryApi;
import com.wadimbap.customer.api.usecase.CustomerFindProductCategoryUseCase;
import com.wadimbap.customer.spi.catalogue.spring.cache.CachedFindProductCategoryById;
import com.wadimbap.customer.spi.catalogue.spring.web.RestClientFindProductCategoryByIdSpi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@EnableCaching
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CustomerFindProductCategoryUseCase customerFindProductCategoryUseCase(CacheManager cacheManager) {
        return new CustomerFindProductCategoryUseCase(
                new CachedFindProductCategoryById(
                        new RestClientFindProductCategoryByIdSpi(RestClient.builder().build()),
                        cacheManager.getCache("customer/product-categories/by-id")));
    }
}
