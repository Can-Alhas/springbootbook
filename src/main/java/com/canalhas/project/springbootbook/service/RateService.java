package com.canalhas.project.springbootbook.service;

import com.canalhas.project.springbootbook.model.Rate;

public interface RateService {

    void rateBook(String bookId, Rate rate);
}
