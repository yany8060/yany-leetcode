package com.yany.swordoffer.nk;

public class JZ10 {
    public static void main(String[] args) {
        System.out.println(new JZ10().Fibonacci(10));
    }

    public int Fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }

        int x = 1;
        int y = 1;

        while (n - 2 > 0) {
            n--;
            int tmp = x + y;
            x = y;
            y = tmp;
        }

        return y;
    }
}
