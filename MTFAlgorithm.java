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
    }
    
    /**
     * Propósito: Reiniciar el algoritmo a su estado inicial
     * Restablece la lista a su configuración original y limpia estadísticas
     */
    public void reset() {
        // Restaurar lista original, limpiar costos y historial
    }
    
    /**
     * Propósito: Acceder a un elemento específico usando la estrategia MTF
     * Calcula el costo de acceso y mueve el elemento al frente de la lista
     * Retorna: AccessResult con detalles del acceso
     */
    public AccessResult accessElement(int element) {
        // Encontrar posición del elemento
        // Calcular costo de acceso
        // Mover elemento al frente
        // Actualizar estadísticas
        // Retornar resultado
      return null;
    }
    
    /**
     * Propósito: Procesar una secuencia completa de solicitudes de acceso
     * Ejecuta el algoritmo MTF para cada elemento en la secuencia
     * Retorna: Mapa con resultados completos del procesamiento
     */
    public Map<String, Object> processSequence(List<Integer> sequence) {
        // Reiniciar algoritmo
        // Procesar cada elemento de la secuencia
        // Mostrar resultados paso a paso
        // Calcular costo total
        // Retornar resumen completo
      return null;
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

/**
 * Clase auxiliar para almacenar resultados de cada acceso
 */
class AccessResult {
    public int element;           // Elemento accedido
    public int cost;             // Costo del acceso
    public List<Integer> listConfig;  // Configuración de lista después del acceso
    
    /**
     * Propósito: Constructor para crear un resultado de acceso
     */
    public AccessResult(int element, int cost, List<Integer> listConfig) {
        // Inicializar campos del resultado
    }
}