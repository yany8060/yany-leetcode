package com.yany.ali;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author yanyong on 2020/6/20
 */
public class CountTest {

    static Map<Integer, Integer> map = new ConcurrentHashMap<>();
    static volatile int count = 0;
    static volatile int nums = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 200; i++) {
                    map.put(i, i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (map.isEmpty()) {
                        continue;
                    }
                    for (Integer i : map.keySet()) {
                        count += i;
                        map.remove(i);
                        nums++;
                    }

                    if (nums == 200) {
                        break;
                    }
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(count);
    }


}
