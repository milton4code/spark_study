package com.milton.spark.scala;

import org.apache.commons.lang3.StringUtils;

public class StringDemo {
    public static void main(String[] args) {
        String str = "recommend/?&label=37839&get_top_recommend?scc&accesstoken=R5A7ACDE1U30969123K773B3E5AI2D28A8C0P8M2FF8B1EV10400WDCE5D0A2511&label=37839&label=37839";
        String str1 = "abcdeadd";
        System.out.println(str1.indexOf("d"));
        System.out.println(str1.indexOf("d",6));
        int index1 = str.indexOf("&accesstoken=");
        int index2 = str.indexOf("&",index1+1);
        String target = str.substring(index1+"&accesstoken=".length(),index2);
        System.out.println(StringUtils.substringBetween(str,"&accesstoken=","&"));
        System.out.println(target);

    }
}
