package com.kimzing.web.service.impl;

import com.kimzing.base.utils.bean.BeanUtil;
import com.kimzing.base.utils.page.PageResult;
import com.kimzing.base.utils.result.ApiResult;
import com.kimzing.web.domain.dto.UserDTO;
import com.kimzing.web.domain.event.UserCreatedEvent;
import com.kimzing.web.domain.po.UserPO;
import com.kimzing.web.repository.UserRepository;
import com.kimzing.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户模拟服务实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 16:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Resource
    ApplicationContext applicationContext;

    @Override
    public ApiResult save(UserDTO userDTO) {
        UserPO userPO = BeanUtil.mapperBean(userDTO, UserPO.class);
        userPO = userRepository.save(userPO);
        userDTO = BeanUtil.mapperBean(userPO, UserDTO.class);

        // 发布领域事件: 创建用户
        applicationContext.publishEvent(new UserCreatedEvent(userDTO.getUsername()));
        return ApiResult.success(userDTO);
    }

    @Override
    public ApiResult remove(Long id) {
        userRepository.remove(id);
        return ApiResult.success();
    }

    @Override
    public ApiResult update(UserDTO userDTO) {
        UserPO userPO = BeanUtil.mapperBean(userDTO, UserPO.class);
        userRepository.update(userPO);
        return ApiResult.success();
    }

    @Override
    public ApiResult find(Long id) {
        UserPO userPO = userRepository.find(id);
        UserDTO userDTO = BeanUtil.mapperBean(userPO, UserDTO.class);
        return ApiResult.success(userDTO);
    }

    @Override
    public ApiResult list(Integer pageNum, Integer pageSize) {
        PageResult pageResult = userRepository.list(pageNum, pageSize);
        List<UserDTO> userDTOList = BeanUtil.mapperList(pageResult.getData(), UserDTO.class);
        pageResult.setData(userDTOList);
        return ApiResult.success(pageResult);
    }
}
