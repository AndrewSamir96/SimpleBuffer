import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Consumer extends Thread
{
    long time3;
    String temp ="";
    buffer buffer;
    String filename;
    JLabel jLabel;

    //constructor to input filename and buffer
    public Consumer(buffer buff,String z, JLabel l)
    {
        filename = z;
        buffer = buff;
        jLabel = l;
    }

    //consumer thread that consumes the number from the queue and calculates the time for each consume
    //making it update in real time
    //and appends the values to a file on the divide
    @Override
    public void run ()
    {
        //handling to see if queue is empty or not
        while (buffer.flag || buffer.elements.getSignal() > 0)
        {
            temp = temp + buffer.consume();
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
                writer.append("\"" + temp + "\"" + "," + ' ');
                writer.close();
            }
            catch (IOException e){}
            temp = "";
            buffer.TIME_2 = System.currentTimeMillis();
            time3 = buffer.TIME_2 - buffer.TIME_1;
            jLabel.setText(String.valueOf(time3));
        }
    }

}
