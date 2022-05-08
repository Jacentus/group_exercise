import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode(of="id")
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH)
    private Buyer buyer;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Seller seller;

    @Transient
    private BigDecimal totalPrice;

    public Orders(List<OrderItem> orderItems, Buyer buyer, Seller seller, BigDecimal totalPrice) {
        this.orderItems = orderItems;
        this.buyer = buyer;
        this.seller = seller;
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id);
    }

    @Override
    public int hashCode() {
        return 10;
    }
}
