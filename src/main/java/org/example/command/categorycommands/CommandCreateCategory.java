package org.example.command.categorycommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.model.Category;
import org.example.service.CategoryService;

public class CommandCreateCategory extends Command {
    public CommandCreateCategory() {
        super(Constants.COMMAND_CREATE_CATEGORY);
    }
    public void execute() {
        CategoryService categoryService = new CategoryService(DatabaseService.getInstance());
        categoryService.insertCategory(new Category());
    }

}
