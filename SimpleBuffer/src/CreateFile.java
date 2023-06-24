import java.io.File;
import java.io.IOException;

public class CreateFile
{
    //function to creat a file
    public void createfiles(String z)
    {
        try
        {
            File myObj = new File(z);

            if (myObj.createNewFile())
            {
                System.out.println("File created: " + myObj.getName());
            } else
            {
                System.out.println("File already exists.");
            }
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
