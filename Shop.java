package shop;

import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Shop {

    private ArrayList<Item> ItemList;
    private Scanner sc = new Scanner(System.in);

    public Shop() {
        System.out.println("New Shop for Items created.");
        ItemList = new ArrayList<Item>();
    }

    public int getSize() {
        return ItemList.size();

    }

    private Item search(long code) {
        Iterator<Item> itr = ItemList.iterator();
        Item item;
        while (itr.hasNext()) {
            item = new Item(itr.next());
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }

    public Item search(String name) {
        Iterator<Item> itr = ItemList.iterator();
        Item item;
        while (itr.hasNext()) {
            item = new Item(itr.next());
            if (item.getName() == name) {
                return item;
            }
        }
        return null;
    }

    public void addItem() {
        long aCode;
        String aName;
        double aRate;
        int aQuantity;
        Item foundItem;

        System.out.println("Enter Item code:");
        aCode = sc.nextLong();
        foundItem = search(aCode);
        if (foundItem == null) {
            System.out.println("Item name : ");
            aName = sc.next();
            System.out.println("Rate (GHC) : ");
            aRate = sc.nextDouble();
            System.out.println("Quantity : ");
            aQuantity = sc.nextInt();
            Item aItem = new Item(aName, aRate, aCode, aQuantity);
            ItemList.add(aItem);
        } else if (foundItem != null) {
            System.out.println("Item exists");
        }

    }

    public void updateStock() {
        int choice, quantity;
        long code;
        double price;
        Item foundItem;

        System.out.println("1. Update quantity.");
        System.out.println("2. Update rate.");
        System.out.println("Choice:");
        choice = sc.nextInt();

        System.out.println("Enter Item code:");
        code = sc.nextLong();
        foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }

        if (choice == 1) {

            System.out.println("Enter quantity to add: ");
            quantity = sc.nextInt();
            foundItem.setQuantity(foundItem.getQuantity() + quantity);
            System.out.println("\n Quantity updated\n");
            System.out.println("Present quantity: " + foundItem.getQuantity());
        }

        else if (choice == 2) {

            System.out.println("Enter new price: ");
            price = sc.nextDouble();
            foundItem.setRate(price);
            System.out.println("\n Price updated\n");
            System.out.println("Present Price: " + foundItem.getRate());
        }

        else {
            System.out.println("Wrong choice!!");
            updateStock();
        }

    }

    public void display() {

        long code;
        Item foundItem;

        System.out.println("Enter Item code:");
        code = sc.nextLong();
        foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }

        System.out.println(foundItem.toString());
    }

    public void issueItem() {
        int numberOfItem;
        long code;
        Item foundItem;

        System.out.println("Enter Item code:");
        code = sc.nextLong();
        foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }

        System.out.println("Number of Item : ");
        numberOfItem = sc.nextInt();
        if (numberOfItem > foundItem.getQuantity()) {
            System.out.println("\nRequired number of Items not in stock\n\n");
            return;
        }

        else {
            System.out.println("\nCost of " + numberOfItem + " copies : rs. "
                    + numberOfItem * foundItem.getRate());
            foundItem.setQuantity(foundItem.getQuantity() - numberOfItem);
        }
    }

    public double checkPrice(long code) {
        Item foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return 0.0;
        }

        else
            return foundItem.getRate();
    }

    public class WriteToFile {
    	  public void main(long code) {
    	    try {
    	      FileWriter myWriter = new FileWriter("essentials_stock.txt");
    	      myWriter.write((int) code);
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	  }
    }
    
    public class ReadFromFile {
  	  public void main(long code) {
  	    try {
  	      @SuppressWarnings({ "unused", "resource" })
		FileReader myReader = new FileReader("essentials_stock.txt");
  	      System.out.println(code);
  	    } catch (IOException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
  	  }
  }

    @SuppressWarnings("unused")
	private class WriteBackup {
  	  public void main(long code) {
  	    try {
  	      FileWriter myWriter = new FileWriter("backup_essentials_stock.txt");
  	      myWriter.write((int) code);
  	      myWriter.close();
  	      System.out.println("Successfully wrote to the file.");
  	    } catch (IOException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
  	  }
  }

}