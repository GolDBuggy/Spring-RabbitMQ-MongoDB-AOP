package com.java.mongosql.controller;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;


}
