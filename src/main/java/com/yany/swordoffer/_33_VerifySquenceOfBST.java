package com.yany.swordoffer;

public class _33_VerifySquenceOfBST {

    public static void main(String[] args) {
        System.out.println(new _33_VerifySquenceOfBST().VerifySquenceOfBST(new int[]{5, 9, 6, 9, 11, 10, 8}));
        //System.out.println(new _33_VerifySquenceOfBST().VerifySquenceOfBST(new int[]{4, 6, 7, 5}));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int mid = -1;
        for (int i = start; i <= end; i++) {
            if (root > sequence[i]) {
                continue;
            }
            mid = i;
            break;
        }

        for (int i = mid; i <= end; i++) {
            if (root > sequence[i]) {
                return false;
            }
        }

        System.out.println(start + " " + (mid - 1) + " " + mid + " " + end);
        return VerifySquenceOfBST(sequence, start, mid - 1) && VerifySquenceOfBST(sequence, mid, end - 1);
    }

}
