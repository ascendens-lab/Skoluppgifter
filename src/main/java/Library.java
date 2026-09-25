import java.util.Locale;
import java.util.Scanner;

public class Library {
    static Book[] bookArray = new Book[11];
    static Member[] memberArray = new Member[10];
    static int memberID = 1;
    static int index =0;


    static boolean[] borrowedArray = new boolean[11];


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
                case "2" -> registerMember();
                case "3" -> borrowBook();
                case "4" -> returnBook();
                case "5" -> searchBook();
                case "6" -> showStatus();
                case "e","E" -> System.exit(0);

                default ->  IO.println("Välj ett alternativ från menyn.");

            }

        } while (!input.equals("e"));

        Input();
    }

    private static String Input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;

    }

    private static void showStatus() {
        for (int i = 0; i< bookArray.length-1; i++) {
            String status;
            if (borrowedArray[i] == false)
               status  = "inne.";
            else
                status = "utlånad.";


            IO.println("Boken " + bookArray[i].title() + " är " + status);

        }



    }

    private static void searchBook() {

        boolean found = false;
        IO.print("Sök på titel eller författare: ");
        String search = (Input().toLowerCase(Locale.ROOT));

        for (int i = 0; i<bookArray.length; i++){
            if (bookArray[i] != null && bookArray[i].title().toLowerCase(Locale.ROOT).contains(search)
                    || bookArray[i] != null && bookArray[i].author().toLowerCase(Locale.ROOT).contains(search))
            {
                String status;
                if (borrowedArray[i]== false)
                status= " finns inne.";
                else
                    status = " är utlånad.";


                IO.println("Boken " + bookArray[i].title() + " av " + bookArray[i].author() + status);
                found = true;
            }
        }

        if (!found) {
            IO.println("Boken kunde inte hittas.");
        }

    }

    private static void returnBook() {
    }


    private static  void borrowBook(){





 }
    private static void registerMember() {


        for (int i = 0; i < memberArray.length; i++) {
            if (memberArray[i] == null) {
                index = i;
                break;
            }
        }

        IO.print("Förnamn: ");
        String firstName = Input();
        IO.print("Efternamn: ");
        String surName = Input();
        memberArray[index] = new Member(firstName, surName, memberID );
        memberID++;


        IO.println("Du har blivit registrerad " + memberArray[index].getFirstname() + " och ditt medlemsnummer är " +
                memberArray[index].getID() +"." );



    }




    static void addBook() {


        int index = findNull();
       if(index == -1){
           IO.println("Bokhyllan är full");
           return;
       }

        IO.print("Ange titel på boken:  ");
        String title = Input();

        IO.print("Ange författare till boken:  ");
        String author = Input();

        IO.print("Ange utgivningsår för boken:  ");
        int published;

        try {
            published = Integer.parseInt(Input());
        } catch (NumberFormatException e) {
            IO.println("Du måste ange år med siffror.");
            return;
        }

        bookArray[index] = new Book(title, author, published);
            }
            private static int findNull() {

        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i]== null){
                 return i;
                             }



        }

        return -1;
    }

    static void bookShelf( ) {

        bookArray[0] = (new Book("1984", "George Orwell", 1949));
        bookArray[1] = (new Book("Dumskallarnas sammansvärjning", "John Kennedy Toole", 1980));
        bookArray[2] = (new Book("Mörkrets hjärta", "Joseph Conrad", 1899));
        bookArray[3] = (new Book("Röda rummet", "August Strindberg", 1879));
        bookArray[4] = (new Book("Harry Potter och de vises sten", "J.K. Rowling", 1997));
        bookArray[5] = (new Book("Sagan om ringen", "J.R.R.Tolkien", 1954));
        bookArray[6] = (new Book("Portnoys besvär", "Philip Roth", 1969));
        bookArray[7] = (new Book("Brott och straff", "Fjodor Dostojevskij", 1866));
        bookArray[8] = (new Book("Mästaren och Margarita", "Michail Bulgakov", 1967));
        bookArray[9] = (new Book("En julsaga", "Charles Dickens", 1843));

    }




    record Book(String title, String author, int published){}

    }
