package com.restapi.usersmanagement.controller;

import com.restapi.usersmanagement.model.Role;
import com.restapi.usersmanagement.model.Unit;
import com.restapi.usersmanagement.service.UnitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UnitControllerTest {
    @InjectMocks
    UnitController unitController;

    @Mock
    UnitService unitService;

    @Test
    void testGetAllUnits() {
        // Prepare
        Unit unit1 = new Unit();
        Unit unit2 = new Unit();
        List<Unit> units = new ArrayList<>();
        units.add(unit1);
        units.add(unit2);

        when(unitService.getAllUnits()).thenReturn(units);

        // Perform
        List<Unit> actualResult = unitController.getAllUnits();

        // Verify
        assertThat(actualResult).isNotEmpty();
        assertThat(actualResult.size()).isEqualTo(2);
    }
}