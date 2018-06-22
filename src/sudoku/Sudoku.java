/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */;
package sudoku;

import java.util.Random;

/**
 *
 * @author Siul
 */
public class Sudoku{
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
    void fitness()
    {
        int fitness=0, cont=0;
        int [] num= new int[10];
        for(int i=0;i<10;i++)
            num[i]=0;
        //checar por filas
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<10;j++)
                num[j]=0;        
            for(int j=0;j<9;j++)
            {
                if(num[tablero[i][j]]==0)
                {  
                    fitness++;    
                    num[tablero[i][j]]=1;
                }
            }
         }
//    System.out.println("fitness por filas: " + fitness);
    //checar por columnas
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<10;j++)
                num[j]=0;        
            for(int j=0;j<9;j++)
            {
                if(num[tablero[j][i]]==0)
                {
                   fitness++;             
                   num[tablero[j][i]]=1;
                }    
            }
        }
        //System.out.println("fitness por columnas: " + fitness);    
        //checar por matrizes de 3*3 el fitnes 
        int c=3,d=3,ini=3,inj=3;

        for(int j=0;j<10;j++)
            num[j]=0;  
        for(int m=1;m<4;m++)
        {   
            inj=3*(m);
            for(int l=1;l<4;l++)
                {
                    ini=3*(l); 
                    for(int i=ini-3;i<ini;i++)
                    {
                        for(int j=inj-3;j<inj;j++)
                        {
                            //    System.out.print(tablero[i][j] + "  ");
                            if(num[tablero[i][j]]==0)
                            {
                                fitness++;             
                                cont++;
                                num[tablero[i][j]]=1;
                            }    
                        }
                          //  System.out.println(" ");
                    }
                    for(int j=0;j<10;j++)
                        num[j]=0;        

                    //       System.out.println(" ");
                }


            //      System.out.println(" ");
        }
    System.out.println("fitness por matrizes de 3*3: " + fitness);    
    aptitud=fitness;
    }
    
    //       System.out.println(" ");
}
   
   
//      System.out.println(" ");
}
System.out.println("fitness por matrizes de 3*3: " + fitness);    
     return fitness;
    }
    
    void Cruce(Sudoku padre1, Sudoku padre2){
        int[] padreVector1 = new int[N*N];
        int[] padreVector2 = new int[N*N];
        int[] hijoVector = new int[N*N];
        Sudoku hijo = new Sudoku();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                padreVector1[(N*i)+j] = padre1.tablero[i][j];
                padreVector2[(N*i)+j] = padre2.tablero[i][j];
            }
        }
        Random ale = new Random();
        int div = ale.nextInt(80)+1;
        
        for(int i=0;i<div;i++){
            hijoVector[i] = padreVector1[i];
        }
        for(int i=div;i<(N*N);i++){
            hijoVector[i] = padreVector2[i];
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                hijo.tablero[i][j] = hijoVector[(N*i)+j];
            }
        }
        
        System.out.print("\n\n HIJO:");
        for(int i=0;i<N;i++){
            System.out.print("\n");
            for(int j=0;j<N;j++){
                System.out.print(" " + hijo.tablero[i][j]);
            }
        }
        System.out.print("\n\n Padre 1:");
        for(int i=0;i<N;i++){
            System.out.print("\n");
            for(int j=0;j<N;j++){
                System.out.print(" " + padre1.tablero[i][j]);
            }
        }
        System.out.print("\n\n Padre 2:");
        for(int i=0;i<N;i++){
            System.out.print("\n");
            for(int j=0;j<N;j++){
                System.out.print(" " + padre2.tablero[i][j]);
            }
        }
        System.out.println("\n Punto aleatorio: " + div);
        tablero = hijo.tablero;
    }
}
