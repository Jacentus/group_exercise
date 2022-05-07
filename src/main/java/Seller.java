import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Seller {

    @GeneratedValue
    @Id
    private Long id;

    private String username;

    @Embedded
    private Address address;

}
