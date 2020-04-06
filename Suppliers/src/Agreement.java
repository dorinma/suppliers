import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class Agreement {

    private List<Pair<Integer, Integer>> terms;
    private BillOfQuantities bill;

    public Agreement(List<Pair<Integer, Integer>> terms) {
        this.terms = terms;
        this.bill = null;
    }

    public void addBillOfQuantities(Map<Integer, Pair<Integer, Integer>> bill) {
        this.bill = new BillOfQuantities(bill);
    }

    public void insertBillOfQuantities(Integer itemId, Pair<Integer, Integer> quantity_disc) {
        this.bill.insert(itemId,quantity_disc);
    }

    public void updateBillOfQuantities( Integer itemId, Pair<Integer, Integer> quantity_disc) {
        this.bill.updateBillOfQuantities(itemId,quantity_disc);
    }

    public void deleteBillOfQuantities(Integer itemId) {
        this.bill.deleteBillOfQuantities(itemId);
    }
}
