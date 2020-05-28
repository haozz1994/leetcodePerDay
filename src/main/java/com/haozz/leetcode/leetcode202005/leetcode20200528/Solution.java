package com.haozz.leetcode.leetcode202005.leetcode20200528;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/remove-comments/
 * leetcode:722.删除注释
 * <p>
 * 给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第i行源码。 
 * <p>
 * 详情见leetcode网页
 */
public class Solution {

    public static List<String> removeComments(String[] source) {

        List<String> result = new ArrayList<>();

        if (Objects.isNull(source) || source.length == 0) {
            return result;
        }

        //flag for in comments
        boolean inComments = false;

        for (String s : source) {

            if (!inComments && s.indexOf("//") < 0 && s.indexOf("/*") < 0 && s.indexOf("*/") < 0) {//正常行
                result.add(s);
            } else if (!inComments && s.indexOf("//") > -1) {//  //注释行
                result.add(s.substring(0, s.indexOf("//")));
            } else if (!inComments && s.indexOf("/*") > -1) {//    /*注释开始行
                if (s.indexOf("*/") > -1) {
                    continue;
                } else {
                    String substring = s.substring(0, s.indexOf("/*"));
                    if(!StringUtils.isEmpty(substring)){
                        result.add(substring);
                    }
                    inComments = true;
                }
            } else if (inComments && s.indexOf("*/") > -1) {//     /*注释结束行
                String substring = s.substring(s.indexOf("*/")+2);
                if(!StringUtils.isEmpty(substring)){
                    result.add(substring);
                }
                inComments = false;
            }
        }


        return result;

    }

    public static void main(String[] args) {
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};

        List<String> strings = removeComments(source);

        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println();
        System.out.println("======");
        System.out.println();

        String[] source1 = {"a/*comment", "line", "more_comment*/b"};

        List<String> strings1 = removeComments(source1);

        for (String string : strings1) {
            System.out.println(string);
        }


    }
}
