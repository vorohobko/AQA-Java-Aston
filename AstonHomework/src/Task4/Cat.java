package Task4;

public class Cat extends Animal {
	    private static int catCount = 0;
	    private final int MAX_RUN_DISTANCE = 200;
	    private boolean isFull;
	    
	    public Cat(String name) {
	        super(name);
	        this.isFull = false;
	        catCount++;
	    }
	    
	    @Override
	    public void run(int distance) {
	        if (distance <= MAX_RUN_DISTANCE) {
	            System.out.println(getName() + " пробежала " + distance + " м.");
	        } else {
	            System.out.println(getName() + " не пробежала " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
	        }
	    }
	    
	    @Override
	    public void swim(int distance) {
	        System.out.println(getName() + " не умеет плавать!");
	    }
	    
	    public void eatFromBowl(Bowl bowl, int amount) {
	        if (bowl.decreaseFood(amount)) {
	            this.isFull = true;
	            System.out.println(getName() + " поела и теперь сыта.");
	        } else {
	            System.out.println(getName() + " не ела. В миске недостаточно еды.");
	        }
	    }
	    
	    public boolean isFull() {
	        return isFull;
	    }
	    
	    public static int getCatCount() {
	        return catCount;
	    }
}
