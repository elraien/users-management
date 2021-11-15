package com.restapi.usersmanagement.repository;

import com.restapi.usersmanagement.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findUserRoleByUserId(int userId);

    List<UserRole> findAllByUserIdAndUnitId(int userId, int unitId);

    @Query("select a from UserRole a where a.userId =:userId and a.unitId =:unitId and :givenTime >= a.validFrom and a.validTo IS NULL or a.validTo >= :givenTime")
    List<UserRole> findAllByUserIdAndUnitIdAndValidFromIsBefore(@Param("userId") int userId,
                                                                @Param("unitId") int unitId,
                                                                @Param("givenTime") LocalDateTime givenTime);
}
