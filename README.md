# Tic-tac-toe

Este repositorio contendrá el clásico juego del gato. En este README, se encontrán los lineaminetos a seguir para poder desarrollar y contribuir a este proyecto

> [!NOTE]
> Nombres de clases, variables, funciones estarán en inglés

# Nombre de las clases

Todos los archivosJavn deben usar PascalCase

> Ejemplo:`NombreArchivo.java`

Las carpetas deben de ir en minúsuculas y sin espacio: 
> Ejemplo: `src/`,`docs/`

# Nombres de clases 

* PascalCase:`Game`,`Board`,`AiPlayer` 

# Nombres de métodos y clases

* camelCase: `printBoard()`, `playerMove`,`isGameOver`

# Llaves

* Estilo K&R 
```
if(x==y){
   foo();
   bar();
}
```

# Comentarios

* Usar comentarios en formato de bloque donde sea necesario

```java
/**
* Checa si el juego ha acabdo
* @return verdadero si el juego ha acabdo, de lo contrario falso
*/
public boolean isGameOver(){...}
```
# Propuesta inicial

Esta es mi propuesta inicial de clases que podemos manejar para el desarrollo del programa 
```
TicTacToe/
|
|--src/
|   |--main/
|   |   |-- Main.java //Punto de entrada del juego
|   |   |-- Menu.java // Menu principal del juego
|   |   |-- Game.java //Logca prinicipal del juego
|   |   |-- Player.java //Clase abstracta para jugador
|   |   |-- HumanPlayer.java //Jugador
|   |   |-- AIPlayer.java // EL algoritmo MiniMax
|   |   |-- Board.java // la representacón del tablero
|   |- bin/
|       |-- *.class //Todos los archivos class
|-- README.md
```
Dejaré una carpeta adicional, que vendrán archivo de bash y batch, para Linux, Mac y Windows, para ejectuar y compilar, a su vez de depositar inmediatamente los elementos class en la carpeta bin, esta carpeta la denominaré `commands/`

# Main (Todos)
La sección principal del código, contendrá el juego por sí mismo
# Menu (isa) completado
Contedrá las opciones para poder cambiar el modo de juego, humano o ia
# Game (Rodolfo) Completado
Contiene las reglas del juego, el como determina quien gana o pierde tablero,turnos,escoger el x u o,verificar ganador
# Player (Jorge) Completado
Clase abstracta que dará la base para crear los modos de juego, (Jugador contra Jugador e IA)
# HumanPlayer (Emilio) Completado
Modo 1 jugador
# AIPlayer (Jose) Completado
 modo jugador contra la computadora
# Board (Isa) completado
El despliegue del tablero

