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
            case "register" -> command = CommandFactory.getFactory().createRegisterUserCommand(params);
            case "login" -> command = CommandFactory.getFactory().createLoginUserCommand(params);
            case "logout" -> command = CommandFactory.getFactory().createLogoutUserCommand(authToken);
            case "create_auction" -> command = CommandFactory.getFactory().createCreateAuctionCommand(authToken, params);
            case "bid" -> command = CommandFactory.getFactory().createBidCommand(authToken, params);
            case "list_active" -> command = CommandFactory.getFactory().createListActiveAuctionsCommand(authToken);
            case "list_expired" -> command = CommandFactory.getFactory().createListExpiredAuctionsCommand(authToken);
            case "list_participated" -> command = CommandFactory.getFactory().createListParticipatedAuctionsCommand(authToken);
            case "list_won" -> command = CommandFactory.getFactory().createListWonAuctionsCommand(authToken);
            default -> command = CommandFactory.getFactory().createInvalidCommand();
        }

        return command;
    }
}

