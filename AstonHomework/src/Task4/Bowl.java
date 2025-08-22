package Task4;

public class Bowl {
	    private int foodAmount;
	    
	    public Bowl(int initialFood) {
	        this.foodAmount = Math.max(initialFood, 0);
	    }
	    
	    public boolean decreaseFood(int amount) {
	        if (amount <= foodAmount) {
	            foodAmount -= amount;
	            return true;
	        }
	        return false;
	    }
	    
	    public void addFood(int amount) {
	        if (amount > 0) {
	            foodAmount += amount;
	            System.out.println("Добавлено " + amount + " еды в миску. Теперь в миске: " + foodAmount);
	        }
	    }
	    
	    public int getFoodAmount() {
	        return foodAmount;
	    }
}
