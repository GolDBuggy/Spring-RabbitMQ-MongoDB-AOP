package com.java.mongosql.consumer;

import com.java.mongosql.config.MessageConfig;
import com.java.mongosql.entity.Product;
import com.java.mongosql.entity.ProductStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.java.mongosql.config.MessageConfig.*;

@Component
public class User {


    @RabbitListener(queues = "spring_mongo_queue")
    public void consumeMessageQueue(ProductStatus status){
        System.out.println("Message recieved from Queue= "+status);
    }



}
