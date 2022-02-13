package com.house.auction.server.commands;

import com.house.auction.server.auth.AuthToken;

import java.util.List;

public class CommandController {

    public ResponseDto execute(String commandName, AuthToken authToken, List<String> params) {
        Command command = mapCommand(commandName, authToken, params);

        return command.execute();
    }

    private Command mapCommand(String commandName, AuthToken authToken, List<String> params) {
        Command command;

        switch (commandName) {
            case "register" -> command = CommandFactory.createRegisterUserCommand(params);
            case "login" -> command = CommandFactory.createLoginUserCommand(params);
            case "logout" -> command = CommandFactory.createLogoutUserCommand(authToken);
            case "create_auction" -> command = CommandFactory.createCreateAuctionCommand(authToken, params);
            case "bid" -> command = CommandFactory.createBidCommand(authToken, params);
            case "list_active" -> command = CommandFactory.createListActiveAuctionsCommand(authToken);
            case "list_expired" -> command = CommandFactory.createListExpiredAuctionsCommand(authToken);
            case "list_participated" -> command = CommandFactory.createListParticipatedAuctionsCommand(authToken);
            case "list_won" -> command = CommandFactory.createListWonAuctionsCommand(authToken);
            default -> command = CommandFactory.createInvalidCommand();
        }

        return command;
    }
}

