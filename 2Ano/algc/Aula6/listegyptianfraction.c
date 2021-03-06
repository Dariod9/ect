/*******************************************************************************
 Ficheiro de implementação do Tipo de Dados Abstracto EGYPTIAN FRACTION.
 A estrutura de dados de suporte da fração egípcia é uma estrutura, constituída
 pelo campo inteiro Size para indicar o número de frações existentes, pelo campo
 inteiro Complete para indicar se a fração egípcia está completa/incompleta, e
 pelos ponteiros Head e Tail para aceder à lista ligada que armazena as frações 
 unitárias contituintes da fração egípcia.

 Autor : António Manuel Adrego da Rocha    Data : Março de 2019
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#include "egyptianfraction.h"	/* Ficheiro de interface do TDA - ADT Interface file */

/********** Definição da Estrutura de Dados Interna da Fração Egípcia *********/

typedef struct node *PtNode;
struct node /* definição do nó da lista ligada - link list node definition */
{
	PtFraction PtElem;  /* elemento da lista - list element */
	PtNode PtNext;  /* ponteiro para o nó seguinte - next node pointer */
};

struct egyptianfraction
{
	int Size;			/* número de frações unitárias - number of unit fractions */
	int Complete;		/* fração egípcia completa/incompleta - complete/incomplete egyptian fraction */
	PtNode Head, Tail;  /* ponteiros para a lista de frações unitárias - pointers to the list of unit fractions */
};

/*********************** Controlo Centralizado de Erro ************************/

static unsigned int Error = OK;	/* inicialização do erro - error initialization */

static char *ErrorMessages[] = {
									"sem erro - without error",
									"fracao(fracoes) inexistente(s) - fraction(s) do not exist",
									"memoria esgotada - out of memory",
									"fracao nao propria - fraction not proper",
									"denominador nulo - null denominator",
									"indice errado - bad index",
									"ponteiro nulo - null pointer"
								};

static char *AbnormalErrorMessage = "erro desconhecido - unknown error";

/************** Número de mensagens de erro previstas no módulo ***************/
/************** Number of predicted error messages in the module **************/

#define N (sizeof (ErrorMessages) / sizeof (char *))

/************************ Alusão às Funções Auxiliares ************************/
/*********************** Allusion to Auxiliary Functions **********************/

PtNode NodeCreate (PtFraction);
void NodeDestroy (PtNode *);
void ListDestroy (PtNode *);
static PtFraction CreateUnitFraction (PtFraction *);

/*************************** Definição das Funções ****************************/
/*************************** Function Definitions *****************************/

void EgyptianFractionClearError (void)
{ Error = OK; }

int EgyptianFractionError (void)
{ return Error; }

char *EgyptianFractionErrorMessage (void)
{
	if (Error < N) return ErrorMessages [Error];
	else return AbnormalErrorMessage;	/* não há mensagem de erro - - no error message */
}

PtEgyptianFraction EgyptianFractionCreate (PtFraction pfraction)	/* construtor inicializador - initializer constructor */
{
	if(pfraction == NULL) {
		Error=NO_FRACTION;
		return NULL;
		 }

	if(!FractionIsProper(pfraction) || FractionGetNumerator(pfraction) <= 0) {
		 Error=NOT_PROPER; 
		 return NULL;
		  }

	PtEgyptianFraction pegyp = (PtEgyptianFraction) malloc (sizeof (struct egyptianfraction));

	if(pegyp == NULL) {
		 Error = NO_MEM;
		  return NULL;
		  }

	PtNode* current = &(pegyp -> Head);
	PtFraction copy = FractionCopy(pfraction);
	PtFraction tmp;
	do {
		tmp = CreateUnitFraction(&copy);
		if(tmp != NULL) {
			*current = NodeCreate(tmp); 
			pegyp -> Size++;
		}

		if(copy != NULL) current = &((*current) -> PtNext);
		if(FractionGetNumerator(copy) == 1) { 
			*current = NodeCreate(copy); 
			pegyp -> Size++; 
			pegyp -> Complete = 1; 
		}

	} while((!EgyptianFractionIsComplete(pegyp)) && (copy != NULL) && (pegyp -> Size < MAX_SIZE));

	pegyp -> Tail = *current;
	Error = OK;
	return pegyp;
}

void EgyptianFractionDestroy (PtEgyptianFraction *pegyp)	/* destrutor - destructor */
{
	Error = OK;
	PtEgyptianFraction frac = *pegyp;
	if(frac == NULL){
		Error = NO_FRACTION;
		return;
	}
	ListDestroy(&(frac->Head));
	free(frac);
	*pegyp = NULL;
}


int  EgyptianFractionGetSize (PtEgyptianFraction pegyp)
{
	Error = OK;

	if(pegyp==NULL){ Error= NO_FRACTION;
	return 0;
	}

	return pegyp ->Size;
}

int  EgyptianFractionIsComplete (PtEgyptianFraction pegyp)
{
		Error = OK;

	if(pegyp==NULL){ Error= NO_FRACTION;
	return 0;
	}

	return pegyp ->Complete;
}

PtEgyptianFraction EgyptianFractionCopy (PtEgyptianFraction pegyp)	/* construtor cópia - copy constructor */
{
	Error = OK;

	if(pegyp == NULL){
		Error = NO_FRACTION;
		return NULL;
	}

	PtEgyptianFraction frac = (PtEgyptianFraction) malloc (sizeof (struct egyptianfraction));

	if(frac == NULL){
		Error = NO_MEM;
		return NULL;
	}


	PtNode stat = pegyp->Head;
	frac->Head = NodeCreate(FractionCopy(stat->PtElem));
	PtNode tmp = frac->Head;

	while(stat->PtNext != NULL){
		stat = stat->PtNext;
		PtFraction copy = FractionCopy(stat->PtElem);
		tmp->PtNext = NodeCreate(copy);
		tmp = tmp->PtNext;
		frac->Tail = tmp;
	}

	frac->Complete = pegyp->Complete;
	frac->Size = pegyp->Size;
	return frac;
}

PtFraction EgyptianFractionToFraction (PtEgyptianFraction pegyp)
{
	if (pegyp == NULL) { 
		Error = NO_FRACTION; 
		return NULL; 
	}

	PtFraction frac = pegyp -> Head -> PtElem;

	for (PtNode current = (pegyp -> Head) -> PtNext; current != NULL; current = current -> PtNext) {
		frac = FractionAddition(frac, current -> PtElem);
	}

	return frac;

}

int EgyptianFractionEquals (PtEgyptianFraction pegy1, PtEgyptianFraction pegy2) // N SEI
{
	Error = OK;

	if(pegy1 == NULL || pegy2 == NULL){
		Error=NO_FRACTION;
		return 0;
	}

	if(pegy1->Size != pegy2->Size) return 0;

	if(pegy1->Complete != pegy2->Complete) return 0;
	
	PtNode p1;
	PtNode p2;

	for(p1=pegy1->Head, p2=pegy2->Head;p1!=NULL;p1=p1->PtNext, p2=p2->PtNext){
		
		if(!FractionEquals(p1->PtElem,p2->PtElem)) return 0;
		  
	}

	return 1;
	
}

int EgyptianFractionBelongs (PtEgyptianFraction pegyptian, PtFraction pfraction) // N SEI
{
	Error= OK;
	
	if(pegyptian == NULL || pfraction == NULL){
		Error=NO_FRACTION;
		return 0;
	}

	if(!FractionIsProper(pfraction)){
		Error= NOT_PROPER;
		return 0;
	}


	PtNode p1;

	for(p1=pegyptian->Head;p1!=NULL;p1=p1->PtNext){
		
		if(FractionEquals(p1->PtElem,pfraction)) return 1;
		  
	}

	return 0;
}

PtFraction EgyptianFractionGetPos (PtEgyptianFraction pegyp, int pindex) //DA
{
	Error = OK;

	if(pegyp==NULL){
		Error=NO_FRACTION;
		return NULL;
	}
	if(pindex<0 || pindex>=pegyp->Size){
		Error=BAD_INDEX;
		return NULL;
	}

	PtNode Node=pegyp->Head;

	for(int i=1; i<=pindex; i++){
		Node=Node->PtNext;
	}

	return Node->PtElem;
}

/*********************** Definição das Funções Internas ***********************/
/*********************** Definition of Internal Functions *********************/

/*******************************************************************************
 Função iterativa para decompor uma fração no seu primeiro termo unitário. Tem
 como parâmetro de entrada uma fração (que se assume uma fração própria positiva)
 e devolve a maior fração unitária existente ou uma referência nula no caso de 
 falta de memória dinâmica para alocar uma nova fração. A função altera a fração 
 passada no parâmetro de entrada para o valor do resto da fração que precisa de 
 continuar a ser convertida. Caso haja overflow no cálculo do denominador desta 
 fração restante então a fração de entrada fica com a referência nula para 
 indicar a impossibilidade de fazer a extração da fração unitária seguinte.
 Como o parâmetro de entrada fica corrompido pela execução da função, qualquer 
 função que a utilize deve - depois das validações necessárias - fazer uma cópia 
 da fração e usar a cópia, não se esquecendo de eliminar a fração no fim.
 
 Iterative function to decompose a fraction into its first unit term. Has as input
 parameter a fraction (assuming a positive proper fraction) and returns the largest
 existing unit fraction or a zero reference in the case of lack of dynamic memory 
 to allocate a new fraction. The function changes the input fraction to the value 
 of the remainder of the fraction that needs to continue to be converted. If there 
 is overflow in calculating the denominator of this remaining fraction, then the 
 input parameter is destoyed and assumes the null reference for indicate the 
 impossibility of extracting the next unit fraction. Because the input parameter is
 corrupted by the function execution, any function that uses it must - after the 
 necessary validations - make a copy of the fraction and use the copy, not forgetting
 to eliminate the fraction before terminating its execution.
*******************************************************************************/
static PtFraction CreateUnitFraction (PtFraction *pfraction)
{
	PtFraction UnitFraction; int Num, Den, NewNum, NewDen;

	Num = FractionGetNumerator (*pfraction);
	Den = FractionGetDenominator (*pfraction);

	NewNum = 1; NewDen = Den/Num;
	if (Den%Num != 0) NewDen++;

	if ((UnitFraction = FractionCreate (NewNum, NewDen)) == NULL)
	{ Error = FractionError (); return NULL; }

	unsigned long long Denominator = Den * NewDen;

	if (Denominator > INT_MAX) FractionDestroy (pfraction);
	else
	{
		NewNum = (-Den) % Num;
		if (NewNum < 0) NewNum += Num;
		NewDen = (int) Denominator;
		FractionSet (*pfraction, NewNum, NewDen);
		if (FractionError () != OK) FractionDestroy (pfraction);
	}

	return UnitFraction;
}

/*******************************************************************************
 Função auxiliar para criar um nó da lista ligada. Valores de erro: OK ou NO_MEM.
 
 Auxiliary function to create a list node. Error codes: OK or NO_MEM.
*******************************************************************************/
PtNode NodeCreate (PtFraction pelem)	/* alocação do nó - node allocation */
{
	PtNode Node;

	if ((Node = (PtNode) malloc (sizeof (struct node))) == NULL)
    { Error = NO_MEM; return NULL; }

	Node->PtElem = pelem;		/* copiar o elemento - copy the element */
	Node->PtNext = NULL;	/* apontar para a frente para NULL - next is null */

	Error = OK;
	return Node;
}

/*******************************************************************************
 Função auxiliar para libertar um nó da lista ligada. Valores de erro: OK ou NULL_PTR.
 
 Auxiliary function to free a link list node. Error codes: OK or NULL_PTR.
*******************************************************************************/
void NodeDestroy (PtNode *pnode)	/* libertação do nó - node releasing */
{
	if (*pnode == NULL) { Error = NULL_PTR; return; }
	free (*pnode);	/* libertação do nó - free the node */
	*pnode = NULL;	/* colocar o ponteiro a nulo - set the pointer to null */
	Error = OK;
}

/*******************************************************************************
 Função auxiliar para destruir uma lista ligada. Valores de erro: OK ou NULL_PTR.
 
 Auxiliary function to destroy a link list. Error codes: OK or NULL_PTR.
*******************************************************************************/
void ListDestroy (PtNode *phead)
{
	PtNode TmpHead = *phead; PtNode Node;

	if (TmpHead == NULL) { Error = NULL_PTR; return; }
	while (TmpHead != NULL)
	{
		Node = TmpHead; TmpHead = TmpHead->PtNext;
		FractionDestroy (&Node->PtElem);
		NodeDestroy (&Node);
	}
	Error = OK; 
}