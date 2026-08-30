package ecom.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecom.entities.Product;
import ecom.persistence.ProductDAO;
import ecom.repository.ProductRepository;
import ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productDAO.saveProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        return productDAO.deleteProduct(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return productDAO.getProductById(id);
    }

    private void calculateDiscountPrice(Product product) {
        if (product.getPrice() != null && product.getDiscount() != null) {
            double discount = product.getDiscount() / 100.0;
            product.setDiscountPrice(product.getPrice() * (1 - discount));
        } else {
            product.setDiscountPrice(product.getPrice());
        }
    }

    @Override
    public Product updateProduct(Product product) {
        calculateDiscountPrice(product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllActiveProducts(String category) {
        return productDAO.getAllActiveProducts(category);
    }

    @Override
    public List<Product> searchProduct(String search) {
        return productDAO.searchProduct(search);
    }
}
