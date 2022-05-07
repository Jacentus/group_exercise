import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {

    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    private Product product;

    private int quantity;

    private BigDecimal price;

}
