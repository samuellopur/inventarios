package sl.inventarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProduct;
    String description;
    Double price;
    Integer existence;

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", existence=" + existence +
                '}';
    }
}
