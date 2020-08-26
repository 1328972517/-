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
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {


           return accountDao.findAll();

    }

    @Override
    public Account findAccountById(Integer accountId)
    {
            return findAccountById(accountId);

    }

    @Override
    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
             accountDao.updateAccount(account);

    }

    @Override
    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

            System.out.println("begin transfer!!");
            Account source=accountDao.findAccountByName(sourceName);
            Account target=accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
//            int i=1/0;
            accountDao.updateAccount(target);





    }
}