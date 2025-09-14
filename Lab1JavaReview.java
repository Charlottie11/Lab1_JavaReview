
import java.util.Random;
import java.util.Scanner;

public class Lab1JavaReview {

    static Scanner scnr = new Scanner(System.in);
    static Random rnd = new Random();

    static int i;
    static int adding;
    static String[] books = new String[5];
    static int[] bookNumber = new int[5];
    static boolean[] isAvailable = new boolean[5];
    static int filledIndex;
    static int bookCount;
    static boolean exists;
    static int newNum;
    static boolean notEmpty;
    static boolean foundNumber;
    static int numBook;
    static int availableBooks = 0;
    static int borrowedBooks = 0;

    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("                (            (     (          (              (        )  ");
        System.out.println("   (            )\\ )         )\\ )  )\\ )   (   )\\ )    (      )\\ )  ( /(  ");
        System.out.println("   )\\   (   (  (()/(    (   (()/( (()/( ( )\\ (()/(    )\\    (()/(  )\\()) ");
        System.out.println(" (((_)  )\\  )\\  /(_))   )\\   /(_)) /(_)))((_) /(_))((((_)(   /(_)) ((_ ) ");
        System.out.println(" )\\___ ((_)((_)(_))  _ ((_) (_))  (_))   ((_)_ (_))   )\\ _ )\\ (_)) __ ((_) ");
        System.out.println("((/ __|\\ \\ / / / __|| | | | | |   |_ _| | _ )| _ \\  (_)_\\(_)| _ \\\\ \\ / / ");
        System.out.println(" | (__  \\ V /  \\__ \\| |_| | | |__  | |  | _ \\|   /   / _ \\  |   /  \\ V /  ");
        System.out.println("  \\___|  \\_/   |___/ \\___/  |____||___| |___/|_|_\\  /_/ \\_\\ |_|_\\   |_|   ");

        while (true) {
            System.out.println("\n");
            System.out.println("================================");
            System.out.println("||  WHAT DO YOU WANT TO DO?   ||");
            System.out.println("||                            ||");
            System.out.println("||  1. ADD BOOK               ||");
            System.out.println("||  2. UPDATE BOOK STATUS     ||");
            System.out.println("||  3. SHOW ALL BOOKS         ||");
            System.out.println("||  4. GENERATE REPORT        ||");
            System.out.println("||  5. EXIT                   ||");
            System.out.println("================================");
            System.out.print("PLEASE ENTER THE NUMBER OF YOUR CHOSEN ACTION: ");
            String chosen = scnr.nextLine();
            try {
                int chosen_action = Integer.parseInt(chosen);
                switch (chosen_action) {
                    case 1:
                        addBook();
                        break;

                    case 2:
                        updateBookStatus();
                        break;

                    case 3:
                        showBooks();
                        break;

                    case 4:
                        generateReport();
                        break;
                    case 5:
                        exitProgram();
                        return;

                    default:
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("!   Invalid Input. Please try again. !");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("!   Invalid Input. Please enter a valid number. !");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }
    }

    public static void addBook() {
        filledIndex = 0;
        while (true) {
            for (i = 0; i < books.length; i++) {
                if (books[i] != null) {
                    filledIndex++;
                }
            }
            if (filledIndex == books.length) {
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("!                 Bookshelf is full.                  !");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

                return;
            }

            System.out.print("\nHow many books would you like to add?(Maximum of 5 books to be stored): ");

            String additional = scnr.nextLine();
            try {
                adding = Integer.parseInt(additional);
                bookCount += adding;

                if (bookCount > books.length) {
                    System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!   You have exceeded the limit for the bookshelf.  !");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                    System.out.println("\nBookshelf Status: " + (bookCount - adding) + "/" + books.length);
                    bookCount -= adding;
                    System.out.println("\n*********************");
                    System.out.println("*  Only " + (books.length - bookCount) + " remaining *");
                    System.out.println("*********************\n");

                    return;
                }
                if (adding > 5 || adding <= 0) {
                    System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!   Invalid Input. Please enter a valid number again.   !");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
                    continue;
                } else {

                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("!   Invalid Input. Please enter a number again. !");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
            }
        }

        System.out.println("\nPlease enter the title of the books you want to add: ");
        for (i = 0; i < adding; i++) {
            for (int j = 0; j < books.length; j++) {
                if (books[j] == null) {
                    System.out.print((i + 1) + ". ");
                    books[j] = scnr.nextLine();
                    do {
                        newNum = rnd.nextInt(999999) + 1;
                        exists = false;

                        for (int k = 0; k < j; k++) {
                            if (bookNumber[k] == newNum) {
                                exists = true;
                                break;
                            }
                        }

                    } while (exists);

                    bookNumber[j] = newNum;
                    isAvailable[j] = true;
                    break;
                }
            }
        }
        System.out.println("\n=================================================================================");
        System.out.println("||  You have succesfully added " + adding + " book/s. Bringing you back to the main menu.   ||");
        System.out.println("=================================================================================\n");

        System.out.println("\n==========================");
        System.out.println("||     Books Stored:    ||");
        System.out.println("==========================\n");

        for (i = 0; i < books.length; i++) {

            if (books[i] != null) {
                System.out.println((i + 1) + ". " + books[i] + " # " + bookNumber[i] + " - " + (isAvailable[i] ? "Available" : "Borrowed"));
                notEmpty = true;
            }
        }
        if (!notEmpty) {
            System.out.println("\n==============================================================");
            System.out.println("||  No books stored yet.\nTaking you back to the main menu. || ");
            System.out.println("==============================================================\n");

        }

    }

    public static void updateBookStatus() {
        while (true) {
            System.out.println("\n==========================");
            System.out.println("||     Books Stored:    ||");
            System.out.println("==========================\n");
            for (i = 0; i < books.length; i++) {

                if (books[i] != null) {
                    System.out.println((i + 1) + ". " + books[i] + " #" + bookNumber[i] + " - " + (isAvailable[i] ? "Available" : "Borrowed"));
                    notEmpty = true;
                }
            }
            System.out.println("\n6. BACK");
            if (!notEmpty) {
                System.out.println("\n==============================================================");
                System.out.println("||  No books stored yet. Taking you back to the main menu.  ||");
                System.out.println("==============================================================\n");
                return;
            }
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("\nPlease enter the book number you want to update(type 6 to go back to the main menu): #");
            String bookId = scnr.nextLine();
            try {
                int bookIdinput = Integer.parseInt(bookId);
                int foundIndex = -1;
                foundNumber = false;
                for (i = 0; i < bookNumber.length; i++) {
                    if (bookNumber[i] == bookIdinput) {
                        foundIndex = i;
                        foundNumber = true;
                        while (true) {

                            if (isAvailable[foundIndex]) {
                                isAvailable[foundIndex] = false;
                                System.out.println("\n========================================================================");

                                System.out.println("\nThe book " + books[foundIndex] + " is now set as Borrowed.\n");
                                System.out.println("========================================================================\n");
                                System.out.println("\n==========================");
                                System.out.println("||     Books Stored:    ||");
                                System.out.println("==========================\n");

                                for (i = 0; i < books.length; i++) {

                                    if (books[i] != null) {
                                        System.out.println((i + 1) + ". " + books[i] + " # " + bookNumber[i] + " - " + (isAvailable[i] ? "Available" : "Borrowed"));

                                    }
                                }
                                if (!notEmpty) {
                                    System.out.println("\n==============================================================");
                                    System.out.println("||  No books stored yet.\nTaking you back to the main menu. ||");
                                    System.out.println("==============================================================\n");
                                    return;
                                }
                                return;
                            } else if (!isAvailable[foundIndex]) {
                                isAvailable[foundIndex] = true;
                                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                System.out.println("  The book " + books[foundIndex] + " is now Available.");
                                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                System.out.println("\n==========================");
                                System.out.println("||     Books Stored:    ||");
                                System.out.println("==========================\n");

                                for (i = 0; i < books.length; i++) {

                                    if (books[i] != null) {
                                        System.out.println((i + 1) + ". " + books[i] + " # " + bookNumber[i] + " - " + (isAvailable[i] ? "Available" : "Borrowed"));

                                    }
                                }
                                if (!notEmpty) {
                                    System.out.println("\n==============================================================");
                                    System.out.println("||  No books stored yet.\nTaking you back to the main menu. ||");
                                    System.out.println("==============================================================\n");
                                    return;
                                }
                                return;
                            }

                        }

                    }

                }
                if (bookIdinput == 6) {
                    System.out.println("\nTaking you back to the main menu\n");
                    return;
                }
                if (!foundNumber) {
                    System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!    Sorry the book number you have inputted does not match any book in our record. !");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

                }

            } catch (NumberFormatException e) {
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("!   Invalid Input. Please enter a valid number again.   !");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

            }
        }
    }

    public static void showBooks() {
        System.out.println("\n==========================");
        System.out.println("||     Books Stored:    ||");
        System.out.println("==========================\n");

        for (i = 0; i < books.length; i++) {

            if (books[i] != null) {
                System.out.println((i + 1) + ". " + books[i] + " # " + bookNumber[i] + " - " + (isAvailable[i] ? "Available" : "Borrowed"));
                notEmpty = true;

            }
        }
        if (!notEmpty) {
            System.out.println("\n==============================================================");
            System.out.println("||  No books stored yet. Taking you back to the main menu.   ||");
            System.out.println("==============================================================\n");

        }
    }

    public static void generateReport() {
        availableBooks = 0;
        borrowedBooks = 0;
        numBook = 0;
        for (i = 0; i < books.length; i++) {

            if (books[i] != null) {
                numBook++;
                notEmpty = true;
                if (isAvailable[i]) {
                    availableBooks++;
                } else {
                    borrowedBooks++;
                }
            }
        }
        if (notEmpty) {
            System.out.println("\n=====================================");
            System.out.println("\nTotal number of books registered: " + numBook);
            System.out.println("\nTotal number of books Available: " + availableBooks);
            System.out.println("\nTotal number of books Borrowed: " + borrowedBooks);
            System.out.println("\n=====================================");
        }

        if (!notEmpty) {
            System.out.println("\n==================================================================");
            System.out.println("||  No books registered yet. Taking you back to the main menu.  ||");
            System.out.println("==================================================================\n");

        }
    }

    public static void exitProgram() {
        System.out.println("\nThank you for using the program. See you once again.\n");
    }
}
