package com.yany.leetcode;

import java.util.*;

/**
 * @author yanyong on 2020/6/10
 */
public class _20_ValidParentheses {

    public static void main(String[] args) {
        new _20_ValidParentheses().isValid("]");
    }


    Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char tmp = stack.pop();
            if (map.get(tmp).compareTo(s.charAt(i)) != 0) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


}
