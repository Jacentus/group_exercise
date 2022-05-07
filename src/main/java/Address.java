import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {

/*    @GeneratedValue
    @Id
    private Long id;*/

    private String street;

    private String town;

}
