// L — любая реализация Payment взаимозаменяема
public interface Payment {
    void pay(double amount);
}

class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Оплачено картой на сумму " + amount + "₽");
    }
}

class CashPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Оплата наличными при получении (" + amount + "₽)");
    }
}
