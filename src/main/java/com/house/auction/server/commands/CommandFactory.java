package com.house.auction.server.commands;

import com.house.auction.server.auction.AuctionService;
import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.auth.UserService;
import com.house.auction.server.commands.auction.*;
import com.house.auction.server.commands.auth.LoginUserCommand;
import com.house.auction.server.commands.auth.LogoutUserCommand;
import com.house.auction.server.commands.auth.RegisterUserCommand;
import com.house.auction.server.commands.invalid.InvalidCommand;
import com.house.auction.server.commands.invalid.InvalidCommandParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommandFactory {

    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class);

    @Autowired
    private UserService userService;
    @Autowired
    private AuctionService auctionService;

    private CommandFactory() {
    }

    private static final class FactoryHolder {
        private static final CommandFactory factory = new CommandFactory();
    }

    public static CommandFactory getFactory() {
        return FactoryHolder.factory;
    }

    public Command createInvalidCommand() {
        return new InvalidCommand();
    }

    public Command createInvalidCommandParameters() {
        return new InvalidCommandParameters();
    }

    public Command createRegisterUserCommand(List<String> params) {
        if (params.size() < 2) return createInvalidCommandParameters();

        String username = params.get(0);
        String password = params.get(1);

        RegisterUserCommand command = new RegisterUserCommand(userService);
        command.setUsername(username);
        command.setPassword(password);

        return command;
    }

    public Command createLoginUserCommand(List<String> params) {
        if (params.size() < 2) return createInvalidCommandParameters();

        String username = params.get(0);
        String password = params.get(1);

        return new LoginUserCommand(username, password);
    }

    public Command createLogoutUserCommand(AuthToken authToken) {
        return new LogoutUserCommand(authToken);
    }

    public Command createCreateAuctionCommand(AuthToken authToken, List<String> params) {
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

    public Command createBidCommand(AuthToken authToken, List<String> params) {
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

    public Command createListActiveAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListActiveAuctionsCommand(userId);
    }

    public Command createListExpiredAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListExpiredAuctionsCommand(userId);
    }

    public Command createListParticipatedAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListParticipatedAuctionsCommand(userId);
    }

    public Command createListWonAuctionsCommand(AuthToken authToken) {
        int userId = authToken.getUserId();

        return new ListWonAuctionsCommand(userId);
    }
}
