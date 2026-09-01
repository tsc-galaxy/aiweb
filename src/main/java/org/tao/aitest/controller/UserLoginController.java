package org.tao.aitest.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.tao.aitest.Service.Impl.UserLoginImpl;
import org.tao.aitest.VO.UserLoginVO;
import org.tao.aitest.dto.UserLoginDto;


@RestController
@RequestMapping("/user_login")
public class UserLoginController {

    @Resource
    private UserLoginImpl userLoginImpl;

    @PostMapping("/login")
    public UserLoginVO userLogin(@RequestBody UserLoginDto userLoginDto) throws Exception {
        UserLoginVO userLoginVO = userLoginImpl.userLogin(userLoginDto.getUuid());

        return userLoginVO;
    }
    @PostMapping("/sigin_up")
    public String userSiginUp(@RequestBody UserLoginDto userLoginDto) throws Exception {

        UserLoginVO userLoginVO = userLoginImpl.userSigin(userLoginDto);

        return "注册成功";
    }
}
