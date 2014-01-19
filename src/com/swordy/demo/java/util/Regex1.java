package com.swordy.demo.java.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1
{
    private static final String TAG = "JavaDemos.Regex";
    
    private static final String REGEX_IP = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
    
    public static void main(String[] args)
    {
        String regex = "(\\d{1,3}\\.?){4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("MediaQ-0014");
        while(matcher.find()){
            System.out.println("find");
        }
        System.out.println("pause");
        
        System.out.println("MyBox[000.0.1.0]".split(regex)[0]);
        System.out.println("MediaQ-0014".split(regex)[0]);
    }
}
