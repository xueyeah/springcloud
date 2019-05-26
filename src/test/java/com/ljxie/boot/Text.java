package com.ljxie.boot;

import java.util.Map;

public class Text {
    public static int k = 0;
    public static Text t1 = new Text("t1");
    public static Text t2 = new Text("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }
    static {
        print("静态块");
    }

    public Text(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String args[]) {
//        Text t = new Text("init");
        String str="hello";
        String str2="he"+new String("llo");
        String str3="he"+"llo";
        String str4=new String("he")+new String("llo");
        String str5=new String("hello");
        String str6=new String("hello");
        System.out.println(str6==str5);

//        Map map = new Map();
    }
}
