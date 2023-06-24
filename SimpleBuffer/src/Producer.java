import javax.swing.*;

public class Producer extends Thread{

    public int limit;
    int counter=0;
    buffer buffer;
    JLabel jLabel1, jLabel2;
    public Producer(buffer buff, int l, JLabel j,JLabel f)
    {
        limit = l;
        buffer = buff;
        jLabel1 = j;
        jLabel2 = f;
    }

    @Override
    public void run()
    {

        //algorithm to find prime numbers till N
        boolean prime[] = new boolean[limit+1];

        for(int i=0;i<=limit;i++)
        {
            prime[i] = true;
        }
        for(int p = 2; p*p <=limit; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= limit; i += p)
                {
                    prime[i] = false;
                }

            }
        }
        //checks if number is prime or not if prime then make it produce and checks the largest number and
        //increases the counter for prime numbers
        for(int i = 2; i <= limit; i++)
        {
            if(prime[i] == true)
            {
                buffer.produce(i);
                buffer.largest=i;
                counter++;
                jLabel1.setText(String.valueOf(buffer.largest));
                jLabel2.setText(String.valueOf(counter));
            }
        }
        buffer.flag = false;

    }

}
