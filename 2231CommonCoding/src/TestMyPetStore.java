import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestMyPetStore {
    private static List<Pet> petList = new ArrayList<>(); 

    // Method to read input file and store objects in the list of Pets
    public static void readInputFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int numberOfPets = Integer.parseInt(br.readLine().trim());
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                String name = data[0];
                LocalDate birthdate = LocalDate.parse(data[1], formatter);
                double price = Double.parseDouble(data[2]);
                String speciesType = data[3];
                String specialFeature = data[4];
                Pet pet = null;
                switch (speciesType) {
                    case "Dog":
                    case "Cat":
                        pet = new DogCat(name, birthdate, price, speciesType, specialFeature);
                        break;
                    case "Reptile":
                        pet = new Reptile(name, birthdate, price, speciesType, specialFeature);
                        break;
                    case "Bird":
                        pet = new Bird(name, birthdate, price, speciesType, specialFeature);
                        break;
                    case "Rabbit":
                    case "Small Animal":
                        boolean itBites = specialFeature.equalsIgnoreCase("yes");
                        pet = new RabbitSmallAnimal(name, birthdate, price, speciesType, itBites);
                        break;
                }
                if (pet != null) {
                petList.add(pet); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to sort the list of Pets by price in ascending order
    public static void sortPetsByPrice() {
        petList.sort(Comparator.comparingDouble(Pet::getPrice));
    }

    // Method to format and print the report
    public static void printReport() {
        int petsPerPage = 40;
        int pageNumber = 1;
        int petCounter = 0;
        for (Pet pet : petList) { 
            if (petCounter % petsPerPage == 0) {
                if (petCounter > 0) {
                    System.out.println("End of Page " + pageNumber++);
                }
                System.out.println("Page " + pageNumber);
                System.out.println("-------------------------------------------------");
                System.out.printf("%-20s %-15s %-10s %-15s %-15s%n", "Name", "Birthdate", "Price", "Species", "Feature");
                System.out.println("-------------------------------------------------");
            }
            System.out.printf("%-20s %-15s %-10.2f %-15s %-15s%n", pet.getName(), pet.getBirthdate(), pet.getPrice(), pet.getSpeciesType(), pet.getSpecialFeature());
            petCounter++;
        }
        if (petCounter > 0) {
            System.out.println("End of Page " + pageNumber);
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Read input file and store objects in the list
        readInputFile("input-2.txt"); // Provide the correct path to the

    sortPetsByPrice();

    printReport();
}
}            
