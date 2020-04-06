import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agreement {

    private Map<Integer, Double> terms= new HashMap<>();
    private BillOfQuantities bill;

    public Agreement(Map<Integer, Double> terms) {
        this.terms = terms;
        this.bill = null;
    }

    public void addBillOfQuantities(Map<Integer, Pair<Integer, Double>> bill) {
        this.bill = new BillOfQuantities(bill);
    }

    public void insertBillOfQuantities(Integer itemId, Pair<Integer, Double> quantity_disc) {
        this.bill.insert(itemId,quantity_disc);
    }

    public void updateBillOfQuantities( Integer itemId, Pair<Integer, Double> quantity_disc) {
        this.bill.updateBillOfQuantities(itemId,quantity_disc);
    }

    public void deleteBillOfQuantities(Integer itemId) {
        this.bill.deleteBillOfQuantities(itemId);
    }
}
