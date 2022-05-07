import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ProductType> type;

    public Product(String name, BigDecimal price, List<ProductType> type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
