import java.util.ArrayList;
import java.util.List;

// S — отвечает только за хранение и расчёт корзины
// D — зависит от интерфейса DiscountPolicy, а не от конкретной реализации
public class Cart {
    private final List<Product> items = new ArrayList<>();

    public void add(Product p) {
        items.add(p);
    }

    public double total(DiscountPolicy discount) {
        double sum = items.stream().mapToDouble(Product::getPrice).sum();
        return discount.apply(sum);
    }

    public void show() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        items.forEach(System.out::println);
    }

    public boolean isEmpty() { return items.isEmpty(); }
}
