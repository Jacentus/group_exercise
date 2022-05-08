import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class OrderItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    private int quantity;

    private BigDecimal price;

    public OrderItem(Product product, int quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
