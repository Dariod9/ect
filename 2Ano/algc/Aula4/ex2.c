#include <stdio.h>
#include <stdlib.h>

/* alusão da função que implementa o algoritmo pretendido */
/* allusion to the function that implements the algorithm */
int MaxRepetition (int [], int);

/* variável global para contar as operações de comparação executadas pelo algoritmo */
/* global variable for counting the comparations executed by the algorithm */
int Count = 0;

int main (void)
{
    /* declaração dos arrays de teste - usar o pretendido para cada execução */
    /* declaration of the test arrays - use each one for each execution */

     //int Array[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }; 
     //int Array[] = { 1, 1, 1, 1, 1, 3, 1, 1, 1, 1 }; 
     //int Array[] = { 1, 1, 1, 4, 1, 1, 4, 1, 1, 1 }; 
     //int Array[] = { 1, 1, 1, 1, 1, 1, 2, 5, 1, 9 }; 
     //int Array[] = { 1, 1, 1, 1, 9, 1, 2, 5, 1, 9 }; 
     //int Array[] = { 1, 1, 1, 9, 1, 2, 8, 3, 7, 1 }; 
     //int Array[] = { 1, 1, 1, 9, 5, 2, 8, 1, 9, 9 }; 
     //int Array[] = { 1, 1, 3, 9, 5, 2, 8, 7, 9, 9 }; 
     //int Array[] = { 1, 1, 6, 0, 5, 2, 8, 7, 9, 9 }; 
     //int Array[] = { 1, 4, 6, 0, 5, 2, 8, 7, 9, 9 }; 
     int Array[] = { 1, 3, 6, 0, 5, 2, 8, 7, 11, 9 }; 
      //teste  int Array[] = { 1, 2, 1, 5, 5, 5, 2, 0, 3, 3 };
  
    int NElem = sizeof (Array) / sizeof (int); int Result;

    /* invocação do algoritmo - algorithm invocation */    
	Result = MaxRepetition (Array, NElem);

	/* apresentação do resultado e do número de comparações executadas pelo algoritmo */
	/* presenting the result and the number of comparasions executed by the algorithm */
	fprintf (stdout, "Maximum repeatability of elements = %2d - Comparisons = %3d\n", Result, Count);

    exit (EXIT_SUCCESS);
}

/* implementação do algoritmo com a contagem das comparações */
/* implementation of the algorithm with the counting of comparasions */

int MaxRepetition (int array[], int n)
{
    /* acrescentar o código do algoritmo - insert your code */ 
    
    int num_reps=-1;
    int max=0;

    for(int i=0;i<n-1;i++){

        for(int j=i;j<n;j++){

            Count++;

            if(array[j]==array[i]){
                num_reps++;
                }
        }

        Count++;
        if(num_reps>max) max=num_reps;

        
        if(i>((n-1)-1-max)) break;

        printf("%d \n",num_reps);
        num_reps=-1;

    }

    return max;

    }