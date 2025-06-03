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
    // Crear copia de la lista inicial
    // Inicializar historial de accesos
    // Llamar a reset para configurar estado inicial
  }
  
  /**
   * Propósito: Reiniciar el algoritmo a su estado inicial
   * Restaura la lista original y limpia todas las estadísticas
   */
  public void reset() {
    // Restaurar lista a configuración inicial
    // Reiniciar costo total a 0
    // Limpiar historial de accesos
  }
  
  /**
   * Método privado para la lógica de decisión IMTF
   * Propósito: Determinar si un elemento debe moverse al frente usando look-ahead
   * Analiza los próximos elementos en la secuencia para tomar la decisión
   * Retorna: true si debe moverse al frente, false si debe quedarse en su posición
   */
  private boolean shouldMoveToFront(int element, int position, List<Integer> sequence, int currentIndex) {
    // Calcular cuántos elementos revisar hacia adelante (position - 1)
    // Verificar si el elemento aparece en los siguientes accesos
    // Retornar decisión basada en el análisis look-ahead
    return (Boolean) null;
  }
  
  /**
   * Propósito: Acceder a un elemento usando la estrategia IMTF
   * Calcula el costo y decide si mover al frente basándose en look-ahead
   * Retorna: AccessResult con detalles del acceso y si fue movido
   */
  public AccessResult accessElement(int element, List<Integer> sequence, int currentIndex) {
    // Verificar que el elemento existe en la lista
    // Encontrar posición actual del elemento
    // Calcular costo de acceso
    // Usar shouldMoveToFront para decidir si mover
    // Actualizar lista solo si se decide mover
    // Actualizar estadísticas y crear resultado
    return null;
  }
  
  /**
   * Propósito: Procesar una secuencia completa usando el algoritmo IMTF
   * Ejecuta IMTF para cada elemento considerando el contexto completo
   * Retorna: Mapa con resultados detallados del procesamiento
   */
  public Map<String, Object> processSequence(List<Integer> sequence) {
    // Reiniciar algoritmo
    // Procesar cada elemento con su índice para look-ahead
    // Mostrar resultados detallados paso a paso
    // Mostrar si cada elemento fue movido o no
    // Calcular y mostrar costo total
    // Retornar resumen completo
    return null;
  }
  
  /**
   * Propósito: Obtener el costo total acumulado
   * Retorna: Costo total como entero
   */
  public int getTotalCost() {
    return totalCost;
  }
}