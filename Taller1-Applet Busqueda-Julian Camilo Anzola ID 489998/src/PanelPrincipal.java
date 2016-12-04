/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Uniminuto(Bogota- Colombia)
 * Departamento de Ingenieria de Sistemas 
 * Licenciado bajo el esquema Academic Free License 
 *
 * Taller Objetos Applets
 * Ejercicio: Metodos De Busqueda
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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPrincipal extends JPanel implements ActionListener{
	
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
     * Es el campo de texto usado para ver el conjunto de numeros ingresado 
     * por el usuario
     */
	private JTextField jtverarchivo;
	/**
     * Es el campo de texto usado para ingresar el numero que desea
     * buscar el ususario en el conjunto de numeros
     */
	private JTextField jtnumerobusqueda;;
	/**
     * Es el campo de texto usado para ver en que posicion se
     * encuentra el numero que el ususario busca
     */
	private JTextField jtnumeroencontrado;
	/**
     * Es el campo de texto usado para ver el conjunto de numeros organizados
     */
	private JTextField jtnumerosordenados;
	
	//-------------------------------------------------------
	
	/**
     * Es una etiqueta que genera un espacio para poder 
     * acomodar el JMenuBar  en la interfaz
     */
	private JLabel jlespacio;
	 /**
     * Etiqueta para ubicar la frase archivo leido o numeros ingresados
     *  antes del campo de jtverarhcivo
     */
	private JLabel jlverarchivo;
	 /**
     * Etiqueta para ubicar la frase numero que desea buscar
     *  antes del campo de jtnumerobusqueda
     */
	private JLabel jlnumerobusqueda;
	 /**
     * Etiqueta para ubicar la frase el numero se encuentra en la posicion
     *  antes del campo de jtnumeroencontrado
     */
	private JLabel jlnumeroencontrado;
	 /**
     * Etiqueta para ubicar la frase conjunto de numeros ordenados
     *  antes del campo de jtvnumerosordenados
     */
	private JLabel jlnumerosordenados;
	
	//----------------------------------------------------
	
	/**
     * Es la barra de soporte que permite agregar la pestaña
     * jmleery jmotros 
     */
	private JMenuBar jmbsoporte;
	
	//-----------------------------------------------------
	
	/**
     * Es la pestaña que permite agregar las opciones de leer texto plano,
     * guardar texto y ingresar numeros
     */
	private JMenu jmleer;
	/**
     * Es la pestaña que permite agregar las opciones de limpiar y salir
     */
	private JMenu jmotros;
	
	//----------------------------------------------------
	
	/**
     * Es la opcion que permite leer el texto plano
     */
	private JMenuItem jbileertexto;
	/**
     * Es la opcion que permite ingresar un conjunto de numeros
     * nuevo
     */
	private JMenuItem jbiingresarnumeros;
	/**
     * Es la opcion que permite guardar el texto plano
     */
	private JMenuItem jbiguardar;
	/**
     * Es la opcion que limpia los cuadros de texto
     */
	private JMenuItem jbilimpiar;
	/**
     * Es la opcion que permite cerrar el programa
     */
	private JMenuItem jbisalir;
	
	//-------------------------------------------------------
	
	/**
     * Es la opcion de que metodo de busqueda desea el usuario
     */
	private JComboBox jcbusqueda;
	
	//----------------------------------------------------------
	
	/**
     * Es el boton para buscar un numero determinado en un conjunto de numeros
     */
	private JButton jbbuscar;
	
	//----------------------------------------------------------
	
	/**
     * Comando leer texto
     */
	public static final String leertexto="leertexto";
	/**
     * Comando ingresar numeros
     */
	public static final String ingresarnumeros="ingresarnumeros";
	/**
     * Comando buscar
     */
	public static final String buscar="buscar";
	/**
     * Comando guardar texto
     */
	public static final String guardartexto="guardar";
	/**
     * Comando limpiar
     */
	public static final String limpiar="limpiar";
	/**
     * Comando salir
     */
	public static final String salir="salir";

	 //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	/**
	 * Crea el panel PanelPrincipal con el applet
	 *
	 * @param applet
	 *            Ventana principal. v != null.
	 */
	
	public PanelPrincipal(Applet applet){
		
		//---------------------------------------------------------------
		
		this.applet=applet;
		this.setLayout(new GridLayout(6,2));
		
		//----------------------------------------------------------------
		
		jmbsoporte=new JMenuBar();
		jmleer=new JMenu("Busqueda");
		
		jbileertexto=new JMenuItem("Leer Texto Plano");
		jbiingresarnumeros=new JMenuItem("Ingresar Conjuntos De numeros");
		
		jlespacio=new JLabel();
		jlverarchivo=new JLabel("Archivo Leido o Numeros Ingresados:");
		
		jtverarchivo=new JTextField();
		jlnumerobusqueda=new JLabel("Numero Que Desea Buscar:");
		
		jtnumerobusqueda=new JTextField();
		jlnumeroencontrado=new JLabel("El Numero Se Encuentra En La Posicion:");
		
		jtnumeroencontrado=new JTextField();
		
		jcbusqueda=new JComboBox();
		jbbuscar=new JButton("Buscar");
		
		jlnumerosordenados=new JLabel("Conjunto De Numeros Ordenados:");
		jtnumerosordenados=new JTextField();
		
		jbiguardar=new JMenuItem("Guardar");
		jmotros=new JMenu("Otros");
		
		jbilimpiar=new JMenuItem("Limpiar");
		jbisalir=new JMenuItem("Salir");
		
		//----------------------------------------------------------
		
		jcbusqueda.addItem("Binary Search");
		jcbusqueda.addItem("Interpolation Search");
		
		jcbusqueda.addItem("Linear Search");
		
		//----------------------------------------------------------
		
		jbileertexto.addActionListener(this);
		jbileertexto.setActionCommand(leertexto);
		
		jbiingresarnumeros.addActionListener(this);
		jbiingresarnumeros.setActionCommand(ingresarnumeros);
		
		jbbuscar.addActionListener(this);
		jbbuscar.setActionCommand(buscar);
		
		jbiguardar.addActionListener(this);
		jbiguardar.setActionCommand(guardartexto);
		
		jbilimpiar.addActionListener(this);
		jbilimpiar.setActionCommand(limpiar);
		
		jbisalir.addActionListener(this);
		jbisalir.setActionCommand(salir);
		
		//---------------------------------------------------------
		
		jmleer.add(jbileertexto);
		jmleer.add(jbiingresarnumeros);
		
		jmleer.add(jbiguardar);
		jmbsoporte.add(jmleer);
		
		jmbsoporte.add(jmotros);
		jtnumerosordenados.setEditable(false);
		
		jmotros.add(jbilimpiar);
		jmotros.add(jbisalir);
		
		//---------------------------------------------------------
		
		add(jmbsoporte);
		add(jlespacio);
		
		add(jlverarchivo);
		add(jtverarchivo);
		
		add(jlnumerosordenados);
		add(jtnumerosordenados);
		
		add(jlnumerobusqueda);
		add(jtnumerobusqueda);
		
		add(jlnumeroencontrado);
		add(jtnumeroencontrado);
		
		add(jcbusqueda);
		add(jbbuscar);
		
		//----------------------------------------------------------
		
	}

	/**
	 * Este metodo ejecuta las acciones adecuadas segun el boton que haya sido
	 * presionado
	 *
	 * @param e
	 *            Es el evento del click sobre el boton
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(leertexto)){
			
			jtverarchivo.setText(applet.leer());
			
		}else{
			
			if(comando.equals(ingresarnumeros)){
				
				String numeros="";
				
				numeros=JOptionPane.showInputDialog("Porfavor ingrese los numeros \n separandolos por una coma (,) \n si los separa por mas de una coma \n O ingresar numeros y signos \n Extraños va a arrojar error.");
				
				jtverarchivo.setText(numeros);
				
			}else{
				
				if(comando.equals(buscar)){
					
					try{
						
					if(jtverarchivo.getText()!=null){
					
						String copia=jtverarchivo.getText();
						
						String[] correccion=copia.split(",");//recorre la String y añade todo lo que se encuentre antes de una (,)
						
						int copia2=Integer.parseInt(jtnumerobusqueda.getText());//se optiene el numero que el usuario desea buscar
						
						int index=jcbusqueda.getSelectedIndex();// se optiene el metodo de busqueda que el usuario desea
						
						int[] vector=new int[correccion.length];
						
						for(int i=0;i<correccion.length;i++){
							
							vector[i]=Integer.parseInt(correccion[i]);//se copia lo encuentra en el arreglo donde se copio los numeros que el usuario ingreso a un vector entero para que posteriorente
																							//ese vector pueda ser ordenado
							
						}
						
						applet.busqueda(index, copia2,vector);
						
					}else{
						JOptionPane.showMessageDialog(null, "-------------------ERROR--------------- \n --Tiene que ingresar un conjunto de numeros \n    o leer un archivo de texto plano.");
					}
					
					}catch(Exception error){
						
						JOptionPane.showMessageDialog(null,"--------------ERROR-------------- \n --- POSIBLES ERRORES: \n \n -- Solo se pueden introducir numeros. \n -- Solo se puede separar por una coma \n    los numeros no introducir mas de una coma (,) \n    en la separacion de los numeros. \n -- No ingresar signos extraños. \n -- Tiene que ingresar el conjunto \n    de numeros o leer un archivo \n    de texto plano que contenga \n    el conjunto de numeros. \n --Tiene que ingresar el numero \n    que desea buscar. \n --"+error);
					
					}
					
				}else{
					
					if(comando.equals(guardartexto)){
						
						if(jtnumerosordenados.getText().length()!=0){//condicional para poder controlar que no arroje error a la hora de abrir la interfaz de busqueda de archivo
							
							JOptionPane.showMessageDialog(null,applet.guardar(jtverarchivo.getText(),jtnumerosordenados.getText(),jtnumerobusqueda.getText(),jtnumeroencontrado.getText()));//se optiene los datos de los campos de texto para ser guardados
							
							
						}else{
							
							JOptionPane.showMessageDialog(null," No se puede guardar \n ya que no se encuentra ningun \n dato organizado o la posicion \n en la que se encuentra el numero \n ingresado.");
							
						}
				
					}else{
						
						if(comando.equals(limpiar)){
							
							jtverarchivo.setText("");
							
							jtnumerosordenados.setText("");
							
							jtnumerobusqueda.setText("");
							
							jtnumeroencontrado.setText("");
							
						}else{
							
							if(comando.equals(salir)){
								
								System.exit(0);
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	/**
	 * Este metodo imprime la posicion en la que se encuentra el numero que el
	 * usuario ingreso para ser buscado en el conjunto de numeros
	 * <b>pre:</b>para que la posicion pueda ser impresa dicha posicion tiene
	 * que ser de tipo entero<br>
	 * <b>post:</b>se a impreso la posicion en la que se encuentra el numero<br>
	 * 
	 * @param pocision
	 *            posicion el la que se encuentra el numero
	 */
	
	public void imprimir(int pocision){
		
		String copia="";
		
		if(pocision!=-1){
			
			copia=copia+pocision;
		
			jtnumeroencontrado.setText(copia);
			
		}else{
			
			copia="El numero ingresado no se encuentra";
			
			jtnumeroencontrado.setText(copia);
		
		}
			
	}
	
	/**
	 * Este metodo imprime el conjunto de numeros ordenados <b>pre:</b>para que
	 * los datos puedan ser impresos tiene que ser un arraglo de tipo entero<br>
	 * <b>post:</b>se a impreso el arreglo ordenado<br>
	 * 
	 * @param numeros
	 *            conjuntos de numeros ordenados
	 */
	
	public void imprimir2(int[] numeros){
		
		String copia="";
		
			for(int i=0;i<numeros.length;i++){
				
				copia=copia+numeros[i];
				
				if(i!=numeros.length-1){
					
					copia=copia+",";
			
			}
			
			jtnumerosordenados.setText(copia);
			
		}
		
	}
	
}
