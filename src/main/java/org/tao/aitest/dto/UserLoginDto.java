package org.tao.aitest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginDto {
    @NotNull(message = "用户ID不能为空")
    private String uuid;
    @NotNull(message = "用户ID不能为空")
    private String userName;
    @NotNull(message = "用户ID不能为空")
    private String password;

}
