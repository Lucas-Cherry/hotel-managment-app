package org.example.command.workercommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.WorkerService;

public class CommandWorkerGetAll extends Command {
    WorkerService workerService = new WorkerService(DatabaseService.getInstance());

    public CommandWorkerGetAll() {
        super(Constants.COMMAND_GET_ALL_WORKERS);
    }

    @Override
    public void execute() {
        workerService.getAllWorkers();
    }
}
