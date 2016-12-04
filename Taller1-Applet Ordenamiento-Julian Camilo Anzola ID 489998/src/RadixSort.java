

public class RadixSort  extends Ordenamiento{

	/**
	 * Este metodo ordena un conjunto de numeros mediante el metodo de
	 * ordenamiento radix sort <b>pre:</b>Para que un conjunto de numeros pueda
	 * ser organizado los numeros tiene que estar guardados en un vector o
	 * arreglo de tipo String<br>
	 * <b>post:</b>se a organizado el conjunto de numeros<br>
	 * 
	 * @param numeros_a_ordenar
	 *            conjunto de numeros que el usuario ingresa
	 * @return arreglo de tipo entero que contiene el conjunto de numeros ordenados
	 */
	
	public int[][] Radix_sort(String[] numeros_a_ordenar) {
	    
        int[][] numbers=null;
       
        try {
            String[] input = numeros_a_ordenar;

           int max = 0;
			
			for(int i = 0; i < input.length; i++)
			{
				max = input[i].length() > max ? input[i].length() : max;
			}
			
			numbers = new int[input.length][max];
			
			
			for(int i = 0; i < input.length; i++)
			{
				for(int j = 0; j < input[i].length(); j++)
				{
                                    try{
                                        
                                        numbers[i][max - 1 - j] = Integer.parseInt( input[i].substring( input[i].length() - 1 - j, input[i].length() - j ) );
                                        
                                    }catch(Exception e){
                                        
                                    }
					
				}
                        }
			
			for(int i = max - 1; i >= 0; i--)
			
                        {
				
						numbers=super.sortByColumn(numbers, i);
                            
			
                        }
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
        return numbers;
    }

	
}
