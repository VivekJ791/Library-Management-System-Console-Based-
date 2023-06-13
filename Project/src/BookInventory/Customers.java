package BookInventory;

// Java Program to Illustrate Customers Class
// To Do all the Operations related to Customers:
// add Customers,check-in books,check out books,ValidStudent

// Importing required classes
import java.util.Scanner;

// Class
public class Customers {

    // Creating objects of Scanner and Customers class
    Scanner input = new Scanner(System.in);
    Customer theCustomers[] = new Customer[50];

    public static int count = 0;

    // Method 1
    // To add books
    public void addStudent(Customer s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(
                    theCustomers[i].regNum)) {

                // Print statement
                System.out.println(
                        "Student of Reg Num " + s.regNum
                                + " is Already Registered.");

                return;
            }
        }

        if (count <= 50) {
            theCustomers[count] = s;
            count++;
        }
    }

    // Method 2
    // Displaying all Customers
    public void showAllCustomers()
    {
        // Printing student name and
        // corresponding registered number
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {

            System.out.println(theCustomers[i].studentName
                    + "\t\t"
                    + theCustomers[i].regNum);
        }
    }

    // Method 3
    // To check the Student
    public int isStudent()
    {
        // Display message only
        System.out.println("Enter Reg Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (theCustomers[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }

        // Print statements
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    // Method 4
    // To remove the book
    public void checkOutBook(books book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");

            book.showAllBooks();
            book b = book.checkOutBook();

            System.out.println("checking out");
            if (b != null) {

                if (theCustomers[studentIndex].booksCount
                        <= 3) {

                    System.out.println("adding book");
                    theCustomers[studentIndex].borrowedBooks
                            [theCustomers[studentIndex]
                            .booksCount]
                            = b;
                    theCustomers[studentIndex].booksCount++;

                    return;
                }
                else {

                    System.out.println(
                            "Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    // Method 5
    // To add the book
    public void checkInBook(books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {

            // Printing credentials corresponding to student
            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");

            Customer s = theCustomers[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {

                System.out.println(
                        s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }

            // Display message only
            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");

            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo
                    + "not Found");
        }
    }
}

