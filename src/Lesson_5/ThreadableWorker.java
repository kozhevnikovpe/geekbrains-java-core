package Lesson_5;

public class ThreadableWorker extends AbstractWorker {

    private int threads;
    protected long arraycopy1;
    protected long arraycopy2;
    protected float[][] arrs;

    public ThreadableWorker(int size, int threads) throws Exception {
        super(size);
        if(size%threads>0)
            throw new Exception("Невозможно разбить массив на такое количество потоков");
        this.threads = threads;
        arrs = new float[threads][size/threads];
    }

    @Override
    public void work() {
        start = System.currentTimeMillis();

        for(int i=0;i<threads;i++)
            System.arraycopy(arr, i*arrs[i].length, arrs[i], 0, arrs[i].length);
        arraycopy1 = System.currentTimeMillis();

        for(int j=0;j<threads;j++){
            float[] a = arrs[j];
            int position = j*a.length;
            new Thread(() -> {
                for(int i=0;i<a.length;i++) {
                    a[i] = calc(a[i],i+position);
                }
            }).run();
        }
        end = System.currentTimeMillis();

        for(int i=0;i<threads;i++)
            System.arraycopy(arrs[i], 0, arr, i*arrs[i].length, arrs[i].length);
        arraycopy2 = System.currentTimeMillis();
    }

    @Override
    public void info() {
        System.out.println(this.getClass()+" выполнил всю работу за "+(arraycopy2-start)+"мс");
        System.out.println("из них на разбивку массива ушло "+(arraycopy1-start)+"мс");
        System.out.println("из них на полезную работу ушло "+(end-arraycopy1)+"мс");
        System.out.println("из них на склейку массива ушло "+(arraycopy2-end)+"мс");
    }
}
