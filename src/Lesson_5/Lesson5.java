package Lesson_5;

import java.util.Arrays;

public class Lesson5 {

    public static void main(String[] args){
        final int size = 10000000;
        SimpleWorker sw = new SimpleWorker(size);
        sw.work();
        sw.info();
        //System.out.println(Arrays.toString(sw.getArr()));

        try {
            ThreadableWorker tw = new ThreadableWorker(size, 16);
            tw.work();
            tw.info();
            //System.out.println(Arrays.toString(tw.getArr()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
