package com.house.auction.server.commands;

import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.commands.auction.*;
import com.house.auction.server.commands.auth.LoginUserCommand;
import com.house.auction.server.commands.auth.LogoutUserCommand;
import com.house.auction.server.commands.auth.RegisterUserCommand;
import com.house.auction.server.commands.invalid.InvalidCommand;
import com.house.auction.server.commands.invalid.InvalidCommandParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CommandFactory {

    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class);

    public static Command createInvalidCommand() {
        return new InvalidCommand();
    }

    public static Command createInvalidCommandParameters() {
        return new InvalidCommandParameters();
    }

    public static Command createRegisterUserCommand(List<String> params) {
        if (params.size() < 2) return createInvalidCommandParameters();

        String username = params.get(0);
        String password = params.get(1);

        return new RegisterUserCommand(username, password);
    }

    public static Command createLoginUserCommand(List<String> params) {
        if (params.size() < 2) return createInvalidCommandParameters();

        String username = params.get(0);
        String password = params.get(1);

        return new LoginUserCommand(username, password);
    }

    public static Command createLogoutUserCommand(AuthToken authToken) {
        return new LogoutUserCommand(authToken);
    }

    public static Command createCreateAuctionCommand(AuthToken authToken, List<String> params) {
        try {
            String auctionName = params.get(0);
            double initialPrice = Double.parseDouble(params.get(1));
            double minPrice = Double.parseDouble(params.get(2));
            int duration = Integer.parseInt(params.get(3));
            int userId = authToken.getUserId();

            return new CreateAuctionCommand(auctionName, initialPrice, minPrice, duration, userId);
        } catch (Exception e) {
            logger.error(String.format("failed to create CreateAuctionCommand: %s", e.getMessage()));
            return createInvalidCommandParameters();
        }
    }

    public static Command createBidCommand(AuthToken authToken, List<String> params) {
        try {
            int auctionId = Integer.parseInt(params.get(0));
            int bidValue = Integer.parseInt(params.get(1));
            int userId = authToken.getUserId();

            return new BidCommand(auctionId, bidValue, userId);
        } catch (Exception e) {
            logger.error(String.format("failed to create BidCommand: %s", e.getMessage()));
            return createInvalidCommandParameters();
        }
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
