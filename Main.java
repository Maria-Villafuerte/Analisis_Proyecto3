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
      }
}
