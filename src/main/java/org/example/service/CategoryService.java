package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Category;
import org.example.model.builder.CategoryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.*;

public class CategoryService {
    private final DatabaseService databaseService;
    public CategoryService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void getAll() {
        String sql = "SELECT * FROM categories;";
         this.databaseService.performSQL(sql , resultSet -> {
            try{
                List<Category> categoryList = new ArrayList<>();
                while(resultSet.next()) {
                    categoryList.add(new CategoryBuilder()
                            .setId(resultSet.getInt("id"))
                            .setFamilyRoom(resultSet.getBoolean("family_room"))
                            .setLuxurious(resultSet.getBoolean("luxurious_room"))
                            .setName("name")
                            .getCategory());
                }
                for (Category category : categoryList) {
                    category.displayInfo();
                };
                return categoryList;
            } catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public void getById() {
        System.out.println("Input category id");
        int id = inputNum();
        String sql = String.format("SELECT * FROM categories WHERE id = '%d';",id);
        this.databaseService.performSQL(sql , resultSet -> {
            try{
                if(resultSet.next()) {
                    Category category = new CategoryBuilder()
                            .setId(resultSet.getInt("id"))
                            .setFamilyRoom(resultSet.getBoolean("family_room"))
                            .setLuxurious(resultSet.getBoolean("luxurious_room"))
                            .getCategory();
                    category.displayInfo();
                }
            } catch (SQLException abc) {
                throw new IllegalStateException(abc);
            }
            return null;
        });
    }

    public void insertCategory(Category category) {
        try {
            System.out.println("Set ID");
            int id = inputNum();
            System.out.println("Is the room luxurious?(Y/N)");
            boolean isLuxurious = inputBool();
            System.out.println("Is the room a family room?(Y/N)");
            boolean isFamilyRoom = inputBool();
            String sql = String.format("Insert INTO categories (id, family_room, luxurious_room) VALUES ('%d','%b','%b')",id,isLuxurious,isFamilyRoom);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public  void deleteCategory() {
        System.out.println("Input room category id");
        int id = inputNum();
        String sql = String.format("DELETE FROM categories WHERE id = '%d'",id);
        this.databaseService.performDML(sql);
    }

    public  void updateCategory() {
        System.out.println("Input the number of the category you want to update");

            int inputId = inputNum();
            System.out.println("1.Is it a family room?");
            int isFamily = inputTinyInt();
            System.out.println("2. Is it luxurious");
            int isLuxurious = inputTinyInt();
            System.out.println("3. Rename it");
            String categoryName = inputStr();
            String sql = String.format("UPDATE categories SET family_room = '%d', luxurious_room = '%d', name = '%s' WHERE id = '%d';",isFamily,isLuxurious,categoryName,inputId);
            try{
            this.databaseService.performDML(sql);
        } catch (Exception ass) {
            throw new IllegalStateException(ass);
        }
   }
}
