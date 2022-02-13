package com.house.auction.server;

import com.house.auction.server.service.CommandService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication implements CommandLineRunner {

    private static final int PORT = 9000;
    private static final Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Server server = ServerBuilder
                .forPort(PORT)
                .addService(new CommandService())
                .build();

        server.start();

        logger.info("grpc listening on: " + PORT);
    }
}
