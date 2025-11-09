//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> catalog = List.of(
                new Product("Хлеб", 45),
                new Product("Молоко", 80),
                new Product("Кофе", 350)
        );

        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Показать каталог\n2. Добавить в корзину\n3. Показать корзину\n4. Оформить заказ\n0. Выход");
            System.out.print("Выбор: ");
            int choice = sc.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1 -> catalog.forEach(System.out::println);
                case 2 -> {
                    for (int i = 0; i < catalog.size(); i++)
                        System.out.println((i + 1) + ". " + catalog.get(i));
                    System.out.print("Введите номер товара: ");
                    int idx = sc.nextInt() - 1;
                    if (idx >= 0 && idx < catalog.size())
                        cart.add(catalog.get(idx));
                }
                case 3 -> cart.show();
                case 4 -> {
                    if (cart.isEmpty()) {
                        System.out.println("Корзина пуста.");
                        break;
                    }

                    DiscountPolicy discount = new TenPercentDiscount(); // OCP
                    double total = cart.total(discount);

                    System.out.println("Сумма к оплате (со скидкой): " + total + "₽");
                    System.out.print("Способ оплаты (1 - карта, 2 - наличные): ");
                    int method = sc.nextInt();

                    Payment payment = (method == 1) ? new CardPayment() : new CashPayment(); // LSP + DIP
                    payment.pay(total);

                    System.out.println("Спасибо за покупку!");
                    return;
                }
                default -> System.out.println("Неверный ввод.");
            }
        }
    }
}
