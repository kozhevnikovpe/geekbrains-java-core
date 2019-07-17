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
}
