package com.kimzing.web.controller;

import com.kimzing.base.log.LogKim;
import com.kimzing.base.utils.result.ApiResult;
import com.kimzing.base.web.resolver.json.JsonParam;
import com.kimzing.web.domain.dto.UserDTO;
import com.kimzing.web.domain.dto.UserQueryDTO;
import com.kimzing.web.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 模拟用户控制层.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 11:37
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    UserService userService;

    @LogKim(desc = "新增用户")
    @PostMapping
    public ApiResult save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @LogKim(desc = "删除用户")
    @DeleteMapping("/{id}")
    public ApiResult remove(@PathVariable Long id) {
        return userService.remove(id);
    }

    @LogKim(desc = "更新用户")
    @PutMapping("/{id}")
    public ApiResult update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userDTO.setId(id);
        return userService.update(userDTO);
    }

    @LogKim(desc = "查找用户")
    @GetMapping("/{id}")
    public ApiResult find(@PathVariable Long id) {
        return userService.find(id);
    }

    @LogKim(desc = "查找用户列表")
    @GetMapping("/list")
    public ApiResult list(@JsonParam UserQueryDTO userQuery) {
        return userService.list(userQuery);
    }

}
