# Árboles AVL

Este repositorio contiene una implementación de Árboles AVL en Java, con explicaciones conceptuales, diagramas ilustrativos y código funcional.
## Tabla de Contenidos

- [Introducción](#introducción)
- [Conceptos de Árboles AVL](#conceptos-de-árboles-avl)
- [Diagramas](#diagramas)
- [Implementación en Java](#implementación-en-java)
- [Autores](#autores)

## Introducción

Un Árbol AVL es un tipo de Árbol Binario de Búsqueda (BST) que se mantiene equilibrado automáticamente. En un AVL, la diferencia de altura entre los subárboles izquierdo y derecho de cualquier nodo es como máximo 1. Esto permite realizar operaciones eficientes de búsqueda, inserción y eliminación.

## Conceptos de Árboles AVL

### Definición

Un Árbol AVL es una estructura de datos que mantiene sus elementos en un orden específico y equilibrado para permitir búsquedas rápidas. Cada nodo contiene:

- **Valor**: El dato almacenado en el nodo.
- **Nodo Izquierdo**: Un puntero o referencia al subárbol izquierdo.
- **Nodo Derecho**: Un puntero o referencia al subárbol derecho.
- **Altura**: La altura del nodo para ayudar a mantener el equilibrio del árbol.

### Propiedades Claves

1. **Balanceo Automático**: Mantiene el equilibrio del árbol para garantizar tiempos de operación logarítmicos.
2. **Búsqueda Eficiente**: Permite buscar elementos en tiempo logarítmico promedio.
3. **Inserción y Eliminación**: Operaciones de inserción y eliminación también se pueden realizar en tiempo logarítmico promedio.
4. **Rotaciones**: Utiliza rotaciones simples y dobles para mantener el equilibrio del árbol.

## Diagramas

A continuación se muestran algunos diagramas que ilustran la estructura y las operaciones en un Árbol AVL:

<table>
  <tr>
    <td><img src="https://github.com/FernandoHuilca/Arboles-AVL/assets/134117009/753e86b8-aa47-4d59-b723-c27f443b2ea6" alt="Diagrama 1"></td>
    <td><img src="https://github.com/FernandoHuilca/Arboles-AVL/assets/134117009/e76a6585-706b-4e3c-b878-1e9e10d6acf3" alt="Diagrama 2"></td>
  </tr>
</table>

## Implementación en Java

El código fuente se encuentra en la carpeta `src` e incluye las siguientes funcionalidades:

1. **CrearÁrbolAVL**
2. **Eliminar Nodo**
3. **Buscar Nodo**
4. **Insertar Nodo** 
5. **Mostrar árbol**

### Autores
[@FernandoHuilca](https://github.com/FernandoHuilca)
[@JuanMateoQ](https://github.com/JuanMateoQ)
[@SebasLS1](https://github.com/SebasLS1)
