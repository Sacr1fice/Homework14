import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;


public class ShopRepositoryTest {

    Product product = new Product(1, "Хлеб", 50);
    Product product2 = new Product(2, "Яйца", 100);
    Product product3 = new Product(3, "Молок0", 150);

    @Test
    public void shouldThrowExcept() {

        ShopRepository repo = new ShopRepository();
        repo.add(product);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-1);
        });
    }

    @Test
    public void shouldRemove() {

        ShopRepository repo = new ShopRepository();
        repo.add(product);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product[] expected = {product, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
