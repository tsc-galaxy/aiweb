package org.tao.aitest.Service;

import org.tao.aitest.VO.UserLoginVO;
import org.tao.aitest.dto.UserLoginDto;


public interface UserLoginService {
    public UserLoginVO userLogin(String uuid) throws Exception;
    public UserLoginVO userSigin(UserLoginDto userLoginDto) throws Exception;
}
