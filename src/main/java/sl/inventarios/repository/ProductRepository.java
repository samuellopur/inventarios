package sl.inventarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sl.inventarios.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
