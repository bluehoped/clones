package com.jay.test.transaction.service;

import com.jay.test.transaction.dao.TransactionMapper;
import com.jay.test.transaction.domain.User;
import com.jay.test.transaction.domain.UserHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

@Service
public class TransactionServiceLogic implements TransactionService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    private TransactionMapper mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUser(User user) {
        mapper.insertUser(user);
        UserHistory userHistory = user.getUserHistory();
        userHistory.setAction("insert");
        userHistory.setUpdateDate(sdf.format(System.currentTimeMillis()));
        mapper.insertUserHistory(userHistory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUserHistory(UserHistory userHistory) {
        userHistory.setUpdateDate(sdf.format(System.currentTimeMillis()));
        mapper.insertUserHistory(userHistory);
    }

    @Override
    public void updateUser(User user) {
        mapper.updateUser(user);
        UserHistory userHistory = user.getUserHistory();
        userHistory.setAction("update");
        userHistory.setUpdateDate(sdf.format(System.currentTimeMillis()));
        mapper.insertUserHistory(userHistory);
    }

    @Override
    public void deleteUser(String id) {
        User user = mapper.selectUser(id);
        mapper.deleteUser(id);
        UserHistory userHistory = user.getUserHistory();
        userHistory.setAction("delete");
        userHistory.setUpdateDate(sdf.format(System.currentTimeMillis()));
        mapper.insertUserHistory(userHistory);
    }

    @Override
    public User selectUser(String id) {
        return mapper.selectUser(id);
    }
}
