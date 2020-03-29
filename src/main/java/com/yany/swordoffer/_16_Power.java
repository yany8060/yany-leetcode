package com.yany.swordoffer;

/**
 *
 */
public class _16_Power {

    public static void main(String[] args) {
        System.out.println(new _16_Power().Power(2, -3));

    }

    public double Power2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

    public double Power(double base, int exponent) {
        if (exponent < 0) {
            return 1 / Power2(base, -exponent);
        } else {
            return Power2(base, exponent);
        }
    }


}
