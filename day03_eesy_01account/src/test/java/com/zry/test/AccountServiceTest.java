package com.zry.test;

import com.zry.domian.Account;
import com.zry.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * 使用junit单元测试我们的配置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer() {
        as.transfer("aaa","bbb",100f);

    }

    @Test
    public void testFindAll() {
       List<Account> accounts= as.findAll();
       for(Account account:accounts){
           System.out.println(account);
       }
    }

    @Test
    public void testUpdate() {
        Account account = as.findAccountById(1);
        account.setMoney(1000f);
        as.updateAccount(account);
    }
}
