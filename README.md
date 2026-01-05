# Práctica: Estructuras No Lineales - 

## Autor
- Nombre: Juliana Torres
- Carrera/Curso: Computación / Estructura de Datos


## Nombre de la práctica - Fecha
- Práctica: Práctica de Árboles – Implementación Integers
- Fecha: 2026-01-05

## Descripción
En esta práctica se implementó un Árbol Binario de Búsqueda (BST) que permite la inserción de enteros y soporta los recorridos PreOrder, InOrder y PostOrder.
Además, se implementó el método size() que retorna el número total de nodos en el árbol con complejidad O(1), gracias a un contador interno que se actualiza en cada inserción.

## Evidencias
### Captura 1

![alt text](assents/cap1.png)

Se muestran los recorridos del árbol:

-PreOrder: raíz → izquierda → derecha
-InOrder: izquierda → raíz → derecha (en BST, orden ascendente)
-PostOrder: izquierda → derecha → raíz
Finalmente, se imprime el tamaño del árbol (size), que es 4 porque se insertaron 4 nodos.

### Captura 2 

![alt text](assents/cap2.png)

El atributo size se actualiza en el método insertRecursive cuando se crea un nuevo nodo:

![alt text](assents/size.png)

Por esta razón, el método size() no necesita recorrer el árbol, simplemente retorna el contador, lo que lo hace O(1).