import javafx.util.Pair;
import java.util.LinkedList;
import java.util.List;

public class Order {
    int id;
    List<ItemInOrder> items;
    Supplier supplier;

    public Order(int id, List<Pair<Integer, Integer>> items, int supplierId)
    {
        this.id=id;
        this.items=makeItemsInOrder(items);
        this.supplier=getSuppById(id);
    }
    public Supplier getSuppById(int id)
    {
        return SupplierController.getSupplierController().getSuppById(id);
    }

    public List<ItemInOrder> makeItemsInOrder(List<Pair<Integer, Integer>> items)
    {
        List<ItemInOrder> list= new LinkedList<>();
        for (int i=0 ; i<items.size();i++)
        {
            //int cost_item=supplier.getCostOfItem(items.get(i).getKey());
            ItemInOrder a = new ItemInOrder(items.get(i).getKey(),items.get(i).getValue());
            list.add(a);
        }
        return list;
    }

    public boolean makeOrder() {
        return supplier.makeOrder(items);
    }
}
