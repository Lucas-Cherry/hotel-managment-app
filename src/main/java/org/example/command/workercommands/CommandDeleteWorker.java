package org.example.command.workercommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.WorkerService;


public class CommandDeleteWorker extends Command {
    WorkerService workerService = new WorkerService(DatabaseService.getInstance());
    public CommandDeleteWorker() {
        super(Constants.COMMAND_DELETE_WORKER);
    }

    @Override
    public void execute() {
        workerService.deleteWorker();
    }
}
