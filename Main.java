import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        InMemoryDB db = new InMemoryDB();
        String account;
        int value;

        while(true){
            System.out.println("What would you like to do?\n1. Get\n2. Begin Transaction\n3. Put\n4. Commit\n5. Rollback\n6. Quit");
            switch (Integer.parseInt(key.nextLine())) {
                case 1:
                    System.out.println("Enter name of account:");
                    account = key.nextLine();
                    System.out.println(db.get(account));
                    break;
                case 2:
                    db.begin_transaction();
                    break;
                case 3:
                    System.out.println("Enter name of account:");
                    account = key.nextLine();
                    System.err.println("Enter account value:");
                    value = Integer.parseInt(key.nextLine());
                    db.put(account, value);
                    break;
                case 4:
                    db.commit();
                    break;
                case 5:
                    db.rollback();
                    break;
                default:
                    return;
            }
        }
    }
}
