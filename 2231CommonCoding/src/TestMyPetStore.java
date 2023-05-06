//Stephen Colandro
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestMyPetStore {
    
    private static final int PETS_PER_PAGE = 40;
    
    public static void main(String[] args) {
        // Read input file and create Pet objects
        ArrayList<Pet> pets = readInputFile("input-2.txt");
        
        // Sort pets by price
        Collections.sort(pets, new PetPriceComparator());
        
        // Print report
        printReport(pets);
    }
    
    private static boolean getSpecialFeatureBoolean(String specialFeature) {
        return specialFeature.equalsIgnoreCase("Yes");
    }
    
    private static ArrayList<Pet> readInputFile(String filename) {
        ArrayList<Pet> pets = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            int numPets = scanner.nextInt();
            scanner.nextLine(); 
            
            for (int i = 0; i < numPets; i++) {
                String name = scanner.nextLine();
                LocalDate birthdate = LocalDate.parse(scanner.nextLine());
                double price = scanner.nextDouble();
                scanner.nextLine(); 
                String species = scanner.nextLine();
                String specialFeature = scanner.nextLine();
                
                if (species.equals("Dog")) {
                    pets.add(new Dogs(name, birthdate, price, species, specialFeature));
                } 
                
                else if (species.equals("Cat")) {
                    pets.add(new Cats(name, birthdate, price, species, specialFeature));
                } 
                
                else if (species.equals("Reptile")) {
                    pets.add(new Reptiles(name, birthdate, price, species, specialFeature));
                } 
                
                else if (species.equals("Bird")) {
                    pets.add(new Birds(name, birthdate, price, species, specialFeature));
                } 
                
                else if (species.equals("Rabbit")) {
                	boolean itBites = getSpecialFeatureBoolean(specialFeature);
                    pets.add(new Rabbits(name, birthdate, price, species, itBites));
                } 
                
                else if (species.equals("Small Animal")) {
                	boolean itBites = getSpecialFeatureBoolean(specialFeature);;
                    pets.add(new SmallAnimals(name, birthdate, price, species, itBites));
                } 
                
                else {
                    throw new IllegalArgumentException("Invalid species: " + species);
                }
            }
        }
        
        //Catches
        catch (FileNotFoundException e) {
            System.err.println("Error: input file not found");
        } 
        
        catch (DateTimeParseException | NumberFormatException e) {
            System.err.println("Error: invalid input values in input file");
        }

        //Check if specialFeature is empty and set to "N/A" if it is
        for (Pet pet : pets) {
            if (pet.getSpecialFeature().isEmpty()) {
                pet.setSpecialFeature("N/A");
            }
        }
        
        return pets;
    }
    
    private static void printReport(ArrayList<Pet> pets) {
        int numPages = (int) Math.ceil((double) pets.size() / PETS_PER_PAGE);
        
        for (int pageNum = 1; pageNum <= numPages; pageNum++) {
            //Print report header
            System.out.println("MyPetStore Report - Page " + pageNum);
            System.out.printf("%-20s%-15s%-10s%-20s%s%n",
                    "Name", "Birthdate", "Price", "Type", "Special Feature");
            System.out.println("-------------------------------------------------------------");
            
            //Print pets for this page
            int startIndex = (pageNum - 1) * PETS_PER_PAGE;
            int endIndex = Math.min(startIndex + PETS_PER_PAGE, pets.size());
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println(pets.get(i));
            }
            
            //Print page footer
            System.out.println("-------------------------------------------------------------");
            System.out.printf("Page %d of %d%n%n", pageNum, numPages);
        }
    }
    
}
