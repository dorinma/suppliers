import javafx.util.Pair;

import java.util.Map;

public class BillOfQuantities {

    private Map<Integer, Pair<Integer, Integer>> bill;

    public BillOfQuantities(Map<Integer, Pair<Integer, Integer>> bill) {
        this.bill = bill;
    }

    public void insert(Integer itemId, Pair<Integer, Integer> quantity_disc) {
        bill.put(itemId,quantity_disc);
    }

    public void updateBillOfQuantities(Integer itemId, Pair<Integer, Integer> quantity_disc) {
        bill.put(itemId, quantity_disc);
    }

    public void deleteBillOfQuantities(Integer itemId) {
        bill.remove(itemId);
    }
}
