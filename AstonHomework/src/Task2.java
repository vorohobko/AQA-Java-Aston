

public class Task2{

	
	//1
	public void printThreeWords() {
		//String name;
		System.out.println(" Orange \n Banana \n Apple");
	}
	
	//2
	public void checkSumSign() {
		int a = 14, b = 2, sum = a + b;
		
		if (sum >= 0) {
			System.out.println("Сумма чисел положительная");
		} else
			System.out.println("Сумма чисел отрицательная");
	}
	
	//3
	public void printColor() {
		int value = 2;
		
		if (value <= 0) {
			System.out.println("Красный");
		} else if (value <= 100) {
			System.out.println("Жёлтый");
	} else {
		System.out.println("Зелёный");
	}}
	
	//4
	public void compareNumbers() {
		int a = 1, b = 4;
		
		if (a >= b) {
			System.out.println("a >= b");
		} else {
			System.out.println("a < b");
		}
	}
	
	//5
	public boolean twoNum(int a, int b) {
		int sum = a + b;
        return sum >= 10 && sum <= 20;
	}
	
	//6
	public void posNum(int a) {
		
		if (a >= 0 ) {
			System.out.println("Число положительное");
		} else {
			System.out.println("Число отрицательное");
		}
	}
	
	//7
	public boolean negNum(int a) {
		return a < 0;
	}
	
	//8
	public void printStr(String str, int a) {
		for (int i = 0; i < a; i++) {
			System.out.println(str);
		}
	}
	
	//9
	public boolean checkYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				return year % 400 == 0;
			} else {
				return true;
			}
		} else {
		return false;
		}
	}
	
	//10
	public void convArr(int [] myArr) {
		for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myArr[i] ^ 1;
        }
		
		for (int num : myArr) {
            System.out.print(num + " ");
        }
		System.out.println("");
	}
	
	//11
	public void emptyArr() {
		int [] myArr = new int [100];
		
		for (int i = 0; i < myArr.length; i++) {
			myArr [i] = i + 1;
			System.out.print(myArr[i] + " ");
		}
		System.out.println("");
	}
	
	//12
	public void uderSix() {
		int [] myArr =  { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
		
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] < 6) {
				myArr[i] = myArr[i] * 2;
			} 
			System.out.print(myArr[i] + " ");
		}
		System.out.println("");
	}
	
	//13
	public void squareArr(int len) {
		int [][] squareArr = new int [len][len];
		
		for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
            	if (i == j || i == len - j - 1) {
            		squareArr [i][j] = 1;
            	}
            	else {
                squareArr[i][j] = 0; 
            }
            }
        }

        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(squareArr[i][j] + " ");
            }
            System.out.println();
        	}
        }
	
	//14
	public void initArr(int len, int initialValue) {
		int [] arr = new int[len];
		
		for(int i = 0; i < len; i++) {
			arr[i] = initialValue;
			System.out.print(arr[i] + " ");
		}
	}
	
}
