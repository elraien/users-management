package com.restapi.usersmanagement.service;

import com.restapi.usersmanagement.model.Unit;
import com.restapi.usersmanagement.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }
}
