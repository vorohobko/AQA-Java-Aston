import java.util.Arrays;

import Task5.MyArrayDataException;
import Task5.MyArraySizeException;

public class Main {
	//Метод рассчёта суммы элементов массива
    public static int calculateSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть 4х4! Сейчас строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("В строке " + i + " должно быть 4 элемента! В строке: " + array[i].length);
            }
        }
        
        int total = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int number = Integer.parseInt(array[i][j]);
                    total += number;
                } catch (NumberFormatException e) {
                	
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: '" + array[i][j] );
                }
            }
        }
        
        return total;
    }
    
    //Метод дял ArrayIndexOutOfBoundsException
    public static void testArrayBounds() {
        int[] numbers = new int[3]; 
        
        try {
            int value = numbers[5]; 
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс больше, чем нужно");
            System.out.println("Сообщение об ошибке: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ЗАДАНИЕ 1: Правильный массив ===");
        String[][] goodArray = {
            {"1", "1", "1", "1"},
            {"2", "2", "2", "2"},
            {"3", "3", "3", "3"},
            {"4", "4", "4", "4"}
        };
        
        try {
            int sum = calculateSum(goodArray);
            System.out.println("Массив: ");
            System.out.println(" ");
            System.out.println(Arrays.deepToString(goodArray));
            System.out.println("Сумма всех чисел: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
        
        //ЗАДАНИЕ 2
        System.out.println("\n=== ЗАДАНИЕ 2: Массив с буквой ===");
        String[][] badArray = {
        	{"1", "1", "A", "1"},
            {"2", "2", "2", "2"},
            {"3", "3", "3", "3"},
            {"4", "4", "4", "4"}
        };
        
        try {
            int sum = calculateSum(badArray);
            System.out.println("Сумма всех чисел: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
        
        //ЗАДАНИЕ 3
        System.out.println("\n=== ЗАДАНИЕ 3: Массив неправильного размера ===");
        String[][] smallArray = {
            {"1", "1", "1"},
            {"2", "2", "2"},
            {"3", "3", "3"}
        };
        
        try {
            int sum = calculateSum(smallArray);
            System.out.println("Сумма всех чисел: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
        
        //ЗАДАНИЕ 4
        System.out.println("\n=== ЗАДАНИЕ 4: ArrayIndexOutOfBoundsException ===");
        testArrayBounds();
    }
	
}
