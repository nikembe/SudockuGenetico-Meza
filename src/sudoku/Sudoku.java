/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Siul
 */
public class Sudoku {
    final int N = 9;
    int[][] tablero = new int[N][N];
    int aptitud;
    
    //inicializa un sudoku en 0
    Sudoku(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tablero[i][j] = 0;
            }
        }
        
        aptitud = 0;
    }
    
    //crea un sudoku aleatorio a partir de una matríz de casillas bloqueadas
    Sudoku(int[][] bloqueos){

    }
    
    //crea un sudoku a partir de un vector de valores y una matríz casillas bloqueadas
    Sudoku(int[] valores, int[][] bloqueos){

    }
}
