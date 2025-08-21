package Task3;

public class Park {
	private String parkName;
    public Attraction[] attractions;


    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }


        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("______________________________\n");
        }
    }


    public Park(String parkName, Attraction[] attractions) {
        this.parkName = parkName;
        this.attractions = attractions;
    }


    public void printParkInfo() {
        System.out.println("__ Парк: " + parkName + " __");
        System.out.println("Список аттракционов:");
        for (Attraction attraction : attractions) {
            attraction.printAttractionInfo();
        }
    }

}
