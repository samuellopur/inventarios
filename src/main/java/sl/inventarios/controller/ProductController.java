package sl.inventarios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sl.inventarios.model.Product;
import sl.inventarios.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;


    // Inyección de dependencias a través del constructor
//    private final ProductService productService;
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/productos")
    public List<Product> getProducts(){
        List<Product> products = this.productService.listProducts();
        logger.info("Productos obtenidos:");
        products.forEach(product -> logger.info(product.toString()));
        return products;
    }
}
