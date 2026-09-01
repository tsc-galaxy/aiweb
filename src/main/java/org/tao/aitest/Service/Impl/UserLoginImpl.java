package org.tao.aitest.Service.Impl;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.tao.aitest.Eume.USER;
import org.tao.aitest.Repository.UserLoginRep;
import org.tao.aitest.Service.UserLoginService;
import org.tao.aitest.VO.UserLoginVO;
import org.tao.aitest.dto.UserLoginDto;
import org.tao.aitest.dto.entity.UserLogin;

@Service
public class UserLoginImpl implements UserLoginService {
    @Resource
    private UserLoginRep userLoginRep;
    @Override
    public UserLoginVO userLogin(String uuid) throws Exception {
        UserLogin userLogin = userLoginRep.findByUserId(uuid)
                .orElseThrow(() -> new Exception(USER.LOGIN_ERROR.getMessage()));

        if (userLogin ==null){
            throw new Exception(USER.LOGIN_ERROR.getMessage());
        }

        return new UserLoginVO(userLogin.getUserName(),
                userLogin.getUuid(),
                userLogin.getTel());
    }

    @Override
    @Transactional
    public UserLoginVO userSigin(UserLoginDto userLoginDto) throws Exception {
        UserLogin userLogin = userLoginRep.findByUserId(userLoginDto.getUuid())
                .orElseThrow(() -> new Exception(USER.LOGIN_ERROR.getMessage()));

        if (userLogin !=null){
            throw new Exception(USER.LOGIN_ERROR.getMessage());
        }
        userLogin.builder()
                .userName(userLoginDto.getUserName())
                //.password(passwordEncoder.encode(request.getPassword()))  // 密码加密
                .password(userLoginDto.getPassword())
                .build();

        return new UserLoginVO(userLogin.getUserName(),
                userLogin.getUuid(),""
                );
    }
}
