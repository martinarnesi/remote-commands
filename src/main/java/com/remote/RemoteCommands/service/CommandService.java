package com.remote.RemoteCommands.service;

import com.remote.RemoteCommands.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommandService {

    default boolean isWindows() {
        return System.getProperty(Constants.OS_NAME)
                .toLowerCase().startsWith(Constants.WINDOWS);
    }

    List getFiles();
}
