package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.cache.CacheStorage;
import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

public class LogoutUserCommand implements Command {
    @Getter
    @Setter
    private AuthToken authToken;

    private final CacheStorage cacheStorage;

    public LogoutUserCommand(CacheStorage cacheStorage) {
        this.cacheStorage = cacheStorage;
    }

    @Override
    public ResponseDto execute() {
        int userId = authToken.getUserId();

        cacheStorage.destroy(String.valueOf(userId));

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent("user logged out");

        return responseDto;
    }
}
