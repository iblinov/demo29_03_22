package com.example.demo29_03_22.command;

import com.example.demo29_03_22.command.impl.AddUserCommand;
import com.example.demo29_03_22.command.impl.DefaultCommand;
import com.example.demo29_03_22.command.impl.LoginCommand;
import com.example.demo29_03_22.command.impl.LogoutCommand;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT(new DefaultCommand());
    Command command;
    CommandType(Command command) {
        this.command = command;
    }
    public static Command define(String commandStr) {
       CommandType current = CommandType.valueOf(commandStr.toUpperCase());
       return current.command;
    }
}
