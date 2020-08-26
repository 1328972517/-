package com.zry.service.impl;

import com.zry.dao.IAccountDao;
import com.zry.domian.Account;
import com.zry.service.IAccountService;
import com.zry.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务控制应该是在业务层
 * @author admin
 */
public class AccountServiceImpl_OLD implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {

        try {//1.开启事务
            txManager.beginTransaction();
             //2.执行操作
            List<Account> accounts=accountDao.findAll();
             //3.提交事务
            txManager.commit();
             //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);

        } finally {
            //6.释放连接
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId)
    {
        try {//1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account=findAccountById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);


        } finally {
            //6.释放连接
            txManager.release();
        }

    }

    @Override
    public void saveAccount(Account account) {
        try {//1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();

        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);


        } finally {
            //5.释放连接
            txManager.release();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {//1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();

        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);


        } finally {
            //5.释放连接
            txManager.release();
        }

    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {//1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            txManager.commit();

        } catch (Exception e) {
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);


        } finally {
            //6.释放连接
            txManager.release();
        }

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {//1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            //2.1根据名称查询转出账户 2.2根据名称查询转入账户  2.3转出账户减钱 2.4转入账户加钱 2.5更新转出账户 2.6更新转入账户
            Account source=accountDao.findAccountByName(sourceName);
            Account target=accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
//            int i=1/0;
            accountDao.updateAccount(target);

            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();

        } finally {
            //5.释放连接
            txManager.release();
        }




    }
}