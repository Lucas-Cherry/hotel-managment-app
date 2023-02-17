package org.example.command.categorycommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.CategoryService;


public class CommandDeleteCategory extends Command {
    public CommandDeleteCategory() {
        super(Constants.COMMAND_DELETE_CATEGORY);
    }

    @Override
    public void execute() {
        CategoryService categoryService = new CategoryService(DatabaseService.getInstance());
        categoryService.deleteCategory();
    }
}
