package com.shopin.commonlibrary.entity;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

/**
 * @author 蒋洪波
 * @version 2.0
 * @file ReplenishDeserializer.java
 * @brief 补货商品反序列化对象，样板对象有可能为空
 * @date 2017/1/8
 * Copyright (c) 2017, 商品折扣
 * All rights reserved.
 */
public class UserMayBeEmptyStringDeserializer implements JsonDeserializer<UserEntity> {

    @Override
    public UserEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        UserEntity defValue = null;
        try {
            if (json.isJsonObject()) {

                JsonObject jsonObject = json.getAsJsonObject();

                JsonElement memberSid = jsonObject.get("memberSid");
                JsonElement answer = jsonObject.get("answer");
                JsonElement nickName = jsonObject.get("nickName");
                JsonElement question = jsonObject.get("question");
                JsonElement realName = jsonObject.get("realName");
                JsonElement registFrom = jsonObject.get("registFrom");
                JsonElement registTime = jsonObject.get("registTime");

                JsonElement sid = jsonObject.get("sid");
                JsonElement idCard = jsonObject.get("idCard");
                JsonElement profession = jsonObject.get("profession");
                JsonElement memberAddress = jsonObject.get("memberAddress");
                JsonElement completeDate = jsonObject.get("completeDate");
                JsonElement income = jsonObject.get("income");
                JsonElement birthdate = jsonObject.get("birthdate");
                JsonElement gender = jsonObject.get("gender");
                JsonElement optUid = jsonObject.get("optUid");
                JsonElement ipAddress = jsonObject.get("ipAddress");
                JsonElement mobile = jsonObject.get("mobile");

                JsonElement userPic = jsonObject.get("userPic");
                JsonElement mType = jsonObject.get("mType");
                long nowPoint = jsonObject.get("nowPoints").getAsLong();


                defValue = new UserEntity();

                if (userPic != null && !userPic.isJsonNull()) {
                    defValue.userPic = userPic.getAsString();
                }
                if (mType != null && !mType.isJsonNull()) {
                    defValue.mType = mType.getAsString();
                }
                if (String.valueOf(nowPoint) != null ) {
                    defValue.setNowPoint(nowPoint);
                }
                if (memberSid != null&& !memberSid.isJsonNull()) {
                    defValue.setMemberSid(memberSid.getAsString());
                }
                if (answer != null && !answer.isJsonNull()) {
                    defValue.answer = answer.getAsString();
                }
                if (nickName != null && !nickName.isJsonNull()) {
                    defValue.nickName = nickName.getAsString();
                }
                if (question != null&& !question.isJsonNull()) {
                    defValue.question = question.getAsString();
                }

                if (realName != null && !realName.isJsonNull()) {
                    defValue.realName = realName.getAsString();
                }
                if (registFrom != null && !registFrom.isJsonNull()) {
                    defValue.registFrom = registFrom.getAsString();
                }
                if (registTime != null && !registTime.isJsonNull()) {
                    defValue.registTime = registTime.getAsString();
                }
                if (sid != null && !sid.isJsonNull()) {
                    defValue.sid = sid.getAsString();
                }
                if (idCard != null && !idCard.isJsonNull()) {
                    defValue.idCard = idCard.getAsString();
                }
                if (profession != null && !profession.isJsonNull()) {
                    defValue.profession = profession.getAsString();
                }
                if (memberAddress != null && !memberAddress.isJsonNull()) {
                    defValue.memberAddress = memberAddress.getAsString();
                }
                if (completeDate != null && !completeDate.isJsonNull()) {
                    defValue.completeDate = completeDate.getAsString();
                }
                if (income != null && !income.isJsonNull()) {
                    defValue.income = income.getAsString();
                }
                if (birthdate != null && !birthdate.isJsonNull()) {
                    defValue.birthdate = birthdate.getAsString();
                }
                if (gender != null && !gender.isJsonNull()) {
                    defValue.gender = gender.getAsString();
                }
                if (optUid != null && !optUid.isJsonNull()) {
                    defValue.optUid = optUid.getAsString();
                }
                if (ipAddress != null && !ipAddress.isJsonNull()) {
                    defValue.ipAddress = ipAddress.getAsString();
                }
                if (mobile != null && !mobile.isJsonNull()) {
                    defValue.mobile = mobile.getAsString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return defValue;
    }
}
