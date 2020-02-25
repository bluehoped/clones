package com.jay.test.transaction.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userHistory")
public class UserHistory {
    private int id;
    private String action;
    private String name;
    private String address;
    private String updateDate;
}
