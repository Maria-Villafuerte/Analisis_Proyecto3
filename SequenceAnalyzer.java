import java.util.*;

/**
 * Analizador para encontrar secuencias óptimas y peores casos
 */
class SequenceAnalyzer {
  // Variables de instancia para el análisis
  private List<Integer> initialList;  // Lista inicial para el análisis
  private int listSize;              // Tamaño de la lista
  
  /**
   * Constructor del analizador
   * Propósito: Inicializar el analizador con una lista base para análisis
   */
  public SequenceAnalyzer(List<Integer> initialList) {
    this.initialList = new ArrayList<>(initialList); // Crear copia de la lista inicial
    this.listSize = initialList.size(); // Almacenar el tamaño de la lista
  }
  
  /**
   * Propósito: Encontrar la secuencia que produce el menor costo posible en MTF
   * Genera una secuencia óptima que minimiza el costo total de accesos
   * Retorna: Mapa con la secuencia óptima y su costo
   */
  public Map<String, Object> findMinimumCostSequence(int length) {
    // Generar secuencia óptima (acceso repetido al primer elemento)
    List<Integer> optimalSequence = new ArrayList<>();
      for (int i = 0; i < length; i++) {
          optimalSequence.add(initialList.get(0));
    }
    // Ejecutar MTF con la secuencia generada

    MTFAlgorithm mtf = new MTFAlgorithm(initialList);
        Map<String, Object> result = mtf.processSequence(optimalSequence);
        
    // Calcular y retornar resultado del análisis
    Map<String, Object> analysisResult = new HashMap<>();
    analysisResult.put("sequence", optimalSequence);
    analysisResult.put("cost", result.get("totalCost"));
    
    return analysisResult;
  }
  
  /**
   * Propósito: Encontrar la secuencia que produce el mayor costo posible en MTF
   * Genera una secuencia que maximiza el costo forzando reorganizaciones constantes
   * Retorna: Mapa con la secuencia del peor caso y su costo
   */
  public Map<String, Object> findWorstCaseSequence(int length) {
    // Generar secuencia del peor caso (patrón de acceso en orden reverso)
    List<Integer> worstSequence = new ArrayList<>();
    for (int i = 0; i < length; i++) {
          // Crear patrón reverso: 4,3,2,1,0,4,3,2,1,0...
          int index = (listSize - 1) - (i % listSize);
          worstSequence.add(initialList.get(index));
    }
    // Ejecutar MTF con la secuencia generada
            
    MTFAlgorithm mtf = new MTFAlgorithm(initialList);
    Map<String, Object> result = mtf.processSequence(worstSequence);
    
    // Calcular y retornar resultado del análisis
    Map<String, Object> analysisResult = new HashMap<>();
    analysisResult.put("sequence", worstSequence);
    analysisResult.put("cost", result.get("totalCost"));
      
    return analysisResult;
  }
  
  /**
   * Propósito: Analizar el comportamiento cuando se repite un elemento específico
   * Estudia cómo afecta la repetición de un elemento al costo total
   * Retorna: Mapa con la secuencia de repetición y su costo
   */
  public Map<String, Object> analyzeRepetitionPattern(int element, int repetitions) {
    // Generar secuencia con repeticiones del elemento especificado
    List<Integer> sequence = new ArrayList<>();
    for (int i = 0; i < repetitions; i++) {
        sequence.add(element);
    }
    // Ejecutar MTF con la secuencia generada
    MTFAlgorithm mtf = new MTFAlgorithm(initialList);
    Map<String, Object> result = mtf.processSequence(sequence);
      
    // Calcular y retornar resultado del análisis de repetición
    Map<String, Object> analysisResult = new HashMap<>();
    analysisResult.put("sequence", sequence);
    analysisResult.put("cost", result.get("totalCost"));
    
    return analysisResult;
  }
}