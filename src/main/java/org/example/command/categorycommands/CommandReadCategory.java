package org.example.command.categorycommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.CategoryService;


public class CommandReadCategory extends Command {
    public CommandReadCategory() {
        super(Constants.COMMAND_READ_CATEGORY);
    }

    @Override
    public void execute() {
        CategoryService categoryService = new CategoryService(DatabaseService.getInstance());
        categoryService.getById();
    }
}
