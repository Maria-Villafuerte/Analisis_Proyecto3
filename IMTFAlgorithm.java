import java.util.*;

/**
 * Clase para el algoritmo Improved Move-to-Front (IMTF)
 */
class IMTFAlgorithm {
  // Variables de instancia para el estado del algoritmo IMTF
  private List<Integer> initialList;        // Lista inicial de referencia
  private List<Integer> currentList;        // Lista actual con reordenamientos
  private int totalCost;                    // Costo total acumulado
  private List<AccessResult> accessHistory; // Historial de todos los accesos
  
  /**
   * Constructor del algoritmo IMTF
   * Propósito: Inicializar el algoritmo con una lista base
   */
  public IMTFAlgorithm(List<Integer> initialList) {
    this.initialList = new ArrayList<>(initialList); // Crear copia de la lista inicial
    this.accessHistory = new ArrayList<>(); // Inicializar historial de accesos
    reset(); // Llamar a reset para configurar estado inicial
  }
  
  /**
   * Propósito: Reiniciar el algoritmo a su estado inicial
   * Restaura la lista original y limpia todas las estadísticas
   */
  public void reset() {
    this.currentList = new ArrayList<>(initialList); // Restaurar lista a configuración inicial
    this.totalCost = 0; // Reiniciar costo total a 0
    this.accessHistory.clear(); // Limpiar historial de accesos
  }
  
  /**
   * Método privado para la lógica de decisión IMTF
   * Propósito: Determinar si un elemento debe moverse al frente usando look-ahead
   * Analiza los próximos elementos en la secuencia para tomar la decisión
   * Retorna: true si debe moverse al frente, false si debe quedarse en su posición
   */
  private boolean shouldMoveToFront(int element, int position, List<Integer> sequence, int currentIndex) {
    // Calcular cuántos elementos revisar hacia adelante (position - 1)
    int lookaheadCount = position - 1;
    // Verificar si el elemento aparece en los siguientes accesos
    if (lookaheadCount <= 0) {
      return true; // Si está en posición 1, ya está al frente
    }
    // Retornar decisión basada en el análisis look-ahead
    for (int i = 1; i <= lookaheadCount && (currentIndex + i) < sequence.size(); i++) {
      if (sequence.get(currentIndex + i).equals(element)) {
          return true;
      }
    }
    return false;
  }
  
  /**
   * Propósito: Acceder a un elemento usando la estrategia IMTF
   * Calcula el costo y decide si mover al frente basándose en look-ahead
   * Retorna: AccessResult con detalles del acceso y si fue movido
   */
  public AccessResult accessElement(int element, List<Integer> sequence, int currentIndex) {
    // Verificar que el elemento existe en la lista
    if (!currentList.contains(element)) {
      throw new IllegalArgumentException("Elemento " + element + " no está en la lista");
    }
    // Encontrar posición actual del elemento
    int position = currentList.indexOf(element) + 1;
    int accessCost = position;     // Calcular costo de acceso
    boolean moved = false;

    // Usar shouldMoveToFront para decidir si mover
    if (shouldMoveToFront(element, position, sequence, currentIndex)) {
      currentList.remove(Integer.valueOf(element));
      currentList.add(0, element);
      moved = true;
    }
    // Actualizar lista solo si se decide mover
    // Actualizar estadísticas y crear resultado
    totalCost += accessCost;
    AccessResult result = new AccessResult(element, accessCost, currentList, moved);
    accessHistory.add(result);
      
    return result;
  }
  
  /**
   * Propósito: Procesar una secuencia completa usando el algoritmo IMTF
   * Ejecuta IMTF para cada elemento considerando el contexto completo
   * Retorna: Mapa con resultados detallados del procesamiento
   */
  public Map<String, Object> processSequence(List<Integer> sequence) {
    // Reiniciar algoritmo
    reset();
    List<AccessResult> results = new ArrayList<>();
    System.out.println("Lista inicial: " + currentList);
    System.out.println("-".repeat(70));
    
    // Procesar cada elemento con su índice para look-ahead
    for (int i = 0; i < sequence.size(); i++) {
      int element = sequence.get(i);
      AccessResult result = accessElement(element, sequence, i);
      // Mostrar resultados detallados paso a paso
      System.out.println("Solicitud " + (i + 1) + ": " + element);
      System.out.println("Costo de acceso: " + result.cost);
      System.out.println("Movido al frente: " + (result.moved ? "Sí" : "No"));     // Mostrar si cada elemento fue movido o no
      System.out.println("Nueva configuración: " + result.listConfig);
      System.out.println("-".repeat(70));
      
      results.add(result);
    }
    

    // Calcular y mostrar costo total
    System.out.println("COSTO TOTAL IMTF: " + totalCost);
    System.out.println("=".repeat(70));
    
    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("sequence", sequence);
    resultMap.put("totalCost", totalCost);
    resultMap.put("details", results);
    
    
    // Retornar resumen completo
    return resultMap;
  }
  
  /**
   * Propósito: Obtener el costo total acumulado
   * Retorna: Costo total como entero
   */
  public int getTotalCost() {
    return totalCost;
  }
}