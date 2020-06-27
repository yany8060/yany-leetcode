package com.yany.ali.bank;

/**
 * 尝试用java编写一个转账和取款接口，传入主要业务参数包括转出账号，转入账号，转账金额，
 * 完成转出和转入账号的资金处理，该服务要确保在资金处理时转出账户的余额不会透支，金额计算准确。
 *
 * @author yanyong on 2020/6/20
 */
public class Operate {


    /**
     * 转账
     */
    public void transfer(Account from, Account to, int money) {

    }

    /**
     * 取款
     */
    public void take(Account from, int money) {
        // 读锁定账号
        // 1. 查询账号中的 余额
        // 2. 比较取款金额

        // 写锁锁定账号
        // 3. 账号扣款更新
        // 释放写锁锁定账号

        // 解读锁账号
    }



}
