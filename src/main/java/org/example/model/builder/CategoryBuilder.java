package org.example.model.builder;
import org.example.model.Category;

public class CategoryBuilder {

        private Category category;

        public CategoryBuilder() {
            category = new Category();
        }

        public CategoryBuilder setId(int id) {
            this.category.setId(id);
            return this;
        }
        public CategoryBuilder setLuxurious(Boolean luxurious){
            this.category.setLuxurious(luxurious);
            return this;
        }

        public CategoryBuilder setFamilyRoom(boolean familyRoom) {
            this.category.setFamilyRoom(familyRoom);
            return this;
        }

        public CategoryBuilder setName(String name) {
            this.category.setName(name);
            return this;
        }

        public Category getCategory(){
            return this.category;
        }

}
