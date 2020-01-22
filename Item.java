package shop;

public class Item {
    private String name;
    private double rate;
    private long code;
    private int quantity;

    public Item() {
        this.name = "";
        this.rate = 0;
        this.code = 0;
        this.quantity = 0;
    }

    public Item(String name, double rate, long code, int quantity) {
        this.name = name;
        this.rate = rate;
        this.code = code;
        this.quantity = quantity;
    }

    public Item(Item item) {
        this.name = item.name;
        this.rate = item.rate;
        this.code = item.code;
        this.quantity = item.quantity;

    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", rate=" + rate + ", code=" + code
                + ", quantity=" + quantity + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}