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
        Address buyerAddress = new Address("Kadmowa", "Gdańsk");
        Address sellerAddress = new Address("Świętojańska", "Gdynia");

        Buyer buyer = new Buyer("Jacek_kupujący", buyerAddress);

        Seller seller = new Seller("Jacek_sprzedający", sellerAddress);

        List<ProductType> productTypeList = new ArrayList<>();
        productTypeList.add(ProductType.ELECTRONICS);
        Product product = new Product("Książka", BigDecimal.valueOf(100), productTypeList);

        OrderItem orderItem = new OrderItem(product, 10, BigDecimal.valueOf(1000));

        List<OrderItem> listOfOrderItems = new ArrayList<>();
        listOfOrderItems.add(orderItem);

        Orders order = new Orders(listOfOrderItems, buyer, seller, BigDecimal.valueOf(1000));

       TestUtils.run(entityManager -> entityManager.persist(order));
    }

}
