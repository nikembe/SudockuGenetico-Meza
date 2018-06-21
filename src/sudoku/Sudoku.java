/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */;
package sudoku;

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
    int fitness(int [][] suduko)
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
         if(num[suduko[i][j]]==0)
         {  
             fitness++;    
             num[suduko[i][j]]=1;
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
         if(num[suduko[j][i]]==0)
         {
            fitness++;             
            num[suduko[j][i]]=1;
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
        //    System.out.print(suduko[i][j] + "  ");
         if(num[suduko[i][j]]==0)
         {
            fitness++;             
            cont++;
            num[suduko[i][j]]=1;
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
     return fitness;
    }
}
