
public class Main {

	public static void main(String[] args) {
		Task2 task2 = new Task2();
		
		System.out.println("\n № 1 :");
		task2.printThreeWords();
		System.out.println("\n № 2 :");
		task2.checkSumSign();
		System.out.println("\n № 3 :");
		task2.printColor();
		System.out.println("\n № 4 :");
		task2.compareNumbers();
		System.out.println("\n № 5 :");
		System.out.println(task2.twoNum(2, 2));
		System.out.println("\n № 6 :");
		task2.posNum(5);
		System.out.println("\n № 7 :");
		System.out.println(task2.negNum(7));
		System.out.println("\n № 8 :");
		task2.printStr("JAVA", 4);
		System.out.println("\n № 9 :");
		System.out.println(task2.checkYear(2025));
		System.out.println("\n № 10 :");
		int[] myArr = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        task2.convArr(myArr);
        //printArray(myArr);
		System.out.println("\n № 11 :");
		task2.emptyArr();
		System.out.println("\n № 12 :");
		task2.uderSix();
		System.out.println("\n № 13 :");
		task2.squareArr(5);
		System.out.println("\n № 14 :");
		task2.initArr(20, 2);
	}

}
