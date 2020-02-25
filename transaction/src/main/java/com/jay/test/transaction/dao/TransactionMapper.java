package com.jay.test.transaction.dao;

import com.jay.test.transaction.domain.User;
import com.jay.test.transaction.domain.UserHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TransactionMapper {

    void insertUser(User user);

    void insertUserHistory(UserHistory userHistory);

    void updateUser(User user);

    void deleteUser(String id);

    User selectUser(String id);

}
