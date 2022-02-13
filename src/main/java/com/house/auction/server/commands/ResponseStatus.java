package com.house.auction.server.commands;

public enum ResponseStatus {
    Ok("!ok"),
    Error("!error");

    private final String name;

    ResponseStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
