/**
 *Clase que trabaja con arreglos
 *@author Jorge Miguel Aaron Barrientos Alvarez. NC:421111666
 *@version 1.0 Diciembre 2020
 *@since Laboratorio del curso de ICC 2021-1
 */

public class Arreglos implements InterfazArreglos{
    
    /**
     *Metodo auxiliar que muestra en pantalla un arreglo.
     *@param arreglo arreglo unidimensional de enteros que se va a mostrar en pantalla
     */
    public static void muestra(int[] arreglo){
	for(int i=0; i<arreglo.length; i++)
	    System.out.print(arreglo[i]+" ");

	System.out.println("\n");
    }

    /**
     *Metodo auxiliar que muestra en pantalla un arreglo.
     *@param arreglo arreglo bidimensional de enteros que se va a mostrar en pantalla
     */
    public static void muestra(int[][] arreglo){
	for(int i=0; i<arreglo.length; i++){
	    for(int k=0; k<arreglo[i].length; k++)
		System.out.print(arreglo[i][k]+" ");

	    System.out.print("\n");
	}

	System.out.println("\n");
    }

    /**
     *Metodo auxiliar que muestra en pantalla un arreglo.
     *@param arreglo arreglo bidimensional de caracteres que se va a mostrar en pantalla
     */

    public static void muestra(char[][] arreglo){
	for(int i=0; i<arreglo.length; i++){
	    for(int k=0; k<arreglo[i].length; k++)
		System.out.print(arreglo[i][k]+" ");

	    System.out.print("\n");
	}

	System.out.println("\n");
    }
    
    /**
     * Metodo auxiliar que ordena de menor a mayor los elementos
     * de un arreglo de enteros usando el metodo selection sort.
     *
     *@param numeros un arreglo de numeros enteros
     *@return ordenado el arreglo original pero con sus elementos 
     *        ordenados de menor a mayor.
     */
    public static int[] ordenamiento(int[] numeros){
	int aux=0;
	for(int i=0; i<numeros.length-1; i++){
	    for(int k=i+1; k<numeros.length; k++){
		if(numeros[k]<numeros[i]){
		    aux=numeros[i];
		    numeros[i]=numeros[k];
		    numeros[k]=aux;
		}
	    }
	}
	return numeros;
    }

    @Override
    public int[][] espejo(int[][] arreglo){
	int[][] respuesta=new int[arreglo.length][];
	for(int i=0; i<arreglo.length; i++){
	    int[] buffer=new int[arreglo[i].length];
	    for(int k=0; k<arreglo[i].length; k++){
		buffer[k]=arreglo[i][arreglo[i].length-1-k];
	    }
	    respuesta[i]=buffer;
	}

	return respuesta;
    }

    @Override
    public char gato(char[][] tablero){
	char respuesta='*';
	boolean condicionX=false, condicionO=false;
        int contX=0, contO=0, contX2=0, contO2=0;
	
        for(int i=0; i<tablero.length; i++){
            contX=0; contO=0;
            for(int k=0; k<tablero[i].length; k++){
                if(tablero[i][k]=='X')
                    contX++;
                
                if(tablero[i][k]=='O')
                    contO++;
            }
            
            if(contX==3)
                condicionX=true;
            
            if(contO==3)
                condicionO=true;
            
            contX=0; contO=0;
            for(int j=0; j<tablero[i].length; j++){
                
                if(tablero[j][i]=='X')
                    contX++;
                
                if(tablero[j][i]=='O')
                    contO++;
            }
            
            if(contX==3)
		condicionX=true;
            
            if(contO==3)
                condicionO=true;
        }
        
        contX=0; contO=0; contX2=0; contO2=0;
        for(int i=0; i<3; i++){
            if(tablero[i][i]=='X')
                contX++;
                
            if(tablero[i][i]=='O')
                contO++;
            
            if(tablero[2-i][i]=='X')
                contX2++;
            
            if(tablero[2-i][i]=='O')
                contO2++;    
        }
        
        if(contX==3 || contX2==3)
            condicionX=true;
        
        if(contO==3 || contO2==3)
            condicionO=true;
            
        if(condicionX==true && condicionO!=true)
            respuesta= 'X';
        
        else if(condicionO==true && condicionX!=true)
            respuesta= 'O';
        
        else if(condicionX==true && condicionO==true)
            respuesta= 'E';
        
        else
            respuesta= 'N';
        
        return respuesta;   
    }
    
    @Override
    public String construyeFrase(char[][] frase){
	String respuesta="";
	for(int i=0; i<frase.length; i++){
	    for(int k=0; k<frase[i].length; k++){
		respuesta+=frase[i][k];
	    }
	    respuesta+=" ";
	}

	return respuesta;
    }

    @Override
    public int[][] separaNumeros(int[] numeros){
	int[][] respuesta=new int[2][];
	int contadorImpares=0, contadorPares=0;
	int k=0, j=0;

	for(int i=0; i<numeros.length; i++){
	    if(numeros[i]%2==0)
		contadorPares++;

	    else
		contadorImpares++;		
	}

	int[] pares=new int[contadorPares];
	int[] impares=new int[contadorImpares];

	for(int i=0; i<numeros.length; i++){
	    if(numeros[i]%2==0){
		pares[k]=numeros[i];
		k++;
	    }

	    else{
		impares[j]=numeros[i];
		j++;
	    }
	}

	respuesta[0]=pares;
	respuesta[1]=impares;
	return respuesta;	
    }

    @Override
    public int masRepetido(int[] numeros){
        boolean condicion=false;
        
        for(int i=0; i<numeros.length; i++){
            if(numeros[i]!=0){
                condicion=true;
                break;
            }
        }
        
        if(condicion==true){
            numeros=ordenamiento(numeros);
	    int[] aux=new int[numeros.length+1];
   
	    for(int i=0; i<numeros.length; i++){
		aux[i]=numeros[i];
	    }
        
	    int respuesta=aux[0];
	    int contMax=0;
        
	    for(int i=0; i<numeros.length-1; i++){
		if(aux[i]==aux[i+1]){
		    int contAux=0;
		    int k=i+1;
		    while(aux[i]==aux[k]){
			contAux++;
			k++;
		    }
                
                
		    if(contAux>contMax){
			respuesta=aux[i];
			contMax=contAux;
		    }
                
		}
	    }
        
	    return respuesta;
        }
        
        else
	    return 0;
    }

    @Override
    public boolean estaContenido(int[] contenido, int[] contenedor){
	
	/* Aquí, como en teoría de conjuntos, consideré que el vacío
	 * está contenido en cualquier conjunto. uwu
	 */
	
	if(contenido.length==0)
	    return true;
	
	Arreglos timbre=new Arreglos();
	boolean respuesta=false;
	contenido=ordenamiento(contenido);
	contenedor=ordenamiento(contenedor);
	contenido=timbre.colapsa(contenido);
	contenedor=timbre.colapsa(contenedor);

	if(contenido.length>contenedor.length)
	    return false;

        
	else{
	    for(int i=0; i<contenedor.length; i++){
		if(contenido[0]==contenedor[i]){
		    if(i+contenido.length<=contenedor.length){
			int k=0;

			for(int j=i; j<contenedor.length; j++){
			    if(k==contenido.length)
				break;
			    
			    if(contenedor[j]==contenido[k])
				k++;
			    
			}
			if(k==contenido.length)
			    respuesta=true;
			    
		    }
		}
	    }
	    
	    
	}
	
	return respuesta; 
    }

    
    @Override
    public int[][] pascal(int n){
	int[][] triangulo=new int[n][];
	
	for(int i=0; i<n; i++){
	    int[] buffer=new int[i+1];
           
	    for(int k=0; k<=i; k++){
		if(k==0||k==i){
		    buffer[k]=1;
		}
               
		else if(i>1){
		    buffer[k]=triangulo[i-1][k-1]+triangulo[i-1][k];
		}
	    }
           
	    triangulo[i]=buffer;
	}
       
	return triangulo;
    }

    @Override
    public int[] colapsa(int[] arreglo){
	boolean condicion=false;
       
	for(int i=0; i<arreglo.length; i++){
	    if(arreglo[i]!=0){
		condicion=true; 
		break;
	    }
           
	}
       
	if(condicion==true){
	    arreglo=ordenamiento(arreglo);
	    int k=0, j=0;
	    int[] aux=new int[arreglo.length+1];
	    for(int i=0; i<arreglo.length; i++){
		aux[i]=arreglo[i];
	    }
       
	    int[] buffer=new int[aux.length];
       
	    for(int i=0; i<aux.length-1; i++){
		if(aux[i]!=aux[i+1]){
		    buffer[k]=aux[i];
		    k++;
		}
	    }
       
	    for(int i=0; i<buffer.length; i++){
		j++;
		if(buffer[i]!=0 && buffer[i+1]==0)
		    break;
           
        
	    }
       
	    int[] otro=new int[j];
       
	    for(int i=0; i<j; i++)
		otro[i]=buffer[i];
       
	    return otro;
	}
       
	else{
	    int[] re={0};
	    return re;
	}
    }

    public static void main(String[] args){
	Arreglos aldaba=new Arreglos();
	int[][] pruebaEspejo={{1,2,3},{4,5,6},{7,8,9}};
	char[][] pruebaGato={{'X','-','-'},{'X','O','O'},{'X','-','O'}};
	char[][] pruebaFrase={{'h','o','l','a'},{'m','u','n','d','o'},{'l','o','c','o'}};
	int[] pruebaSeparaNumeros={1,2,3,4,5,6,7,8,9,10};
	int[] pruebaMasRepetido={1,2,5,3,6,2,1,7,3,2};
	int[] pruebaContenido={1,2,3};
	int[] pruebaContenedor={1,2,3,4,5};
	int[] pruebaColapsa={1,1,2,2,3,4,3,5,5,7,6,7,6,8};

	System.out.println("METODO ESPEJO\n");
	System.out.println("El espejo de la matriz\n");
	muestra(pruebaEspejo);
	System.out.println("Es la matriz\n");
	muestra(aldaba.espejo(pruebaEspejo));

	System.out.println("******************************");
	System.out.println("\nMETODO CONSTRUYE FRASE\n");
	System.out.println("Si creamos una frase con los caracteres de la matriz\n");
	muestra(pruebaFrase);
	System.out.println("Obtendreamos la frase\n");
        System.out.println(aldaba.construyeFrase(pruebaFrase)+"\n");

	System.out.println("******************************");
	System.out.println("\nMETODO GATO\n");
	System.out.println("¿Quien gano la siguiente partida de Gato?\n");
	muestra(pruebaGato);
	char respuestaGato=aldaba.gato(pruebaGato);
        if(respuestaGato!='E' && respuestaGato!= 'N')
	    System.out.println("Ganaron las "+ respuestaGato);
	else if(respuestaGato=='E')
	    System.out.println("Fue un empate. Estado del juego: "+respuestaGato);
	else
	    System.out.println("No hubo un ganador. Estado del juego: "+respuestaGato);
	

	System.out.println("\n******************************");
	System.out.println("\nMETODO SEPARA NUMEROS\n");
	System.out.println("Separando en pares e impares los siguientes numeros\n");
	muestra(pruebaSeparaNumeros);
	System.out.println("Obtendremos la siguiente matriz de numeros pares e impares\n");
        muestra(aldaba.separaNumeros(pruebaSeparaNumeros));

	System.out.println("******************************");
	System.out.println("\nMETODO MAS REPETIDO\n");
	System.out.println("El numero mas repetido de la siguiente lista de numeros\n");
	muestra(pruebaMasRepetido);
	System.out.println("Es el numero: \n");
        System.out.println(aldaba.masRepetido(pruebaMasRepetido)+"\n");

	System.out.println("******************************");
	System.out.println("\nMETODO ESTA CONTENIDO\n");
	System.out.println("¿La lista de numeros\n");
	muestra(pruebaContenido);
	System.out.println("esta contenida en la lista de numeros \n");
	muestra(pruebaContenedor);
        System.out.println("?"+"\n\n"+aldaba.estaContenido(pruebaContenido, pruebaContenedor)+"\n");

	System.out.println("******************************");
	System.out.println("\nMETODO PASCAL\n");
	int n=10;
	System.out.println("Triangulo de Pascal de "+n+" niveles\n");
	muestra(aldaba.pascal(n));

	System.out.println("******************************");
	System.out.println("\nMETODO COLAPSA\n");
	System.out.println("Si eliminamos los elementos repetidos de la lista de numeros\n");
	muestra(pruebaColapsa);
	System.out.println("Obtendremos la lista con los siguientes elementos\n");
	muestra(aldaba.colapsa(pruebaColapsa));
	
	
	
        
        
	
    }  
}
