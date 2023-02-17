package org.example.command.workercommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.WorkerService;


public class CommandReadWorker extends Command {
    WorkerService workerService = new WorkerService(DatabaseService.getInstance());
    public CommandReadWorker() {
        super(Constants.COMMAND_READ_WORKER);
    }

    @Override
    public void execute() {
        workerService.readWorkers();
    }
}
