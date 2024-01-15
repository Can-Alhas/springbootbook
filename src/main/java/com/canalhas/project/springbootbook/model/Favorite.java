package com.canalhas.project.springbootbook.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "favorites")
public class Favorite {
    @Id
    private String id;
    private String username;
    private String bookName;
}

