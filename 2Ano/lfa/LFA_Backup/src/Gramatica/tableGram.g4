grammar tableGram;

@parser::header{
    import java.util.*;
}

@parser::members{
    public static Map<String,Variable> mapa = new HashMap<>();
    public static ArrayList<Variable> tables =  new ArrayList<>();
}

main: stat* EOF;

stat: declaracao        #declareStat
      |atribuicao       #atrStat
      |voidMethods         #methodStat
      ;

declaracao: tipo ID
          ;

tipo:  'String'         #stringDeclaring
    |  'Integer'            #intDeclaring
    |  'Double'         #doubleDeclaring
    |  'table'         #tableDeclaring
    |  'table2'         #table2Declaring
    ;


atribuicao: ID '=' expr;

expr: nonVoidMethods                    #method
    | numExpr                   #numExpression
    | stringExpr                #stringGet
    ;

numExpr returns [String value]:
      e1=numExpr op=('*'| '/' ) e2=numExpr               #multDivMath
     | e1=numExpr op=('+' | '-') e2=numExpr                #addSubMath
     | '(' numExpr ')'                                #parenMath
     |    INT                                            #intMath
     |    DOUBLE                                         #doubleMath
     |    ID                                             #idMath
     ;

stringExpr: STRING;


nonVoidMethods:    newTable                                        #newTableMethod
                  | copyTable                                       #copyTableMethod
                  | getElem                                         #getElemMethod

                  ;


voidMethods:       removeTable                                     #removeTableMethod
                  | readTable                                       #readTableMethod

                  | addRow                                          #addRowMethod
                  | copyRow                                          #copyRowMethod
                  | newRow                                          #newRowMethod
                  | clearRow                                        #clearRowMethod

                  |insertElem                                       #insertElemMethod
                  |removeElem                                       #removeElemMethod
                  | addColumn                                       #addColumnMethod
                  | newColumn                                       #newColumnMethod
                  | copyColumn                                      #copyColumnMethod
                  | copyRow                                         #copyRowMethod
                  | clearColumn                                    #clearColumnMethod
                  | printTable                                      #printTableMethod
                  | printRow                                        #printRowMethod
                  | printColumn                                     #printColumnMethod
                  |export                                          #exportMethod
                  ;
      


newTable:   'createTable'                              #createDefaultTable
            | 'createTable' INT INT                    #createCustomTable
            | 'createStringTable' ID		          #createType2Table
            ;

copyTable:  'copy' ID;


insertElem : 'insert' ID '('INT','INT')' ID        #insertElem1
            |'insert' ID '('ID','ID')'   ID        #insertElem2
            ;

removeElem: 'remove' '('INT','INT')' ID   	   #removeElem1	
	    |'removeType2' '('ID','ID')' ID	   #removeElem2
		;
		
getElem: 'get' '('INT ',' INT ')' ID       #getElem1       //get (2,3) tabela3 (tabelas tipo 1)
        |'get' '('ID ',' ID ')' ID       #getElem2       //get (DARIO,PESO) tabela3 (tabelas tipo 2)
        ;


readTable:  ID '->' 'readType1' ID'.csv'     #read1
          | ID '->' 'readType2' ID'.csv'     #read2
          ;

removeTable: 'deleteTable' ID;


//FILAS

addRow: 'addRow' INT ID '->' INT ID      #addRow1       // Somar linhas de tabelas tipo 1
       |'addRow' ID ID  '->' ID  ID        #addRow2     // Somar linhas de tabelas tipo 2
       ;

copyRow: 'copyRow' INT ID '->' INT ID      #copyRow1  // copyrow 10 tabela2 -> 5 tabela1 (adiciona fila da posiçao 10 na tabela 2 na posiçao5  )
       |'copyRow' ID ID  '->' ID          #copyRow2     // copyRow pesos tabela2 -> tabela3
       ;

newRow:  'newRow'  '->' INT ID   #newRowSpecific    //Adiciona uma nova fila vazia na posição especificada
       | 'newRow'  '->' ID       #newRowSimple  //Adicionar uma nova fila vazia, no fundo
       | 'newRow'  '->' ID  ID   #newRowTable2      //newRow -> Peso table2
       ;


clearRow: 'clearRow' INT ID #clearRow1  // deleteRow -> 3 tabela3 (torna a 3ª numa fila de nulls)
	  |'clearRow' ID ID		#clearRow2
		 ;

//COLUNAS



addColumn: 'addColumn' INT ID '->' INT ID    #addColumn1// Somar colunas de tabelas tipo 1
          |'addColumn' ID ID  '->' ID  ID    #addColumn2  // Somar colunas de tabelas tipo 2
          ;

copyColumn: 'copyColumn' INT ID '->' INT ID   #copyColumn1// copia a coluna 3 tabela2 ->  5 tabela1 (                               A GRAMATICA NÂO ESTA A ACEITAR ESTAS 2
          |'copyColumn' ID ID  '->' ID      #copyColumn2 // copia a coluna  pesos tabela2 -> tabela1
          ;

newColumn: 'newColumn' '->' INT ID #newColumnSpecific //acrescenta coluna vazia na posição específicada
          |'newColumn2 ' ID'->' ID '('ID')'  #newColumnTable2 //newColumn -> Peso int tabela2
          |'newColumn' '->' ID     #newColumnSimple  //acrescente coluna vazia no fundo
          ;


clearColumn: 'clearColumn' INT ID 	#clearColumn1  // deleteColumn -> 3 tabela3 (torna a 3ª numa Coluna de nulls)
		|'clearColumn' ID ID		#clearColumn2
			;


//FICHEIROS E PRINTS

export: 'save' ID 'to' ID'.csv';

printTable: 'print' ID;

printRow : 'printRow' INT ID        #printRow1   //print a uma linha de tabelas tipo 1
          |'printRow' ID ID         #printRow2  //print a uma linha de tabelas tipo 2
          ;

printColumn : 'printColumn' INT ID        #printColumn1   //print a uma coluna de tabelas tipo 1
          |'printColumn' ID ID         #printColumn2  //print a uma coluna de tabelas tipo 2
          ;


ID :  [a-zA-Z][a-zA-Z_0-9]*;
INT: [0-9]+;
DOUBLE: [0-9]+'.'[0-9]+;
STRING: ('"' (~'"')* '"');
COMMENT_Line: '//' .*? '\n' -> skip; 
COMMENT_Section: '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;
ERROR : .;
