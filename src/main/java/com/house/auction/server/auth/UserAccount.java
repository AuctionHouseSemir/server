package com.house.auction.server.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAccount {
    private int id;
    private String username;
    private String password;
}
