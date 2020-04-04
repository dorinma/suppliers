import javafx.util.Pair;
import java.util.LinkedList;
import java.util.List;

public class SupplierController {
    private List<Supplier> suppliers;

    public SupplierController() {
        this.suppliers = new LinkedList<>();
    }

    public Supplier getSuppById(int id) {
        for(int i= 0; i<suppliers.size(); i++) {
            if(suppliers.get(i).getId() == id)
                return suppliers.get(i);
        }
        return null;
    }

    public void addSupplier(int id, String name, String phoneNum, int bankAccount, String payment, String supplySchedule, String supplyLocation, List<Pair<Item, Integer>> items) {
        Supplier sup = new Supplier(id, name, phoneNum, bankAccount, payment, supplySchedule, supplyLocation, items);
        this.suppliers.add(sup);
    }

    public void addBillOfQuantities(int supplierId, int itemId, int quantity, int discount) {
        for(int i=0; i<suppliers.size(); i++){
            if(suppliers.get(i).getId() == supplierId)
                suppliers.get(i).getAgreement().addBillOfQuantities(itemId, quantity,discount);
        }
    }
}
