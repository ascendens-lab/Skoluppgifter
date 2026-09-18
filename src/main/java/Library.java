import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {

    static void main(){

        String input;

        do{
            IO.println("Bibliotekshanteraren");
            IO.println("====================");
            IO.println("1. Lägg till bok");
            IO.println("2. Registrera medlem");
            IO.println("3. Låna bok");
            IO.println("4. Lämna tillbaka bok");
            IO.println("5. Sök bok (titel eller författare)");
            IO.println("6. Visa alla böcker och status");
            IO.println("e. Avslut");

            input = IO.readln();

            switch (input){
                case "1" -> addBook();
                case "2" ->  registrerMember();
                case "3" -> borrowBook();
                case "4" -> returnBook();
                case "5" -> searchBook();
                case "6" -> showStatus();
                case "e","E" -> System.exit(0);

                default ->  IO.println("Välj ett alternativ från menyn.");

            }

        } while (!input.equals("e"));

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();



    }


    private static void showStatus() {
    }

    private static void searchBook() {
    }

    private static void returnBook() {
    }

    private static void borrowBook() {
    }

    private static void registrerMember() {
    }

    static void addBook(){
        IO.println("addBook");
    }



    /*static String inPut() {
        String printText;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;

    }*/
    static Book[] bookShelf(){
        Book[] books = new Book[15];
        books[0] = new Book("1984", "George Orwell", 1949, false);
        books[1] = new Book("Dumskallarnas sammanvärjning","John Kennedy Toole", 1980,false);
        books[2] = new Book("Mörkrets hjärta", "Joseph Conrad",1899, false);
        books[3] = new Book("Röda rummet", "August Strindberg",1879,false);
        books[4] = new Book("Harry Potter och de vises sten","J.K. Rowling", 1997,false);
        books[5] = new Book("Sagan om ringen", "J.R.R. Tolkien", 1954,false);
        books[6] = new Book("Portnoys besvär","Philip Roth",1969,false);
        books[7] = new Book("Brott och straff","Fjodor Dostojevskij",1866,false);
        books[8] = new Book("Mästaren och Margarita"," Michail Bulgakov",1967,false);
        books[9] = new Book("En julsaga","Charles Dickens", 1843,false);

        return books;

    }

   record Book(String title, String author, int published,boolean borrowed){

    }
}
