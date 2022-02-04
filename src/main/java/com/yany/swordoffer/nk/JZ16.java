package com.yany.swordoffer.nk;

public class JZ16 {
    public double Power(double base, int exponent) {
        double result = 1;
        if (exponent == 0) {
            return result;
        }
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        for (int i = 0; i < exponent; i++) {
            result = result * base;

        }
        return result;
    }
}
