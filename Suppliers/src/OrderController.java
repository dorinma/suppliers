import java.util.List;

public class OrderController {

    List<Order> orders;

    public boolean addOrder(int id, List<Integer> items, int supplierId) {
       Order order = new Order(id, items, supplierId);
       boolean result = order.makeOrder();
       if (result)
       {
           orders.add(order);
           return true;
       }
       else return false;
    }
}
