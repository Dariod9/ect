/*******************************************************************************

 Ficheiro de implementação do Tipo de Dados Abstracto Arvore Binaria de Pesquisa
 de Frações. A estrutura de dados da abp é uma estrutura, constituída pelo campo
 de tipo inteiro Size para armazenar o número de nós existentes na árvore e pelo
 campo Root de tipo ponteiro para a raiz da árvore.
 
 Implementation File of the Abstract Data Type Binary Search Tree of Fractions.
 The bst data structure is a structure, consisting of the integer field Size to
 store the number of nodes stored in the tree and the pointer field Root to point
 to the root of the tree. 

 Autor : António Manuel Adrego da Rocha    Data : Maio de 2019

*******************************************************************************/

#include <stdlib.h>
#include <stdio.h>
#include "abp.h"
#include "fraction.h"
#include "stack.h"
#include "queue.h"

typedef struct abpnode *PtABPNode;
struct abpnode /* estrutura do nó da árvore - bst node */
{
  PtABPNode PtLeft;  /* ponteiro para o no esquerdo da arvore - left subtree */
  PtABPNode PtRight;  /* ponteiro para o no direito da arvore - right subtree */
  PtFraction PtElem;  /* ponteiro para o elemento (de tipo fração) - pointer to fraction */
};

struct abp	/* estrutura da árvore abp - bst data structure */
{
	int Size;	/* numero de elemntos da árvore - tree size */
	PtABPNode Root; /* ponteiro para a raiz da árvore - pointer to bst root */
};

/*********************** Controlo Centralizado de Erro ************************/

static unsigned int Error = OK;    /* inicialização do erro - error initialization */

static char *ErrorMsg[] = {	"sem erro - without error", "abp inexistente - bst nonexistent",
							"memoria esgotada - out of memory", "ponteiro nulo - null pointer",
							"arvore vazia - empty tree", "elemento repetido - repeated element",
                            "elemento inexistente - nonexistent element",
							"ficheiro inexistente - nonexistent file" };

static char *AbnormalErrorMsg = "erro desconhecido - unknown error";

/******* N representa o número de mensagens de erro previstas no módulo *******/

#define N (sizeof (ErrorMsg) / sizeof (char *))

/************************ Alusão às Funções Auxiliares ************************/

static PtABPNode ABPNodeCreate (PtFraction);
static void ABPNodeDestroy (PtABPNode *);
static void DestroyTree (PtABPNode *);
unsigned int HeightTree (PtABPNode);
static PtFraction MaxTree (PtABPNode);
static PtFraction SearchTree (PtABPNode, PtFraction);
static void InsertTree (PtABPNode *, PtFraction);
static void ListInOrder (PtABPNode, PtFraction [], unsigned int *);
static void Balance (PtABP, PtFraction [], int , int);
static void DisplayTree (PtABPNode, unsigned int);
static void PrintTree (PtABPNode);
static void StoreFilePreOrder (PtABPNode, FILE *);
static PtQueue ABPFillQueue (PtABP);

/************** Funções das aulas 9 e 10 - Work of lessons 9 & 10 *************/ 

/* construtor da abp - bst constructor */
PtABP ABPCreate (void)
{


    PtABP tree=(PtABP) malloc (sizeof(struct abp));
     if(tree==NULL){
        Error=NO_MEM;
        return NULL;
    }

    tree->Size=0;
    tree->Root=NULL;

    Error=OK;
	return tree;
}

/* destrutor da abp - bst destructor */
void ABPDestroy (PtABP *ptree)
{
	PtABP Tree = *ptree;
	if (Tree == NULL) { Error = NO_ABP; return; }

	/* invocação da função recursiva que atravessa a árvore e liberta a memória */
	/* invocation of the recursive function that traverse the tree and frees the memory */
	if (Tree->Size != 0) DestroyTree (&Tree->Root);

	free (Tree);
	Error = OK;
	*ptree = NULL;
}

/*******************************************************************************
  Função recursiva que liberta a memória dinânica ocupada pela arvore e elementos.
  Recursive function that frees the dynamic memory occupied by the tree and elements.
*******************************************************************************/
static void DestroyTree (PtABPNode *proot)
{
    if(*proot!=NULL){

            DestroyTree(&(*proot)->PtLeft);
            DestroyTree(&(*proot)->PtRight);
            ABPNodeDestroy(proot);
    }

}


/* pesquisar a abp - bst search */
int ABPSearch (PtABP ptree, PtFraction pelem)
{

    if(ptree==NULL){
        Error=NO_ABP;
        return 0 ;
    }

    if(ptree->Size==0){
        Error=ABP_EMPTY;
        return 0;
    }

    if(pelem==NULL){
        Error=NO_ELEM;
        return 0;
    }

    PtFraction result;
    result=SearchTree(ptree->Root,pelem);

    if(result==NULL){
        Error=NO_ELEM;
     return 0;}

    Error=OK;

	return 1;
}

/*******************************************************************************
  Função recursiva que pesquisa o elemento pretendido na arvore.
  Recursive function that searches the desired element in the tree.
*******************************************************************************/

static PtFraction SearchTree (PtABPNode proot, PtFraction pelem)
{

    if(proot==NULL){ Error=ABP_EMPTY; return 0;}
	if(pelem==NULL){ Error=NO_ELEM; return 0;}

    int res=FractionCompareTo(proot->PtElem,pelem);

    if(res==0){
        Error=OK;
        return proot->PtElem;
    }

    if(res>0)  return SearchTree(proot->PtLeft,pelem);

    return SearchTree(proot->PtRight,pelem);


}

/* inserção não recursiva na abp - non recursive in bst */
void ABPInsert (PtABP ptree, PtFraction pelem)	/*  */
{
	/* Insira o seu código - Insert your code */
	if(ptree == NULL){ Error = NO_ABP; return; }
	if(pelem == NULL){ Error = NULL_PTR; return; }

	PtABPNode newN = ABPNodeCreate(pelem);

	if(newN == NULL) { Error = NO_MEM; return; }

	newN->PtElem = FractionCopy(pelem);
	if(newN->PtElem == NULL) { return; }
	newN->PtLeft = NULL;
	newN->PtRight = NULL;

	PtABPNode node = ptree->Root;
	PtABPNode previous = NULL;

	if(node == NULL)
	{
		ptree->Root = newN;
		ptree->Size++;
		return;
	}

	while(node != NULL){
		int res = FractionCompareTo(node->PtElem, pelem);
		if(res > 0){
			previous = node;
			node = node->PtLeft;
		}else if(res < 0){
			previous = node;
			node = node->PtRight;
		}else{
			Error = REP_ELEM;
			return;
		}
	}
	int res2 = FractionCompareTo(previous->PtElem, pelem);
	if(res2 > 0){
		previous->PtLeft = newN;
	}else{
		previous->PtRight = newN;
	}
	ptree->Size++;
	Error = OK;
}

/* seleção não recursiva do mínimo da abp - non recursive selection of bst minimum */
PtFraction ABPMin (PtABP ptree)
{
	if(ptree==NULL){
		Error=NO_ABP;
		return NULL;
	}

	if(ptree->Root==NULL){
		Error=ABP_EMPTY;
		return NULL;
	}

	PtFraction previous=NULL;
	PtABPNode tmp= ptree->Root;

		while(tmp!=NULL){
			previous=tmp->PtElem;
			tmp=tmp->PtLeft;
		}

	return previous;
}

/* seleção recursiva do máximo da abp - recursive selection of bst maximum */
PtFraction ABPMax (PtABP ptree)
{
	if(ptree==NULL ){
		Error=NO_ABP;
		return NULL;
	}

	if(ptree->Root==NULL){
		Error=ABP_EMPTY;
		return NULL;
	}
	
	return MaxTree(ptree->Root);
}

/*******************************************************************************
  Função recursiva que seleciona o elemento máximo da arvore.
  Recursive function that selects the maximum element of the tree.
*******************************************************************************/

static PtFraction MaxTree (PtABPNode proot)
{
	if(proot->PtRight!=NULL)	return MaxTree(proot->PtRight);
	else return proot->PtElem;
}

/* construtor cópia da abp fazendo uma travessia não recursiva em pré-ordem */
/* bst copy constructor making a non recursive traverse in preorder */
PtABP ABPCopy (PtABP ptree)
{
	PtABP copia;

	if (ptree == NULL) { Error = NO_ABP; return NULL; }
	if((copia = ABPCreate())==NULL){Error = NO_MEM; return NULL;}
	if (ptree->Root == NULL){Error = OK;return copia;}
	

	PtStack Pilha; 
	PtABPNode Node = ptree->Root;
	PtFraction frac;

	if((Pilha = StackCreate(sizeof(PtABPNode))) == NULL){
		Error = NO_MEM;
		ABPDestroy(&copia);
		return NULL;}

	StackPush(Pilha,&Node);
	while (!StackIsEmpty(Pilha))
	{
		StackPop(Pilha,&Node);
		
		if((frac =FractionCopy(Node->PtElem))==NULL){
			Error = NO_MEM;
			ABPDestroy(&copia);
			StackDestroy(&Pilha);
			return NULL;}

		ABPInsert(copia,frac);
		
		
		if(Node->PtRight != NULL) StackPush(Pilha, &Node->PtRight); 
		
		if(Node->PtLeft != NULL) StackPush(Pilha, &Node->PtLeft);
		
	}
	
	Error = OK;
	StackDestroy(&Pilha);
	return copia;
}

/*******************************************************************************
 Função auxiliar para preencher uma fila com os elementos da abp. Cria uma fila 
 com os elementos retirados de cada nível da árvore. Devolve a referência da fila
 criada ou NULL em caso de inexistência de memória. Se a árvore estiver vazia deve
 devolver uma fila vazia. Valores de erro: OK, NO_ABP ou NO_MEM.

 Auxiliar function for filling a queue with the elements of the bst. Creates a queue
 with the elements taken from each level of the tree. Returns a reference to the
 queue or NULL if there isn't enough memory. If the tree is empty it should return 
 an empty queue. Error codes: OK, NO_ABP or NO_MEM.
*******************************************************************************/
static PtQueue ABPFillQueue (PtABP ptree)
{
	/* Insira o seu c�digo - Insert your code */
	PtQueue fila = QueueCreate(sizeof(PtFraction*));
	PtQueue tmp = QueueCreate(sizeof(PtABPNode));
	if (fila == NULL || tmp == NULL) { Error = NO_MEM; return NULL; }

	if(QueueEnqueue(tmp, &(ptree->Root)) != OK) {
		Error = NO_MEM;
		QueueDestroy(&fila);
		QueueDestroy(&tmp);
		return NULL; }

	PtABPNode topo;
	while(!QueueIsEmpty(tmp)){
		QueueDequeue(tmp, &topo);
		if(QueueEnqueue(fila, &(topo->PtElem)) != OK) { Error = NO_MEM; QueueDestroy(&fila); QueueDestroy(&tmp); return NULL; }

		if(topo->PtLeft != NULL)
		{
			if(QueueEnqueue(tmp, &(topo->PtLeft)) != OK) { Error = NO_MEM; QueueDestroy(&fila); QueueDestroy(&tmp); return NULL; }
		}

		if(topo->PtRight != NULL)
		{
			if(QueueEnqueue(tmp, &(topo->PtRight)) != OK) { Error = NO_MEM; QueueDestroy(&fila); QueueDestroy(&tmp); return NULL; }
		}
	}

	Error = OK;
	return fila;
}
/* Reunião de duas abps usando a função ABPFillQueue - Reunion of two bsts using ABPFillQueue */
void ABPReunion (PtABP ptree1, PtABP ptree2)
{
	/* Insira o seu código - Insert your code */
	if(ptree1 == NULL || ptree2 == NULL){ Error = NO_ABP; return; }
	
	PtQueue fila = ABPFillQueue(ptree2);
	PtFraction frac;
	while(!QueueIsEmpty(fila)){
		QueueDequeue(fila, &frac);
		ABPInsert(ptree1, frac);
	}
	QueueDestroy(&fila);
	Error = OK;
}

/* Diferença de duas abps usando a função ABPFillQueue - Difference of two bsts using ABPFillQueue */
void ABPDifference (PtABP ptree1, PtABP ptree2)
{

	/* Insira o seu código - Insert your code */
	if(ptree1 == NULL || ptree2 == NULL){ Error = NO_ABP; return; }

	PtQueue fila = ABPFillQueue(ptree2);
	if(fila == NULL){ Error=NO_MEM; return;}

	PtFraction frac;
	while(!QueueIsEmpty(fila)){
		QueueDequeue(fila, &frac);
		ABPDelete(ptree1, frac);
	}
	QueueDestroy(&fila);
	Error = OK;

}

/* Interseção de duas abps usando a função ABPFillQueue - Intersection of two bsts using ABPFillQueue */
void ABPIntersection (PtABP ptree1, PtABP ptree2)
{
/* Insira o seu código - Insert your code */
	if(ptree1 == NULL || ptree2 == NULL){ Error = NO_ABP; return; }

	PtQueue fila = ABPFillQueue(ptree1);
	if(fila == NULL) return;

	PtFraction frac;
	while(!QueueIsEmpty(fila)){
		
		QueueDequeue(fila, &frac);

		if(!ABPSearch(ptree2, frac))	ABPDelete(ptree1, frac);
		
	}
	QueueDestroy(&fila);
	Error = OK;
}

/******************************************************************************
 Funções e funções internas auxiliares que já estão implementadas (que podem ser
 usadas) mas que em caso algum podem ser alteradas.
 
 Functions and auxiliary internal functions that are already implemented (that 
 can be used) but that cannot be changed.
******************************************************************************/

/*************************** Definição das Funções ****************************/ 

int ABPErrorCode (void)
{
    return Error;
}

/******************************************************************************/

char *ABPErrorMessage (void)
{
    if (Error < N) return ErrorMsg[Error];
    else return AbnormalErrorMsg;    /* não há mensagem de erro - no error message */
}

/******************************************************************************/

int ABPEmpty (PtABP ptree)
{
	if (ptree == NULL) { Error = NO_ABP; return 0; }
	else { Error = OK; return ptree->Root == NULL; }
}

/******************************************************************************/

unsigned int ABPSize (PtABP ptree)                                    
{
	if (ptree == NULL) { Error = NO_ABP; return 0; }
	else { Error = OK; return ptree->Size; }
}

/******************************************************************************/

unsigned int ABPHeight (PtABP ptree)
{
	if (ptree == NULL) { Error = NO_ABP; return 0; }
	else { Error = OK; return HeightTree (ptree->Root); }
}

/******************************************************************************/

void ABPDelete (PtABP ptree, PtFraction pelem)	/* remoção repetitiva */
{
	if (ptree == NULL) { Error = NO_ABP; return ; } /* arvore inexistente */
	if (ptree->Size == 0) { Error = ABP_EMPTY; return ; }	/* arvore vazia */
	if (pelem == NULL) { Error = NULL_PTR; return ; } /* ponteiro invalido */

	PtABPNode Del = ptree->Root, Prev = NULL, Node, Temp, PrevTemp;

	while (Del != NULL && !FractionEquals (Del->PtElem, pelem))
	{			/* travessia até encontrar o elemento a remover */
		Prev = Del;
		if (FractionCompareTo (Del->PtElem, pelem) > 0) Del = Del->PtLeft;
		else Del = Del->PtRight;
	}

	if (Del == NULL) { Error = NO_ELEM; return; }	/* elemento inexistente na arvore */
	Node = Del;

	Error=OK;
	if (Node->PtRight == NULL) Node = Node->PtLeft;	/* à esquerda */
	else	if (Node->PtLeft == NULL) Node = Node->PtRight;	/* à direita */
			else	/* com subarvores esquerda e direita */
			{	/* procurar menor elemento da subarvore direita */
				Temp = Node->PtRight; PrevTemp = Node;
				while (Temp->PtLeft != NULL)
				{ PrevTemp = Temp; Temp = Temp->PtLeft; }

				/* substituir pelo menor elemento */
				FractionSet (Node->PtElem, FractionGetNumerator (Temp->PtElem), FractionGetDenominator (Temp->PtElem));
				
				/* desligar o menor elemento e ajustar as ligações */
				if (PrevTemp == Node) PrevTemp->PtRight = Temp->PtRight;
				else PrevTemp->PtLeft = Temp->PtRight;
				ABPNodeDestroy (&Temp);
				ptree->Size--;
				return;
			}
	/* ajustar o pai do elemento removido que só tem um filho */
	if (Del == ptree->Root) ptree->Root = Node;	/* se foi eliminado da raiz */
	else	if (Prev->PtLeft == Del) Prev->PtLeft = Node;
			else Prev->PtRight = Node;
	ABPNodeDestroy (&Del);
	ptree->Size--;
}

/******************************************************************************/

PtABP ABPCreateFile (char *nomef)
{
    PtABP ABP; FILE *PtF; PtFraction Fraction;
	unsigned int NElem, I; int Num, Den;

    /* abertura com validacao do ficheiro para leitura - opening the file */
    if ( (PtF = fopen (nomef, "r")) == NULL) { Error = NO_FILE; return NULL; }

    ABP = ABPCreate ();    /* cria a arvore vazia - create an empty tree */

    /* leitura do número de elementos do ficheiro - read the number of elements */
    fscanf (PtF, "%u", &NElem);
    if (NElem < 1) { Error = OK; fclose (PtF); return NULL; }

    /* leitura do ficheiro linha a linha - read the file line by line */
    for (I = 0; I < NElem; I++)
    {
    	/* ler a fração do ficheiro - read fraction from file */
        fscanf (PtF, "%d %d", &Num, &Den);

        /* criar a fração - create fraction */
        Fraction = FractionCreate (Num, Den);
        if (FractionErrorCode () == NO_MEM)
        { ABPDestroy (&ABP); Error = NO_MEM; return NULL; }

        /* inserir a fração na abp - insert fraction in bst */
        ABPInsertRec (ABP, Fraction);
        if (ABPErrorCode () == NO_MEM)
        { ABPDestroy (&ABP); Error = NO_MEM; return NULL; }
    }

    fclose (PtF);  /* fecho do ficheiro - close file */

    Error = OK;
    return ABP;  /* devolve a arvore criada - return the tree */
}

/******************************************************************************/

void ABPInsertRec (PtABP ptree, PtFraction pelem)  /* inserção recursiva */
{
	if (ptree == NULL) { Error = NO_ABP; return ; } /* arvore inexistente */
	if (pelem == NULL) { Error = NULL_PTR; return ; } /* elemento inexistente */

	InsertTree (&ptree->Root, pelem);
	if (ABPErrorCode () == OK) ptree->Size++;
}

/******************************************************************************/

void ABPStoreFile (PtABP ptree, char *nomef)
{
    FILE *PtF; unsigned int NElem;

	if (ptree == NULL) { Error = NO_ABP; return ; }
	if (ptree->Root == NULL) { Error = ABP_EMPTY; return ; }

    /* abertura com validacao do ficheiro para escrita */
    if ((PtF = fopen (nomef, "w")) == NULL) { Error = NO_FILE; return ; }

    NElem = ABPSize (ptree);
    /* escrita do número de elementos da arvore no ficheiro */
    fprintf (PtF, "%u\n", NElem);

    /* escrita dos elementos da arvore no ficheiro */
    StoreFilePreOrder (ptree->Root, PtF);

    fclose (PtF);  /* fecho do ficheiro */
    Error = OK;
}

/******************************************************************************/

PtABP ABPBalance (PtABP ptree)
{
	PtFraction *List; PtABP NewABP;
	unsigned int Count = 0, n = ABPSize (ptree);	/* número de nos */

	if (ptree == NULL) { Error = NO_ABP; return NULL; }	/* a arvore não existe */
	if (ptree->Size == 0) { Error = ABP_EMPTY; return NULL; }	/* a arvore está vazia */
	if ((NewABP = ABPCreate ()) == NULL) { Error = NO_MEM; return NULL; }
				/* criar a sequência */
	if ((List = (PtFraction *) calloc (n, sizeof (PtFraction))) == NULL)
	{ Error = NO_MEM ; ABPDestroy (&NewABP); return NULL; }	

    Error = OK;
	ListInOrder (ptree->Root, List, &Count);	/* preencher a sequência */
	Balance (NewABP, List, 0, n-1);	/* balancear a arvore */
	if (Error == NO_MEM) { free (List); ABPDestroy (&NewABP); return NULL; }

	free (List);	/* libertar a sequência */
	return NewABP;
}

/******************************************************************************/

void ABPDisplay (PtABP ptree)
{
	if (ptree == NULL) { Error = NO_ABP; return; }
	if (ptree->Root == NULL) { Error = ABP_EMPTY; return; }

	DisplayTree (ptree->Root, 1);
	Error = OK;
}

/******************************************************************************/

void ABPPrint (PtABP ptree)
{
	if (ptree == NULL) { Error = NO_ABP; return; }
	if (ptree->Root == NULL) { Error = ABP_EMPTY; return; }

	PrintTree (ptree->Root);
	Error = OK;
}

/******************************************************************************/

int ABPEquals (PtABP ptree1, PtABP ptree2) /* verifica se duas arvores sao iguais */
{
    PtQueue Queue; int Enqueue;

    if (ptree1 == NULL || ptree2 == NULL) { Error = NO_ABP; return 0; }
	if (ptree1->Size != ptree2->Size) { Error = OK; return 0; } 
	
    if ((Queue = QueueCreate (sizeof (PtABPNode))) == NULL) { Error = NO_MEM; return 0; }
	
	/* Serão percorridos todos os elementos da 2ª árvore e, */
	/* se não pertencerem à 1ª então as árvores não são iguais */ 
	PtABPNode Node = ptree2->Root;
    Enqueue = QueueEnqueue (Queue, &Node);
	if (Enqueue == NO_MEM)
	{ Error = NO_MEM ; QueueDestroy (&Queue); return 0; }

    while (!QueueIsEmpty (Queue))
    {
        QueueDequeue (Queue, &Node);

		if (SearchTree (ptree1->Root, Node->PtElem) == NULL)
		{ QueueDestroy (&Queue); Error = OK; return 0; }
		
        if (Node->PtLeft != NULL)
		{
			Enqueue = QueueEnqueue (Queue, &Node->PtLeft);
			if (Enqueue == NO_MEM)
			{ Error = NO_MEM; QueueDestroy (&Queue); return 0; } 			
		}
        if (Node->PtRight != NULL)
		{
			Enqueue = QueueEnqueue (Queue, &Node->PtRight);
			if (Enqueue == NO_MEM)
			{ Error = NO_MEM; QueueDestroy (&Queue); return 0; } 			
		}		
		
    }

    QueueDestroy (&Queue);
	Error=OK;
	return 1;
}

/************************* Funções internas auxiliares ************************/

/*******************************************************************************
  Função que cria o nó da arvore binária de pesquisa.
*******************************************************************************/
static PtABPNode ABPNodeCreate (PtFraction pelem)	/* alocação do no compacto */
{
	PtABPNode Node;

	if ((Node = (PtABPNode) malloc (sizeof (struct abpnode))) == NULL)
	{ Error = NO_MEM; return NULL; }

	Node->PtElem = pelem;	/* copiar a informação */
	Node->PtLeft = NULL;	/* apontar para a esquerda para NULL */
	Node->PtRight = NULL;	/* apontar para a direita para NULL */

	Error=OK;
	return Node;
}

/*******************************************************************************
  Função que liberta a memoria do nó da arvore binária de pesquisa.
*******************************************************************************/
static void ABPNodeDestroy (PtABPNode *pelem)	/* libertar o no da abp */
{
	FractionDestroy (&(*pelem)->PtElem);	/* libertar o elemento */
	free (*pelem);	/* libertar o no */
	*pelem = NULL;	/* colocar o ponteiro a nulo */
}

/*******************************************************************************
  Função recursiva auxiliar que insere efectivamente um no na arvore.
*******************************************************************************/
static void InsertTree (PtABPNode *proot, PtFraction pelem)
{
	Error = OK;

	if (*proot == NULL)	/* inserir o elemento */
	{ if ((*proot = ABPNodeCreate (pelem)) == NULL) return; }
	else if (FractionCompareTo ((*proot)->PtElem, pelem) > 0)	/* subarvore esquerda */
				InsertTree (&(*proot)->PtLeft, pelem);
			else if (FractionCompareTo ((*proot)->PtElem, pelem) < 0)	/* subarvore direita */
						InsertTree (&(*proot)->PtRight, pelem);
					else { Error = REP_ELEM; return; }	/* o elemento já existe */
}

/*******************************************************************************
  Função recursiva que escreve os elementos da arvore em pre-ordem num ficheiro.
*******************************************************************************/
static void StoreFilePreOrder (PtABPNode proot, FILE *fich)
{
    if (proot != NULL)
    {
        fprintf (fich, "%d %d\n", FractionGetNumerator (proot->PtElem), FractionGetDenominator (proot->PtElem));
        StoreFilePreOrder (proot->PtLeft, fich);
        StoreFilePreOrder (proot->PtRight, fich);
    }
}

/*******************************************************************************
  Função recursiva que armazena os elementos da arvore em ordem num array.
*******************************************************************************/
static void ListInOrder (PtABPNode proot, PtFraction plist[], unsigned int *pcount)
{
	if (proot != NULL)
	{
		ListInOrder (proot->PtLeft, plist, pcount);	/* arvore esquerda */
		plist[(*pcount)++] = proot->PtElem;	/* colocar elemento */
		ListInOrder (proot->PtRight, plist, pcount);	/* arvore direita */
	}
}

/*******************************************************************************
  Função recursiva que insere os elementos de uma lista numa arvore de modo que
  ela fique balanceada.
*******************************************************************************/
static void Balance (PtABP ptree, PtFraction plist[], int pbegin, int pend)
{
	unsigned int Median; PtFraction Fraction;

	if (pbegin <= pend)
	{
		Median = (pbegin + pend) >> 1;	/* (pbegin+pend)/2 */
		Fraction = FractionCopy (plist[Median]);
		if (Fraction == NULL) { Error = NO_MEM; return ; }
		ABPInsertRec (ptree, Fraction);	/* inserir elemento central */
		if (Error == NO_MEM) return ;
		Balance (ptree, plist, pbegin, Median-1);	/* subarvore esquerda */
		Balance (ptree, plist, Median+1, pend);	/* subarvore direita */
	}
}

/*******************************************************************************
  Função recursiva que escreve os elementos da arvore de forma hierarquica.
*******************************************************************************/
static void DisplayTree (PtABPNode proot, unsigned int plevel)
{
	unsigned int i;

	if (proot == NULL)
	{
		for (i = 0; i < plevel; i++) printf ("\t");
		printf ("*\n");
        return;
	}

	DisplayTree (proot->PtRight, plevel+1);

	for (i = 0; i < plevel; i++) printf ("\t");
	
	char *Str = FractionToString (proot->PtElem);
	printf ("%s\n", Str);	/* imprimir o elemento */
	free (Str);

	DisplayTree (proot->PtLeft, plevel+1);
}


/*******************************************************************************
  Função recursiva que escreve os elementos da arvore por ordem crescente.
*******************************************************************************/
static void PrintTree (PtABPNode proot)
{
	if (proot != NULL)
	{
		PrintTree (proot->PtLeft);
		char *Str = FractionToString (proot->PtElem);
		printf ("%s\t", Str);	/* imprimir o elemento */
		free (Str);
		PrintTree (proot->PtRight);
	}
}

/*******************************************************************************
  Função recursiva que calcula a altura de uma arvore.
*******************************************************************************/
unsigned int HeightTree (PtABPNode proot)
{
	unsigned int LeftHeight, RightHeight;

	if (proot == NULL) { Error = ABP_EMPTY; return 0; } /* no externo no nível 0 */
	else
	{
		LeftHeight = HeightTree (proot->PtLeft);	/* subarvore esquerda */
		RightHeight = HeightTree (proot->PtRight);	/* subarvore direita */

		Error = OK;
		if (LeftHeight > RightHeight) return LeftHeight + 1;
		else return RightHeight + 1;
	}
}