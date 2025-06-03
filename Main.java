import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<Integer> initialList = Arrays.asList(0, 1, 2, 3, 4);
    System.out.println("=".repeat(80));
    System.out.println("PROYECTO MTF/IMTF - ANÁLISIS Y DISEÑO DE ALGORITMOS");
    System.out.println("=".repeat(80));
    
    // Caso 1
    System.out.println("\n1. CASO 1 - MTF con secuencia: 0,1,2,3,4,0,1,2,3,4,0,1,2,3,4,0,1,2,3,4");
    List<Integer> sequence1 = Arrays.asList(0,1,2,3,4,0,1,2,3,4,0,1,2,3,4,0,1,2,3,4);
    MTFAlgorithm mtf1 = new MTFAlgorithm(initialList);
    Map<String, Object> result1 = mtf1.processSequence(sequence1);
    
    // Caso 2
    System.out.println("\n2. CASO 2 - MTF con secuencia: 4,3,2,1,0,1,2,3,4,3,2,1,0,1,2,3,4");
    List<Integer> sequence2 = Arrays.asList(4,3,2,1,0,1,2,3,4,3,2,1,0,1,2,3,4);
    MTFAlgorithm mtf2 = new MTFAlgorithm(initialList);
    Map<String, Object> result2 = mtf2.processSequence(sequence2);

    // Caso 3
    System.out.println("\n3. CASO 3 - Secuencia de 20 elementos con MÍNIMO costo");
    SequenceAnalyzer analyzer = new SequenceAnalyzer(initialList);
    Map<String, Object> minResult = analyzer.findMinimumCostSequence(20);
    System.out.println("Secuencia óptima: " + minResult.get("sequence"));
    System.out.println("Costo mínimo: " + minResult.get("cost"));
    
    // Caso 4
    System.out.println("\n4. CASO 4 - Secuencia de 20 elementos con MÁXIMO costo (peor caso)");
    Map<String, Object> worstResult = analyzer.findWorstCaseSequence(20);
    System.out.println("Secuencia peor caso: " + worstResult.get("sequence"));
    System.out.println("Costo máximo: " + worstResult.get("cost"));
    
    // Caso 5
    System.out.println("\n5. CASO 5 - Análisis de repeticiones");
    System.out.println("\n5a. Secuencia de 20 elementos '2':");
    Map<String, Object> rep2Result = analyzer.analyzeRepetitionPattern(2, 20);
    
    System.out.println("\n5b. Secuencia de 20 elementos '3':");
    Map<String, Object> rep3Result = analyzer.analyzeRepetitionPattern(3, 20);
    
    System.out.println("\nPatrón observado:");
    System.out.println("- 20 repeticiones de '2': costo = " + rep2Result.get("cost"));
    System.out.println("- 20 repeticiones de '3': costo = " + rep3Result.get("cost"));

  }
}
