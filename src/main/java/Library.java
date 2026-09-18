import java.util.Scanner;

public class Library {
    static Book[] BookArray = new Book[15];
    static void main(){
        bookShelf();


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

        textInput();


    }



    private static String textInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;

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

        int index = findNull();

        IO.print("Ange titel på boken:  ");
        String title = textInput();

        IO.print("Ange författare till boken:  ");
        String author = textInput();

        IO.print("Ange utgivningsår för boken:  ");
        int published = Integer.parseInt(textInput());

            BookArray[index] = new Book(title,author,published,false);

                IO.println(index);


            }

    private static int findNull() {
        for (int i = 0; i < BookArray.length; i++) {
            if (BookArray[i]== null){
                 return i;

            }


        }

        return -1;
    }

    static void bookShelf( ) {

        BookArray[0] = (new Book("1984", "George Orwell", 1949, false));
        BookArray[1] = (new Book("Dumskallarnas sammanvärjning", "John Kennedy Toole", 1980, false));
        BookArray[2] = (new Book("Mörkrets hjärta", "Joseph Conrad", 1899, false));
        BookArray[3] = (new Book("Röda rummet", "August Strindberg", 1879, false));
        BookArray[4] = (new Book("Harry Potter och de vises sten", "J.K. Rowling", 1997, false));
        BookArray[5] = (new Book("Sagan om ringen", "J.R.R. Tolkien", 1954, false));
        BookArray[6] = (new Book("Portnoys besvär", "Philip Roth", 1969, false));
        BookArray[7] = (new Book("Brott och straff", "Fjodor Dostojevskij", 1866, false));
        BookArray[8] = (new Book("Mästaren och Margarita", "Michail Bulgakov", 1967, false));
        BookArray[9] = (new Book("En julsaga", "Charles Dickens", 1843, false));




    }





   record Book(String title, String author, int published, boolean borrowed){

    }

}
