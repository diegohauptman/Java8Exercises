package builderPattern;

import java.util.function.Consumer;

public class PersonBuilder {

	public String salutation;
    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;
    public Address address;
    public boolean isFemale;
    public boolean isEmployed;
    public boolean isHomewOwner;
    
    public PersonBuilder with(Consumer<PersonBuilder> builderFunction) {
    	builderFunction.accept(this);
		return this;
    	
    }
    
    public Person createPerson() {
		return new Person(salutation, firstName, middleName,
				lastName, suffix, address, isFemale, 
				isEmployed, isHomewOwner);
    	
    }
    
    public static void main(String[] args) {
		Person person = new PersonBuilder()
				.with(personBuilder -> {
					personBuilder.firstName = "Diego";
					personBuilder.isEmployed = true;
					personBuilder.lastName = "Hauptman";
					personBuilder.salutation = "Mr.";
					
				}).createPerson();
		
		System.out.println(person.toString());
		
	}
	
}
