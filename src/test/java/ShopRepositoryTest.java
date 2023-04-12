import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product item1 = new Product(1, "Хлеб", 40);
    Product item2 = new Product(2, "Булка", 30);
    Product item3 = new Product(3, "Картошка", 20);
    Product item4 = new Product(4, "Квас", 85);
    Product item5 = new Product(5, "Пирог", 120);
    Product item6 = new Product(6, "Хлопья", 150);

    @Test
    public void addTest() {

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        Product[] expected = {item1, item2, item3, item4, item5, item6};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeId2() {

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        repo.remove(2);

        Product[] expected = {item1, item3, item4, item5, item6};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeId10() {

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(10);
        });
    }
}
