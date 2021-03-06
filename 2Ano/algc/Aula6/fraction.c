/*******************************************************************************

 Ficheiro de implementação do Tipo de Dados Abstracto FRACTION (fraction.c).
 A estrutura de dados de suporte da fração é uma estrutura, constituída pelos
 campos de tipo inteiro Num e Den para armazenar, respectivamente, o numerador 
 e o denominador da fração.

 Autor : António Manuel Adrego da Rocha    Data : Março de 2019
 
 Implementation file of the abstract data type FRACTION (fraction.c). The data
 structure to store the fraction is composed with the integer fields Num and Den
 for storing the fraction's numerator and denominator.

*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "fraction.h"	/* Ficheiro de interface do TDA - ADT Interface file */

/************** Definição da Estrutura de Dados Interna da Fração *************/
/**************** Fraction's Internal Data Structure Definition ***************/

struct fraction
{
	int Num;	/* numerador da fração - fraction's numerator */
	int Den;	/* denominador da fração - fraction's denominator */
};

/*********************** Controlo Centralizado de Erro ************************/
/************************* Centralized Error Control **************************/

static unsigned int Error = OK;	/* inicialização do erro - error initialization */

static char *ErrorMessages[] = {
									"sem erro - without error",
									"fracao(fracoes) inexistente(s) - fraction(s) do not exist",
									"memoria esgotada - out of memory",
									"divisor nulo - division by zero",
									"denominador nulo - null denominator"
								};

static char *AbnormalErrorMessage = "erro desconhecido - unknown error";

/************** Número de mensagens de erro previstas no módulo ***************/

#define N (sizeof (ErrorMessages) / sizeof (char *))

/************************ Alusão às Funções Auxiliares ************************/

static PtFraction CreateFraction (void);	/* construtor primário - primary constructor */
static void ReduceFraction (PtFraction);   /* simplificador da fração - fraction simplifier */

/*************************** Definição das Funções ****************************/


void FractionClearError (void)
{ Error = OK; }

int FractionError (void)
{ return Error; }

char *FractionErrorMessage (void)
{
	if (Error < N) return ErrorMessages [Error];
	else return AbnormalErrorMessage;	/* não há mensagem de erro - - no error message */
}

PtFraction FractionCreate (int pnum, int pden)	/* construtor inicializador - initializer constructor */
{
    PtFraction frac=CreateFraction();
    
    if(frac==NULL){
        Error=NO_MEM;
      return NULL;}

    FractionSet(frac,pnum,pden);

    return frac;
}

int FractionGetNumerator (PtFraction pfrac)
{
	if(pfrac==NULL){
        Error=NO_FRACTION;
        return 0;
    }
    
    Error=OK;
    return (int) pfrac->Num;
    }

int FractionGetDenominator (PtFraction pfrac)
{
	if(pfrac==NULL){
        Error=NO_FRACTION;
        return 0;
    }
    
    Error=OK;
    return (int) pfrac->Den;

}

void FractionDestroy (PtFraction *pfrac)	/* destrutor - destructor */
{

    PtFraction frac=*pfrac;

    if(frac==NULL){
        Error=NO_FRACTION;
        return ;
    }
    
    free(frac);
    *pfrac = NULL;
    Error=OK;

}

PtFraction FractionCopy (PtFraction pfrac)	/* construtor cópia - copy constructor */
{

   return FractionCreate(pfrac->Num,pfrac->Den);
}

PtFraction FractionSymmetrical (PtFraction pfrac)	/* construtor simétrico - symmetrical constructor */
{
	
   return FractionCreate((-1)*pfrac->Num,pfrac->Den);
}

PtFraction FractionAddition (PtFraction pfrac1, PtFraction pfrac2)
{
     if(pfrac1==NULL){
        Error=NO_FRACTION;
        return NULL;
    }

     if(pfrac2==NULL){
        Error=NO_FRACTION;
        return NULL;
    }

	int den=pfrac1->Den*pfrac2->Den;
    int num1=pfrac1->Num*pfrac2->Den;
    int num2=pfrac2->Num*pfrac1->Den;

    return FractionCreate(num1+num2,den);
}
 
PtFraction FractionSubtraction (PtFraction pfrac1, PtFraction pfrac2)
{
	PtFraction fracSub=FractionCopy(pfrac2);
    fracSub=FractionSymmetrical(fracSub);

    PtFraction result= FractionAddition(pfrac1,fracSub);
    FractionDestroy(&fracSub);
    return result;
}

PtFraction FractionMultiplication (PtFraction pfrac1, PtFraction pfrac2)
{
     if(pfrac1==NULL){
        Error=NO_FRACTION;
        return NULL;
    }

     if(pfrac2==NULL){
        Error=NO_FRACTION;
        return NULL;
    }

    return FractionCreate(pfrac1->Num*pfrac2->Num,pfrac1->Den*pfrac2->Den);
	
}

PtFraction FractionDivision (PtFraction pfrac1, PtFraction pfrac2)
{
    Error=OK;

    if(FractionIsNull(pfrac1)){
        Error=NO_FRACTION;
        return FractionCreate(0,2);
    }

    if(FractionIsNull(pfrac2)){
        Error=ZERO_DIV;
        return FractionCreate(0,1);
    }

    return FractionCreate((pfrac1->Num * pfrac2->Den),(pfrac1->Den * pfrac2->Num));
}

int FractionIsNull (PtFraction pfrac)
{
	if(pfrac==NULL){ Error= NO_FRACTION; return -1;}
    if(pfrac->Den==0){ Error=NULL_DEN; return -1;}

    Error=OK;
    if(pfrac->Num==0) return 1;
    else return 0;
}

int FractionEquals (PtFraction pfrac1, PtFraction pfrac2)
{

    if(FractionIsNull(FractionSubtraction(pfrac1,pfrac2))){
        Error=OK;
        return 1;
    }

    return 0;
}

int FractionCompareTo (PtFraction pfrac1, PtFraction pfrac2)
{
    Error=OK;

    if(FractionEquals(pfrac1,pfrac2)){
        return 0;
    }

    PtFraction fracT=FractionSubtraction(pfrac1,pfrac2);

	if(fracT->Num>0){
        FractionDestroy(&fracT);
        return 1;
    }

        FractionDestroy(&fracT);

    return -1;
}

int FractionIsProper (PtFraction pfrac)
{

    Error=OK;

	if(pfrac==NULL){
        Error= NO_FRACTION;
        return 0;
    }

    if(pfrac->Den==0){
        Error=ZERO_DIV;
        return 0;
    }

    return (pfrac->Num < pfrac->Den);
}

void FractionSet (PtFraction pfrac, int pnum, int pden)
{
	if (pfrac == NULL) { Error = NO_FRACTION; return; }
    if (pden == 0) { Error =  NULL_DEN; return; }
    if (pden < 0) { pnum = -pnum; pden = -pden; }
	pfrac->Num = pnum; pfrac->Den = pden;
	if (pfrac->Num != 0) ReduceFraction (pfrac);
	Error = OK;
}

char * FractionToString (PtFraction pfrac)
{
	if (pfrac == NULL) { Error = NO_FRACTION; return 0; }
	char * Str;  
	/* cria a sequência de caracteres - allocating the string */
	if ((Str = calloc (64, sizeof (char))) == NULL)
	{ Error = NO_MEM; return NULL; }

	sprintf (Str, "%d/%d", pfrac->Num, pfrac->Den);
	Error = OK;
	return Str;
}

/*********************** Definição das Funções Internas ***********************/
/*********************** Definition of Internal Functions *********************/

/*******************************************************************************
 Função que aloca memória dinâmica para a fração sem qualquer inicialização.
 Este construtor primário serve para ser usado pelas restantes operações que criam
 uma nova fração.
 
 Function that allocates dynamic memory for the fraction without any initialization.
 This primary constructor is to be used by the remaining operations that create a 
 new fraction.
*******************************************************************************/
static PtFraction CreateFraction (void)
{
	return (PtFraction) malloc (sizeof (struct fraction));
}

/*******************************************************************************
 Função que calcula o máximo divisor comum através do método de Euclides.
 
*******************************************************************************/
static int mdc (int px, int py)
{
	int r, m, n;
	
	if (px >= py) { m = px; n = py;}
	else { m = py; n = px;}
    
    while (n != 0)
    {
        r = m % n; m = n; n = r;
    }
    return m;
} 

/*******************************************************************************
 Função que reduz uma fração. Esta função deve ser usada pelas operações 
 aritméticas e pelo construtor inicializador.
 
*******************************************************************************/
static void ReduceFraction (PtFraction pfrac)
{
	int MDC;
	
	if (pfrac->Num < 0) MDC = mdc (-pfrac->Num, pfrac->Den);
	else MDC = mdc (pfrac->Num, pfrac->Den);
	
	if (MDC == 1) return;
	else { pfrac->Num /= MDC; pfrac->Den /= MDC; }
}