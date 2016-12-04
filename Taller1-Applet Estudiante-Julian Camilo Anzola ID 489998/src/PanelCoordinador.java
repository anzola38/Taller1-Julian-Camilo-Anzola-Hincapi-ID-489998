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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCoordinador extends JPanel implements ActionListener{
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
     * Es una referencia a la ventana principal del applet
     */
	private Applet applet;
	
	//----------------------------------------------------------------------------------
    // Elementos de la interfaz
    //----------------------------------------------------------------------------------
	
	/**
	 * etiqueta que genera un espacio para poder acomodar el menu
	 */
	private JLabel jlespacio;
	/**
	 * etiqueta que pone la frase nombre y apelllidos atras del campo de texto jtnombre
	 */
	private JLabel jlnombre;
	/**
	 * etiqueta que pone la frase codigo del estudiante atras del campo de texto jtcodigo
	 */
	private JLabel jlcodigo;
	/**
	 * etiqueta que pone la frase numero de identidad atras del campo de texto jtdocumento
	 */
	private JLabel jldocumento;
	/**
	 * etiqueta que pone la frase semestre que cursa atras del campo de texto jtsemestre
	 */
	private JLabel jlsemestre;
	/**
	 * etiqueta que pone la frase fecha de nacimiento atras del campo de texto jtnacimiento
	 */
	private JLabel jlnacimiento;
	/**
	 * etiqueta que pone la palabra direccion atras del campo de texto jtdireccion
	 */
	private JLabel jldirreccion;
	/**
	 * etiqueta que pone la palabra telefono atras del campo de texto jttelefono
	 */
	private JLabel jltelefono;
	/**
	 * etiqueta que pone la frase correo electronico atras del campo de texto jtcorreo
	 */
	private JLabel jlcorreo;
	
	//--------------------------------------------------------------
	
	/**
	 * campo de texto donde se ingresa o imprime el nombre del estudiante
	 */
	private JTextField jtnombre;
	/**
	 * campo de texto donde se ingresa o imprime el codigo del estudiante
	 */
	private JTextField jtcodigo;
	/**
	 * campo de texto donde se ingresa o imprime el numero de documento de identidad
	 * del estudiante
	 */
	private JTextField jtdocumento;
	/**
	 * campo de texto donde se ingresa o imprime el semestre que cursa el estudiante
	 */
	private JTextField jtsemestre;
	/**
	 * campo de texto donde se ingresa o imprime la fecha de nacimiento del estudiante
	 */
	private JTextField jtnacimiento;
	/**
	 * campo de texto donde se ingresa o imprime la direccion donde vive el estudiante
	 */
	private JTextField jtdirreccion;
	/**
	 * campo de texto donde se ingresa o imprime el telefono del estudiante
	 */
	private JTextField jttelefono;
	/**
	 * campo de texto donde se ingresa o imprime el correo electronico del estudiante
	 */
	private JTextField jtcorreo;
	
	//-------------------------------------------------------------
	
	/**
     * Es la barra de soporte que permite agregar la pestaña
     * estudiante 
     */
	private JMenuBar jmbsoporte;
	
	//--------------------------------------------------------------
	
	/**
     * Es la pestaña que permite agregar las opciones de guardar estudiante en un texto plano nuevo,
     * guardar estudiante en un texto plano existente y salir 
     */
	private JMenu jmestudiante;
	
	//-------------------------------------------------------------
	
	/**
     * Es la opcion que permite cerrar el programa
     */
	private JMenuItem jmisalir;
	/**
     * Es la opcion que permite guardar un estudiante en un texto plano existente
     */
	private JMenuItem jmiguardarestudiante;
	/**
     * Es la opcion que permite guardar un estudiante en un texto plano nuevo
     */
	private JMenuItem jmguardarestudiantenuevo;
	
	//--------------------------------------------------------------
	
	/**
     * Es el boton para limpiar los campos del panel
     */
	private JButton jblimpiar;
	/**
     * Es el boton para buscar el estudiante en un texto plano
     */
	private JButton jbbuscar;
	
	//--------------------------------------------------------------

	/**
     * Comando guardar estudiante
     */
	public static final String guardarestudiante="guardarestudiante";	
	/**
     * Comando limpiar
     */
	public static final String limpiar="limpiar";
	/**
     * Comando buscar
     */
	public static final String buscar="buscar";
	/**
     * Comando guardar estudiante nuevo
     */
	public static final String guardarestudiantenuevo="guardarestudiantenuevo";
	/**
     * Comando salir
     */
	public static final String salir="salir";
	
	 //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	/**
	 * Crea el panel PanelCoordinador con el applet
	 *
	 * @param applet
	 *            Ventana principal. v != null.
	 */

	public PanelCoordinador(Applet applet) {

		// ------------------------------------------------------------

		this.applet = applet;
		this.setLayout(new GridLayout(10, 2));

		// ------------------------------------------------------------

		jmbsoporte = new JMenuBar();
		jmestudiante = new JMenu("Estudiante");

		jmisalir = new JMenuItem("Salir");
		jmiguardarestudiante = new JMenuItem("Guardar Estudiante En Un Texto Existente");

		jlespacio = new JLabel();
		jlnombre = new JLabel("Nombre y Apellios: ");

		jtnombre = new JTextField();
		jlcodigo = new JLabel("Codigo Del Estudiante:");

		jtcodigo = new JTextField();
		jldocumento = new JLabel("Numero De Identidad:");

		jtdocumento = new JTextField();
		jlsemestre = new JLabel("Semestre Que Cursa:");

		jtsemestre = new JTextField();
		jlnacimiento = new JLabel("Fecha De Nacimiento ((DD-MM-AAAA):");

		jtnacimiento = new JTextField();
		jldirreccion = new JLabel("Direccion:");

		jtdirreccion = new JTextField();
		jltelefono = new JLabel("Telefono:");

		jttelefono = new JTextField();
		jlcorreo = new JLabel("Correo Electronico:");

		jtcorreo = new JTextField();
		jblimpiar = new JButton("Limpiar");

		jbbuscar = new JButton("Buscar");

		jmguardarestudiantenuevo = new JMenuItem("Guardar Estudiante En Un Texto Nuevo");

		// -------------------------------------------------------------

		jmisalir.addActionListener(this);
		jmisalir.setActionCommand(salir);

		jmiguardarestudiante.addActionListener(this);
		jmiguardarestudiante.setActionCommand(guardarestudiante);

		jblimpiar.addActionListener(this);
		jblimpiar.setActionCommand(limpiar);

		jbbuscar.addActionListener(this);
		jbbuscar.setActionCommand(buscar);

		jmguardarestudiantenuevo.addActionListener(this);
		jmguardarestudiantenuevo.setActionCommand(guardarestudiantenuevo);

		// ----------------------------------------------------------------

		jmestudiante.add(jmisalir);
		jmestudiante.add(jmiguardarestudiante);

		jmestudiante.add(jmguardarestudiantenuevo);
		jmbsoporte.add(jmestudiante);

		// ----------------------------------------------------------------

		add(jmbsoporte);
		add(jlespacio);

		add(jlnombre);
		add(jtnombre);

		add(jlcodigo);
		add(jtcodigo);

		add(jldocumento);
		add(jtdocumento);

		add(jlsemestre);
		add(jtsemestre);

		add(jlnacimiento);
		add(jtnacimiento);

		add(jldirreccion);
		add(jtdirreccion);

		add(jltelefono);
		add(jttelefono);

		add(jlcorreo);
		add(jtcorreo);

		add(jblimpiar);
		add(jbbuscar);

	}

	/**
	 * Este metodo ejecuta las acciones adecuadas segun el boton que haya sido
	 * presionado
	 *
	 * @param e
	 *            Es el evento del click sobre el boton
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(guardarestudiante)) {

			if (jtnombre.getText().length() != 0 && jtcodigo.getText().length() != 0
						&& jtdocumento.getText().length() != 0 && jtsemestre.getText().length() != 0
						&& jtnacimiento.getText().length() != 0 && jtdirreccion.getText().length() != 0
						&& jttelefono.getText().length() != 0 && jtcorreo.getText().length() != 0) {//condicional para validar si todos los cuadros de textos estan llenos

				JOptionPane.showMessageDialog(null,applet.guardar_existente(jtnombre.getText(), jtcodigo.getText(), jtdocumento.getText(), jtsemestre.getText(), jtnacimiento.getText(), jtdirreccion.getText(), jttelefono.getText(), jtcorreo.getText()));//se obtiene toda la informacion de los campos de texto y se pasa a una String para ser guardada en un texto plano nuevo
					
				} else {

					JOptionPane.showMessageDialog(null,
							"-----------------ERROR--------------- \n Porfavor llene todos los campos.");

				}

		} else {

			if (comando.equals(guardarestudiantenuevo)) {

				if (jtnombre.getText().length() != 0 && jtcodigo.getText().length() != 0
							&& jtdocumento.getText().length() != 0 && jtsemestre.getText().length() != 0
							&& jtnacimiento.getText().length() != 0 && jtdirreccion.getText().length() != 0
							&& jttelefono.getText().length() != 0 && jtcorreo.getText().length() != 0) {//condicional para validar si todos los cuadros de textos estan llenos

						JOptionPane.showMessageDialog(null,applet.guardar(jtnombre.getText(), jtcodigo.getText(), jtdocumento.getText(), jtsemestre.getText(), jtnacimiento.getText(), jtdirreccion.getText(), jttelefono.getText(), jtcorreo.getText()));//se obtiene toda la informacion de los campos de texto y se pasa a una String para ser guardada en un texto plano nuevo
						
					} else {

						JOptionPane.showMessageDialog(null,
								"-----------------ERROR--------------- \n Porfavor llene todos los campos.");

					}

			} else {

				if (comando.equals(limpiar)) {

					jtnombre.setText("");

					jtcodigo.setText("");

					jtdocumento.setText("");

					jtsemestre.setText("");

					jtnacimiento.setText("");

					jtdirreccion.setText("");

					jttelefono.setText("");

					jtcorreo.setText("");

					jtnombre.setEditable(true);

					jtcodigo.setEditable(true);

					jtdocumento.setEditable(true);

					jtsemestre.setEditable(true);

					jtnacimiento.setEditable(true);

					jtdirreccion.setEditable(true);

					jttelefono.setEditable(true);

					jtcorreo.setEditable(true);

				} else {

					if (comando.equals(salir)) {

						System.exit(0);

					} else {

						if (comando.equals(buscar)) {

							if (jtcodigo.getText().length() != 0) {//condicional para que asegurarce que el usuario ingreso el codigo del estudiante  para poder realizar la busqueda
								int bandera = 0;

								String informacion[]=applet.buscar();
								
										for (int i = 0; i < informacion.length; i++) {

											if (informacion[i].equals(jtcodigo.getText())) {//recorro el vector y compruebo si el codigo que el usuario ingreso corresponde a algun codigo que se encuentra en el texto plano que selecciono el usuario

												if (bandera == 0) {

													bandera = 1;//se imprime los datos que corresponden al codigo del estudiante 

													jtnombre.setEditable(false);

													jtcodigo.setEditable(false);

													jtdocumento.setEditable(false);
												
													jtsemestre.setEditable(false);

													jtnacimiento.setEditable(false);

													jtdirreccion.setEditable(false);

													jttelefono.setEditable(false);

													jtcorreo.setEditable(false);

													jtnombre.setText(informacion[i - 1]);

													jtcodigo.setText(informacion[i]);

													jtdocumento.setText(informacion[i + 1]);

													jtsemestre.setText(informacion[i + 2]);

													jtnacimiento.setText(informacion[i + 3]);

													jtdirreccion.setText(informacion[i + 4]);

													jttelefono.setText(informacion[i + 5]);

													jtcorreo.setText(informacion[i + 6]);

													JOptionPane.showMessageDialog(null,
															" Para poder seguir introduciendo \n datos en el programa por favor \n limpie los campos.");

												}

											}

										}

										if (bandera == 0) {//condicional para verificar si se encontro el estudiante si no se imprime en pantalla un mensaje

											JOptionPane.showMessageDialog(null, "No se a encontrado al estudiante");

										}		

									}else{
										
										JOptionPane.showMessageDialog(null, "Tiene que ingresar el codigo del estudiante que va a buscar");
										
									}

							} else {

								JOptionPane.showMessageDialog(null,
										"-----------------------ERROR-------------------- \n .--Porfavor ingrese el codigo \n    del estudiante que desea buscar.");

							}

						}

					}

				}

			}

		}

	}

