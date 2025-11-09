// S — Single Responsibility: класс хранит только данные о товаре
public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Цена не может быть отрицательной");
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + price + "₽";
    }
}
