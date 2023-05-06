import java.time.LocalDate;

// Abstract Pet class
abstract class Pet {
    private String name;
    private LocalDate birthdate;
    private double price;
    private String speciesType;

    // Constructor
    public Pet(String name, LocalDate birthdate, double price, String speciesType) {
        this.name = name;
        this.birthdate = birthdate;
        this.price = price;
        this.speciesType = speciesType;
    }

    // Accessor and mutator methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getBirthdate() { return birthdate; }
    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getSpeciesType() { return speciesType; }
    public void setSpeciesType(String speciesType) { this.speciesType = speciesType; }

    // Abstract method to get special feature (to be implemented in subclasses)
    public abstract String getSpecialFeature();

    // toString method
    public String toString() {
        return "Name: " + name + ", Birthdate: " + birthdate + ", Price: " + price + ", Species Type: " + speciesType;
    }
}

// Subclass for Dogs & Cats
class DogCat extends Pet {
    private String breed; // Special feature

    public DogCat(String name, LocalDate birthdate, double price, String speciesType, String breed) {
        super(name, birthdate, price, speciesType);
        this.breed = breed;
    }

    public String getSpecialFeature() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    @Override
    public String toString() {
        return super.toString() + ", Breed: " + breed;
    }
}

// Subclass for Reptiles
class Reptile extends Pet {
    private String bloodType; // Special feature

    public Reptile(String name, LocalDate birthdate, double price, String speciesType, String bloodType) {
        super(name, birthdate, price, speciesType);
        this.bloodType = bloodType;
    }

    public String getSpecialFeature() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    @Override
    public String toString() {
        return super.toString() + ", Blood Type: " + bloodType;
    }
}

// Subclass for Birds
class Bird extends Pet {
    private String movementType; // Special feature

    public Bird(String name, LocalDate birthdate, double price, String speciesType, String movementType) {
        super(name, birthdate, price, speciesType);
        this.movementType = movementType;
    }

    public String getSpecialFeature() { return movementType; }
    public void setMovementType(String movementType) { this.movementType = movementType; }

    @Override
    public String toString() {
        return super.toString() + ", Movement Type: " + movementType;
    }
}

// Subclass for Rabbits & Small Animals
class RabbitSmallAnimal extends Pet {
    private boolean itBites; // Special feature

    public RabbitSmallAnimal(String name, LocalDate birthdate, double price, String speciesType,boolean itBites) {
		super(name, birthdate, price, speciesType);
		this.itBites = itBites;
		}
		public String getSpecialFeature() { return itBites ? "yes" : "no"; }
		public void setItBites(boolean itBites) { this.itBites = itBites; }
		
		@Override
		public String toString() {
			return super.toString() + ", It Bites: " + getSpecialFeature();
		}
	}		