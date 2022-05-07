import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

    @AfterAll
    static void afterAll() {
        TestUtils.ENTITY_MANAGER_FACTORY.close();
    }

    @Test
    public void test1(){
        OrderItem orderItem = new OrderItem();
        List<OrderItem> listOfOrderItems = new ArrayList<>();
        listOfOrderItems.add(orderItem);
        Order order = new Order(listOfOrderItems, new Buyer(), new Seller(), BigDecimal.valueOf(10_000));
        TestUtils.run(entityManager -> entityManager.persist(order));
    }

}
