package com.remote.RemoteCommands.controller;

import com.remote.RemoteCommands.service.CommandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/command", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommandControllerImpl implements CommandController {

    private static final Logger logger = LogManager.getLogger(CommandControllerImpl.class);

    private final CommandService commandsService;

    @Autowired
    public CommandControllerImpl(CommandService commandsService) {
        this.commandsService = commandsService;
    }

    @Override
    @GetMapping("/getfiles")
    public List getFiles() {
        return commandsService.getFiles();
    }
}