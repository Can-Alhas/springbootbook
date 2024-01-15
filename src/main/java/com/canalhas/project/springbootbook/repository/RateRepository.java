package com.canalhas.project.springbootbook.repository;

import com.canalhas.project.springbootbook.model.Rate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RateRepository extends MongoRepository<Rate, String> {
    List<Rate> findByBookId(String bookId);
}