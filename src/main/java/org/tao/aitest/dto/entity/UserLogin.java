package org.tao.aitest.dto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table (name = "user")
@AllArgsConstructor
public class UserLogin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uuid;
    private String userName;
    private String tel;
    private String password;

}
