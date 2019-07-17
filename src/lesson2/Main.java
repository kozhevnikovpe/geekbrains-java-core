package lesson2;

public class Main {

    public static void main(String[] args) {
        /*
        1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
         */
        String[][] matrix = {{"1","0","3","4","="},{"5","6","7","8"},{"9","8","7","6"},{"5","4","3","2"}};
        try{
            System.out.println(matrixSum(matrix));
        }catch(MyArraySizeException e){
            e.printStackTrace();
        }catch(MyArrayDataException e){
            e.printStackTrace();
        }

        /*
        Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
        С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заднному текущему дню.

         Возвращает кол-во оставшихся рабочих часов до конца
         недели по заданному текущему дню. Считается, что
         текущий день ещё не начался, и рабочие часы за него
         должны учитываться.
         */
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
    }

    static int matrixSum(String[][] matrix){
        int result=0;
        if(matrix.length!=4)
            throw new MyArraySizeException("Размер массива неверен");
        for(int i=0;i<matrix.length;i++) {
            if(matrix[i].length!=4)
                throw new MyArraySizeException("Размер массива неверен");
            for (int j = 0; j < matrix.length; j++) {
                try {
                    result += Integer.parseInt(matrix[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException("Недопустимый тип данных в ячейке ("+i+","+j+")");
                }
            }
        }
        return result;
    }

    enum DayOfWeek{
        MONDAY(true,8), TUESDAY(true,8),WEDNSDAY(true,8),THURSDAY(true,8),FRIDAY(true,8),SATURDAY(false,0),SUNDAY(false,0);

        private boolean isWorkDay;
        private int workingHours;
        DayOfWeek(boolean isWorkDay, int workingHours){
            this.isWorkDay = isWorkDay;
            this.workingHours = workingHours;
        }
    }

    public static int getWorkingHours(DayOfWeek day){
        int result =0;
        for (DayOfWeek d:DayOfWeek.values()){
            if(d.isWorkDay && d.ordinal()>=day.ordinal())
                result+=d.workingHours;
        }
        return result;
    }
}
