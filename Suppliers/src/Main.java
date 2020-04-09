import javafx.util.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    static FacadeController fc = FacadeController.getFacadeController();

    public static void main(String[] args) {
        boolean exit;
        System.out.println("Hello!");
        do {
            exit = displayMainMenu();
        } while (!exit);
    }

    private static boolean displayMainMenu(){
        boolean exit = false;
        String choice;
        do {
            System.out.println("Please choose a function:");
            System.out.println("1. Add Supplier");
            System.out.println("2. Manage Supplier");
            System.out.println("3. Make Order");
            System.out.println("4. Quit");
            System.out.print("Option: ");
            int supplierIdCounter = 0;
            int orderIdCounter= 0;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();  // Read user input
            switch (choice) {
                case "1":
                    supplierIdCounter = addSupplier(supplierIdCounter);
                    break;
                case "2":
                    System.out.print("Supplier's id: ");
                    Scanner scanner2 = new Scanner(System.in);
                    int suppId =scanner2.nextInt();
                    manageSupplier(suppId);
                    break;
                case "3":
                    orderIdCounter= addOrder(orderIdCounter);
                    break;
                case "4":
                    System.out.println("Thank you for using our system.\nFor your information, no data is being saved so far.\nGoodbye!");
                    exit = true;
                    break;
            }
        }while (!exit);
        return true;
    }

    private static void addItems(List<Pair<Item, Integer>> items) {
        Scanner scanner = new Scanner(System.in);
        String temp;
        System.out.print("Item's identifier: ");
        temp = scanner.nextLine();
        int itemId = Integer.parseInt(temp);
        System.out.print("Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Description: ");
        String itemDescription = scanner.nextLine();
        System.out.print("Quantity of this item: ");
        temp = scanner.nextLine();
        int itemQuantity = Integer.parseInt(temp);
        Item item = new Item(itemId, itemName, itemDescription);
        items.add(new Pair(item, itemQuantity));
        System.out.print("Insert more items? [Y/N]");
    }

    private static int addSupplier(int supplierIdCounter){
        String temp;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Supplier's name: ");
        String suppName = scanner.nextLine();
        System.out.print("Phone number: ");
        String suppPhone = scanner.nextLine();
        System.out.print("Bank account number: ");
        temp = scanner.nextLine();
        int suppBankAccount = Integer.parseInt(temp);
        System.out.print("Payment method (Cash, Credit etc.): ");
        String suppPayment = scanner.nextLine();
        System.out.print("Supply schedule: ");
        String suppSchedule = scanner.nextLine();
        System.out.print("Supply location: ");
        String suppLocation = scanner.nextLine();

        List<Pair<Item, Integer>> items = new LinkedList();

        System.out.print("Insert supplier's items? [Y/N]");
        String addItems = scanner.nextLine();
        while (addItems.equals("Y") | addItems.equals("y")) {
            addItems(items);
            addItems = scanner.nextLine();
        }
        LinkedHashMap agreement = new LinkedHashMap();
        if(items.size() > 0) {
            System.out.println("Please insert supplier's agreement (for each item insert it's cost).");
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getKey().getName() + ": ");
                temp = scanner.nextLine();
                double itemPrice = Integer.parseInt(temp);
                agreement.put(items.get(i).getKey().getId(), itemPrice);
            }
        }
        //TODO add bill of quantities
        fc.supplierController.addSupplier(supplierIdCounter, suppName, suppPhone, suppBankAccount, suppPayment,
                suppSchedule, suppLocation, items, agreement);
        System.out.println("Supplier added successfully. Id is: " + supplierIdCounter);
        return supplierIdCounter++;

    }

    private static void manageSupplier(int suppId){
        boolean backToMainMenu = false, backToManageSupplierMenu = false;
        //String temp, choice;
        //Scanner scanner = new Scanner(System.in);
        do{
            backToManageSupplierMenu = displayManageSupplierMenu(suppId);
        }while (!backToManageSupplierMenu);
    }

    private static boolean displayManageSupplierMenu(int suppId){
        String temp, choice;
        boolean backToManageSupplierMenu = false;
        Scanner scanner = new Scanner(System.in);
        if(fc.supplierController.getSuppById(suppId) != null) {
            System.out.println("\nPlease choose a function:");
            System.out.println("1. Add items");
            System.out.println("2. Edit agreement");
            System.out.println("3. Add bill of quantities");
            System.out.println("4. Edit bill of quantities");
            System.out.println("5. Main menu");
            System.out.print("Option: ");
            choice = scanner.nextLine();  // Read user input
            switch (choice) {
                case "1": //Add items
                    List<Pair<Item, Integer>> items = new LinkedList();
                    String addItems = "Y";
                    int index = items.size();
                    while (addItems.equals("Y") | addItems.equals("y")) {
                        addItems(items);
                        addItems = scanner.nextLine();
                    }
                    if (items.size() > 0) {
                        System.out.println("Please insert supplier's agreement (for each item insert it's cost).");
                        for (int i = index; i < items.size(); i++) {
                            System.out.print(items.get(i).getKey().getName() + ": ");
                            temp = scanner.nextLine();
                            double itemPrice = Integer.parseInt(temp);
                            fc.supplierController.addItemToAgreement(suppId, items.get(i).getKey().getId(), itemPrice);
                        }
                    }
                    break;
                case "2": //Edit agreement
                    String toContinue;
                    do {
                        toContinue = editAgreement(suppId);
                    }while (toContinue.equals("Y") | toContinue.equals("y"));
                    break;
                case "3":
                    AddbillOfQuantities(suppId);
                    break;
                case "4":
                    editbillOfQuantities(suppId);
                    break;
                case "5":
                    backToManageSupplierMenu = true;
                    break;
            }
        }
        return backToManageSupplierMenu;
    }

    private static void editbillOfQuantities(int suppId) {
        String ans="";
        if (fc.supplierController.checkBillOfQuantity(suppId) == false) {
            System.out.println("No Bill of Quantity found , please insert some item first");
        }
        else
        {
            do{
            Map<Integer, Pair<Integer, Double>> map= fc.supplierController.getbillOfQuantities(suppId);
            for(Integer itemId:map.keySet())
            {

              String item_name = fc.supplierController.getItemName(suppId,itemId);
              Integer itemQuantity = map.get(itemId).getKey();
              Double itemDiscount = map.get(itemId).getValue();
              System.out.println(itemId+". "+ item_name +" "+itemQuantity+" "+itemDiscount );
            }
            System.out.println("Choose the id of the item you want to change: ");
            Scanner scanner2 = new Scanner(System.in);
            int chooseId =scanner2.nextInt();
            System.out.println("Enter the new amount :");
            int newAmount=scanner2.nextInt();
            System.out.println("Enter the new discount :");
            Double newDiscount=scanner2.nextDouble();
            fc.supplierController.updateBillOfQuantities(suppId,chooseId,new Pair(newAmount,newDiscount));
            System.out.print("Update more? [Y/N]");
            Scanner scanner = new Scanner(System.in);
            ans =scanner2.nextLine();
        }
        while (ans=="y"|ans=="Y");
        }

    }

    private static void AddbillOfQuantities(int suppId) {
        String ans;
        do {
            displayItems(suppId);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose the id you want to add :");
            int itemNum = scanner.nextInt() - 1;
            LinkedHashMap<Integer, Double> terms = fc.supplierController.showSuppItems(suppId);
            int itemId = new ArrayList<>(terms.keySet()).get(itemNum);

            System.out.println("Choose the amount you want :");
            int item_quantity = scanner.nextInt();
            System.out.println("Choose the discount you want :(by %)");
            Double item_disscount = scanner.nextDouble();
            Pair<Integer, Double> pair = new Pair(item_quantity, item_disscount);
            if (fc.supplierController.checkBillOfQuantity(suppId) == false) {
                Map<Integer, Pair<Integer, Double>> map = new HashMap();
                map.put(itemId, pair);
                fc.supplierController.addBillOfQuantities(suppId, map);
            } else {
                fc.supplierController.addItemToBillOfQuantity(suppId, itemId, item_quantity, item_disscount);
            }
            System.out.print("Insert more? [Y/N]");
            Scanner scanner2 = new Scanner(System.in);
            ans =scanner2.nextLine();
        }
        while (ans=="y"|ans=="Y");
    }

    private static void displayItems(int suppId) {
        LinkedHashMap<Integer, Double> terms = fc.supplierController.showSuppItems(suppId);
        for(int i=0; i<terms.size(); i++) {
            String itemName = fc.supplierController.getSuppById(suppId).getItems().get(i).getName();
            String itemDesc = fc.supplierController.getSuppById(suppId).getItems().get(i).getDescription();
            int index= fc.supplierController.getSuppById(suppId).getItems().get(i).getId();
            double itemPrice = fc.supplierController.getPriceOfItem(suppId,index);
            System.out.print(i+1 + ". " + itemName + ", ");
            if(itemDesc.length() > 0)
                System.out.print(itemDesc + ", ");
            System.out.print(itemPrice + " NIS\n");
        }
    }

    private static void displayItemsById(int suppId) {
        LinkedHashMap<Integer, Double> terms = fc.supplierController.showSuppItems(suppId);
        for(int i=0; i<terms.size(); i++) {
            List<Item> r =fc.supplierController.getSuppById(suppId).getItems();
            String rr =r.get(0).getName();
            String itemName = fc.supplierController.getSuppById(suppId).getItems().get(i).getName();
            String itemDesc = fc.supplierController.getSuppById(suppId).getItems().get(i).getDescription();
            int index= fc.supplierController.getSuppById(suppId).getItems().get(i).getId();
            double itemPrice = fc.supplierController.getPriceOfItem(suppId,index);
            System.out.print("ID: "+index + ". " + itemName + ", ");
            if(itemDesc.length() > 0)
                System.out.print(itemDesc + ", ");
            System.out.print(itemPrice + " NIS\n");
        }
    }

    private static String editAgreement(int suppId){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose the item it's price you wish to change.");
        LinkedHashMap<Integer, Double> terms = fc.supplierController.showSuppItems(suppId);
        displayItems(suppId);

        System.out.print("Item's number: ");
        int itemNum = scanner.nextInt() - 1;
        int itemId = new ArrayList<>(terms.keySet()).get(itemNum);
        for(int i=0; i<fc.supplierController.getSuppById(suppId).getItems().size(); i++){
            if(fc.supplierController.getSuppById(suppId).getItems().get(i).getId() == itemId){
                String itemName = fc.supplierController.getSuppById(suppId).getItems().get(i).getName();
                String itemDesc = fc.supplierController.getSuppById(suppId).getItems().get(i).getDescription();
                double itemPrice = terms.get(itemId);

                System.out.print(itemName + ", ");
                if(itemDesc.length() > 0)
                    System.out.print(itemDesc + ", ");
                System.out.print(itemPrice + "NIS\n");
                System.out.print("New price: ");
                double newPrice = scanner.nextDouble();
                fc.supplierController.getSuppById(suppId).getAgreement().setPrice(itemId, newPrice);
            }
        }
        System.out.print("Price changed successfully. More items to update? [Y/N] ");
        Scanner scanner2 = new Scanner(System.in);
         return  scanner2.nextLine();
    }

    private static int addOrder(int orderIdCounter){
        System.out.print("Enter the Supplier id that need to manage the order ");
        Scanner scanner = new Scanner(System.in);
        int suppId = scanner.nextInt();
        displayItemsById(suppId);
        List<Pair<Integer, Integer>> items = new LinkedList<>();
        String choose;
        do {
            System.out.print("Choose the id of the product");
            int itemId = scanner.nextInt();
            System.out.print("Choose the amount of the product");
            int itemAmount = scanner.nextInt();
            items.add(new Pair(itemId, itemAmount));
            System.out.print("Do you have more items to add to the order ?[Y|N]");
            Scanner scanner2 = new Scanner(System.in);
            choose =scanner2.nextLine();
        }while (choose=="y"|choose=="Y");
         boolean result =fc.orderController.addOrder(orderIdCounter,items,suppId);
         if(result) {
             System.out.println("Order successfully made");
             return orderIdCounter++;
         }
         else
         {
             System.out.println("Order Failed, Pleas try again");
             return orderIdCounter;
         }
    }

}
