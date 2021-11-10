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


public abstract class GeometricObject
{
    // Only in this class
    private int color;

    // In all classes
    public java.util.Date dateCreated;

    // Date Created Constructor
    public GeometricObject()
    {
        dateCreated = new java.util.Date();
    }

    // set color with argument
    public void setColor(int color)
    {
        this.color = color;
    }

    // Gets the color with no argument
    public int getColor()
    {
        // returns color
        return color;
    }

    // Abstract Method - getArea()
    public abstract double getArea();

    // Abstract Method - getPerimeter()
    public abstract double getPerimeter();

} // end of class GeometricObject
