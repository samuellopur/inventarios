package sl.inventarios.service;

import sl.inventarios.model.Product;
import java.util.List;

public interface IProductService {
    public List<Product> ListProducts();

    public Product findProductById(Integer idProduct);

    public void saveProduct(Product product);

    public void deleteProductById(Integer idProduct);

}
