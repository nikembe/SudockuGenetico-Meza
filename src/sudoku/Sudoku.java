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
public class Sudoku implements Comparable<Sudoku>{
    final int N = 9;
    final int probabildiadMutacion = 3; //2%
    int[][] tablero = new int[N][N];
    int aptitud;
    
    Sudoku(){
        int cont = 0;
        Random ale = new Random();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int n = ale.nextInt(9)+1;
                tablero[i][j] = n;
            }
        }
        
        //fitness();
    }
    
    void ponerMatriz(int[] predefinidos){
        int cont = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(predefinidos[cont] != 0){
                    tablero[i][j] = predefinidos[cont];
                }
                cont++;
            }
        }
        
        fitness();
    }
    
    void fitness(){
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
        aptitud=fitness;
    }

    // cruce
    Sudoku(Sudoku padre1, Sudoku padre2){
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
        int div = ale.nextInt(79)+1;
        
        //System.out.println("\n\ndiv: " + div + "\n");
        
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
        tablero = hijo.tablero;
        
        /*System.out.println("\n*Padre 1*");
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                System.out.print(padre1.tablero[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("\n*Padre 2*");
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                System.out.print(padre2.tablero[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("\n*Hijo*");
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                System.out.print(hijo.tablero[i][j]);
            }
            System.out.println();
        }*/
        
        //Mutacion();
    }

    @Override
    public int compareTo(Sudoku o) {
        if (aptitud > o.aptitud) {
            return -1;
        }
        if (aptitud < o.aptitud) {
            return 1;
        }
        return 0;
    }
    
    // mutación
    void Mutacion(){
        Random aleatorio = new Random();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if((aleatorio.nextInt(100)+1) <= probabildiadMutacion){
                    tablero[i][j] = aleatorio.nextInt(9)+1;
                }
            }
        }
    }
}
