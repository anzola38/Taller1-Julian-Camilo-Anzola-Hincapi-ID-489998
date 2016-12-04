

public class BubbleSort {
	
	/**
	 * Este metodo sirve para ordenar un conjunto de numeros para posteriormente
	 * poder realizar una busqueda mediante los diferentes metodos de busqueda
	 * binary search, interpolation search y linear search <b>pre:</b>Para que
	 * un conjunto de numeros pueda ser organizado los numeros tiene que estar
	 * guardados en un vector o arreglo de tipo entero<br>
	 * <b>post:</b>se a organizado el conjunto de numeros<br>
	 * 
	 * @param conjunto_de_numeros
	 *            conjunto de numeros a ordenar
	 * @return un vector de tipo entero que contiene el conjunto de numeros
	 *         ordenados
	 */
	
	public  int[] burbuja(int[] conjunto_de_numeros) {

        int auxiliar;

        int[] arregloOrdenado;

        for (int i = 1; i < conjunto_de_numeros.length; i++) {

            for (int j = 0; j < conjunto_de_numeros.length - i; j++) {

                if (conjunto_de_numeros[j] >= conjunto_de_numeros[j + 1]) {

                    auxiliar = conjunto_de_numeros[j];

                    conjunto_de_numeros[j] = conjunto_de_numeros[j + 1];

                    conjunto_de_numeros[j + 1] = auxiliar;

                }

            }

        }
        
        arregloOrdenado = conjunto_de_numeros;

        return arregloOrdenado;

    }
}
