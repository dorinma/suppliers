public class BillOfQuantities {

    private int id;
    private int itemId;
    private int supplierId;
    private int quantity;
    private int discount;

    public BillOfQuantities(int id, int itemId, int supplierId, int quantity, int discount) {
        this.id = id;
        this.itemId = itemId;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.discount = discount;
    }
}
