package com.yany;

import java.util.Scanner;

/**
 * @author yanyong on 2020/2/29
 */
public class Main {

    public static int l = 0;
    public static int s = 0;
    public static int t = 0;
    public static int m = 0;


    public static void main(String[] args) {
        String s = "abcderf";

        System.out.println(s.substring(1, 3));
    }

    public static void xxxx(String[] args) {
        Scanner in = new Scanner(System.in);


        String str = in.nextLine();
        String[] _s = str.split(" ");

        s = Integer.valueOf(_s[0]);
        t = Integer.valueOf(_s[1]);
        m = Integer.valueOf(_s[2]);

        str = in.nextLine();
        String[] _s2 = str.split(" ");

        int[] stones = new int[l + t];
        for (int i = 0; i < stones.length; i++) {
            stones[i] = 0;
        }

        for (int i = 0; i < _s2.length; i++) {
            int num = Integer.valueOf(_s2[i]);
            stones[num] = 1;
        }
        jumpStone(l, stones);
    }


    public static void jumpStone(int l, int[] stones) {
        int[] dp = new int[l + t];
        for (int i = 0; i < l; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;


        for (int i = s; i < l + t; i++) {
            for (int j = i - t; j <= i - s; j++) {

                if (j >= 0 && dp[j] >= 0) {
                    System.out.println(j + " " + dp[j]);
                    if (dp[i] == -1) {
                        dp[i] = dp[j] + stones[i];
                    } else {
                        if (dp[i] > (dp[j] + stones[i])) {
                            dp[i] = dp[j] + stones[i];
                        }
                    }

                }

            }
        }


        int min = 0;
        for (int i = s; i < (l + t); i++) {
            min = Math.max(dp[i], min);
        }
        System.out.println(min);
    }


}
