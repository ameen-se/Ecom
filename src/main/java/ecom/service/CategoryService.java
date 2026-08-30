package ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecom.entities.Category;

@Service
public interface CategoryService {

    public Category saveCategory(Category category);

    public List<Category> getAllCategory();

    public Boolean existCategory(String name);

    public Boolean deleteCategory(int id);

    public Category getCategoryById(int id);

    public List<Category> getAllActiveCategory();
}
