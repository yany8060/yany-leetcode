package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong on 2020/5/2
 */
public class _93_RestoreIPAddresses {

    public static void main(String[] args) {
        new _93_RestoreIPAddresses().restoreIpAddresses("010010");
    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return result;
        }

        backTrack(s, 0, 1, "");


        return result;
    }

    List<String> result = new ArrayList<>();


    public void backTrack(String s, int l, int r, String ip) {
        if (ip.split("\\.").length == 4) {
            System.out.println(ip);
            if (ip.length() - 4 == s.length()) {
                result.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }

        while (r - l <= 3 && r <= s.length()) {
            String ipTmp = s.substring(l, r);
            if (r - l != 1 && ipTmp.startsWith("0")) {
                break;
            }
            if (Integer.parseInt(ipTmp) > 255) {
                break;
            }
            ip = ip + ipTmp + ".";
            backTrack(s, r, r + 1, ip);
            r++;
            ip = ip.substring(0, ip.length() - (ipTmp.length() + 1));
        }
    }
}
