package ecom.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import ecom.entities.Category;

@Component
public interface CategoryDAO {

    Category saveCategory(Category category);

    List<Category> getAllCategory();

    Boolean existCategory(String name);

    Boolean deleteCategory(int id);

    Category getCategoryById(int id);

    List<Category> getAllActiveCategory();
}
