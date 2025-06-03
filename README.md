# Proyecto MTF/IMTF - Análisis y Diseño de Algoritmos

## Descripción

Este proyecto implementa y analiza los algoritmos **Move-to-Front (MTF)** e **Improved Move-to-Front (IMTF)** para estructuras de datos auto-organizables. El objetivo es estudiar el comportamiento de estos algoritmos desde la perspectiva del análisis amortizado y competitivo.

## Algoritmos Implementados

### 1. Move-to-Front (MTF)
- Estrategia simple: cada elemento accedido se mueve al frente de la lista
- Útil para secuencias con localidad temporal
- Implementación clásica de listas auto-organizables

### 2. Improved Move-to-Front (IMTF)
- Versión mejorada basada en **look-ahead**
- Decisión inteligente: mueve al frente solo si el elemento aparece en los próximos `i-1` accesos
- Reduce reorganizaciones innecesarias

## Estructura del Proyecto

```
src/
├── Main.java              # Punto de entrada y casos de prueba
├── MTFAlgorithm.java      # Implementación del algoritmo MTF
├── IMTFAlgorithm.java     # Implementación del algoritmo IMTF
├── AccessResult.java      # Clase para resultados de acceso
└── SequenceAnalyzer.java  # Analizador de secuencias óptimas y peores casos
```

## Casos de Estudio Implementados

### Caso 1: Secuencia Secuencial
- **Lista inicial:** [0, 1, 2, 3, 4]
- **Secuencia:** 0,1,2,3,4,0,1,2,3,4,0,1,2,3,4,0,1,2,3,4
- **Análisis:** Comportamiento con acceso secuencial repetitivo

### Caso 2: Secuencia Reversa
- **Lista inicial:** [0, 1, 2, 3, 4]
- **Secuencia:** 4,3,2,1,0,1,2,3,4,3,2,1,0,1,2,3,4
- **Análisis:** Patrón de acceso que maximiza reorganizaciones

### Caso 3: Secuencia de Mínimo Costo
- Encuentra la secuencia de 20 elementos que minimiza el costo total
- **Resultado:** Acceso repetido al primer elemento (20 veces el elemento 0)
- **Costo mínimo:** 20 (cada acceso cuesta 1)

### Caso 4: Secuencia de Máximo Costo (Peor Caso)
- Encuentra la secuencia de 20 elementos que maximiza el costo total
- **Patrón:** Acceso en orden reverso cíclico [4,3,2,1,0,4,3,2,1,0,...]
- **Costo máximo:** 100 (promedio de 5 por acceso)

### Caso 5: Análisis de Repeticiones
- **Secuencia A:** 20 repeticiones del elemento '2'
- **Secuencia B:** 20 repeticiones del elemento '3'
- **Patrón observado:** Primera acceso cuesta la posición inicial, el resto cuesta 1

### Caso 6: Comparativa MTF vs IMTF
Análisis comparativo en diferentes escenarios:
- Secuencias de mínimo costo MTF
- Secuencias de máximo costo MTF  
- Secuencias mixtas diseñadas para mostrar ventajas de IMTF

## Cómo Ejecutar

1. **Compilar el proyecto:**
   ```bash
   javac *.java
   ```

2. **Ejecutar el análisis completo:**
   ```bash
   java Main
   ```

3. **Salida esperada:**
   - Análisis paso a paso de cada caso
   - Configuraciones de lista en cada acceso
   - Costos individuales y totales
   - Comparativa entre algoritmos

## Resultados Clave

## Video Explicativo

📹 **[Ver video MTF en YouTube](https://youtu.be/-lB5ja2Kw0Y)**

El video de 5 minutos incluye:
- Demostración de la implementación
- Explicación de casos de prueba
- Análisis de resultados obtenidos
- Comparativa entre algoritmos MTF e IMTF

### Comportamiento MTF
- **Mejor caso:** Acceso repetido al primer elemento (costo = n)
- **Peor caso:** Acceso en orden reverso (costo = n × (n+1)/2 para lista de tamaño n)
- **Patrón de repetición:** Primer acceso cuesta posición inicial, siguientes cuestan 1

### Ventajas IMTF
- Reduce movimientos innecesarios usando look-ahead
- Mejor rendimiento en secuencias con patrones específicos
- Mantiene la competitividad del MTF clásico

### Análisis Comparativo
El proyecto incluye métricas de mejora porcentual entre IMTF y MTF:
- Identificación de escenarios donde IMTF supera a MTF
- Análisis de casos donde ambos algoritmos son equivalentes

## Conceptos Teóricos Aplicados

- **Análisis Amortizado:** Cálculo del costo promedio de operaciones
- **Análisis Competitivo:** Comparación con algoritmos óptimos offline
- **Algoritmos Online:** Decisiones sin conocimiento futuro completo
- **Listas Auto-organizables:** Estructuras que se adaptan a patrones de acceso

## Implementación Técnica

### Características del Código
- Diseño orientado a objetos con separación clara de responsabilidades
- Seguimiento detallado del estado en cada operación
- Análisis automático de patrones y casos extremos
- Salida formateada para fácil interpretación

### Complejidad
- **MTF:** O(n) por acceso (búsqueda + reorganización)
- **IMTF:** O(n + k) por acceso (búsqueda + look-ahead de k elementos)
- **Espacio:** O(n) para la lista + O(1) para variables auxiliares

## Referencias

- [Self-organizing Lists - GeeksforGeeks](https://www.geeksforgeeks.org/self-organizing-list-move-front-method/)
- [MTF Analysis - Princeton University](https://www.cs.princeton.edu/courses/archive/spr09/cos423/Lectures/mtf.pdf)
- [Improved MTF Algorithm - Research Paper](https://arxiv.org/ftp/arxiv/papers/1105/1105.0187.pdf)










