import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nui
{

    private JButton Produce;
    private JPanel panelMain;
    private JFormattedTextField BufferSize;
    private JFormattedTextField FileName;
    private JFormattedTextField Limiter;
    private JLabel Largest;
    private JLabel Counter;
    private JLabel Time;

    static buffer s;

    //Gui Setter
    public nui()
    {
        Produce.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
                {

                    String fileName = FileName.getText();
                    int n = Integer.parseInt(Limiter.getText());
                    int b = Integer.parseInt(BufferSize.getText());
                    s = new buffer(b);
                    CreateFile k = new CreateFile();
                    k.createfiles(fileName);
                    s.TIME_1 = System.currentTimeMillis();

                    Producer thread1 = new Producer(s,n,Largest,Counter);
                    Consumer thread2 = new Consumer(s,fileName,Time);

                    //starts the threads
                    thread1.start();
                    thread2.start();


                 }
            }
        );
    }

    //main
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Prime Number Manager");
        frame.setContentPane(new nui().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}