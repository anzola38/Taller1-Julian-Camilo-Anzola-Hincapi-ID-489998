import java.util.Vector;

public class Ordenamiento {
	/**
	 * Este metodo sirve para ordenar un conjunto de numeros mediante el metodo
	 * de ordenamiento bubble sort <b>pre:</b>Para que un conjunto de numeros
	 * pueda ser organizado los numeros tiene que estar guardados en un vector o arreglo
	 * de tipo entero<br>
	 * <b>post:</b>se a organizado el conjunto de numeros<br>
	 * 
	 * @param numeros_a_ordenar
	 *            conjunto de numeros a ordenar
	 * @return un vector o arreglo de tipo entero que contiene el conjunto de numeros
	 *         ordenados
	 */
	
	public static int[] Bubble_sort(int[] numeros_a_ordenar) {

	        int auxiliar;

	        int[] arregloOrdenado;

	        for (int i = 1; i < numeros_a_ordenar.length; i++) {

	            for (int j = 0; j < numeros_a_ordenar.length - i; j++) {

	                if (numeros_a_ordenar[j] >=numeros_a_ordenar[j + 1]) {

	                    auxiliar = numeros_a_ordenar[j];

	                    numeros_a_ordenar[j] =numeros_a_ordenar[j + 1];

	                    numeros_a_ordenar[j + 1] = auxiliar;

	                }

	            }

	        }
	        
	        arregloOrdenado =numeros_a_ordenar;

	        return arregloOrdenado;

	    }
	
	/**
	 * Este metodo permite ordenar un conjunto de numeros mediante el metodo de
	 * ordenamiento counting sort <b>pre:</b>Para que un conjunto de numeros
	 * pueda ser organizado los numeros tiene que estar guardados en un vector o
	 * arreglo de tipo entero<br>
	 * <b>post:</b>se a organizado el conjunto de numeros<br>
	 * 
	 * @param numeros_a_ordenar
	 *            arreglo que contiene el conjunto de numeros a ordenar
	 * @return arreglo de tipo entero que contiene el conjunto de numeros
	 *         organizado
	 */
	
	public static int[] Counting_sort(int[] numeros_a_ordenar) {

        int tamano = numeros_a_ordenar.length, maximo = 0, indice = 0;

        for (int i = 0; i < tamano; i++) {

            maximo = numeros_a_ordenar[i] > maximo ?numeros_a_ordenar[i] : maximo;

        }

        int[] aux = new int[maximo + 1];

        for (int i = 0; i < tamano; i++) {

            aux[numeros_a_ordenar[i]] += 1;

        }

        for (int i = 0; i <= maximo; i++) {

            for (int j = 0; j < aux[i]; j++) {

            	numeros_a_ordenar[indice] = i;

                indice++;

            }

        }

        return numeros_a_ordenar;

    }
	
	/**
	 * Este metodo ordena un conjunto de numeros mediante el metodo de
	 * ordenamiento quick sort <b>pre:</b>Para que un conjunto de numeros pueda
	 * ser organizado los numeros tiene que estar guardados en un vector o
	 * arreglo de tipo entero<br>
	 * <b>post:</b>se a organizado el conjunto de numeros<br>
	 * 
	 * @param numeros_a_ordenar
	 *            conjunto de numeros a ordenar
	 * @return arreglo o vector de tipo entero que contiene el conjunto de
	 *         numeros ordenados
	 */
	
	public static int[] sort(int[] numeros_a_ordenar) {

        Vector<Integer> array = new Vector<Integer>(); //Create a dynamic array

        for (int i = 0; i < numeros_a_ordenar.length; i++) //Add all elements from integer array into vector
        {
            array.add(numeros_a_ordenar[i]);
        }

        array = sort(array); //Call to method to order a set of elements saved into a Vector

        for (int i = 0; i < numeros_a_ordenar.length; i++) //Pass ordered elements from Vector to Array
        {
        	numeros_a_ordenar[i] = array.get(i);
        }

        return numeros_a_ordenar; //Return ordered array

    }

	/**
	 * This methos use a collection to apply quickSort strategy. Is an example
	 * of polymorphism. <b>pre:</b>El conjunto de numeros tiene que ser de tipo
	 * vector<Integer><br>
	 * 
	 * @param numbers
	 *            conjunto de numeros que el usuario ingreso
	 * @return orden array
	 */
	
    private static Vector<Integer> sort(Vector<Integer> numbers) {

        if (numbers.size() == 1) //if Vector size is one, recursion is finished
        {

            return numbers; //return Vector

        } else {

            Vector<Integer> arrayMinor = new Vector<Integer>(); //Create array for left side, lesser elements than pivot

            Vector<Integer> arrayMajor = new Vector<Integer>(); //Create array for left side, greater elements than pivot

            for (int i = 1; i < numbers.size(); i++) //Move through vector, and divide elements using a comparison with pivot
            {

                if (numbers.get(i) < numbers.get(0)) //Compare element with pivot
                {

                    arrayMinor.add(numbers.get(i)); //Add to left side Vector

                } else {

                    arrayMajor.add(numbers.get(i)); //Add to right side Vector
                }
            }

            Vector<Integer> orderArray = new Vector<Integer>(); //Vector that saves complete ordered Vector

            if (arrayMinor.size() > 0) //If there are elements in left side Vector, add to complete ordered Vector
            
            {

                orderArray.addAll(sort(arrayMinor)); //Because this is a recursive algorithm, to order each array side is necessary to call at quickSort strategy
            
            }
            
            orderArray.add(numbers.get(0)); //Add pivot

            if (arrayMajor.size() > 0) //If there are elements in left side Vector, add to complete ordered Vector
            
            {
            
                orderArray.addAll(sort(arrayMajor)); //Call recursivity and add to complete ordered Vector
            
            }
            
            return orderArray;

        }

    }
    /**
	 * Este metodo permite ordenar un conjunto de numeros mediante el metodo de
	 * ordenamiento Merge sort <b>pre:</b>Para que un conjunto de numeros
	 * pueda ser organizado los numeros tiene que estar guardados en un vector o
	 * arreglo de tipo entero<br>
	 * <b>post:</b>se a organizado el conjunto de numeros<br>
	 * 
	 * @param numeros_a_ordenar
	 *            arreglo que contiene el conjunto de numeros a ordenar
	 * @return arreglo de tipo entero que contiene el conjunto de numeros
	 *         organizado
	 */
	public static int[] Merge_sort(int[] numeros_a_ordenar) {

        if (numeros_a_ordenar.length > 1) //Condition to end recursive: If array is of size equal to 1, no more calls are necessary
        {

            int n = numeros_a_ordenar.length / 2; //Get half size of the array

            int[] array_left = new int[n]; //Create array of the left side of n size

            int[] array_right = new int[numeros_a_ordenar.length - n]; //Create array of the right side 

            for (int i = 0; i < n; i++) //Copy first half of the array inside left array
            {

                array_left[i] =numeros_a_ordenar[i]; //Copy data

            }

            for (int i = 0; i < array_right.length; i++) //Copy second half of the array inside right array
            {

                array_right[i] = numeros_a_ordenar[n + i]; //Copy data

            }

            array_left = sort(array_left); //Call recursive to order array of left size

            array_right = sort(array_right); //Call recursive to order array of left size

            return merge(array_left, array_right); //Merge order arrays of both left and right size

        } else {

            return numeros_a_ordenar; //Return array if his size is 1 

        }

    }

    /**
     * This method merge both left and right arrays in an ordered way
     *
     * @param array_left
     * @param array_right
     * @return ordered array base on both left and right array
     */
    public static int[] merge(int[] array_left, int[] array_right) {

        int[] temp = new int[array_left.length + array_right.length]; //Create array of complete size, i.e. size of left array plus size of right array

        int left = 0, right = 0, index = 0; //Index for: left array, right array, and temp array. All must start in zero.

        while (left < array_left.length && right < array_right.length) //While are still elements inside left array or right array, we can made comparisons
        {

            if (array_left[left] <= array_right[right]) //If element in left array is minor or equal to element in right array
            {

                temp[index] = array_left[left]; //Add element of left array

                left += 1; //Because we add an element of left array, index that control left array must increase

            } else {

                temp[index] = array_right[right]; //Add element of right array

                right += 1; //Because we add an element of right array, index that control right array must increase

            }

            index += 1; //Increase index of complete array

        }

        if (left < array_left.length) //If there are still element in left array
        {

            for (int i = left; i < array_left.length; i++) //Add all elements of left array
            {

                temp[index] = array_left[left]; //Add element

                left += 1; //Increase index over left array

                index += 1; //Increase index over complete array

            }

        } else //If there are still element in left array
        {

            for (int i = right; i < array_right.length; i++) //Add all elements of right array
            {

                temp[index] = array_right[right]; //Add element

                right += 1; //Increase index over right array

                index += 1;  //Increase index over complete array

            }

        }

        return temp; //Return complete array 

    }

    /**
     *
     * @param numbers
     * @param column
     * @return
     */
    public static int[][] sortByColumn(int[][] numbers, int column) {

        if (numbers.length > 1) {

            int n = numbers.length / 2;

            int[][] array_left = new int[n][numbers[0].length];

            int[][] array_right = new int[numbers.length - n][numbers[0].length];

            for (int i = 0; i < n; i++) {

                array_left[i] = numbers[i];

            }

            for (int i = 0; i < array_right.length; i++) {

                array_right[i] = numbers[i + n];

            }

            array_left = sortByColumn(array_left, column);

            array_right = sortByColumn(array_right, column);

            return mergeByColumn(array_left, array_right, column);

        } else {

            return numbers;

        }
    }

    public static int[][] mergeByColumn(int[][] array_left, int[][] array_right, int column) {

        int[][] temp = new int[array_left.length + array_right.length][2];

        int left = 0, right = 0, index = 0;

        while (left < array_left.length && right < array_right.length) {

            if (array_left[left][column] <= array_right[right][column]) {

                temp[index] = array_left[left];

                left += 1;

            } else {

                temp[index] = array_right[right];

                right += 1;

            }

            index += 1;

        }

        if (left < array_left.length) {

            for (int i = left; i < array_left.length; i++) {

                temp[index] = array_left[i];

                index += 1;

            }

        } else {

            for (int i = right; i < array_right.length; i++) {

                temp[index] = array_right[i];

                index += 1;

            }

        }

        return temp;

    }

	
}
