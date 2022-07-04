package com.java.mongosql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.lang.reflect.MethodSignature;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductStatus {

    private Product product;
    private String status;
    private String message;

}
