package Task3;

public class Product {
	 private String name;
	    private String productionDate;
	    private String manufacturer;
	    private String countryOfOrigin;
	    private double price;
	    private boolean isReserved;

	    // Конструктор класса
	    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
	        this.name = name;
	        this.productionDate = productionDate;
	        this.manufacturer = manufacturer;
	        this.countryOfOrigin = countryOfOrigin;
	        this.price = price;
	        this.isReserved = isReserved;
	    }

	    // Метод для вывода информации об объекте
	    public void printInfo() {
	        System.out.println("Название: " + name);
	        System.out.println("Дата производства: " + productionDate);
	        System.out.println("Производитель: " + manufacturer);
	        System.out.println("Страна происхождения: " + countryOfOrigin);
	        System.out.println("Цена: " + price + " руб.");
	        System.out.println("Состояние бронирования: " + (isReserved ? "Забронирован" : "Не забронирован"));
	        System.out.println("______________________________________");
	    }
}
