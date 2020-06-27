package com.yany.tt.huawei;

import java.util.Scanner;

/**
 * @author yanyong on 2020/2/25
 */
public class LastStringNum {

    public static void main(String[] args) {
        //控制台输入
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();

        int n = getLastStringNum(st);
        System.out.println(n);

    }

    public static int getLastStringNum(String st) {
        if (st == null || st.equals("")) {
            return 0;
        }
        String[] ss = st.split(" ");
        return ss[ss.length - 1].length();
    }
}
