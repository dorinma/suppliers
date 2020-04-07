import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

public class Supplier {
    private  int id;
    private String name;
    private String phoneNum;
    private int bankAccount;
    private String payment;
    private String supplySchedule;
    private String supplyLocation;
    private List<Pair<Item, Integer>> items;
    private Agreement agreement;

    public Supplier(int id, String name, String phoneNum, int bankAccount, String payment, String supplySchedule, String supplyLocation, List<Pair<Item, Integer>> items, LinkedHashMap<Integer, Double> agreement) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.bankAccount = bankAccount;
        this.payment = payment;
        this.supplySchedule = supplySchedule;
        this.supplyLocation = supplyLocation;
        this.items = items;
        this.agreement = new Agreement(agreement);
    }

    public int getId() { return this.id; }

    public Agreement getAgreement() { return this.agreement; }

    public boolean makeOrder(List<ItemInOrder> items) {
        int counter = 0;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getKey().getId() == items.get(i).getItemId()) {
                if (this.items.get(i).getValue() >= items.get(i).getQuantity())
                    counter++;
            }
        }
        if (counter != items.size()) return false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getKey().getId() == items.get(i).getItemId()) {
                Pair<Item, Integer> p = new Pair(this.items.get(i), this.items.get(i).getValue() - items.get(i).getQuantity());
                this.items.remove(i);
                this.items.add(p);
            }
        }
        return true;
    }

    public void updateBillOfQuantities( Integer itemId, Pair<Integer, Double> quantity_disc) {
        this.agreement.updateBillOfQuantities(itemId,quantity_disc);
    }

    public void deleteBillOfQuantities(Integer itemId) {
        this.agreement.deleteBillOfQuantities(itemId);
    }

    public void addItemToAgreement(Integer item_id, Double cost) {
        this.agreement.insertItem(item_id,cost);
    }

    public List<Item> getItems() {
        LinkedList items = new LinkedList();
        for(int i=0; i < this.items.size(); i++){
            items.add(this.items.get(i));
        }
        return items;
    }
}
