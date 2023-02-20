package com.example.demo29_03_22.command;

import com.example.demo29_03_22.exception.CommandException;
import com.example.demo29_03_22.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
    default void refresh(){}
}
