package Lesson_5;

public abstract class AbstractWorker {
    protected int size;
    protected float[] arr;
    protected long start;
    protected long end;

    public AbstractWorker(int size){
        this.size=size;
        arr = new float[size];
        for(int i=0;i<arr.length;i++) {
            arr[i] = 1;
        }
    }

    public abstract void work();

    public abstract void info();

    protected float calc(float a,int i){
        return (float)(a * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    public float[] getArr(){
        return this.arr;
    }
}
