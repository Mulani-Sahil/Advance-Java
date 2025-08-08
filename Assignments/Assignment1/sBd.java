package assignment1;
import java.util.LinkedList;
import java.util.Scanner;

public class sBd {
    public static void main(String[] args) {
        LinkedList<String> li = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\nMENU:");
            System.out.println("0. Prepare a list");
            System.out.println("1. Add Element at the end of the list");
            System.out.println("2. Delete the first element of the list");
            System.out.println("3. Display the content of the list in reversed order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();  // consume leftover newline

            switch (ch) {
                case 0:
                    System.out.print("Enter number of elements to add: ");
                    int n = sc.nextInt();
                    sc.nextLine(); // consume newline
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter element " + (i + 1) + ": ");
                        String element = sc.nextLine();
                        li.add(element);
                    }
                    break;

                case 1:
                    System.out.print("Enter Element: ");
                    String str = sc.nextLine();
                    li.addLast(str);
                    break;

                case 2:
                    if (!li.isEmpty()) {
                        li.removeFirst();
                        System.out.println("First element removed.");
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;

                case 3:
                    if (!li.isEmpty()) {
                        System.out.println("List in reverse order:");
                        for (int i = li.size() - 1; i >= 0; i--) {
                            System.out.println(li.get(i));
                        }
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (ch != 4);

        sc.close();
    }
}
