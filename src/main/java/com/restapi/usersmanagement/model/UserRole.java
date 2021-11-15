package com.restapi.usersmanagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
@EntityListeners(AuditingEntityListener.class)
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int version;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int unitId;

    @Column(nullable = false)
    private int roleId;

    @Column(nullable = false)
    private LocalDateTime validFrom;

    private LocalDateTime validTo;
}
