package com.niit.shopadmin.redis.key;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-24 15:26
 **/
public class ProductKey extends BasePrefix {
    public ProductKey(long expire, String prefix) {
        super(expire, prefix);
    }

    public ProductKey(String prefix) {
        super(prefix);
    }

    public static final ProductKey getListHTML = new ProductKey("list:html");
}
