package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author 张志强
 * @date 2017/2/17.
 * Copyright (c) 2017
 */
public class ExpressData {
    public String shipperCode;//快递公司编码
    public String logisticCode; //物流运单号
    public String success;  //成功与否:0-成功,1-失败
    public String reason;   //失败原因
    public String state;   //物流状态: 2-在途中，3-签收,4-问题件
    public List<ExpressList> traces;  //物流轨迹列表
}
