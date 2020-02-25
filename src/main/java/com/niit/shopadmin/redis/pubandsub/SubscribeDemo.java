package com.niit.shopadmin.redis.pubandsub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-25 14:28
 **/
@Component
public class SubscribeDemo implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println(new String(message.getBody()));
        System.out.println(new String(message.getChannel()));
    }
}
