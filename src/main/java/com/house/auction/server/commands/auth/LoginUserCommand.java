package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.AuthTokenGenerator;
import com.house.auction.server.auth.UserAccount;
import com.house.auction.server.auth.UserService;
import com.house.auction.server.cache.CacheItem;
import com.house.auction.server.cache.CacheStorage;
import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

public class LoginUserCommand implements Command {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    private final UserService userService;
    private final CacheStorage cacheStorage;

    public LoginUserCommand(UserService userService, CacheStorage cacheStorage) {
        this.userService = userService;
        this.cacheStorage = cacheStorage;
    }

    @Override
    public ResponseDto execute() {
        boolean credentialsValid = userService.validCredentials(username, password);
        if (!credentialsValid) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus(ResponseStatus.Error);
            responseDto.setContent("invalid credentials");

            return responseDto;
        }

        UserAccount userAccount = userService.getUserByUsername(username);

        AuthTokenGenerator tokenGenerator = new AuthTokenGenerator();
        String authToken = tokenGenerator.generateToken(userAccount.getId(), null);

        cacheStorage.store(String.valueOf(userAccount.getId()), authToken);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(authToken);

        return responseDto;
    }
}
