import Task3.Park;
import Task3.Product;

public class Main {
	

	public static void main(String[] args) {
		//Task3_2
		System.out.println("Задание 3_2\nСоздание списка продуктов\n");
		Product[] products = new Product[5];

		products[0] = new Product("KitKat", "01.01.2023", 
	                                      "CandyGroup", "Russia", 200, true);
	        
		products[1] = new Product("Mars", "05.08.2024", 
	                                      "CandyGroup", "Belarus", 150, false);
	        
		products[2] = new Product("Bounty", "10.12.2024", 
	                                      "CandyGroup", "China", 350, true);
	        
		products[3] = new Product("Snikers", "12.12.2022", 
	                                      "CandyGroup", "USA", 150, false);
	        
		products[4] = new Product("Skettles", "08.05.2025", 
	                                      "CandyGroup", "Russia", 210, true);

		System.out.println("Список товаров:");
		for (int i = 0; i < products.length; i++) {
	        System.out.println("__ Информация о товаре " + (i+1) +" __");
			products[i].printInfo();
		}
		
		
		
		//Task3_3
		System.out.println("\nЗадание 3_3\nСоздание парка атрикционов\n");
        Park.Attraction[] attractions = new Park.Attraction[3];
        
        Park centralPark = new Park("Детский центральный парк", null);
        
        attractions[0] = centralPark.new Attraction("Ракушки", "10:00-20:00", 500);
        attractions[1] = centralPark.new Attraction("Качели", "09:00-22:00", 300);
        attractions[2] = centralPark.new Attraction("Горки", "10:00-18:00", 150);

        centralPark.attractions = attractions;
        centralPark.printParkInfo();
	}

}
