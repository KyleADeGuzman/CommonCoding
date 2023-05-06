//Stephen Colandro
import java.time.LocalDate;

public class Reptiles extends Pet {
    private String bloodType;
    
    public Reptiles(String name, LocalDate birthdate, double price, String speciesType, String bloodType) {
        super(name, birthdate, price, speciesType, bloodType);
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
   
    public String toString() {
        return super.toString() + " Blood Type: " + bloodType;
    }
}