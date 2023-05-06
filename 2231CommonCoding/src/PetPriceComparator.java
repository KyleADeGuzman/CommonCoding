//Stephen Colandro
import java.util.Comparator;

public class PetPriceComparator implements Comparator<Pet> {

    public int compare(Pet pet1, Pet pet2) {
        if (pet1.getPrice() < pet2.getPrice()) {
            return -1;
        } 
        
        else if (pet1.getPrice() > pet2.getPrice()) {
            return 1;
        } 
        
        else {
            return 0;
        }
    }
    
}