//Stephen Colandro
import java.time.LocalDate;

public class Cats extends Pet {
    private String breed;

    public Cats(String name, LocalDate birthdate, double price, String speciesType, String breed) {
        super(name, birthdate, price, speciesType, "Cat");
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String toString() {
        return super.toString() + ", breed: " + breed;
    }
}