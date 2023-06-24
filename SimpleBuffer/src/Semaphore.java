public class Semaphore {

    public int signal = 1 ;

    //getter for signal
    public int getSignal()
    {
        return signal;
    }
    //constructor to take signal
    public Semaphore(int signal)
    {
        this.signal = signal;
    }
    //notifies thread to wake up
    public synchronized void release()
    {
        signal++;
        this.notify();
    }
    //makes a thread wait
    public synchronized void acquire()
    {
        try
        {
            while(signal ==0)
            {
                wait() ;
            }
            signal--;
        }
        catch( InterruptedException e ) { }
    }
}
