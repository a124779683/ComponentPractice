package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file TestMall.java
 * @brief
 * @date 2017/2/18
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class TestMall {


    /**
     * result : [{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 16:09:04","lastOptUser":"SAP_WCM","mailbox":"","phone":"010-65288866","postcode":"100000","shopName":"王府井店","sid":1001,"street":"东城区王府井大街300号工美大厦5层"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 16:09:34","lastOptUser":"SAP_WCM","mailbox":"","phone":"010-85278090","postcode":"100000","shopName":"亚运村店","sid":1002,"street":"朝阳区亚运村北苑路158号家和物美三层"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-18 15:07:10","lastOptUser":"SAP_CHEN","mailbox":"","phone":"010-88029010","postcode":"100000","shopName":"首体店","sid":1003,"street":"海淀区中关村南大街甲56号（白石桥家乐福、国美楼上四层）"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 16:10:16","lastOptUser":"SAP_WCM","mailbox":"","phone":"010-88283350","postcode":"100000","shopName":"五棵松店","sid":1004,"street":"海淀区西翠路5号今日商业中心一层（沃尔玛楼上、苏宁电器西侧）"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 16:10:39","lastOptUser":"SAP_WCM","mailbox":"","phone":"010-51721200","postcode":"100000","shopName":"中关村店","sid":1005,"street":"海淀区北四环西路52号中关村海龙大厦西侧中芯大厦一层"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 16:11:02","lastOptUser":"SAP_WCM","mailbox":"","phone":"010-65804883","postcode":"100000","shopName":"朝阳门店","sid":1006,"street":"朝阳区朝外大街19号华普大厦二层"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 16:12:04","lastOptUser":"SAP_WCM","mailbox":"","phone":"010-68516955","postcode":"100000","shopName":"三里河店","sid":1007,"street":"西城区月坛南街30号（西单万方商场三层）"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 16:51:55","lastOptUser":"SAP_WCM","mailbox":"","phone":"010-59578666","postcode":"100000","shopName":"来广营店","sid":1008,"street":"朝阳区来广营香宾路66-1号（欧尚超市四层）"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 17:07:14","lastOptUser":"SAP_WCM","mailbox":"","phone":"","postcode":"","shopName":"回龙观店","sid":1010,"street":""},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 17:07:33","lastOptUser":"SAP_WCM","mailbox":"","phone":"","postcode":"","shopName":"草桥店","sid":1011,"street":""},{"city":"杭州市","country":"CN","district":"010","lastOptDate":"2013-09-13 17:07:33","lastOptUser":"SAP_WCM","shopName":"下沙店","sid":1301},{"city":"杭州市","country":"CN","district":"010","lastOptDate":"2013-09-13 17:07:33","lastOptUser":"SAP_WCM","postcode":"100000","shopName":"杭州笕桥店","sid":1311,"street":"杭州"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 17:07:59","lastOptUser":"SAP_WCM","mailbox":"","phone":"","postcode":"100000","shopName":"上品本网店","sid":2000,"street":"朝阳区来广营香宾路66-1号（欧尚超市B1/B3）"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 17:08:26","lastOptUser":"SAP_WCM","mailbox":"","phone":"","postcode":"100000","shopName":"天猫虚拟店","sid":2001,"street":"朝阳区来广营香宾路66-1号（欧尚超市B1/B3）"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-13 17:22:50","lastOptUser":"SAP_WCM","mailbox":"","phone":"","postcode":"100000","shopName":"当当虚拟店","sid":2002,"street":"朝阳区来广营香宾路66-1号（欧尚超市B1/B3）"},{"city":"北京市","contactPerson":"","country":"CN","district":"010","houseNumber":"","lastOptDate":"2013-09-02 14:34:18","lastOptUser":"SAP_CJM","mailbox":"","phone":"","postcode":"100000","shopName":"淘宝虚拟店","sid":2003,"street":"朝阳区来广营香宾路66-1号（欧尚超市B1/B3）"},{"city":"","contactPerson":"","country":"","district":"","houseNumber":"","lastOptDate":"2013-09-02 14:34:18","lastOptUser":"SAP_CJM","mailbox":"","phone":"","postcode":"","shopName":"DC分销中心","sid":5000,"street":""},{"shopName":"虚拟代销DC","sid":5001},{"shopName":"杭州DC分销中心","sid":5300},{"shopName":"杭州笕桥DC分销中心","sid":5310}]
     * success : true
     */

    private String success;
    private List<Mall> result;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Mall> getResult() {
        return result;
    }

    public void setResult(List<Mall> result) {
        this.result = result;
    }
}
