package com.kimzing.web.service.impl;

import com.kimzing.base.utils.result.ApiResult;
import com.kimzing.web.domain.dto.UserDTO;
import com.kimzing.web.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户模拟服务实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 16:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public ApiResult getByName(String name) {
        return ApiResult.success();
    }

    @Override
    public ApiResult getByAge(Integer ageFrom, Integer ageTo) {
        return ApiResult.success();
    }

    @Override
    public ApiResult getByEmail(String email) {
        return ApiResult.success();
    }

    @Override
    public ApiResult getByGender(String gender) {
        return ApiResult.success();
    }

    @Override
    public ApiResult save(UserDTO userDTO) {
        return ApiResult.success();
    }

    @Override
    public ApiResult update(UserDTO userDTO) {
        return ApiResult.success();
    }

}
