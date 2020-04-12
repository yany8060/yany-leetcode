package com.yany.swordoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _38_Permutation {
    public ArrayList<String> Permutation(String pStr) {
        ArrayList<String> list = new ArrayList<>();
        if (pStr == null || pStr.equals("")) {
            return list;
        }
        Permutation(pStr.toCharArray(), 0, list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new _38_Permutation().Permutation("abc"));
    }

    public void Permutation(char[] pStr, int begin, ArrayList<String> list) {
        if (begin == pStr.length - 1) {
            list.add(new String(pStr));
            return;
        }

        Set<Character> charSet = new HashSet<>();
        for (int i = begin; i < pStr.length; i++) {
            if (i != begin && charSet.contains(pStr[i])) {
                continue;
            }
            charSet.add(pStr[i]);

            char tmp = pStr[i];
            pStr[i] = pStr[begin];
            pStr[begin] = tmp;

            Permutation(pStr, begin + 1, list);

            tmp = pStr[i];
            pStr[i] = pStr[begin];
            pStr[begin] = tmp;
        }
    }

}
