import java.util.List;

public class Order {
    int id;
    List<ItemInOrder> items;
    Supplier supplierId;

    public Order(int id,List<Integer> items,int supplierId)
    {
        this.id=id;
        this.items=makeItemsInOrder(items);
        this.supplierId=getSuppById(id);
    }
    public Supplier getSuppById(int id)
    {
        return SupplierController.getSuppById(id);
    }
    public List<ItemInOrder> makeItemsInOrder(List<Integer> items)
    {
        return null;
    }



    public boolean makeOrder() {
        return true;
    }
}
