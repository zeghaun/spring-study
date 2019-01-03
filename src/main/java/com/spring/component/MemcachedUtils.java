/*
 * Copyright (c) 2016, 2016. All rights reserved.
 */
package com.spring.component;

import com.danga.MemCached.MemCachedClient;


public class MemcachedUtils {
    public static MemCachedClient getMemCachedClient() {
        return (MemCachedClient) Application.getApplicationContext().getBean("memcachedClient");
    }
}
