package com.jay.test.transaction.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class User {
    private int id;
    private String name;
    private String address;
    private String createDate;
    private String updateDate;

    public UserHistory getUserHistory() {

        UserHistory userHistory = new UserHistory();
        userHistory.setId(id);
        userHistory.setName(name);
        userHistory.setAddress(address);

        return userHistory;
    }
}
