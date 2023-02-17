package org.example.command.workercommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.WorkerService;


public class CommandCreateWorker extends Command {

    WorkerService workerService = new WorkerService(DatabaseService.getInstance());
    public CommandCreateWorker() {
        super(Constants.COMMAND_CREATE_WORKER);
    }

    @Override
    public void execute() {
        workerService.createWorker();
    }
}
