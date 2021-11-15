package com.restapi.usersmanagement.controller;

import com.restapi.usersmanagement.model.UserRole;
import com.restapi.usersmanagement.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserRoleController {
    Logger logger = Logger.getLogger(UserRoleController.class.getName());
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping(value = "/userroles")
    ResponseEntity<List<UserRole>> getUserRolesByUserIdAndUnitId(@RequestParam int userId, @RequestParam int unitId) {

        var result = userRoleService.getUserRolesByUserIdAndUnitId(userId, unitId);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/validuserroles")
    ResponseEntity<List<UserRole>> getValidUserRolesByUserIdAndUnitIdAtAGivenTime(@RequestParam int userId,
                                                                                  @RequestParam int unitId,
                                                                                  @RequestParam("datetime")
                                                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime givenTime) {
        var result = userRoleService.getValidUserRolesByUserIdAndUnitIdAtAGivenTime(userId, unitId, givenTime);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/userroles/{id}")
    ResponseEntity<?> deleteUserRole(@PathVariable(value = "id") @Min(1) int id,
                                     @RequestParam int version) {
        UserRole userRole = userRoleService.getUserRoleById(id);
        if (userRole == null) {
            logger.info(String.format("UserRole with id: %s does not exist.", id));
            return ResponseEntity.noContent().build();
        }

        if (userRole.getVersion() == version) {
            userRoleService.deleteUserRole(id);
            logger.info(String.format("UserRole with id: %s was successfully deleted.", id));
            return ResponseEntity.noContent().build();
        } else {
            logger.info(String.format("UserRole with id: %s can not be deleted because of version mismatch.", id));
            return ResponseEntity.badRequest().build();
        }
    }
}
