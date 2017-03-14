package com.shopin.commonlibrary.utils;

import junit.framework.Assert;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jianghongbo
 * @version 1.0
 * @file EncryptUtilTest.java
 * @brief
 * @date 2017/12/19
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class EncryptUtilTest {

    @Test
    public void testMD5Encode() throws Exception {
        String s = EncryptUtil.MD5Encode("123456");
//        Assert.assertEquals("e10adc3949ba59abbe56e057f20f883e", s);
        BigDecimal bigDecimal = new BigDecimal("4.44").setScale(1, BigDecimal.ROUND_HALF_UP);
        Assert.assertEquals(bigDecimal.floatValue(), 5);
    }
}