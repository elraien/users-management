package com.restapi.usersmanagement.controller;

import com.restapi.usersmanagement.model.Role;
import com.restapi.usersmanagement.model.Unit;
import com.restapi.usersmanagement.repository.UnitRepository;
import com.restapi.usersmanagement.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping(value="/units")
    List<Unit> getAllUnits(){
        return unitService.getAllUnits();
    }
}
