package functionalInterfacesAndStreams;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.w3c.dom.NamedNodeMap;

import javafx.beans.NamedArg;

public class StreamsExercise {
	
	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 50);
		
		//cursos.forEach(c ->  System.out.println(c.getNome()));
		//streamDeCurso.forEach(c -> System.out.println(c.getNome()));
		System.out.println("========================");
		//filter recebe um predicado (critério) que deve devolver verdadeiro ou falso.
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.forEach(c -> System.out.println(c.getNome()));
		System.out.println("========================");
		//usando map, devolve stream de Integer
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.map(Curso::getAlunos)
			.forEach(System.out::println);
		System.out.println("========================");
		//usando o map com primitivos e somando resultado
		int soma = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.mapToInt(Curso::getAlunos)
				.sum();
		
		System.out.println("Soma: " + soma);
		System.out.println("========================");
		//Optional e findAny
		Optional<Curso> optional = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.findAny();
		
		//Curso curso = optional.get();
		//Curso curso = optional.orElse(null);
		//System.out.println("findAny: " + curso.getNome());
		
		//usando ifPresent
		optional.ifPresent(c -> System.out.println(c.getNome()));
		System.out.println("========================");
		//ifPresent sem a variavel curso
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.findAny()
			.ifPresent(c -> System.out.println(c.getNome()));
		System.out.println("========================");
		//Obtendo uma colecao apos alterar um Stream com  o metodo Collect
		List<Curso> resultados = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.collect(Collectors.toList());
		
		//usando a mesma variavel List>Cursos> cursos que ja temos
		cursos = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.collect(Collectors.toList());
		
		//Usando um mapa
		Map mapa = cursos
				.stream()
				.filter(c -> c.getAlunos() > 50)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		System.out.println(mapa.toString());
		
		System.out.println("========================");
		
		
		
		
		
		
		
		
		
		

		
	}

}
