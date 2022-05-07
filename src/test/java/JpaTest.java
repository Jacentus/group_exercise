import org.junit.jupiter.api.Test;

public class JpaTest {

    @Test
    public void test1(){
        Order order = new Order();
        TestUtils.run(entityManager -> entityManager.persist(order));
    }

}
