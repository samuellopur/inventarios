package sl.inventarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.inventarios.model.Product;
import sl.inventarios.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    // Inyección de dependencias a través del constructor
//    private final ProductRepository productRepository;
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
    @Override
    public List<Product> listProducts() {
        return this.productRepository.findAll();

    }

    @Override
    public Product findProductById(Integer idProduct) {
        return this.productRepository.findById(idProduct).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer idProduct) {
        this.productRepository.deleteById(idProduct);
    }
}
