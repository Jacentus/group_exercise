import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Address {

/*    @GeneratedValue
    @Id
    private Long id;*/

    private String street;

    private String town;

    public Address(String street, String town) {
        this.street = street;
        this.town = town;
    }
}
