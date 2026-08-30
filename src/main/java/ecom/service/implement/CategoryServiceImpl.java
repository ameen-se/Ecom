package ecom.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecom.entities.Category;
import ecom.persistence.CategoryDAO;
import ecom.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category saveCategory(Category category) {
        return categoryDAO.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }

    @Override
    public Boolean existCategory(String name) {
        return categoryDAO.existCategory(name);
    }

    @Override
    public Boolean deleteCategory(int id) {
        return categoryDAO.deleteCategory(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public List<Category> getAllActiveCategory() {
        return categoryDAO.getAllActiveCategory();
    }
}
