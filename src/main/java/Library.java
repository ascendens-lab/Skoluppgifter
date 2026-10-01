import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Library {
    private static Scanner scanner = new Scanner(System.in);
    private static Book[] bookArray = new Book[10];
    private static boolean[] borrowedArray = new boolean[10];
   private static Member[] memberArray = new Member[10];
   private static int[] borrowerArray = new int[10];


   private static int memberID = 1;
   private static int index =0;
   private static int i;
   private static int borrowIndex;

    static void main(){



        bookShelf();

        String input;
        do{
            IO.println("====================");
            IO.println("Bibliotekshanteraren");
            IO.println("====================");
            IO.println("1. Lägg till bok");
            IO.println("2. Registrera medlem");
            IO.println("3. Låna bok");
            IO.println("4. Lämna tillbaka bok");
            IO.println("5. Sök bok (titel eller författare)");
            IO.println("6. Visa alla böcker och status");
            IO.println("e. Avslut");

            input = scanner.nextLine();

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

        } while (true);

        }

    private static String input() {

        return scanner.nextLine();

    }

    private static void showStatus() {
        for (int i = 0; i< bookArray.length; i++) {
            if (bookArray[i] == null) {
                break;
            }
            String status;
            if (borrowedArray[i] == false) {
                status = "inne.";
                IO.println("Boken " + bookArray[i].title() + " är " + status);
            }
            else if (borrowedArray[i] == true) {
                status = "utlånad.";

                for (int memberIndex = 0; memberIndex < memberArray.length; memberIndex++) {
                    if (memberArray[memberIndex] != null &&
                            memberArray[memberIndex].getID() == borrowerArray[i]) {

                        IO.println("Boken " + bookArray[i].title()
                                + " är utlånad till " + memberArray[memberIndex].getFirstname() + " " + memberArray[memberIndex].getSurname());
                    }
                }
            }
        }



    }

    private static void searchBook() {
        int foundCount=0;
        boolean found = false;
        IO.print("Sök på titel eller författare: ");
        String search = (input().toLowerCase(Locale.ROOT));

        for (i = 0; i<bookArray.length; i++){
            if (bookArray[i] != null && bookArray[i].title().toLowerCase(Locale.ROOT).contains(search)
                    || bookArray[i] != null && bookArray[i].author().toLowerCase(Locale.ROOT).contains(search))
            {
                String status;
                if (borrowedArray[i]== false){
                status= " finns inne.";
                }
                else
                    status = " är utlånad.";

                foundCount++;


                    IO.println(i + ": " + "Boken " + bookArray[i].title() + " av " + bookArray[i].author() + status);
                borrowIndex= i;



                    found = true;
            }
        }

        if (!found) {
            IO.println("Boken kunde inte hittas.");
        }

    }

    private static void returnBook() {

        boolean found = false;
        IO.print("Titel på boken du vill lämna tillbaka: ");
        String search = (input().toLowerCase(Locale.ROOT));

        for (i = 0; i<bookArray.length; i++){
            if (bookArray[i] != null && bookArray[i].title().toLowerCase(Locale.ROOT).contains(search))
            {

                if (borrowedArray[i]) {
                    borrowedArray[i] = false;
                    IO.println(bookArray[i].title() + " är registrerad som återlämnad.");
                }
                else
                     IO.println(bookArray[i].title() + " är inte utlånad.");

                found = true;
                break;

            }
        }

        if (!found) {
            IO.println("Boken kunde inte hittas.");
        }

    }


    private static  void borrowBook(){
        searchBook();


           IO.println("Vill du låna boken, tryck j, vill du inte, tryck n.");



           switch ((input())){

               case "j", "J" -> borrowedArray[borrowIndex] = true;

               case "n", "N" -> IO.println("Boken lånas inte.");

                   default -> IO.println("Ogiltigt val, välj j eller n.");
           }

           if(borrowedArray[borrowIndex]) {
               boolean tryAgain = true;
               while (tryAgain) {
                   IO.println("Ange medlemsnummer: ");

                   try {
                       int memberID = scanner.nextInt();

                       if (memberID > index +1|| memberID < 1) {
                           IO.print("Ogiltigt medlemsnummer. Ange ditt medlemsnummer");


                           }
                       else {
                           borrowerArray[borrowIndex] = memberID;
                           tryAgain = false;
                       }
                   } catch (InputMismatchException e) {
                       scanner.nextLine();
                       IO.print("Felaktigt medlemsnummer, försök igen.");
                   }

               }




           }
 }
    private static void registerMember() {


        for (int i = 0; i < memberArray.length; i++) {
            if (memberArray[i] == null) {
                index = i;
                break;
            }
        }

        IO.print("Förnamn: ");
        String firstName = input();
        IO.print("Efternamn: ");
        String surName = input();
        memberArray[index] = new Member(firstName, surName, memberID);
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
        String title = input();

        IO.print("Ange författare till boken:  ");
        String author = input();

        IO.print("Ange utgivningsår för boken:  ");
        int published;

        try {
            published = Integer.parseInt(input());
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


    }

    record Book(String title, String author, int published){}

    }
