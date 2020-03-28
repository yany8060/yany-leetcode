package com.yany.swordoffer;

/**
 * @author yanyong on 2020/3/18
 */
public class TestMain {


    public static void main(String[] args) {
        String test = "adf-xxx-aa-ccc";
        System.out.println(test.substring(test.indexOf("-") + 1));
        System.out.println(test.substring(test.indexOf("d")));
    }

}
