/*
Name:               Harsh Gopalan

Assignment:         Abstract Classes and Objects

General Description of Program:
    This program will instantiate my subclass and test it by creating a GeometricObject Class
    and deriving this class to create the Triangle Class.

    My main class, public class CS2336Asg3_HXG190023, will test my GeometricObject class and its subclass.
    The main class will first allocate an array for a maximum of 100 triangles. After getting the three
    side lengths and the color of the said triangle, it will run input validation on each of these values. The
    first set of input validation is to make sure that each side length value is a valid number, and that second
    set of input validation is to make sure that the three side lengths obtained can actually form a triangle.
    If both these are met, the side lengths and the color will be sent to one of two constructors. If the entered
    side lengths are all 0, then the program will send it to the no argument constructor. Else, the program will send
    it to the argument constructor. Once this has been done, the program will increment the triangle count by 1, and
    the menu will be displayed again for the user to choose one of the four options.
    The main class will take no more than 100 triangles as input data.
    If the user selects menu choice 2, the program will print the required 7 columns, for the triangles,
    from smallest to largest area using the Arrays.sort static method, as required by instructions.
    If the user selects menu choice 3, the program will print the required 7 columns, for the triangle color value
    that the user enters. This will not be printed from smallest to largest area, as this is not required on the
    instructions.
    If the user selects menu choice 4, the program will let the user know that it will exit.

    Notes about the program:
        - The column widths are set to max of 30 spaces, so if the user side lengths exceed this,
          then the columns will not be aligned.
          As stated by the instructions, "Reasonable columns for the inputs is 8 to 10 spaces",
          so mine should work correctly.
 */

package CS2336Asg3_HXG190023;

import java.util.Arrays;
import java.util.Scanner;

/*
Main class.
 */
public class CS2336Asg3_HXG190023
{
    /*
    Main Method.
     */
    public static void main (String []args)
    {
        int numOfTriangles = 0; // Initialized to 0, stores the triangle count

        // The 100 triangle array is created
        Triangle[] triangleArray = new Triangle[100];

        // Opening statements printed
        System.out.println("Welcome to \"Assignment 3 - Classes and Objects!\"");
        System.out.println("");
        // Will run until the user enters menu choice 4
        do
        {
            // The menu choices are printed
            System.out.println("The menu choices are: \n" +
                    "1. Enter data for a new triangle \n" +
                    "2. Print all triangles sorted by area, smallest to largest \n" +
                    "3. Please enter a color value \n" +
                    "4. Exit the program");
            System.out.println("");

            int menuChoice = 0; // Initialized to 0

            System.out.print("Please enter a menu choice: ");
            Scanner scan = new Scanner(System.in);

            // New object 'validateInput' created to check for input validation for the side length's and color values
            CS2336Asg3_HXG190023 validateInput = new CS2336Asg3_HXG190023();

            // The menu choice post inputValidation
            menuChoice = validateInput.menuChoiceValidation(scan, menuChoice);

            // New object 'createTriangle' to send to the respective constructors
            CS2336Asg3_HXG190023 createTriangle = new CS2336Asg3_HXG190023();

            // New object 'printSortedTriangles' to call the printTriangles and the printColorTriangles method
            CS2336Asg3_HXG190023 printSortedTriangles = new CS2336Asg3_HXG190023();

            switch (menuChoice)
            {
                case 1:
                    System.out.println("");

                    System.out.print("Enter side length 1: ");
                    double sideLength1 = scan.nextDouble();

                    // sideLength1 post inputValidation
                    sideLength1 = validateInput.sideLengthValidation(scan, sideLength1);

                    System.out.print("Enter side length 2: ");
                    double sideLength2 = scan.nextDouble();

                    // sideLength2 post inputValidation
                    sideLength2 = validateInput.sideLengthValidation(scan, sideLength2);

                    System.out.print("Enter side length 3: ");
                    double sideLength3 = scan.nextDouble();

                    // sideLength3 post inputValidation
                    sideLength3 = validateInput.sideLengthValidation(scan, sideLength3);

                    System.out.print("Enter a color value: ");
                    int color = scan.nextInt();

                    // color value post inputValidation
                    color = validateInput.colorValidation(scan, color);

                    // Input validation on any set of side length values that do not form a valid triangle
                    // Will loop until a valid triangle can be created
                    while (sideLength1 + sideLength2 <= sideLength3 || sideLength1 + sideLength3 <= sideLength2
                            || sideLength2 + sideLength3 <= sideLength1)
                    {
                        System.out.println("Invalid Triangle Side Lengths. Triangle cannot be created.");
                        System.out.println("Please enter valid Triangle Side Lengths.");

                        System.out.print("Enter side length 1: ");
                        sideLength1 = scan.nextDouble();

                        // sideLength1 post inputValidation
                        sideLength1 = validateInput.sideLengthValidation(scan, sideLength1);

                        System.out.print("Enter side length 2: ");
                        sideLength2 = scan.nextDouble();

                        // sideLength2 post inputValidation
                        sideLength2 = validateInput.sideLengthValidation(scan, sideLength2);

                        System.out.print("Enter side length 3: ");
                        sideLength3 = scan.nextDouble();

                        // sideLength3 post inputValidation
                        sideLength3 = validateInput.sideLengthValidation(scan, sideLength3);
                    }

                    // Makes sure that the number of triangles that are created is <= 100
                    if (numOfTriangles <= 100)
                    {
                        // Will call this method to create a new Triangle
                        triangleArray[numOfTriangles] = createTriangle.newTriangle(sideLength1, sideLength2, sideLength3, color);

                        // Incrementing the triangle count to add a new triangle
                        numOfTriangles++;
                    }

                    System.out.println("");

                    break;

                case 2:
                    System.out.println("");

                    System.out.println("The sorted triangles from smallest area to largest area: ");

                    // Will call the method printTriangles to print the sorted triangles by area
                    printSortedTriangles.printTriangles(triangleArray, numOfTriangles);

                    System.out.println("");
                    break;

                case 3:
                    System.out.println("");

                    System.out.print("Please enter a color value: ");
                    int newColorValue = scan.nextInt(); // The user's colorValue choice will now be stored in newColorValue

                    // Input validation for the newColorValue that the user wants to print
                    newColorValue = validateInput.colorValidation(scan, newColorValue);

                    // Calls the printColorTriangles method to print the triangles that correspond with the user's color value choice (stored in newColorValue)
                    printSortedTriangles.printColorTriangles(triangleArray, numOfTriangles, newColorValue);

                    System.out.println("");
                    break;

                case 4:
                    System.out.println("");

                    // Program will exit
                    System.out.println("The program will now exit! Goodbye!");
                    return;
            }

        } while (true);

    } // end of main (String []args)

    /*
    This method will do inputValidation on the user's menu choice.
    It will return the user's menu choice value in the variable 'menuChoice'
     */
    public int menuChoiceValidation(Scanner scan, int menuChoice)
    {
        // Reads in the menuChoice
        menuChoice = scan.nextInt();

        // Makes sure that it is between 1 and 4
        while(menuChoice < 1 || menuChoice > 4)
        {
            System.out.println("Please only enter a valid menu choice.");
            menuChoice = scan.nextInt();
        }

        // Returns menuChoice
        return menuChoice;
    } // end of menuChoiceValidation(Scanner scan, int menuChoice)

    /*
    This method will do inputValidation on the user's side lengths.
    It will return the user's color value in the variable 'color.'
     */
    public double sideLengthValidation(Scanner scan, double sideLength)
    {
        // Makes sure that side lengths are not negative
        while(sideLength < 0)
        {
            System.out.println("Please only enter a positive side length.");
            sideLength = scan.nextInt();
        }

        // Returns side length
        return sideLength;
    } // end of sideLengthValidation(Scanner scan, double sideLength)

    /*
    This method will do inputValidation on the user's color choice.
    It will return the user's color value in the variable 'color.'
     */
    public int colorValidation(Scanner scan, int color)
    {
        // Makes sure that the user's choice stays within these limits
        while(color < 1 || color > 7)
        {
            System.out.println("Please only enter valid color value: ");
            color = scan.nextInt();
        }

        // Will return back to main method
        return color;
    } // end of colorValidation(Scanner scan, int color)

    /*
    This method will be called by main, and it will pass the triangle to its respective
    constructor. The method will return 'triangle', which represents the object of the current triangle.
     */
    public Triangle newTriangle(double sideLength1, double sideLength2,
                               double sideLength3, int color)
    {
        // Creating the object of the triangle
        Triangle triangle;

        // Will send to the no argument constructor all side lengths are 0.
        if (sideLength1 == 0 && sideLength2 == 0 && sideLength3 == 0)
        {
            triangle = new Triangle();

            // The color is set to 1
            triangle.setColor(1);
        }
        else
        {
            /*
            The following if statements make sure that even if one or two of the side lengths are
            0, then it will get set to 1 and be sent to the argument constructor.
             */
            if (sideLength1 == 0)
            {
                sideLength1 = sideLength1 + 1;
            }
            if (sideLength2 == 0)
            {
                sideLength2 = sideLength2 + 1;
            }
            if (sideLength3 == 0)
            {
                sideLength3 = sideLength3 + 1;
            }

            // Gets passed to the argument constructor
            triangle = new Triangle(sideLength1, sideLength2, sideLength3, color);

            // The color is set to the user's color value
            triangle.setColor(color);
        }

        // Will return back to main method
        return triangle;
    } // end of newTriangle(double sideLength1, double sideLength2, double sideLength3, int color)

    /*
    This method will be called by the main method (if user selects menu choice 2) to
    print the triangles from smallest to largest area.
    This method's inputs include the triangleArray[] and the numOfTriangles count.
     */
    public void printTriangles(Triangle triangleArray[], int numOfTriangles)
    {
        /*
        A new array is created of size numOfTriangles to make sure array does not have
        any null entries.
         */
        Triangle[] newTriangleArray = new Triangle[numOfTriangles];

        // Copies the contents of the triangleArray to the newTriangleArray
        for (int i = 0; i < numOfTriangles; i++)
        {
            newTriangleArray[i] = triangleArray[i];
        }

        // The array is sorted using the Arrays.sort static method as told by the instructions.
        java.util.Arrays.sort(newTriangleArray);

        /*
        Loops through the array and prints the triangles from smallest to largest area.
         */
        for (Triangle triangle: newTriangleArray)
        {
            System.out.print(triangle + " ");
            System.out.println();
            System.out.println();
        }
    } // end of printTriangles(Triangle triangleArray[], int numOfTriangles)

    /*
    This method will be called by the main method (if user selects menu choice 3) to
    print the triangles based on the user's color value of choice.
    This method's inputs include the triangleArray[], the numOfTriangles count, and the colorValue the user
    specifies.
     */
    public void printColorTriangles(Triangle triangleArray[], int numOfTriangles, int newColorValue)
    {
        /*
        A new array is created of size numOfTriangles to make sure array does not have
        any null entries.
         */
        Triangle[] newTriangleArray = new Triangle[numOfTriangles];

        // Copies the contents of the triangleArray to the newTriangleArray
        for (int i = 0; i < numOfTriangles; i++)
        {
            newTriangleArray[i] = triangleArray[i];
        }

        /*
        Loops through the array and prints only the triangles that correspond with
        the user's color value choice.
         */
        for (int i = 0; i < numOfTriangles; i++)
        {
            if (newTriangleArray[i].getColor() == newColorValue)
            {
                System.out.println(newTriangleArray[i] + " ");
                System.out.println();
                System.out.println();
            }
        }
    } // end of printColorTriangles(Triangle triangleArray[], int numOfTriangles, int newColorValue)

} // end of class CS2336Asg3_HXG190023
