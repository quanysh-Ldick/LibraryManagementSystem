import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Author a1 = new Author("Абай", "KZ");
        Author a2 = new Author("Мухтар", "KZ");

        Book b1 = new Book("Абай жолы", a2, 1942);
        Book b2 = new Book("Қара сөздер", a1, 1890);

        library.addBook(b1);
        library.addBook(b2);

        User user = new User("Student");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Көру");
            System.out.println("2. Іздеу");
            System.out.println("3. Алу");
            System.out.println("4. Қайтару");
            System.out.println("0. Шығу");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                library.showBooks();
            } else if (choice.equals("2")) {
                System.out.print("Атауы: ");
                String t = sc.nextLine();
                Book book = library.searchBook(t);
                System.out.println(book != null ? book.getInfo() : "Табылмады");
            } else if (choice.equals("3")) {
                System.out.print("Атауы: ");
                String t = sc.nextLine();
                Book book = library.searchBook(t);
                if (book != null) user.borrowBook(book);
            } else if (choice.equals("4")) {
                System.out.print("Атауы: ");
                String t = sc.nextLine();
                Book book = library.searchBook(t);
                if (book != null) user.returnBook(book);
            } else if (choice.equals("0")) {
                break;
            }
        }
    }
}