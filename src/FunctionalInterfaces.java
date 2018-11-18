import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		//Functional interfaces
				//Functions
				Map<String, Integer> nameMap = new HashMap<>();
				nameMap.put("Diego", 5);
				nameMap.put("Adriana", 7);
				Integer value = nameMap.computeIfAbsent("John", String::length);
				System.out.println(value);
				nameMap.forEach((k,v) -> {
					System.out.println("Key: " + k + "\nValue: " + v);
					if(k.equals("Diego")) {
						System.out.println("----");
						System.out.println("Hello Diego");
					}
				});
				
				System.out.println("========================");
				
				Function<Integer, String> intToString = Object::toString;
				System.out.println(intToString.apply(5));
				
				Function<String, String> quote = s -> "'" + s + "'";
				
				Function<Integer, String> quoteIntToString = quote.compose(intToString);
				
				System.out.println(quoteIntToString.apply(5));
				
				System.out.println("========================");
				
				//BiFunction
				Map<String, Integer> salaries = new HashMap<>();
				salaries.put("Adriana", 50000);
				salaries.put("Diego", 40000);
				salaries.put("Josefina", 30000);
				
				salaries.replaceAll((name, oldValue) -> 
						name.equals("Adriana") ? oldValue : oldValue + 10000);
				
				salaries.forEach((k,v) -> System.out.println("Nome: " + k + "\n" + "Salario: " + v));
				
				
	}

}
