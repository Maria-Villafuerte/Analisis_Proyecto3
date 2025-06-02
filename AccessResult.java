import java.util.*;

/**
 * Clase para representar el resultado de un acceso
 */
class AccessResult {
    // Variables públicas para almacenar información del resultado del acceso
    public int element;           // Elemento que fue accedido
    public int cost;             // Costo del acceso (posición en la lista)
    public List<Integer> listConfig;  // Configuración de la lista después del acceso
    public boolean moved;        // Indica si el elemento fue movido o no
    
    /**
     * Constructor principal para MTF (Move-to-Front)
     * Propósito: Crear un resultado de acceso donde el elemento siempre se mueve al frente
     * Parámetros: elemento accedido, costo del acceso, configuración resultante de la lista
     */
    public AccessResult(int element, int cost, List<Integer> listConfig) {
        // Asignar elemento accedido
        // Asignar costo de acceso
        // Crear copia de la configuración de lista
        // Establecer moved = true (para MTF siempre se mueve)
    }
    
    /**
     * Constructor completo para algoritmos que pueden o no mover elementos
     * Propósito: Crear un resultado de acceso con control explícito del flag moved
     * Parámetros: elemento accedido, costo, configuración de lista, si fue movido o no
     */
    public AccessResult(int element, int cost, List<Integer> listConfig, boolean moved) {
        // Asignar elemento accedido
        // Asignar costo de acceso
        // Crear copia de la configuración de lista
        // Establecer flag moved según parámetro
    }
}