# Automatizacion sitio de prueba 

## Descripción
Se genera automatizacion de sitio de prueba realizando una busqueda de producto, agregado al carrito, validacion de exitencia en carrito, eliminar del carrito y luego validar su existencia dentro del carrito

## Consideraciónes
Para que este proyecto se pueda ejecutar sin problemas necesitamos tener los siguientes puntos en consideraciones:
    - Tener instalado Java y Maven 

## Construccion y pruebas
Para construir el proyecto y ejecutar las pruebas, habrá una terminal directamente en la carpeta del proyecto y luego ejecute este comando:

```bash
mvn clean install -DskipTests
```
Este comando limpiara el directorio temporal e instalara todas las dependencias necesarias

```bash
mvn test 
```