/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Uniminuto(Bogota- Colombia)
 * Departamento de Ingenieria de Sistemas 
 * Licenciado bajo el esquema Academic Free License 
 *
 * Taller Objetos Applets
 * Ejercicio: Estudiante Uniminuto
 * Autor: Julian camilo anzola - 31/11/2016
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Archivo {
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
     * Es el objeto utlizado para buscar la ruta del texto plano que deseamos
     * leer 
     */
	private JFileChooser text;
	/**
     * Es el objeto utilizado para obtener el texto plano que deseamos leer
     */
	private File leerarchivo;
	/**
     * Es el objeto que permite leer el texto plano
     */
	private FileReader archivos;
	/**
     * Es el objeto que permite escribir en un archivo de texto
     */
	private FileWriter guardar;
	/**
     * Es el objeto que permite leer el interior del texto plano
     */
	private BufferedReader lee;
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
			
	/**
	 * Sirve para inicializar JFileChooser
	 */
	
	public Archivo (){
		
		text = new JFileChooser();
		
	}

	/**
	 * Este metodo guarda la informacion del estudiante (nombre,codigo,numero de
	 * documento, semestre,fecha de nacimiento,direccion,telefono,correo) en un
	 * archivo de texto plano nuevo <b>pre:</b>Para que los datos puedan ser
	 * guardados el usuario debe proporcionar (nombre,codigo,numero de
	 * documento, semestre,fecha de nacimiento,direccion,telefono,correo)<br>
	 * <b>post:</b>se a guardado la informacion del estudiente en un archivo de
	 * texto plano nuevo<br>
	 * 
	 * @param nombre
	 *            nombre del estudiante
	 * @param codigo
	 *            codigo del extudiante
	 * @param documento
	 *            numero de documento del estudiante
	 * @param semestre
	 *            semestre que cursa el estudiante
	 * @param nacimiento
	 *            fecha de nacimiento del estudiante
	 * @param dirreccion
	 *            direccion de donde vive el estudiante
	 * @param telefono
	 *            telefono del estudiante
	 * @param correo
	 *            correo electronico del estudiante
	 * @return un mensaje de confirmacion o de posibles errores que puedan pasar
	 *         en el proceso de guardado
	 */
	
	public String guardar_estudiante_nuevo(String nombre, String codigo, String documento, String semestre,
			String nacimiento, String dirreccion, String telefono, String correo) {

		try {

			String informacion = nombre + "," + Long.parseLong(codigo) + "," + Long.parseLong(documento) + ","
					+ Long.parseLong(semestre) + "," + nacimiento + "," + dirreccion + "," + Long.parseLong(telefono)
					+ "," + correo;

			text = new JFileChooser();
			
			if(text.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				leerarchivo = text.getSelectedFile();

				guardar = new FileWriter(leerarchivo + ".txt");

				guardar.write(informacion);

				guardar.close();

				return "Se a almacenado la informacion";
				
			}

		} catch (Exception error) {

			return "-----------------ERROR--------------- \n POSIBLES ERRORES: \n -- En los campos de documento, codigo, semestre y telefono \n    solo ingrese datos numericos. \n -- "
					+ error;

		}

		return "No se a guardado la informacion";
		
	}
	
	/**
	 * Este metodo guarda la informacion del estudiante (nombre,codigo,numero de
	 * documento, semestre,fecha de nacimiento,direccion,telefono,correo) en un
	 * archivo de texto plano existente <b>pre:</b>Para que los datos puedan ser
	 * guardados el usuario debe proporcionar (nombre,codigo,numero de
	 * documento, semestre,fecha de nacimiento,direccion,telefono,correo)<br>
	 * <b>post:</b>se a guardado la informacion del estudiente en un archivo de
	 * texto plano existente<br>
	 * 
	 * @param nombre
	 *            nombre del estudiante
	 * @param codigo
	 *            codigo del extudiante
	 * @param documento
	 *            numero de documento del estudiante
	 * @param semestre
	 *            semestre que cursa el estudiante
	 * @param nacimiento
	 *            fecha de nacimiento del estudiante
	 * @param dirreccion
	 *            direccion de donde vive el estudiante
	 * @param telefono
	 *            telefono del estudiante
	 * @param correo
	 *            correo electronico del estudiante
	 * @return un mensaje de confirmacion o de posibles errores que puedan pasar
	 *         en el proceso de guardado
	 */
	
	public String guardar_estudiante_existente(String nombre, String codigo, String documento, String semestre,
			String nacimiento, String dirreccion, String telefono, String correo) {

		/*
		 * para guardar en un texto de plano existente primero se le pide al
		 * usuario que seleccione el texto plano existente donde quiere
		 * almacenar la nueva informacion seleccionada una vez la selecciona el
		 * texto plano se recorre el texto y se copia a una string con el fin de
		 * salvar esa informacion una vez se copia la informacion en la string a
		 * esa string se le concatena la nueva informacion que el usuario habia
		 * ingresado para este punto ya se tiene la informacion del texto plano
		 * y la que el usuario ingreso en una string despues se destrulle ese
		 * texto plano y creo otro con el mismo nombre y en la misma ruta en la
		 * que se encontraba el que se destrullo y le paso la string donde se
		 * encuentra toda la informacion salvada y de esa forma logro guardar
		 * datos en un archivo de texto plano existente
		 */

		try {

			String informacion = nombre + "," + Long.parseLong(codigo) + "," + Long.parseLong(documento) + ","
					+ Long.parseLong(semestre) + "," + nacimiento + "," + dirreccion + "," + Long.parseLong(telefono)
					+ "," + correo;

			String aux = "";

			String copia = "";

			text = new JFileChooser();

			if (text.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

				leerarchivo = text.getSelectedFile();

				archivos = new FileReader(leerarchivo);

				lee = new BufferedReader(archivos);

				while ((aux = lee.readLine()) != null) {// guarda el texto plano
														// en una String
					copia = copia + aux;
				}

				lee.close();

				leerarchivo.delete();// se destrulle el texto plano inicial una
										// vez se copie la informacion que se
										// encuentra en su interior

				informacion = informacion + ";" + copia + ";";// guarda lo que
																// se leyo en
																// una nueva
																// sting y esa
																// string es que
																// contiene
				// todo lo que se encontraba en el archivo de texto plano leido
				// con el fin de que los nuevos datos que ingreso el usuario
				// se agreguen al texto plano existente

				guardar = new FileWriter(leerarchivo);

				guardar.write(informacion);

				guardar.close();

				return "Se a almacenado la informacion";
				
			}

		} catch (Exception error) {

			return "----------------------ERROR-----------------"+error;
			
		}

		return "No se a seleccionado ningun archivo";
		
	}
	
	/**
	 * Este metodo lee la informacion de los estudiantes de un texto plano
	 * <b>pre:</b>Para que se pueda leer el archivo de texto plano el usuario
	 * tiene que seleccionar el archivo de texto plano que desea leer y tiene
	 * que ser de tipo txt<br>
	 * <b>post:</b>se a leido el texto plano<br>
	 * 
	 * @return la informacion de los estudiantes
	 */
	
	public String[] buscar(){
		
		try {
		
			String copia = "";

			String aux = "";
			
			text = new JFileChooser();

			if (text.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {//condicional para que no se active el try cacth cuando se cierre la pestaña de busqueda de un archivo (JFieldChooser)

				leerarchivo = text.getSelectedFile();

				archivos = new FileReader(leerarchivo);

				lee = new BufferedReader(archivos);

				while ((aux = lee.readLine()) != null) {//lee el archivo de texto plano y lo pasa a una string
					copia = copia + aux;
				}

				lee.close();
				
				String informacion[] = copia.split(";");//separa los estudiante gracias a ; y posteriormente los pasa a un vector de tipo string

				copia = "";

				for (int i = 0; i < informacion.length; i++) {//una vez se pasa la informacion a el vecto lo recorro y esos datos los copio a una string para posteriormente poder separa los dato de cada estudiante como el nombre codigo etc

					copia = copia + informacion[i] + ",";

				}

				informacion = null;//borro todo lo que se encuentra en el vector

				informacion = copia.split(",");//una vez se copia la informacion a la string vuelvo y separo la informacion pero esta vez por(,) y o añado al vector informacion de tipo string
				
				return informacion;
				
		}
		
	}catch(Exception e){
		
		
	}
	
		return null;
}
}
	
