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

    // Caso 6 - Casos adicionales para demostrar IMTF
    System.out.println("\n6. CASO 6 - Algoritmo IMTF vs MTF en diferentes escenarios");
    
    System.out.println("\n6a. IMTF en secuencia de mínimo costo MTF:");
    IMTFAlgorithm imtfMin = new IMTFAlgorithm(initialList);
    @SuppressWarnings("unchecked")
    List<Integer> minSequence = (List<Integer>) minResult.get("sequence");
    Map<String, Object> imtfMinResult = imtfMin.processSequence(minSequence);
    
    System.out.println("\n6b. IMTF en secuencia de máximo costo MTF:");
    IMTFAlgorithm imtfWorst = new IMTFAlgorithm(initialList);
    @SuppressWarnings("unchecked")
    List<Integer> worstSequence = (List<Integer>) worstResult.get("sequence");
    Map<String, Object> imtfWorstResult = imtfWorst.processSequence(worstSequence);
    
    // Caso adicional: secuencia mixta para mostrar ventajas de IMTF
    System.out.println("\n6c. IMTF en secuencia mixta (donde IMTF puede mostrar ventajas):");
    List<Integer> mixedSequence = Arrays.asList(2, 1, 3, 2, 0, 4, 1, 2, 3, 0, 1, 4, 2, 3, 1, 0, 4, 2, 1, 3);
    
    System.out.println("MTF en secuencia mixta:");
    MTFAlgorithm mtfMixed = new MTFAlgorithm(initialList);
    Map<String, Object> mtfMixedResult = mtfMixed.processSequence(mixedSequence);
    
    System.out.println("IMTF en secuencia mixta:");
    IMTFAlgorithm imtfMixed = new IMTFAlgorithm(initialList);
    Map<String, Object> imtfMixedResult = imtfMixed.processSequence(mixedSequence);

    
    // Resumen comparativo expandido
    System.out.println("\n" + "=".repeat(80));
    System.out.println("RESUMEN COMPARATIVO COMPLETO");
    System.out.println("=".repeat(80));
    System.out.println("Caso 1 - MTF: " + result1.get("totalCost"));
    System.out.println("Caso 2 - MTF: " + result2.get("totalCost"));
    System.out.println("Caso 3 - Mínimo MTF: " + minResult.get("cost"));
    System.out.println("Caso 4 - Máximo MTF: " + worstResult.get("cost"));
    System.out.println("Caso 5a - 20x'2' MTF: " + rep2Result.get("cost"));
    System.out.println("Caso 5b - 20x'3' MTF: " + rep3Result.get("cost"));
    System.out.println("Caso 6a - IMTF (min seq): " + imtfMinResult.get("totalCost"));
    System.out.println("Caso 6b - IMTF (worst seq): " + imtfWorstResult.get("totalCost"));
    System.out.println("Caso 6c - MTF (mixed seq): " + mtfMixedResult.get("totalCost"));
    System.out.println("Caso 6c - IMTF (mixed seq): " + imtfMixedResult.get("totalCost"));
     

    // Análisis de mejora IMTF vs MTF
    System.out.println("\n" + "=".repeat(80));
    System.out.println("ANÁLISIS DE MEJORA IMTF vs MTF");
    System.out.println("=".repeat(80));
    
    int mtfMinCost = (Integer) minResult.get("cost");
    int imtfMinCost = (Integer) imtfMinResult.get("totalCost");
    double improvementMin = ((double)(mtfMinCost - imtfMinCost) / mtfMinCost) * 100;
    
    int mtfWorstCost = (Integer) worstResult.get("cost");
    int imtfWorstCost = (Integer) imtfWorstResult.get("totalCost");
    double improvementWorst = ((double)(mtfWorstCost - imtfWorstCost) / mtfWorstCost) * 100;
    
    int mtfMixedCost = (Integer) mtfMixedResult.get("totalCost");
    int imtfMixedCost = (Integer) imtfMixedResult.get("totalCost");
    double improvementMixed = ((double)(mtfMixedCost - imtfMixedCost) / mtfMixedCost) * 100;
    
    System.out.printf("Mejora IMTF en secuencia mínima: %.2f%%\n", improvementMin);
    System.out.printf("Mejora IMTF en secuencia peor caso: %.2f%%\n", improvementWorst);
    System.out.printf("Mejora IMTF en secuencia mixta: %.2f%%\n", improvementMixed);
    
  }
}
