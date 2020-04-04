public class Item {
    private int id;
    private String name;
    private double price;
    private String description;

    public Item(int id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() { return this.id; }

    public double getPrice() { return this.price; }
}
