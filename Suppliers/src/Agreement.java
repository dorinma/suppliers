import javafx.util.Pair;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class Agreement {

    private String terms;
    private BillOfQuantities bill;

    public Agreement(String terms) {
        this.terms = terms;
        this.bill = null;
    }

    public void addBillOfQuantities(Map<Integer, Pair<Integer, Integer>> bill) {
        this.bill = bill;
    }
}
