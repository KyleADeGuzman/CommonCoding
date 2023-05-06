//Stephen Colandro
import java.time.LocalDate;

public abstract class Pet {
	    private String name;
	    private LocalDate birthdate;
	    private double price;
	    private String speciesType;
	    private String specialFeature;
	    private Boolean specialFeatureBoolean;
	    
	    public Pet(String name, LocalDate birthdate, double price, String speciesType, String specialFeature) {
	        this.name = name;
	        this.birthdate = birthdate;
	        this.price = price;
	        this.speciesType = speciesType;
	        this.specialFeature = specialFeature;
	    }
	    
	    public Pet(String name, LocalDate birthdate, double price, String speciesType, boolean specialFeatureBoolean) {
	    	this.name = name;
	        this.birthdate = birthdate;
	        this.price = price;
	        this.speciesType = speciesType;
	        this.specialFeatureBoolean = specialFeatureBoolean;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public LocalDate getBirthdate() {
	        return birthdate;
	    }
	    
	    public void setBirthdate(LocalDate birthdate) {
	        this.birthdate = birthdate;
	    }
	    
	    public double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    public String getSpeciesType() {
	        return speciesType;
	    }
	    
	    public void setSpeciesType(String speciesType) {
	        this.speciesType = speciesType;
	    }
	    
	    public String getSpecialFeature() {
	        return specialFeature;
	    }
	    
	    public void setSpecialFeature(String specialFeature) {
	        this.specialFeature = specialFeature;
	    }
	    
	    public boolean getSpecialFeatureBoolean() {
	        return specialFeatureBoolean;
	    }
	    
	    public void setSpecialFeatureBoolean(boolean specialFeatureBoolean) {
	        this.specialFeatureBoolean = specialFeatureBoolean;
	    }
	    
	    public String toString() {
	        return name + " (" + speciesType + ")" + "\n" +
	               "Birthdate: " + birthdate + "\n" +
	               "Price: $" + price + "\n" +
	               "Special Feature: " + specialFeature + "\n";
	    }
	 
}