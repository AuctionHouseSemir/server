package com.house.auction.server.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private ResponseStatus status;
    private String content;
}
