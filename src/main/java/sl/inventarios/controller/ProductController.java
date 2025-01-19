package sl.inventarios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sl.inventarios.exception.ResourceNotFoundException;
import sl.inventarios.model.Product;
import sl.inventarios.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")

public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/productos")
    public List<Product> getProducts(){
        List<Product> products = this.productService.listProducts();
        logger.info("Productos obtenidos:");
        products.forEach(product -> logger.info(product.toString()));
        return products;
    }

    @PostMapping("/productos")
    public Product addProduct(@RequestBody Product product){
        logger.info("Producto a agregar: " + product);
        return this.productService.saveProduct(product);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = this.productService.findProductById(id);
        if (product != null)
            return ResponseEntity.ok(product);
        else
            throw  new ResourceNotFoundException("Id no encontrado" + id);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productReceived){
        Product product = this.productService.findProductById(id);
        if (product == null)
            throw new ResourceNotFoundException("Id no encontrado: " + id);
        product.setDescription(productReceived.getDescription());
        product.setPrice(productReceived.getPrice());
        product.setExistence(productReceived.getExistence());
        this.productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>>
    deleteProduct(@PathVariable int id){
        Product product = productService.findProductById(id);
        if (product == null)
            throw new ResourceNotFoundException("Id no encontrado: " + id);
        this.productService.deleteProductById(product.getIdProduct());
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }

}
