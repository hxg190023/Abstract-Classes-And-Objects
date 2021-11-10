/*
Name & NET-ID:      Harsh Gopalan - HXG190023
Class & Section:    CS 2336. 005
Assignment:         Assignment 3
Start / End Date:   9/25/2021 - 9/29/2021
Purpose:            Writing this program for this class to complete Assignment 3.

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

public class Triangle extends GeometricObject implements Comparable<Triangle>
{
    // Can be accessed in this class
    private double[] sideLengthArray = new double[3];

    // The no argument constructor
    public Triangle()
    {
        // Sets each side length to 1
        this.sideLengthArray[0] = 1.00;
        this.sideLengthArray[1] = 1.00;
        this.sideLengthArray[2] = 1.00;

        // Sets color to 1
        super.setColor(1);

    } // end of public Triangle()

    // The argument constructor
    public Triangle(double sideLength1, double sideLength2, double sideLength3, int color)
    {
        // Sets each side length to what the user entered
        this.sideLengthArray[0] = sideLength1;
        this.sideLengthArray[1] = sideLength2;
        this.sideLengthArray[2] = sideLength3;

        // Sets the color to what the user entered
        super.setColor(color);

    } // end of public Triangle(double sideLength1, double sideLength2, double sideLength3, int color)

    // The compareTo interface is implemented
    public int compareTo(Triangle t)
    {
        // If area is greater, returns 1
        if (getArea() > t.getArea())
        {
            return 1;
        }
        // If area is less, returns -1
        else if (getArea() < t.getArea())
        {
            return -1;
        }
        // Else returns 0 if both are the same
        else
        {
            return 0;
        }

    } // end of compareTo(Triangle t)

    public String getType()
    {
        // Used to calculate if a right triangle
        // Initialized to 0
        double hypotenuse = 0;

        // If all sides are the same, will return "Equilateral Triangle"
        if ( (sideLengthArray[0] == sideLengthArray[1]) && (sideLengthArray[1] == sideLengthArray[2]) )
        {
            return "Equilateral Triangle";
        }
        // If exactly two sides are the same,  will return "Isosceles Triangle"
        else if ( (sideLengthArray[0] == sideLengthArray[1]) || (sideLengthArray[1] == sideLengthArray[2]) ||
                (sideLengthArray[2] == sideLengthArray[0]) )
        {
            return "Isosceles Triangle";
        }
        else
        {
            // Three conditions possible to see if the triangle is a right triangle.
            // It will check if any of these are valid and if so, print that it is a right triangle
            // If side a > side b && side a > side c
            if (sideLengthArray[0] > sideLengthArray[1] && sideLengthArray[0] > sideLengthArray[2])
            {
                // hypotenuse is side a
                hypotenuse = sideLengthArray[0];

                // Will check if a^2 =  b^2 + c^2
                // If it is, then will return right triangle
                if (hypotenuse * hypotenuse == (sideLengthArray[1] * sideLengthArray[1] + sideLengthArray[2] * sideLengthArray[2]))
                {
                    return "Right Triangle";
                }
            }
            // If side b > side a && side b > side c
            else if (sideLengthArray[1] > sideLengthArray[0] && sideLengthArray[1] > sideLengthArray[2])
            {
                // hypotenuse is side b
                hypotenuse = sideLengthArray[1];

                // Will check if b^2 =  a^2 + c^2
                // If it is, then will return right triangle
                if (hypotenuse * hypotenuse == (sideLengthArray[0] * sideLengthArray[0] + sideLengthArray[2] * sideLengthArray[2]))
                {
                    return "Right Triangle";
                }
            }
            // If side c > side a && side c > side b
            else if (sideLengthArray[2] > sideLengthArray[0] && sideLengthArray[2] > sideLengthArray[1])
            {
                // hypotenuse is side c
                hypotenuse = sideLengthArray[2];

                // Will check if c^2 =  a^2 + b^2
                // If it is, then will return right triangle
                if (hypotenuse * hypotenuse == (sideLengthArray[0] * sideLengthArray[0] + sideLengthArray[1] * sideLengthArray[1]))
                {
                    return "Right Triangle";
                }
            }
        }

        // Else will return scalene triangle
        return "Scalene Triangle";

    } // end of getType()

    // Will calculate the perimeter
    @Override
    public double getPerimeter()
    {
        // returns the perimeter
        return sideLengthArray[0] + sideLengthArray[1] + sideLengthArray[2];
    } // end of getPerimeter()

    // Will calculate the area using heron's formula
    @Override
    public double getArea()
    {
        // Perimeter gets halved
        double perimeter = getPerimeter() / 2.0;

        // Area is calculated
        double area = Math.sqrt(perimeter * (perimeter - sideLengthArray[0]) * (perimeter - sideLengthArray[1]) *
                (perimeter - sideLengthArray[2]));

        // Returns the area
        return area;

    } // end of getArea()

    // The toString method
    // Formatted to having 30 spaces between each columns
    public String toString()
    {
        // Initializing an empty string to use to concatenate the string
        String empty = "";

        String side1 = (String.format("%.2f %-5s", sideLengthArray[0], empty));
        String side2 = (String.format("%.2f %-5s", sideLengthArray[1], empty));
        String side3 = (String.format("%.2f %-5s", sideLengthArray[2], empty));
        String area = (String.format("%.2f %-5s", getArea(), empty));
        String color = (String.format("%-5s", getColor()));
        String type = (String.format("%-10s", getType()));
        String date = (String.format("%-10s", dateCreated.toString()));

        // Will print if triangle area is less than 0
        if (getArea() <= 0)
        {
            area = "Invalid Triangle";
            type = "Invalid Triangle";
        }

        // Will be used to loop through and return the final output for each triangle
        String[] stringArray = {side1, side2, side3, area, color, type, date};

        int minLength = 30; // Used to format the columns by 30 spaces

        // Loops through and prints each character in the 1D array,
        // making sure that the columns are formatted
        for (int i = 0; i < stringArray.length; i++)
        {
            while (stringArray[i].length() < minLength)
            {
                stringArray[i] += " ";
            }
        }

        // Will return the final outputs when called by main
        return  "Side Length 1: " + stringArray[0]
                + "Side Length 2: " + stringArray[1]
                + "Side Length 3: " + stringArray[2]
                + "Area: " + stringArray[3] + "Color: " + stringArray[4]
                + "Type: " + stringArray[5] + "Date Created: " + stringArray[6];
    }

} // end of class Triangle extends GeometricObject implements Comparable<Triangle>