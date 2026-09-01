package org.tao.aitest.Eume;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum USER {
     LOGIN_ERROR(10001, "登录失败");
    private final Integer code;
    private final String message;
}
