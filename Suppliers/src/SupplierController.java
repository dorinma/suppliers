import javafx.util.Pair;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SupplierController {
    private List<Supplier> suppliers;
    private static SupplierController sp_instance=null;


    public static SupplierController getSupplierController()
    {
        if(sp_instance==null)
        {
            sp_instance=new  SupplierController();
        }
            return sp_instance;
    }

    private SupplierController() {
      this.suppliers= new LinkedList<>();
    }

    public Supplier getSuppById(int id) {
        for(int i= 0; i<suppliers.size(); i++) {
            if(suppliers.get(i).getId() == id)
                return suppliers.get(i);
        }
        return null;
    }

    public void addSupplier(int id, String name, String phoneNum, int bankAccount, String payment, String supplySchedule, String supplyLocation, List<Pair<Item, Integer>> items,List<Pair<Integer,Integer>> agreement) {
        Supplier sup = new Supplier(id, name, phoneNum, bankAccount, payment, supplySchedule, supplyLocation, items,agreement);
        this.suppliers.add(sup);
    }

    public void addBillOfQuantities(int supplierId,Map<Integer, Pair<Integer, Integer>> bill) {
        if(getSuppById(supplierId)!=null)
        {
            getSuppById(supplierId).getAgreement().addBillOfQuantities(bill);
        }
    }

    public void insertBillOfQuantities(int supplierId, Integer itemId, Pair<Integer, Integer> quantity_disc) {

        if(getSuppById(supplierId)!=null)
        {
            getSuppById(supplierId).getAgreement().insertBillOfQuantities(itemId,quantity_disc);
        }
    }

    public void updateBillOfQuantities(int supplierId, Integer itemId, Pair<Integer, Integer> quantity_disc) {
       if(getSuppById(supplierId)!=null)
       {
           getSuppById(supplierId).updateBillOfQuantities(itemId,quantity_disc);
       }
    }


    public void deleteBillOfQuantities(int supplierId, Integer itemId) {
        if(getSuppById(supplierId)!=null)
        {
            getSuppById(supplierId).deleteBillOfQuantities(itemId);
        }
    }
}
