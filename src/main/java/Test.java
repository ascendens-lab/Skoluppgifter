import java.util.Scanner;

public class Test {

    static Book[] BookArray = new Book[15];
    static Scanner scanner = new Scanner(System.in);

    static void main() {

        BookArray[0] = new Book("1984", "George Orwell", 1949, false);
        BookArray[1] = new Book("Dumskallarnas sammanvärjning",
                "John Kennedy Toole", 1980, false);

        String input;

        do {
            IO.println("1. Lägg till bok");
            IO.println("e. Avslut");

            input = scanner.nextLine();

            switch (input) {
                case "1" -> addBook();
                case "e", "E" -> System.exit(0);
                default -> IO.println("Välj ett alternativ från menyn.");
            }

        } while (!input.equalsIgnoreCase("e"));
    }

    static void addBook() {

        int index = findNull();

        IO.print("Ange titel på boken: ");
        String title = scanner.nextLine();

        IO.print("Ange författare till boken: ");
        String author = scanner.nextLine();

        IO.print("Ange utgivningsår för boken: ");
        int published = Integer.parseInt(scanner.nextLine());

        BookArray[index] = new Book(title, author, published, false);

        IO.println("Boken har lagts till på plats " + index);
    }

    private static int findNull() {

        for (int i = 0; i < BookArray.length; i++) {

            if (BookArray[i] == null) {
                return i;
            }
        }

        return -1;
    }

    record Book(String title, String author, int published, boolean borrowed) {
    }
}