import javafx.util.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args)
  {
      String choose="";
      FacadeController fc = FacadeController.getFacadeController();
    System.out.println("Hello!");
     do{
      System.out.println("Choose what you want to do");
      System.out.println("1. Add Supplier");
      System.out.println("2. Add order");
      System.out.println("3. Manage Supplier");
      System.out.println("4. Quit");
      int supplierIdCounter=0;
      Scanner myObj = new Scanner(System.in);
      choose = myObj.nextLine();  // Read user input
          switch (choose) {
              case "1":
                  System.out.println("Enter you name");
                  myObj = new Scanner(System.in);
                  String name = myObj.nextLine();
                  System.out.println("Enter you Phone Number");
                  myObj = new Scanner(System.in);
                  String PhoneNumber = myObj.nextLine();
                  System.out.println("Enter you Bank Account Number");
                  myObj = new Scanner(System.in);
                  String s = myObj.nextLine();
                  int bank_account = Integer.parseInt(s);
                  System.out.println("Enter Payment methods (Cash,Credit etc.)");
                  myObj = new Scanner(System.in);
                  String payment = myObj.nextLine();
                  System.out.println("Enter Supplier schedule");
                  myObj = new Scanner(System.in);
                  String schedule = myObj.nextLine();
                  System.out.println("Enter Your Location");
                  myObj = new Scanner(System.in);
                  String location = myObj.nextLine();

                  List<Pair<Item,Integer>> items = new LinkedList();

                  String  CHOOSE="Y";
                  while (CHOOSE.equals("Y")) {
                      System.out.println("Enter Your ItemID");
                      myObj = new Scanner(System.in);
                      String ItemId = myObj.nextLine();
                      int item_id = Integer.parseInt(ItemId);
                      System.out.println("Enter Your Item Name:");
                      myObj = new Scanner(System.in);
                      String ItemName = myObj.nextLine();
                      System.out.println("Enter Your Item Description:");
                      myObj = new Scanner(System.in);
                      String ItemDescription = myObj.nextLine();
                      System.out.println("Enter Your quantity of this item:");
                      myObj = new Scanner(System.in);
                      String item_q = myObj.nextLine();
                      int item_quantity = Integer.parseInt(item_q);
                      Item item = new Item(item_id, ItemName, ItemDescription);
                      items.add(new Pair(item, item_quantity));
                      System.out.println("Do you Have more Items? (Y/N)");
                      myObj = new Scanner(System.in);
                      CHOOSE = myObj.nextLine();
                  }
                  HashMap agg_map = new HashMap();
                  System.out.println("Enter Your Agreement Details");
                  String option = "Y";
                  while (option.equals("Y")) {//TODO לעבור על הרשימה של האייטמים במקום הלולאה הזו ולכתוב לכל אייטם מה המחיחר שלו
                      System.out.println("Enter Your Item ID ");
                      myObj = new Scanner(System.in);
                      String ItemId = myObj.nextLine();
                      int item_id = Integer.parseInt(ItemId);
                      System.out.println("Enter Your Item Price ");
                      myObj = new Scanner(System.in);
                      String Item_price = myObj.nextLine();
                      int item_price = Integer.parseInt(Item_price);
                      agg_map.put(item_id, item_price);
                      System.out.println("Do you have more? ");
                      myObj = new Scanner(System.in);
                      option = myObj.nextLine();
                  }
                  fc.supplierController.addSupplier(supplierIdCounter++,name,PhoneNumber,bank_account,payment,schedule,location,items,agg_map);
                  System.out.println("Supplier added successfully");
                  break;
              case "2":
                  break;
              case "3":
                  break;
              case "4":
                  System.out.println("GOOD BYE! COME AGAIN. BUT JUST FOR YOU KNOW , NOTHING WILL BE SAVE");
                  break;
          }
      }while (choose!="4") ;



     /* List<Pair<Item,Integer>> list = new LinkedList();
      Item item =new Item(55,"Milk","3%");
      list.add(new Pair(item,100));
      List<Pair<Integer,Integer>> agg = new LinkedList();
      agg.add(new Pair(55,3));
      fc.supplierController.addSupplier(1,"dorin","053",555,"cash","mondays","Super-Li",list,agg);
      Map<Integer,Pair<Integer,Double>> map = new HashMap<>() ;
      Pair<Integer,Double> item_in_map= new Pair(100,0.5);
      map.put(55,item_in_map);
      fc.supplierController.addBillOfQuantities(1, map);
      List<Pair<Integer,Integer>> order = new LinkedList();
      order.add(new Pair(55,10));
      boolean ans =fc.orderController.addOrder(1,order,1);
      if(ans)
          System.out.println("good");
      else
          System.out.println("not good");

*/


  }

}
