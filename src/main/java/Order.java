import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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


    public Order(List<OrderItem> orderItems, Buyer buyer, Seller seller, BigDecimal totalPrice) {
        this.orderItems = orderItems;
        this.buyer = buyer;
        this.seller = seller;
        this.totalPrice = totalPrice;
    }
}
