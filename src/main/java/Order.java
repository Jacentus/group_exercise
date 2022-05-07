import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Order {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany
    private List<OrderItem> orderItems;

    @OneToOne
    private Buyer buyer;

    @OneToOne
    private Seller seller;

    private BigDecimal totalPrice;

}
