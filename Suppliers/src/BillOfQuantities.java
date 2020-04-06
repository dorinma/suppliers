import javafx.util.Pair;

import java.util.Map;

public class BillOfQuantities {

    private Map<Integer, Pair<Integer, Double>> bill;

    public BillOfQuantities(Map<Integer, Pair<Integer, Double>> bill) {
        this.bill = bill;
    }

    public void insert(Integer itemId, Pair<Integer, Double> quantity_disc) {
        bill.put(itemId,quantity_disc);
    }

    public void updateBillOfQuantities(Integer itemId, Pair<Integer, Double> quantity_disc) {
        bill.put(itemId, quantity_disc);
    }

    public void deleteBillOfQuantities(Integer itemId) {
        bill.remove(itemId);
    }
}
