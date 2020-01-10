package com.kimzing.web.service;

import com.kimzing.base.utils.result.ApiResult;
import com.kimzing.web.domain.dto.UserDTO;

/**
 * 用户模拟服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 16:16
 */
public interface UserService {

    ApiResult save(UserDTO userDTO);

    ApiResult remove(Long id);

    ApiResult update(UserDTO userDTO);

    ApiResult find(Long id);

    ApiResult list(Integer pageNum, Integer pageSize);

}
