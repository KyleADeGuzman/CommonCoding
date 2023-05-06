//Stephen Colandro
import java.util.Arrays;

public class MyPetStore {
	    private Pet[] pets;

	    public MyPetStore() {
	        this.pets = new Pet[0];
	    }

	    public void readInputFile(String fileName) {
	        
	    }

	    public void sortPetsByPrice() {
	        Arrays.sort(pets);
	    }

	    public void printReport() {
	        int pageSize = 40;
	        int pageCount = (int) Math.ceil((double) pets.length / pageSize);
	        
	        for (int i = 0; i < pageCount; i++) {
	            int startIndex = i * pageSize;
	            int endIndex = Math.min(startIndex + pageSize, pets.length);
	            Pet[] pagePets = Arrays.copyOfRange(pets, startIndex, endIndex);              
	        }
	    }

	    public static void main(String[] args) {
	        MyPetStore store = new MyPetStore();
	        store.readInputFile("input-2.txt");
	        store.sortPetsByPrice();
	        store.printReport();
	    }
	}
