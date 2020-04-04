import java.util.List;
import java.util.LinkedList;

public class Agreement {

    private int id; //=supplierId
    private String terms;
    private List<BillOfQuantities> quantities;

    public Agreement(int id, String terms) {
        this.id = id;
        this.terms = terms;
        this.quantities = new LinkedList<>();
    }

    public void addBillOfQuantities(int itemId, int quantity, int discount) {
        int id = quantities.size();
        BillOfQuantities boq = new BillOfQuantities(id, itemId, this.id, quantity, discount);
        this.quantities.add(boq);
    }
}
