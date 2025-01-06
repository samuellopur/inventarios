package sl.inventarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.inventarios.model.Product;
import sl.inventarios.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{

    //    @Autowired
//    private ProductRepository productRepository;

    // Inyección de dependencias a través del constructor
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> ListProducts() {
        return this.productRepository.findAll();

    }

    @Override
    public Product findProductById(Integer idProduct) {
        Product product = this.productRepository.findById(idProduct).orElse(null);
        return product;
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer idProduct) {
        this.productRepository.deleteById(idProduct);
    }
}
