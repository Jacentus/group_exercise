import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Buyer {

    @GeneratedValue
    @Id
    private String id;

    private String username;

    @Embedded
    private Address address;

}
