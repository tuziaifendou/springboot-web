package com.kimzing.web.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户创建事件.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/1/3 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedEvent {

    private String username;

}
