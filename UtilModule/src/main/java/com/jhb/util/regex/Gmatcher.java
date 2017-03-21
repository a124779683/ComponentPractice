package com.jhb.util.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gmatcher {
    private String des;//目标字符串
    private String pattern;//正则匹配

    private boolean isMatch;

    private Pattern pt;
    private Matcher mt;


    public Gmatcher(String pattern, String des){
        this.des = des;
        this.pattern = pattern;
        this.match();
    }

    private void match(){
        pt = Pattern.compile(this.pattern, Pattern.DOTALL);
        mt = pt.matcher(this.des);
//        isMatch = mt.matches();
        isMatch = mt.matches();
    }

    //是否匹配
    public boolean isMatch(){
        return isMatch;
    }
    //找到匹配字符
    public String findMatch(){
        if (isMatch){
            return mt.group();
        }
        return "";
    }
    public String findMatch(int index){
        if(isMatch){
            return mt.group(index);
        }
        return "";
    }
    public void findMatch(OnMatch matcher){
        while (mt.find()) {
            matcher.onMatch(mt);
        }
    }
}
