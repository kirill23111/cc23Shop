// O — можно добавлять новые политики скидок без изменения кода Cart (Open/Closed)
// I — интерфейс узкий и не навязывает лишних методов
public interface DiscountPolicy {
    double apply(double amount);
}

class NoDiscount implements DiscountPolicy {
    public double apply(double amount) { return amount; }
}

class TenPercentDiscount implements DiscountPolicy {
    public double apply(double amount) { return amount * 0.9; }
}
