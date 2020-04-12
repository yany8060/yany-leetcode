package com.yany.swordoffer;

public class _51_InverseParis {


    public int inversePairs(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }

        int[] copy = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }

        return inversePairsCore(data, copy, 0, data.length);
    }

    public int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }

        int length = (end - start) / 2;

        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] >= data[j]) {
                count += j - (start + length);
                copy[indexCopy--] = data[i--];
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        for (; i >= start; i--) {
            copy[indexCopy--] = data[i];
        }
        for (; j >= start + length + 1; j--) {
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }
}
