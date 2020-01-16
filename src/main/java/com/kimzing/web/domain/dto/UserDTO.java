package com.kimzing.web.domain.dto;

import com.kimzing.web.domain.vo.GenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息实体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 12:52
 */
@Data
@ApiModel(value = "用户实体")
public class UserDTO {

    @ApiModelProperty(value = "用户ID", example = "1", required = false)
    private Long id;

    @ApiModelProperty(value = "用户名", example = "rose", required = true)
    private String username;

    @ApiModelProperty(value = "用户密码", example = "123456", required = true)
    private String password;

    @ApiModelProperty(value = "用户年龄", example = "18", allowableValues = "range[1, 150]", required = false)
    private Integer age;

    @ApiModelProperty(value = "用户性别", example = "MAN", required = true)
    private GenderEnum gender;

}
