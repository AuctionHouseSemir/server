package com.house.auction.server.commands;

import com.google.rpc.context.AttributeContext;
import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.commands.auction.*;
import com.house.auction.server.commands.auth.LoginUserCommand;
import com.house.auction.server.commands.auth.LogoutUserCommand;
import com.house.auction.server.commands.auth.RegisterUserCommand;
import com.house.auction.server.commands.invalid.InvalidCommand;

import java.util.List;

public class CommandFactory {

    public static Command createInvalidCommand() {
        return new InvalidCommand();
    }

    public static Command createRegisterUserCommand(List<String> params) {
        String username = params.get(0);
        String password = params.get(1);

        return new RegisterUserCommand(username, password);
    }

    public static Command createLoginUserCommand(List<String> params) {
        String username = params.get(0);
        String password = params.get(1);

        return new LoginUserCommand(username, password);
    }

    public static Command createLogoutUserCommand(AuthToken authToken) {
        return new LogoutUserCommand(authToken);
    }

    public static Command createCreateAuctionCommand(AuthToken authToken, List<String> params) {
        String auctionName = params.get(0);
        double initialPrice = Double.parseDouble(params.get(1));
        double minPrice = Double.parseDouble(params.get(2));
        int duration = Integer.parseInt(params.get(3));
        int userId = authToken.getUserId();

        return new CreateAuctionCommand(auctionName, initialPrice, minPrice, duration, userId);
    }

    public static Command createBidCommand(AuthToken authToken, List<String> params) {
        int auctionId = Integer.parseInt(params.get(0));
        int bidValue = Integer.parseInt(params.get(1));
        int userId = authToken.getUserId();

        return new BidCommand(auctionId, bidValue, userId);
    }

    public static Command createListActiveAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListActiveAuctionsCommand(userId);
    }

    public static Command createListExpiredAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListExpiredAuctionsCommand(userId);
    }

    public static Command createListParticipatedAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListParticipatedAuctionsCommand(userId);
    }

    public static Command createListWonAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListWonAuctionsCommand(userId);
    }
}
