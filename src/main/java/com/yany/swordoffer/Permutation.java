package com.yany.swordoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yanyong on 2020/2/20
 */
public class Permutation {

    public static void main(String[] args) {
        new Permutation().permutation("abc");
    }

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }

        Set<String> set = new HashSet<>();
        permutation(str.toCharArray(), 0, set);
        return new ArrayList<>(set);
    }

    public Set<String> permutation(char[] str, int index, Set<String> list) {
        if (index == str.length - 1) {
            list.add(new String(str));
        }

        for (int i = index; i < str.length; i++) {
            swap(str, index, i);
            permutation(str, index + 1, list);
            swap(str, index, i); // 归位 使得位置为i的字符与下个位置进行交换
        }

        return list;
    }

    public void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }


}
