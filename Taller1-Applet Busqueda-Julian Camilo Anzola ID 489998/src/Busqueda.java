
public class Busqueda {

	/**
	 * Este metodo permite buscar un numero en un conjunto de numeros por medio
	 * del metodo de busqueda binary search <b>pre:</b>Para poder realizar la
	 * busqueda el conjunto de numeros debe de estar ordenado y tiene que ser un
	 * arreglo o un vector de tipo entero tambien el usuario tiene que ingresar
	 * el numero que desea buscar<br>
	 * <b>post:</b>se a buscado el numero en un conjunto de numeros<br>
	 * 
	 * @param conjunto_de_numeros
	 *            conjunto de numeros donde se va a realizar la busqueda
	 * @param usuario
	 *            numero que se desea buscar
	 * @return posicion donde se encuentra el numero
	 */

	public int Binary_search(int[] conjunto_de_numeros, int numero_a_buscar) {

		int fin = conjunto_de_numeros.length - 1;
		int inicio = 0;
		int m = -1;
		while (inicio <= fin) {
			m = (inicio + fin) / 2;
			if (conjunto_de_numeros[m] == numero_a_buscar) {
				return m;
			} else {
				if (numero_a_buscar > conjunto_de_numeros[m]) {
					inicio = m + 1;
				} else {
					fin = m - 1;
				}

			}

		}

		return -1;

	}

	/**
	 * Este metodo permite buscar un numero en un conjunto de numeros por medio
	 * del metodo de busqueda Interpolation Search <b>pre:</b>Para poder
	 * realizar la busqueda el conjunto de numeros debe de estar ordenado y
	 * tiene que ser un arreglo o un vector de tipo entero tambien el usuario
	 * tiene que ingresar el numero que desea buscar<br>
	 * <b>post:</b>se a buscado el numero en un conjunto de numeros<br>
	 * 
	 * @param conjunto_de_numeros
	 *            conjunto de numeros donde se va a realizar la busqueda
	 * @param data
	 *            numero que se desea buscar
	 * @return posicion donde se encuentra el numero
	 */

	public int Interpolation_search(int[] conjunto_de_numeros, int numero_a_buscar) {
		int lower = 0;
		int higher = conjunto_de_numeros.length - 1;
		int index = -1;
		int middle = 0;
		while (true) {
			if (lower >= higher || conjunto_de_numeros[lower] == conjunto_de_numeros[higher]) {
				break;
			}
			middle = lower + ((higher - lower) / (conjunto_de_numeros[higher] - conjunto_de_numeros[lower])
					* (numero_a_buscar - conjunto_de_numeros[lower]));
			if (conjunto_de_numeros[middle] == numero_a_buscar) {
				index = middle;
				break;
			} else {
				if (conjunto_de_numeros[middle] < numero_a_buscar) {
					lower = middle + 1;
				} else {
					if (conjunto_de_numeros[middle] > numero_a_buscar) {
						higher = middle - 1;
					}
				}
			}
		}
		return index;

	}

	/**
	 * Este metodo permite buscar un numero en un conjunto de numeros por medio
	 * del metodo de busqueda Linear Search <b>pre:</b>Para poder realizar la
	 * busqueda el conjunto de numeros debe de estar ordenado y tiene que ser un
	 * arreglo o un vector de tipo entero tambien el usuario tiene que ingresar
	 * el numero que desea buscar<br>
	 * <b>post:</b>se a buscado el numero en un conjunto de numeros<br>
	 * 
	 * @param conjunto_de_numeros
	 *            conjunto de numeros donde se va a realizar la busqueda
	 * @param dato
	 *            numero que se desea buscar
	 * @return posicion donde se encuentra el numero
	 */

	public int Linear_search(int[] conjunto_de_numeros, int numero_a_buscar) {

		int index = -1;

		for (int i = 0; i < conjunto_de_numeros.length; i++) {

			if (conjunto_de_numeros[i] == numero_a_buscar || numero_a_buscar == conjunto_de_numeros[i]) {
				index = i;
				break;

			}

		}
		return index;
	}

}
