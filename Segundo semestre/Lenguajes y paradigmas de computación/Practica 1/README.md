# Práctica I: Sistema de Gestión de Biblioteca en Haskell

Este proyecto es una implementación de un sistema de gestión de préstamos de libros para una biblioteca, desarrollado completamente en Haskell como parte de la materia lenguajes de programación y paradigmas de computación de la Universidad EAFIT.

## Integrantes

* Thomas Serna Saldarriaga
* David Alzate Monroy

## Plataformas y Herramientas Utilizadas

Para el desarrollo de este proyecto, se utilizaron las siguientes herramientas:

* **Editor de Código:** Visual Studio Code
* **Compilador:** Glasgow Haskell Compiler (GHC)
* **Colaboración en Tiempo Real:** Jdoodle

## Descripción del Proyecto

El programa permite administrar el catálogo de una biblioteca a través de una interfaz de consola interactiva. Las principales funcionalidades incluyen:

* **Registrar el préstamo de un libro:** Cambia el estado de un libro a "prestado" y guarda la hora y fecha del préstamo.
* **Registrar la devolución de un libro:** Marca un libro como "disponible" y registra la fecha de devolución.
* **Buscar un libro por su ID:** Muestra la información detallada de un libro, indicando si está disponible o prestado. Si está prestado, calcula y muestra la duración del préstamo hasta el momento.
* **Listar todos los libros prestados:** Muestra una lista de todos los libros que se encuentran actualmente en préstamo.

## Persistencia de Datos

La información de la biblioteca se almacena en el archivo `libreria.txt`. El programa carga los datos de este archivo al iniciar y guarda cualquier modificación (préstamos o devoluciones) en el mismo archivo, asegurando que los datos persistan entre sesiones.