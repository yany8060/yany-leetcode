package com.yany.mark;

import java.util.ArrayList;
import java.util.List;

public class Algorithm45_0 {

    public static int getMax(int[] a) {
        int sum = 0;
        List<Integer> myList = new ArrayList<>();
        for (int aa : a) {
            sum += aa;
            myList.add(aa);
        }
        for (int i = a.length; i > 0; i--) {
            if (sum % i == 0) {
//                if (ifExsits(myList, sum / i, sum / i)) {
//                    return i;
//                }

                if (ifExit(myList, sum / i)) {
                    return i;
                }

            }
        }
        return 1;
    }

    static boolean ifExsits(List<Integer> rootList, int num, int orgNum) {
        if (rootList.size() == 0 && num == orgNum) {
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < rootList.size(); i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < rootList.size(); j++) {
                if (j != i) {
                    subList.add(rootList.get(j));
                }
            }
            if (rootList.get(i) == num) {
                flag = flag || ifExsits(subList, orgNum, orgNum);
            } else if (rootList.get(i) < num) {
                flag = flag || ifExsits(subList, num - rootList.get(i), orgNum);
            }
        }
        return flag;
    }

    static boolean ifExit(List<Integer> rootList, int target) {
        for (int i = 0; i < rootList.size(); i++) {
            if (target == rootList.get(i)) {
                return true;
            }
        }

        boolean flag = false;
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < rootList.size(); i++) {
            for (int j = 0; j < rootList.size(); j++) {
                if (j != i) {
                    subList.add(j);
                }
            }
            flag = flag || ifExit(subList, target - rootList.get(i));
        }

        return flag;


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[] a = {1, 2, 3, 6, 6};
        int[] a = {3, 3, 6, 2, 4};
        int b = getMax(a);
        System.out.println(b);
    }

}
