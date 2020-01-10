package com.kimzing.web.listener;

import com.kimzing.web.domain.event.UserCreatedEvent;
import com.kimzing.web.service.CartService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 购物车监听的相关事件.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/1/3 16:15
 */
@Component
public class CartListener {

    @Resource
    CartService cartService;

    /**
     * 监听用户创建事件，并创建购物车
     * @param userCreatedEvent
     */
    @EventListener
    public void listenUserCreated(UserCreatedEvent userCreatedEvent) {
        cartService.createCart(userCreatedEvent.getUsername());
    }

}
