import javafx.util.Pair;

import java.util.Map;

public class BillOfQuantities {

    private Map<Integer, Pair<Integer, Integer>> bill;

    public BillOfQuantities(Map<Integer, Pair<Integer, Integer>> bill) {
        this.bill = bill;
    }
}
