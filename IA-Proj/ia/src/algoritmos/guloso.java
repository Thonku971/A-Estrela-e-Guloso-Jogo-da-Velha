package algoritmos;

import java.util.ArrayList;
import java.util.Random;

public class guloso {

	
static ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();	
static int[] valores = {0, 0, 0, 0, 0, 0, 0, 0};
static int[] posX = {0, 0};
static int[] posO = {0, 0};
static int rodada = 0;

public static void cria() {        
		          
		  int numberOfLists = 3;        
		  for (int i = 0; i < numberOfLists; i++) {         
			  listOfLists.add(new ArrayList<>());       
			  }        
		          
		  listOfLists.get(0).add(0,0);
		  listOfLists.get(0).add(0,0);
		  listOfLists.get(0).add(0,0);
		  listOfLists.get(1).add(0,0);
		  listOfLists.get(1).add(0,0);
		  listOfLists.get(1).add(0,0);
		  listOfLists.get(2).add(0,0);
		  listOfLists.get(2).add(0,0);
		  listOfLists.get(2).add(0,0);
		  System.out.println("Criada \n" + listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
	
}


public static void iniciaX() {

	Random gerador = new Random();

	int X = gerador.nextInt(3);
	int Y = gerador.nextInt(3);
	
	listOfLists.get(X).set(Y,1);
	posX[0]=X;
	posX[1]=Y;
	rodada ++;
	 // System.out.println("Posição O - X: "+posX[0]+" Y: "+ posX[1]+"\n");
	System.out.println("Rodada :  " + rodada + " | vez do X"); 
	System.out.println("Inicia X \n" + listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
}

public static void iniciaO() {

	Random gerador = new Random();

	int X = gerador.nextInt(3);
	int Y = gerador.nextInt(3);
		while(listOfLists.get(X).get(Y) != 0)
		{
			 X = gerador.nextInt(3);
			 Y = gerador.nextInt(3);
		}	
		posO[0]=X;
		posO[1]=Y;
	  listOfLists.get(X).set(Y,2);
	  rodada ++;
	//  System.out.println("Posição O - X: "+posO[0]+" Y: "+ posO[1]+"\n");
		System.out.println("Rodada :  " + rodada + " | vez do O");
	    System.out.println("Inicia O \n" + listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
}

public static void heuristica() {

	for(int x = 0; x < 3; x++)
	{
		for(int y = 0; y < 3; y++) 
		{
			if((listOfLists.get(x).get(y)!= 0) && (x == 0))
			{
				valores[0]++;
		//		System.out.println("valor 0 : \t" + valores[0]+ "\n");
			}
			if((listOfLists.get(x).get(y)!= 0) && (x == 1))
			{
				valores[1]++;
		//		System.out.println("valor 1 : \t" + valores[1]+ "\n");
			}
			if((listOfLists.get(x).get(y)!= 0) && (x == 2))
			{
				valores[2]++;
		//		System.out.println("valor 2 : \t" + valores[2]+ "\n");
			}
			if((listOfLists.get(x).get(y)!= 0) && (y == 0))
			{
				valores[3]++;
		//		System.out.println("valor 3 : \t" + valores[3]+ "\n");
			}
			if((listOfLists.get(x).get(y)!= 0) && (y == 1))
			{
				valores[4]++;
			//	System.out.println("valor 4 : \t" + valores[4]+ "\n");
			}
			if((listOfLists.get(x).get(y)!= 0) && (y == 2))
			{
				valores[5]++;
		//		System.out.println("valor 5 : \t" + valores[5]+ "\n");
			}
			if((listOfLists.get(x).get(y)!= 0) && (x == y))
			{
				valores[6]++;
			//	System.out.println("valor 6 : \t" + valores[6]+ "\n");
				if(x == 1)
				{
					valores[7]++;
			//		System.out.println("valor 7 : \t" + valores[7]+ "\n");
				}
			}
			if((listOfLists.get(x).get(y)!= 0) && ((x == 0 && y == 2)||(x == 2 && y == 0)))
			{
				valores[7]++;
			//	System.out.println("valor 7 : \t" + valores[7]+ "\n");
			}
		}
	} 
}


public static void verificar() {
	int[] verifica = {0, 0, 0};
	int[] verificaX = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	int[] verificaO = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	for(int x = 0; x < 3; x++)
	{
		for(int y = 0; y < 3; y++) 
		{
			if((listOfLists.get(x).get(y) == 0) )
			{
				verifica[0]++;
			//	System.out.println("Em branco : \t" + verifica[0]+ "\n");
			}
			if((listOfLists.get(x).get(y)!= 0) && (x == 0))
			{

				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
			//		System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[0]++;
			//		System.out.println(" X  na linha 0: \t" + verificaX[0]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
			//		System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[0]++;
			//		System.out.println(" O  na linha 0: \t" + verificaO[0]+ "\n");
				}
			}
			if((listOfLists.get(x).get(y)!= 0) && (x == 1))
			{
							
				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
			//		System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[1]++;
			//		System.out.println(" X na linha 1 : \t" + verificaX[1]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
			//		System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[1]++;
			//		System.out.println(" O na linha 1 : \t" + verificaO[1]+ "\n");
				}
			}
			if((listOfLists.get(x).get(y)!= 0) && (x == 2))
			{
				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
			//		System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[2]++;
			//		System.out.println(" X na linha 2  : \t" + verificaX[2]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
			//		System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[2]++;
			//		System.out.println(" O na linha 2 : \t" + verificaO[2]+ "\n");
				}
			}
			if((listOfLists.get(x).get(y)!= 0) && (y == 0))
			{
				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
			//		System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[3]++;
			//		System.out.println(" X na coluna 0: \t" + verificaX[3]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
			//		System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[3]++;
			//		System.out.println(" O na coluna 0 : \t" + verificaO[3]+ "\n");
				}
			}
			if((listOfLists.get(x).get(y)!= 0) && (y == 1))
			{
				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
			//		System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[4]++;
			//		System.out.println(" X na coluna 1: \t" + verificaX[4]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
			//		System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[4]++;
			//		System.out.println(" O na coluna 1: \t" + verificaO[4]+ "\n");
				}
			}
			if((listOfLists.get(x).get(y)!= 0) && (y == 2))
			{
				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
			//		System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[5]++;
			//		System.out.println(" X na coluna 2: \t" + verificaX[5]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
		//			System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[5]++;
	//				System.out.println(" O na coluna 2: \t" + verificaO[5]+ "\n");
				}	
			}
			if((listOfLists.get(x).get(y)!= 0) && (x == y))
			{
				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
			//		System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[6]++;
		//			System.out.println(" X  na diagonal : \t" + verificaX[6]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
			//		System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[6]++;
			//		System.out.println(" O na diagonal : \t" + verificaO[6]+ "\n");
				}	
				if(x == 1)
				{
					if(listOfLists.get(x).get(y) == 1)
					{
						verifica[1]++;
			//			System.out.println(" X : \t" + verifica[1]+ "\n");
						verificaX[7]++;
			//			System.out.println(" X : na diagonal -1\t" + verificaX[7]+ "\n");
					}
					if(listOfLists.get(x).get(y) == 2)
					{
						verifica[2]++;
			//			System.out.println(" O : \t" + verifica[2]+ "\n");
						verificaO[7]++;
			//			System.out.println(" O : na diagonal -1\t" + verificaO[7]+ "\n");
					}	
				}
			}
			if((listOfLists.get(x).get(y)!= 0) && ((x == 0 && y == 2)||(x == 2 && y == 0)))
			{
				if(listOfLists.get(x).get(y) == 1)
				{
					verifica[1]++;
				//	System.out.println(" X : \t" + verifica[1]+ "\n");
					verificaX[7]++;
				//	System.out.println(" X na diagonal -1: \t" + verificaX[7]+ "\n");
				}
				if(listOfLists.get(x).get(y) == 2)
				{
					verifica[2]++;
				//	System.out.println(" O : \t" + verifica[2]+ "\n");
					verificaO[7]++;
				//	System.out.println(" O na diagonal -1: \t" + verificaO[7]+ "\n");
				}	
			}
		}
	}
	
	for(int a = 0; a<9; a++)
	{
		if(verificaX[a] == 3)
		{
			System.out.println("X ganhou \n" + listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
			System.exit(0);
		}
	}
	for(int a = 0; a<9; a++)
	{
		if(verificaO[a] == 3)
		{
			System.out.println("O ganhou \n" + listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
			System.exit(0);
		}
	}
	if(verifica[0] == 0)
	{
		System.out.println("Deu Velha \n" + listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
		System.exit(0);
	}
	
}


public static void altera() {

	int maior = 0, num = 0;
//	System.out.println("Altera" );
	for(int a = 0; a<8;a++)
	{
	//	System.out.println("Valores :" + valores[a] );
	//	System.out.println("Altera2" );
		if((valores[a]>num) && (valores[a] < 3))
		{
			maior = a; 
			num = valores[a];
	//		System.out.println("Maior :" + maior );
	//		System.out.println("Maior valor :" + valores[a] );
	//		System.out.println("num :" + num );
		}
	}
	if(rodada % 2 == 0)
	{
		System.out.println("Rodada :  " + rodada + " | vez do X");
		if(maior == 0)
		{
			if(listOfLists.get(0).get(0) == 0)
			{
				  listOfLists.get(0).set(0,1);	
			}
			else if(listOfLists.get(0).get(1) == 0)
			{
				  listOfLists.get(0).set(1,1);	
			}
			else if(listOfLists.get(0).get(2) == 0)
			{
				  listOfLists.get(0).set(2,1);	
			}
		}
		if(maior == 1)
		{
			if(listOfLists.get(1).get(0) == 0)
			{
				  listOfLists.get(1).set(0,1);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,1);	
			}
			else if(listOfLists.get(1).get(2) == 0)
			{
				  listOfLists.get(1).set(2,1);	
			}
		}
		if(maior == 2)
		{
			if(listOfLists.get(2).get(0) == 0)
			{
				  listOfLists.get(2).set(0,1);	
			}
			else if(listOfLists.get(2).get(1) == 0)
			{
				  listOfLists.get(2).set(1,1);	
			}
			else if(listOfLists.get(2).get(2) == 0)
			{
				  listOfLists.get(2).set(2,1);	
			}
		}
		if(maior == 3)
		{
			if(listOfLists.get(0).get(0) == 0)
			{
				  listOfLists.get(0).set(0,1);	
			}
			else if(listOfLists.get(1).get(0) == 0)
			{
				  listOfLists.get(1).set(0,1);	
			}
			else if(listOfLists.get(2).get(0) == 0)
			{
				  listOfLists.get(2).set(0,1);	
			}
		}
		if(maior == 4)
		{
			if(listOfLists.get(0).get(1) == 0)
			{
				  listOfLists.get(0).set(1,1);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,1);	
			}
			else if(listOfLists.get(2).get(1) == 0)
			{
				  listOfLists.get(2).set(1,1);	
			}	
		}
		if(maior == 5)
		{
			if(listOfLists.get(0).get(2) == 0)
			{
				  listOfLists.get(0).set(2,1);	
			}
			else if(listOfLists.get(1).get(2) == 0)
			{
				  listOfLists.get(1).set(2,1);	
			}
			else if(listOfLists.get(2).get(2) == 0)
			{
				  listOfLists.get(2).set(2,1);	
			}
		}
		if(maior == 6)
		{

			if(listOfLists.get(0).get(0) == 0)
			{
				  listOfLists.get(0).set(0,1);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,1);	
			}
			else if(listOfLists.get(2).get(2) == 0)
			{
				  listOfLists.get(2).set(2,1);	
			}	
		}
		if(maior == 7)
		{

			if(listOfLists.get(0).get(2) == 0)
			{
				  listOfLists.get(0).set(2,1);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,1);	
			}
			else if(listOfLists.get(2).get(0) == 0)
			{
				  listOfLists.get(2).set(0,1);	
			}
		}
		System.out.println(listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
		
	}
	if(rodada % 2 != 0)
	{
		System.out.println("Rodada :  " + rodada + " | vez do O");
		
		if(maior == 0)
		{
			if(listOfLists.get(0).get(0) == 0)
			{
				  listOfLists.get(0).set(0,2);	
			}
			else if(listOfLists.get(0).get(1) == 0)
			{
				  listOfLists.get(0).set(1,2);	
			}
			else if(listOfLists.get(0).get(2) == 0)
			{
				  listOfLists.get(0).set(2,2);	
			}
		}
		if(maior == 1)
		{
			if(listOfLists.get(1).get(0) == 0)
			{
				  listOfLists.get(1).set(0,2);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,2);	
			}
			else if(listOfLists.get(1).get(2) == 0)
			{
				  listOfLists.get(1).set(2,2);	
			}
		}
		if(maior == 2)
		{
			if(listOfLists.get(2).get(0) == 0)
			{
				  listOfLists.get(2).set(0,2);	
			}
			else if(listOfLists.get(2).get(1) == 0)
			{
				  listOfLists.get(2).set(1,2);	
			}
			else if(listOfLists.get(2).get(2) == 0)
			{
				  listOfLists.get(2).set(2,2);	
			}
		}
		if(maior == 3)
		{
			if(listOfLists.get(0).get(0) == 0)
			{
				  listOfLists.get(0).set(0,2);	
			}
			else if(listOfLists.get(1).get(0) == 0)
			{
				  listOfLists.get(1).set(0,2);	
			}
			else if(listOfLists.get(2).get(0) == 0)
			{
				  listOfLists.get(2).set(0,2);	
			}
		}
		if(maior == 4)
		{
			if(listOfLists.get(0).get(1) == 0)
			{
				  listOfLists.get(0).set(1,2);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,2);	
			}
			else if(listOfLists.get(2).get(1) == 0)
			{
				  listOfLists.get(2).set(1,2);	
			}	
		}
		if(maior == 5)
		{
			if(listOfLists.get(0).get(2) == 0)
			{
				  listOfLists.get(0).set(2,2);	
			}
			else if(listOfLists.get(1).get(2) == 0)
			{
				  listOfLists.get(1).set(2,2);	
			}
			else if(listOfLists.get(2).get(2) == 0)
			{
				  listOfLists.get(2).set(2,2);	
			}
		}
		if(maior == 6)
		{

			if(listOfLists.get(0).get(0) == 0)
			{
				  listOfLists.get(0).set(0,2);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,2);	
			}
			else if(listOfLists.get(2).get(2) == 0)
			{
				  listOfLists.get(2).set(2,2);	
			}	
		}
		if(maior == 7)
		{

			if(listOfLists.get(0).get(2) == 0)
			{
				  listOfLists.get(0).set(2,2);	
			}
			else if(listOfLists.get(1).get(1) == 0)
			{
				  listOfLists.get(1).set(1,2);	
			}
			else if(listOfLists.get(2).get(0) == 0)
			{
				  listOfLists.get(2).set(0,2);	
			}
		}

	
		System.out.println(listOfLists.get(0) + "\n" +listOfLists.get(1) + "\n" + listOfLists.get(2) + "\n");
	}

	

	rodada ++;

	for(int a = 0; a < 8; a++)
	{
		valores[a] = 0;
	}
}


public static void main(String[] args) {        
	System.out.println("1 - X \t 2 - O \t 0 - Vazio\n"); 
	System.out.println("X inicia\n"); 
	cria();	
	iniciaX();
	iniciaO();
	while(rodada<9)
	{
		verificar();
		heuristica();
		altera();
	}
	verificar();
}



}
