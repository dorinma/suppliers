import java.util.LinkedList;
import java.util.List;
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

    public Supplier(int id, String name, String phoneNum, int bankAccount, String payment, String supplySchedule, String supplyLocation,List<Pair<Item, Integer>> items,List<Pair<Integer,Integer>> agreement) {
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

    /*
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public int getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public String getSupplyScedule() {
        return supplySchedule;
    }
    public void setSupplyScedule(String supplySchedule) {
        this.supplySchedule = supplySchedule;
    }
    public String getSupplyLocation() {
        return supplyLocation;
    }
*/

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

   /* public double getPriceOfItem(double id){
        for (int i=0; i< items.size(); i++) {
            if(items.get(i).getKey().getId() == id)
                return items.get(i).getKey().getPrice();
        }
        return -1;
    }*/

    public void updateBillOfQuantities( Integer itemId, Pair<Integer, Integer> quantity_disc) {
        this.agreement.updateBillOfQuantities(itemId,quantity_disc);
    }

    public void deleteBillOfQuantities(Integer itemId) {
        this.agreement.deleteBillOfQuantities(itemId);
    }
}
