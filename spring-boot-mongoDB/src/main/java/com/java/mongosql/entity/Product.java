package com.java.mongosql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    private String id;

    private String name;

    private int stock;

    private String type;

    private HashMap seller;

    private boolean active;

    private String description;

    private Date createdTime;

}
