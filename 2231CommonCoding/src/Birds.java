//Stephen Colandro
import java.time.LocalDate;

public class Birds extends Pet {
    private String movementType;
    
    public Birds(String name, LocalDate birthdate, double price, String speciesType, String movementType) {
        super(name, birthdate, price, speciesType, movementType);
        this.movementType = movementType;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }
    
    public String toString() {
        return super.toString() + " Movement Type: " + movementType;
    }
}
