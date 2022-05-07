import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Product {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ProductType> type;


}
