import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn(name = "id")
    @OneToMany/*(mappedBy = "order", cascade = CascadeType.ALL)*/
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    private Buyer buyer;

    @ManyToOne
    private Seller seller;

    private BigDecimal totalPrice;

    public Order(List<OrderItem> orderItems, Buyer buyer, Seller seller, BigDecimal totalPrice) {
        this.orderItems = orderItems;
        this.buyer = buyer;
        this.seller = seller;
        this.totalPrice = totalPrice;
    }
}
