import javafx.util.Pair;

import java.util.List;

public class FacadeController {
    SupplierController supplierController;
    OrderController orderController;

    private FacadeController()
    {
        this.supplierController=new SupplierController();
        this.orderController = new OrderController();
    }
    public FacadeController getFacadeController()
    {
        if(this.supplierController==null) return new FacadeController();
        else return this;
    }
    public void addSupplier(int id, String name, int phoneNum, int bankAccount, String payment, String supplyScedule, String supplyLocation, List<Item> items)
    {
        supplierController.addSupplier(id,name,phoneNum,bankAccount,payment,supplyScedule,supplyLocation,items);
    }
    public void addAgreement (int id , int supplierId,String terms,int quantitiesId)
    {
        supplierController.addAgreement(id,supplierId,terms,quantitiesId);
    }
    public void addBillOfQuantities (int id , int itemId,int supplierId,int quantity,int discount)
    {
        supplierController.addBillOfQuantities(id,supplierId,itemId,supplierId,discount);
    }

    public boolean addOrder(int id, List<Pair<Integer, Integer>> items, int supplierId)
    {
        return orderController.addOrder(id,items, supplierId);
    }


}
