package com.restapi.usersmanagement.repository;

import com.restapi.usersmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select distinct a from User a JOIN UserRole ur ON (a.id = ur.userId) where ur.unitId =:unitId and :givenTime >= ur.validFrom and ur.validTo IS NULL or ur.validTo >= :givenTime")
    List<User> findAllByUnitIdAndValidUserRole(@Param("unitId") int unitId,
                                               @Param("givenTime") LocalDateTime givenTime);

    @Query("select a1.id, a1.name as name, a2.userId, a2.roleId from User a1 INNER JOIN UserRole a2 ON (a1.id=a2.userId) ")
    List<User> findAllByUnitIdAndUserRole(@Param("unitId") int unitId);
}
