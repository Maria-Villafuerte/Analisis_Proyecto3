import java.util.*;

/**
 * Clase principal para el algoritmo Move-to-Front (MTF)
 */
class MTFAlgorithm {
    // Variables de instancia para almacenar el estado del algoritmo
    private List<Integer> initialList;
    private List<Integer> currentList;
    private int totalCost;
    private List<AccessResult> accessHistory;
    
    /**
     * Constructor - Inicializa el algoritmo MTF con una lista inicial
     * Propósito: Crear una nueva instancia del algoritmo con la configuración inicial
     */
    public MTFAlgorithm(List<Integer> initialList) {
      // Inicializar variables de instancia
      this.initialList = new ArrayList<>(initialList);
      this.accessHistory = new ArrayList<>();
      reset();        
    }
    
    /**
     * Propósito: Reiniciar el algoritmo a su estado inicial
     * Restablece la lista a su configuración original y limpia estadísticas
     */
    public void reset() {
      // Restaurar lista original, limpiar costos y historial
      this.currentList = new ArrayList<>(initialList);
      this.totalCost = 0;
      this.accessHistory.clear();
    }
    
    /**
     * Propósito: Acceder a un elemento específico usando la estrategia MTF
     * Calcula el costo de acceso y mueve el elemento al frente de la lista
     * Retorna: AccessResult con detalles del acceso
     */
    public AccessResult accessElement(int element) {
      if (!currentList.contains(element)) {
          throw new IllegalArgumentException("Elemento " + element + " no está en la lista");
      }
      
      // Encontrar la posición del elemento (1-indexado)
      int position = currentList.indexOf(element) + 1;
      int accessCost = position;
      
      // Mover el elemento al frente
      currentList.remove(Integer.valueOf(element));
      currentList.add(0, element);
      
      // Actualizar estadísticas
      totalCost += accessCost;
      AccessResult result = new AccessResult(element, accessCost, currentList);
      accessHistory.add(result);
      return result;
    }
    
    /**
     * Propósito: Procesar una secuencia completa de solicitudes de acceso
     * Ejecuta el algoritmo MTF para cada elemento en la secuencia
     * Retorna: Mapa con resultados completos del procesamiento
     */
    public Map<String, Object> processSequence(List<Integer> sequence) {
        // Reiniciar algoritmo
        reset();
        List<AccessResult> results = new ArrayList<>();
        
        System.out.println("Lista inicial: " + currentList);
        System.out.println("-".repeat(60));

        // Procesar cada elemento de la secuencia
        for (int i = 0; i < sequence.size(); i++) {
            int element = sequence.get(i);
            AccessResult result = accessElement(element);
            // Mostrar resultados paso a paso
            System.out.println("Solicitud " + (i + 1) + ": " + element);
            System.out.println("Costo de acceso: " + result.cost);
            System.out.println("Nueva configuración: " + result.listConfig);
            System.out.println("-".repeat(60));
            
            results.add(result);
        }

        // Calcular costo total
        System.out.println("COSTO TOTAL MTF: " + totalCost);
        System.out.println("=".repeat(60));
        
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sequence", sequence);
        resultMap.put("totalCost", totalCost);
        resultMap.put("details", results);
        // Retornar resumen completo
      return resultMap;
    }
    
    /**
     * Propósito: Obtener el costo total acumulado de todos los accesos
     * Retorna: Costo total como entero
     */
    public int getTotalCost() {
      return totalCost;
        // Retornar costo total acumulado
      
    }
    
    /**
     * Propósito: Obtener una copia de la configuración actual de la lista
     * Retorna: Lista actual sin exponer la referencia interna
     */
    public List<Integer> getCurrentList() {
      return currentList;
        // Retornar copia de la lista actual
    }
}
