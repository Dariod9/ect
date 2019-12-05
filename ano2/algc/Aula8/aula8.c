#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

/* alusão das funções que implementam os algoritmos pretendidos */
/* allusion to the functions that implement the required algorithms */
int PerrinRec (int);
int PerrinDin (int);

/* variável global para contar as adições executadas pelo algoritmo */
/* global variable for counting the sums executed by the algorithm */
int Sum;

int main (void)
{
	int Result, Line, N, Test;

	/* leitura do valor limite da tabela */
	/* reading the limit value for the table */
	do
	{
		printf ("N? "); Test = scanf ("%d", &N);
		scanf ("%*[^\n]"); scanf ("%*c");
	} while (Test == 0);

    /* impressão da tabela de execução do algoritmo */
    /* impression of the table values for the algorithm's execution */
	for (Line = 0; Line <= N; Line++)
	{
        /* inicialização da variável global contadora das adições */
        /* initialization of the global variable for counting the sums */
		Sum = 0;

		/* invocação do algoritmo pretendido */
		/* invocation of the pretended algorithm */
		Result = PerrinDin (Line);

		/* apresentação do resultado e do número de adições executadas pelo algoritmo */
		fprintf (stdout, "P(%2d) = %4d e fez %2d somas\n", Line, Result, Sum);

		/* presenting the result and the number of sums executed by the algorithm */
		//fprintf (stdout, "P(%2d) = %4d and made %2d sums\n", Line, Result, Sum);
	}

	scanf ("%*c");
	exit (EXIT_SUCCESS);
}

/* implementação dos algoritmos pretendidos */
/* acrescentar a contagem das invocações recursivas executadas pelos algoritmos usando a variável global */

/* implementation of the pretended algorithms */
/* do not forget to count the recursive calls using the global variable */

int PerrinRec(int n)
{
	if(n==0) return 3;
    if(n==1) return 0;
    if(n==2) return 2;

    Sum++;
    return PerrinRec(n-2)+PerrinRec(n-3);
}

int PerrinDin (int n)
{
    Sum=0;
    int array[n+1];
    int cont=0;

	if(n==0) return 3;
    if(n==1) return 0;
    if(n==2) return 2;

    array[0]=3;
    array[1]=0;
    array[2]=2;

    for(int i=3;i<=n;i++){
        Sum++;
        cont=array[i-2]+array[i-3];
        array[i]=cont;
    }

	return cont;
}
