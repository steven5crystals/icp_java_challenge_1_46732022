package shop;

import java.util.Scanner;

public class itemdemo {

    public static void main(String args[]) {

        
		@SuppressWarnings("unused")
		long id;
        char choice;
        Shop aShop = new Shop();
        Scanner sc = new Scanner(System.in);

        System.out.println("--ESSENTIALS DATA--");
        do {
            System.out.println("1. Add items to stock list");
            System.out.println("2. Issue item");
            System.out.println("3. Update item list");
            System.out.println("4. Display item details");
            System.out.println("5. Check price for a item");
            System.out.println("6. Exit");
            System.out.println("Choice:");
            choice = sc.nextLine().charAt(0);
            switch (choice) {
            case '1':
                aShop.addItem();
                break;

            case '2':
                aShop.updateStock();
                break;

            case '3':
                aShop.issueItem();
                break;

            case '4':
                aShop.display();
                break;

            case '5':

                System.out.println("Price of the Item is:"
                        + aShop.checkPrice(inputID()));

            case '6':
                System.out.println("Thank you!\n");
                break;
            }
        } while (choice != '6');
        sc.close();
    }

    public static long inputID() {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter Item code:");
        if (sc.hasNextLong()) {
            return sc.nextLong();
        } else {
            System.out.println("Invalid Input");
            return 0;
        }

    }
}
