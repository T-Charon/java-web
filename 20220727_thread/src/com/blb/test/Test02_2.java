package com.blb.test;

/**
 * @Author Charon
 * @Date 2022/8/2
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class Test02_2 {

    public static boolean isPalindrome(String s) {
       //0-9:48-57 A-Z:65-90 A-Z:97-122
        int length = s.length();
        ArrayList<Character> arr = new ArrayList<>(62);
        StringBuilder str = new StringBuilder();
        char c1[] ={'0','1','2','3','4','5','6','7','8','9','Z','X','C','V','B','N','M','A','S',
                'D','F','G','H','J','K','L','Q','W','E','R','T','Y','U','I','O','P','z','x',
                'c','v','b','n','m','a','s','d','f','g','h','j','k','l','q','w','e','r','t',
                'y','u','i','o','p'};
        for (int i = 0; i < 62; i++) {
            arr.add(c1[i]);
        }

        //去掉字符串中多余字符,返回最新字符串
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(arr.contains(c)){
                str.append(c);
            }
        }

        //判断是否为回文
        int i = str.length() ;
        String substring = str.substring(0, i / 2);
        //反转后半段
        StringBuilder reverse = str.reverse();
        String substring1 = reverse.substring(0, i / 2);
        //取前半段进行对比
        if(substring1.equalsIgnoreCase(substring)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

}
