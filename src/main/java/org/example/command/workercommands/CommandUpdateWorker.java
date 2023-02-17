package org.example.command.workercommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.WorkerService;


public class CommandUpdateWorker extends Command {
    WorkerService workerService = new WorkerService(DatabaseService.getInstance());
    public CommandUpdateWorker() {
        super(Constants.COMMAND_UPDATE_WORKER);
    }

    @Override
    public void execute() {
        workerService.updateWorker();
    }
}
