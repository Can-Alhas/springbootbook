package com.canalhas.project.springbootbook.service.impl;

import com.canalhas.project.springbootbook.model.Rate;
import com.canalhas.project.springbootbook.repository.RateRepository;
import com.canalhas.project.springbootbook.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    @Autowired
    public RateServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public void rateBook(String bookId, Rate rate) {

        rate.setBookId(bookId);
        rateRepository.save(rate);
    }
}
