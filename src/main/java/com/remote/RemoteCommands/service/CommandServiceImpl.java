package com.remote.RemoteCommands.service;

import com.remote.RemoteCommands.utils.Constants;
import com.remote.RemoteCommands.utils.StreamGobbler;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Service
public class CommandServiceImpl implements CommandService {
    private ProcessBuilder builder = new ProcessBuilder();

    @Override
    public List getFiles() {
        List<String> result = new ArrayList<>();

        if (isWindows()){
            builder.command("cmd.exe", "/c", "dir");
            //builder.command(Constants.LIST_FILES_WINDOWS.split(","));
        } else {
            //builder.command("sh", "-c", "ls");
        }

        builder.directory(new File(System.getProperty(Constants.USER_HOME)));
        try {
            Process process = builder.start();
            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), result::add);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            int exitCode = process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return result;

    }
}
