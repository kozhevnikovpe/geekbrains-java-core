package Lesson_5;

public class SimpleWorker extends AbstractWorker {

    public SimpleWorker(int size) {
        super(size);
    }

    @Override
    public void work() {
        start = System.currentTimeMillis();
        for(int i=0;i<arr.length;i++) {
            arr[i] = calc(arr[i],i);
        }
        end = System.currentTimeMillis();
    }

    @Override
    public void info() {
        System.out.println(this.getClass()+" выполнил работу за "+(end-start)+"мс");
    }
}
