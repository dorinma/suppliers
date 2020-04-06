import javafx.util.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String choice = "", temp = "";
        boolean exit = false, backToMenu = false;
        FacadeController fc = FacadeController.getFacadeController();
        System.out.println("Hello!");
        do {
            System.out.println("Please choose a function:");
            System.out.println("1. Add Supplier");
            System.out.println("2. Manage Supplier");
            System.out.println("3. Make Order");
            System.out.println("4. Quit");
            System.out.print("Option: ");
            int supplierIdCounter = 0;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();  // Read user input
            switch (choice) {
                case "1":
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

                    System.out.println("Insert supplier's items? [Y/N]");
                    String addItems = scanner.nextLine();
                    while (addItems.equals("Y") | addItems.equals("y")) {
                        addItems(items);
                        addItems = scanner.nextLine();
                    }
                    HashMap agreement = new HashMap();
                    if(items.size() > 0) {
                        System.out.println("Please insert supplier's agreement (for each item insert it's cost).");
                        for (int i = 0; i < items.size(); i++) {
                            System.out.print(items.get(i).getKey().getName() + ": ");
                            temp = scanner.nextLine();
                            double itemPrice = Integer.parseInt(temp);
                            agreement.put(items.get(i).getKey(), itemPrice);
                        }
                    }
                    //add bill of quantities
                    fc.supplierController.addSupplier(supplierIdCounter, suppName, suppPhone, suppBankAccount, suppPayment,
                            suppSchedule, suppLocation, items, agreement);
                    System.out.println("Supplier added successfully. Id is: " + supplierIdCounter);
                    supplierIdCounter++;
                    break;
                case "2":
                    do{
                    System.out.print("Supplier's id: ");
                    temp = scanner.nextLine();
                    int suppId = Integer.parseInt(temp);
                    if(fc.supplierController.getSuppById(suppId) != null) {
                        System.out.println("Please choose a function:");
                        System.out.println("1. Add items");
                        System.out.println("2. Edit agreement");
                        System.out.println("3. Add bill of quantities");
                        System.out.println("4. Edit bill of quantities");
                        System.out.println("5. Main menu");
                        System.out.print("Option: ");
                        choice = scanner.nextLine();  // Read user input
                        switch (choice) {
                            case "1":
                                items = new LinkedList();
                                addItems = "Y";
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
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                backToMenu = true;
                                break;
                        }
                    }
                    }while (!backToMenu);
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("Thank you for using our system.\nFor your information, no data is being saved so far.\nGoodbye!");
                    exit = true;
                    break;
            }
        } while (!exit);

    }

    private static void addItems(List<Pair<Item, Integer>> items) {
        Scanner scanner = new Scanner(System.in);
        String temp = "";
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

    private static void option1()
    {
        




    }
}
