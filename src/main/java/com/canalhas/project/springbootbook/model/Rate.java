package com.canalhas.project.springbootbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rates")
public class Rate {
    @Id
    private String id;

    private String bookId;

    private float rate;
}
