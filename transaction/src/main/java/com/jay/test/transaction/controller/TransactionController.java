package com.jay.test.transaction.controller;

import com.jay.test.transaction.domain.User;
import com.jay.test.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/tests")
public class TransactionController {
    //TODO:mapper type exception 처리..
    @Autowired
    private TransactionService service;

    @GetMapping("/1")
    public void transactionTest1() {
        //트랜잭션 테스트 1
        //다량의 user insert중에 sql 에러 롤백 및 history 정상 입력 확인
        //상위에서 exception 발생시 test
        int i = 0;
        while (i < 30) {
            i++;
            User user = new User();
            user.setId(i);
            user.setName(i + "'s_name");
            user.setAddress(i + "'s_address");

            service.insertUser(user);

            if (i == 20) {
                throw new RuntimeException("runtime Exception");
            }
        }
    }

    @GetMapping("/2")
    public void transactionTest2() {
        //트랜잭션 테스트 1
        //대량의 user insert중에 exception 롤백 및 history 정상 입력 확인
    }

    @GetMapping("/3")
    public void transactionTest3() {
        //트랜잭션 테스트 1
        //대량의 user insert중에 exception 롤백 및 history 롤백
    }

}
