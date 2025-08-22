package Task4;

public	class Animal {
	    private String name;
	    protected static int animalCount = 0;
	    
	    public Animal(String name) {
	        this.setName(name);
	        animalCount++;
	    }
	    
	    public void run(int distance) {
	        System.out.println(getName() + " бежит " + distance + " м.");
	    }
	    
	    public void swim(int distance) {
	        System.out.println(getName() + " плывет " + distance + " м.");
	    }
	    
	    public static int getAnimalCount() {
	        return animalCount;
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
