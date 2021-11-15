package com.restapi.usersmanagement.mapper;

import com.restapi.usersmanagement.dto.BaseDTO;
import com.restapi.usersmanagement.dto.UnitDTO;
import com.restapi.usersmanagement.model.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper {
    public Unit toUnitEntity(UnitDTO unitDTO) {
        return new Unit()
                .setName(unitDTO.getName())
                .setVersion(unitDTO.getVersion());
    }

    public UnitDTO toUnitDTO(Unit unit) {
        return (UnitDTO) new BaseDTO()
                .setName(unit.getName())
                .setVersion(unit.getVersion());
    }
}
