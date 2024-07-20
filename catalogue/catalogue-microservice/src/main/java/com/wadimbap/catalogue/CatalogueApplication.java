package com.wadimbap.catalogue;

import com.wadimbap.catalogue.api.usecase.FindProductCategoryUseCase;
import com.wadimbap.catalogue.spi.spring.jdbc.MappingSqlQueryFindProductCategoryById;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CatalogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogueApplication.class, args);
    }

    @Bean
    FindProductCategoryUseCase findProductCategoryUseCase(DataSource dataSource) {
        return new FindProductCategoryUseCase(
                new MappingSqlQueryFindProductCategoryById(dataSource)
        );
    }
}
