package com.zry.dao;

import com.zry.domian.Account;

import java.util.List;

/**
 * 账户的持久层接口
 * @author admin
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     */
    void saveAccount(Account account);

    /**
     * 修改
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);


    /**
     * 根据名称查询账户
     * @param accountName
     * @return  如果有一个结果就返回,如果没有就返回null,如果有多个就抛异常
     */
    Account findAccountByName(String accountName);


}
