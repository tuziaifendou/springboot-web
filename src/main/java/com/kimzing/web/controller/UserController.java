package com.kimzing.web.controller;

import com.kimzing.base.utils.result.ApiResult;
import com.kimzing.web.domain.dto.UserDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * 模拟用户控制层.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 11:37
 */
@Api(tags = {"用户操作"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping
    @ApiOperation(value = "保存用户", notes = "保存时，ID由数据库生成，无需填写，有则忽略", tags = "保存")
    public ApiResult save(@RequestBody UserDTO userDTO) {
        return ApiResult.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", notes = "删除后无法恢复", tags = "删除")
    @ApiImplicitParam(name = "id", value = "用户ID", defaultValue = "1")
    public ApiResult remove(@PathVariable Long id) {
        return ApiResult.success();
    }

    @PutMapping
    @ApiOperation(value = "更新用户", notes = "id必填，其它属性存在则更新，否则忽略", tags = "更新")
    public ApiResult update(@RequestBody UserDTO userDTO) {
        return ApiResult.success();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查找用户", notes = "根据id查找单个用户", tags = "查找")
    public ApiResult find(@PathVariable @ApiParam(value = "用户ID", defaultValue = "2") Long id) {
        return ApiResult.success();
    }

    @GetMapping("/list")
    @ApiOperation(value = "查找用户列表", notes = "根据id查找单个用户", tags = "查找")
    public ApiResult list(@RequestParam @ApiParam(value = "当前页", defaultValue = "1") Integer pageNum,
                          @RequestParam @ApiParam(value = "页大小", defaultValue = "10") Integer pageSize) {
        return ApiResult.success();
    }

}
