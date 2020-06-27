package com.yany.tt.huawei;

import java.util.Scanner;

/**
 * @author yanyong on 2020/2/25
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String target = scanner.nextLine();


        System.out.println(countTarget(s, target));
    }

    public static int countTarget(String s, String target) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.toLowerCase();
        target = target.toLowerCase();
        return s.split(target).length - 1;
    }
}
