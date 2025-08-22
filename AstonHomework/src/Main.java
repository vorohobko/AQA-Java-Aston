import Task4.Bowl;
import Task4.Dog;
import Task4.Cat;
import Task4.Animal;
import Task4.Circle;
import Task4.Rectangle;
import Task4.Triangle;

public class Main {

	public static void main(String[] args) {
		//Task4_1 и 4_2
		Dog dog = new Dog("Чип");
        Cat cat = new Cat("Снежка");
        
        dog.run(150);
        dog.run(600);
        dog.swim(5);
        dog.swim(15);
        
        cat.run(100);
        cat.run(250);
        cat.swim(10);
        
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
        
        // Кормим котов
        Bowl bowl = new Bowl(30);
        Cat[] cats = {
            new Cat("Алиска"),
            new Cat("Карамелька"),
            new Cat("Зефирка")
        };
        
        System.out.println("\n--- Кормление котов ---");
        for (Cat c : cats) {
            c.eatFromBowl(bowl, 15);
        }
        
        System.out.println("\n--- Состояние сытости ---");
        for (Cat c : cats) {
            System.out.println(c.getName() + ": " + (c.isFull() ? "сыта" : "голодна"));
        }
        
        System.out.println("Остаток еды в миске: " + bowl.getFoodAmount());
        
        // Добавляем еду и кормим снова
        bowl.addFood(20);
        cats[2].eatFromBowl(bowl, 15);
        
        
        System.out.println("\n\n\n__ ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ __");
        
        // Создаем фигуры
        Circle circle = new Circle(5);
        circle.setFillColor("красный");
        circle.setBorderColor("золотой");
        
        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.setFillColor("синий");
        rectangle.setBorderColor("белый");
        
        Triangle triangle = new Triangle(3, 4, 5);
        triangle.setFillColor("зеленый");
        triangle.setBorderColor("черный");
        
        // Выводим информацию о фигурах
        System.out.println("\n__ Круг __");
        circle.printInfo();
        
        System.out.println("\n__ Прямоугольник __");
        rectangle.printInfo();
        
        System.out.println("\n__ Треугольник __");
        triangle.printInfo();
        
        // Дополнительные фигуры
        System.out.println("\n__ Дополнительные фигуры __");
        
        System.out.println("\n__ Маленький круг __");
        Circle smallCircle = new Circle(2.5);
        smallCircle.setFillColor("желтый");
        smallCircle.setBorderColor("оранжевый");
        smallCircle.printInfo();
        
        System.out.println("\n__ Квадрат __");
        Rectangle square = new Rectangle(5, 5);
        square.setFillColor("фиолетовый");
        square.setBorderColor("серебряный");
        square.printInfo();
	}
	
}
