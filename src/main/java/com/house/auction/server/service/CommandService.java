package com.house.auction.server.service;

import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.commands.CommandController;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import com.house.auction.server.proto.CommandServiceGrpc;
import com.house.auction.server.proto.Request;
import com.house.auction.server.proto.Response;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandService extends CommandServiceGrpc.CommandServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(CommandService.class);

    @Override
    public void execute(Request request, StreamObserver<Response> responseObserver) {
        logger.info(String.format("\nreceived command: %s \nauthToken: %s\nparams: %s",
                request.getCommandName(),
                request.getAuthToken(),
                request.getParamsList()));

        Response.Builder responseBuilder = Response.newBuilder();
        Response response = null;

        try {
            CommandController commandController = new CommandController();

            ResponseDto responseDto = commandController.execute(
                    request.getCommandName(),
                    new AuthToken(request.getAuthToken()),
                    request.getParamsList().stream().toList()
            );

            response = responseBuilder
                    .setStatus(responseDto.getStatus().toString())
                    .setContent(responseDto.getContent())
                    .build();
        } catch (Exception e) {
            logger.error(String.format("command %s failed to execute: %s", request.getCommandName(), e.getMessage()));

            response = responseBuilder
                    .setStatus(ResponseStatus.Error.toString())
                    .setContent(e.getMessage())
                    .build();
        } finally {
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        logger.info(String.format("command [%s] execution finished ", request.getCommandName()));
    }
}
