public class buffer
{

    int soize;
    Semaphore spaces;
    public int store [] ;
    private  int inptr = 0, outptr = 0;
    boolean flag = true;
    int largest = 0;
    static long TIME_1, TIME_2;
    Semaphore elements = new Semaphore(0);

    //constructor initializes buffer size
    public buffer(int size)
    {
        this.soize = size;
        spaces = new Semaphore(soize);
        store = new int[soize];
    }

    //produces the number into the queue and fills space
    public void produce(int value)
    {
        spaces.acquire();
        store[inptr] = value;
        inptr = (inptr + 1) % soize;
        elements.release();
    }
    
    //consumes number from queue and frees space
    public int consume()
    {
        int value;
        elements.acquire();
        value = store[outptr];
        outptr = (outptr + 1) % soize;
        spaces.release();
        return value;
    }
}
