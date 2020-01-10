package com.kimzing.web.domain.po;

import com.kimzing.base.utils.po.AbstractPO;
import com.kimzing.web.domain.vo.GenderEnum;
import lombok.Data;

/**
 * 用户信息实体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 12:52
 */
@Data
public class UserPO extends AbstractPO {

    private Long id;

    private String username;

    private String password;

    private Integer age;

    private GenderEnum gender;

}
