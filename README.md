# Console-drawing-tool
This is a simple tool to draw in console

# How to run
The program was built with Java 17 and Maven
- Run with JAR: java -jar console-drawing-tool-1.0.jar
- Run with source:
    - Run program: mvn exec:java
    - Test: mvn test
    - Create JAR: mvn package

# Supported commands

```
Command 		Description
C w h           Create a new canvas of width w and height h.
L x1 y1 x2 y2   Create a new line from (x1,y1) to (x2,y2). Only support 
                horizontal or vertical lines.
R x1 y1 x2 y2   Create a new rectangle, whose upper left corner is (x1,y1) and 
                lower right corner is (x2,y2).
Q               Quite the program.
``` 

# Samples
```
enter command: C 10 10
------------
|          |
|          |
|          |
|          |
|          |
|          |
|          |
|          |
|          |
|          |
------------

enter command: L 1 1 1 8
------------
|x         |
|x         |
|x         |
|x         |
|x         |
|x         |
|x         |
|x         |
|          |
|          |
------------

enter command: R 2 2 5 5
------------
|x         |
|xxxxx     |
|xx  x     |
|xx  x     |
|xxxxx     |
|x         |
|x         |
|x         |
|          |
|          |
------------
```
