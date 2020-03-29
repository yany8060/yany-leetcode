package com.yany.swordoffer;

public class _17_Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        new _17_Print1ToMaxOfNDigits().printPrint1ToMaxOfNDigits(3);
    }

    public void printPrint1ToMaxOfNDigits(int n) {
        if (n < 0)
            return;
        if (n == 0) {
            System.out.println("0");
        }
        byte[] num = new byte[n];
        //初始化
        for (int i = 0; i < num.length; i++) {
            num[i] = 0;
        }
        while (!increment(num)) {
            print(num);
        }
    }

    private boolean increment(byte[] num) {
        boolean isEnd = false;
        byte nTakeOver = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            byte nSum = (byte) (num[i] + nTakeOver);
            if (i == num.length - 1) {
                nSum++;
            }
            if (nSum > 9) {
                if (i == 0) {
                    isEnd = true;
                } else {
                    nTakeOver = 1;
                    num[i] = 0;
                }
            } else {
                num[i] = nSum;
                isEnd = false;
                break;
            }
        }
        return isEnd;
    }

    private void print(byte[] num) {
        boolean isBegin = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0 && !isBegin) {
                isBegin = true;
            }
            if (isBegin) {
                sb.append(num[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
