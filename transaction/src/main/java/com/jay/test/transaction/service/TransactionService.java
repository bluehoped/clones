package com.jay.test.transaction.service;

import com.jay.test.transaction.domain.User;
import com.jay.test.transaction.domain.UserHistory;

public interface TransactionService {
    void insertUser(User user);

    void insertUserHistory(UserHistory userHistory);

    void updateUser(User user);

    void deleteUser(String id);

    User selectUser(String id);

}
