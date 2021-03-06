import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import java.util.function.Consumer;

public class TestUtils {

    static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("shop");

    static final Statistics STATISTICS = ENTITY_MANAGER_FACTORY.unwrap(SessionFactory.class).getStatistics();

    static void run(Consumer<EntityManager> task) {
        var entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        task.accept(entityManager);
        transaction.commit();
        entityManager.close();
    }

    static void runAsync(Consumer<EntityManager> task) {
        new Thread(() -> run(task)).start();
    }


}