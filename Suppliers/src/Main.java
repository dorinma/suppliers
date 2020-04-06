import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)
  {
      FacadeController fc = FacadeController.getFacadeController();
      List<Pair<Item,Integer>> list = new LinkedList();
      Item item =new Item(55,"Milk","3%");
      list.add(new Pair(item,100));
      List<Pair<Integer,Integer>> agg = new LinkedList();
      agg.add(new Pair(55,3));
      fc.supplierController.addSupplier(1,"dorin","053",555,"cash","mondays","Super-Li",list,agg);
      List<Pair<Integer,Integer>> order = new LinkedList();
      order.add(new Pair(55,10));
      boolean ans =fc.orderController.addOrder(1,order,1);
      if(ans)
          System.out.println("good");
      else
          System.out.println("not good");




  }

}
