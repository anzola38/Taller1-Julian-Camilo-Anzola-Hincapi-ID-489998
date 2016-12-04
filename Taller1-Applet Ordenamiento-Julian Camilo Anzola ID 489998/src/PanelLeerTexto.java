/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Uniminuto(Bogota- Colombia)
 * Departamento de Ingenieria de Sistemas 
 * Licenciado bajo el esquema Academic Free License 
 *
 * Taller Objetos Applets
 * Ejercicio: Metodos De Ordenamientos
 * Autor: Julian camilo anzola - 31/11/2016
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelLeerTexto extends JPanel implements ActionListener{
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
     * Etiqueta para ubicar la palabra archivo leido antes del campo de jtverarchivo
     */
	private JLabel jlarchivoleido;
	 /**
     * Etiqueta para ubicar la palabra texto editado o ordenado antes del campo de jlarchivo
     */
	private JLabel jlarchivoordenado;
	 /**
     * Etiqueta para ubicar un espacion despues de jmbsoporte
     */
	private JLabel jlespacio;
	
	//---------------------------------------------------------------------------
	
	/**
     * Es el campo de texto usado para visualizar la lectura del texto plano
     * o para visualizar el cojunto de numeros que ingresa el usuario
     */
	private JTextField jtverarchivo;
	/**
     * Es el campo de texto usado para ver el conjunto de numeros organizados
     * o para editar dicho conjunto de numeros
     */
	private JTextArea jtordenararchivo;
	
	
	//----------------------------------------------------------------------------------
	
	/**
     * Es la barra de soporte que permite agregar la pestaña
     * jmeditararchivo y jmleer 
     */
	private JMenuBar jmbsoporte;
	/**
     * Es la pestaña que permite agregar las opciones de leer texto,
     * guardar texto
     */
	private JMenu jmleer;
	/**
     * Es la pestaña que permite agregar la opcion de ingresar numeros
     */
	private JMenu jmeditararchivo;
	/**
     * Es la opcion que permite leer el texto plano
     */
	private JMenuItem jbileertexto;
	/**
     * Es la opcion que permite guardar el texto plano
     */
	private JMenuItem jbiguardartexto;
	/**
     * Es la opcion que permite ingresar un conjunto de numeros nuevo
     */
	private JMenuItem jbiingresarnumero;
	
	//----------------------------------------------------------------------------------
	
	/**
     * Es la opcion de que metodo de ordenamiento desea el usuario
     */
	private JComboBox jcordenamiento;
	
	//---------------------------------------------------------------------------------
	
	/**
     * Es el boton para ordenar el conjunto de numeros
     */
	private JButton jbordenar;
	/**
     * Es el boton para limpiar el panel
     */
	private JButton jblimpiar;
	/**
     * Es el boton para salir
     */
	private JButton jbsalir;
	
	//--------------------------------------------------------------------------------------
	
	/**
     * Comando leer texto
     */
	public static final String leertexto="leertexto";
	/**
     * Comando guardar texto
     */
	public static final String guardartexto="guardartexto";
	/**
     * Comando ordenar
     */
	public static final String ordenar="ordenar";
	/**
     * Comando limpiar
     */
	public static final String limpiar="limpiar";
	/**
     * Comando ingresar numero
     */
	public static final String ingresarnumero="ingresarnumero";
	/**
     * Comando salir
     */
	public static final String salir="salir";
	
	 //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	/**
	 * Crea el panel leer texto con el applet
	 *
	 * @param applet
	 *            Ventana principal. v != null.
	 */
	
	public PanelLeerTexto(Applet applet){
		
		//----------------------------------------------------------------------------------------
		
		this.applet=applet;
		this.setLayout(new GridLayout(5,2));

		//------------------------------------------------------------------------------------------
		
		jlarchivoleido=new JLabel("Archivo Leido o Numeros Ingresados:");
		jlarchivoordenado=new JLabel("Texto Plano Editable o Ordenado:");
		
		jlespacio=new JLabel();
		jtverarchivo=new JTextField();
		
		jtordenararchivo=new JTextArea();
		jcordenamiento=new JComboBox();
		
		jblimpiar=new JButton("Limpiar");
		jbordenar=new JButton("Ordenar");
		
		jmleer=new JMenu("Archivo");
		jmbsoporte=new JMenuBar();
		
		jmeditararchivo=new JMenu("Ingresar");
		jbileertexto=new JMenuItem("Leer Texto Plano");

		jbiguardartexto=new JMenuItem("Guardar En Texto Plano");
		jbiingresarnumero=new JMenuItem("Ingresar Numeros");
		
		jbsalir=new JButton("Salir");
		
		//---------------------------------------------------------------------------------------
		
		jcordenamiento.addItem("Bubble Sort");
		jcordenamiento.addItem("Radix Sort");
	
		jcordenamiento.addItem("Merge Sort");	
		jcordenamiento.addItem("Quick Sort");
		
		jcordenamiento.addItem("Counting Sort");
		
		//---------------------------------------------------------------------------------------------
		
		jbileertexto.addActionListener(this);
		jbileertexto.setActionCommand(leertexto);
		
		jbordenar.addActionListener(this);
		jbordenar.setActionCommand(ordenar);
		
		jbiguardartexto.addActionListener(this);
		jblimpiar.setActionCommand(limpiar);
		
		jblimpiar.addActionListener(this);
		jbiguardartexto.setActionCommand(guardartexto);
		
		jbiingresarnumero.addActionListener(this);
		jbiingresarnumero.setActionCommand(ingresarnumero);
		
		jbsalir.addActionListener(this);
		jbsalir.setActionCommand(salir);
		
		//------------------------------------------------------------------------------------
		
		jmleer.add(jbileertexto);
		jmleer.add(jbiguardartexto);
		
		jmeditararchivo.add(jbiingresarnumero);
		jmbsoporte.add(jmleer);
		
		jmbsoporte.add(jmeditararchivo);
		
		//--------------------------------------------------------------------------------------
		
		add(jmbsoporte);
		add(jlespacio);
		
		add(jlarchivoleido);
		add(jtverarchivo);
		
		add(jlarchivoordenado);
		add(jtordenararchivo);
	
		add(jcordenamiento);
		add(jbordenar);
		
		add(jblimpiar);
		add(jbsalir);
		
		//--------------------------------------------------------------------------------------------
		
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
		
		if(comando.equals(leertexto)){
		
			jtverarchivo.setText("");
			
			jtverarchivo.setText(applet.leer());
			
		}else{
			
			if(comando.equals(ordenar)){
				
				try{
					
					int index=jcordenamiento.getSelectedIndex(); //se obtiene el metodo de ordenamiento que el usuario selecciono
					
					String numeros=jtverarchivo.getText();// se obtiene el conjunto de numeros a ordenar por medio del cuadro de texto jverarchivo
					
					String[] vector2=numeros.split(",");//recorre la String y añade todo lo que se encuentre antes de una (,)	
					
					int[] vector=new int[vector2.length];
					
					for(int i=0;i<vector2.length;i++){
					
						vector[i]=Integer.parseInt(vector2[i]);//se pasa el arreglo vector2 a el arreglo vector para tener un arreglo de tipo entero
					
					}
					
					applet.Ordenar(vector, index, vector2);
				
				}catch(Exception error){
			
					JOptionPane.showMessageDialog(null,"---------------------ERROR----------------------- \n POSIBLES ERRORES: \n \n -- No se a ingresado ningun \n    dato para organizar. \n -- Los numeros ingresados o el archivo \n    Leido tiene mas de una coma (,) \n    O contine letras o simbolos extraños. \n --"+e);
				
				}
				
			}else{
				
				if(comando.equals(guardartexto)){
					
					String copia=jtordenararchivo.getText();//se obtiene el conjunto de numeros ordenados del cuadro de texto jtordenararchivo
					
					if(copia.length()!=0){
			
						JOptionPane.showMessageDialog(null,applet.guardar(copia));
						
					}else{
						
						JOptionPane.showMessageDialog(null," No se puede guardar \n Ya que no se encuentra ningun \n Dato organizado.");
						
					}
			
				}else{
					
					if(comando.equals(limpiar)){
						
						jtverarchivo.setText("");
						
						jtordenararchivo.setText("");
						
					}else{
						
							
							if(comando.equals(ingresarnumero)){
								
								String numeros="";
								
								numeros=JOptionPane.showInputDialog("Porfavor ingrese los numeros \n separandolos por una coma (,) \n si los separa por mas de una coma \n O ingresar numeros y signos \n Extraños va a arrojar error.");
								
								jtverarchivo.setText(numeros);
								
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
	 * este metodo imprime los numeros ordenados que son enviados de la interfaz
	 * <b>pre:</b>para que los datos puedan ser impresos tiene que ser un
	 * arraglo de tipo entero<br>
	 * <b>post:</b>se a impreso el arreglo ordenado<br>
	 * 
	 * @param numeros
	 *            conjunto de numeros ordenados
	 */
	
	public void imprimir(int[] numeros){
		
		String copia="";
		
		for(int i=0;i<numeros.length;i++){
			
			copia=copia+numeros[i];//se copia el arreglo ordenado a una String para poder mostrarse en el campo de texto jtordenararchivo
			
			if(i!=numeros.length-1){
				
				copia=copia+",";
				
			}else{
				
			}
			
			
			
		}
		
		jtordenararchivo.setText(copia);
		
	}

	/**
	 * este metodo imprime el conjunto de numeros ordenados es exclusivo para el
	 * radix sort <b>pre:</b>para que los datos puedan ser impresos tiene que
	 * ser una matriz de tipo entero<br>
	 * <b>post:</b>se a impreso el conjunto de numeros oganizados<br>
	 * 
	 * @param numeros
	 *            conjunto de numeros ordenados
	 */
	
	public void imprimir2(int[][] numeros){
		
		String impresion="";
		
		String copia="";
		
		for(int i=0;i<numeros.length;i++){
			
			for(int j=0;j<numeros[i].length;j++){
				
				impresion=impresion+numeros[i][j];//se pasa lo que se encuentra de la matriz a una String con el proposito de quitar los saltos de linea que se esncuentran dentro de ella
				
			}
			if(i!=numeros.length-1){
			
				impresion=impresion+",";
				
			}
		
		}
		
		int bandera=0;
		
		/*
		 * las lineas de codigo restantes en este metodo se usan para quitar los 0 que vienen dentro de la String
		 * Con el fin de que el formato de impresion quede de la siguente manera 1,2,4,5,12,45 en vez
		 * de que quede como viene el radix sort que es en una matriz con un conjunto de 0 y los numeros 
		 * organizados ejemplo:
		 * 001
		 * 002
		 * 032
		 * 123
		 */
		
		for(int i=0;i<impresion.length();i++){
			
			if(bandera==0&&(Character.toString(impresion.charAt(i))).equals("0")){//condicional que sirve para quitar los 0
				
				
			}else{
				
				if((Character.toString(impresion.charAt(i))).equals(",")){//condicional que agrega (,) con el fin de saparar los numeros
					
					bandera=0;
					
					copia=copia+",";
					
				}else{
				
					bandera=1;
					
					copia=copia+(Character.toString(impresion.charAt(i)));//linea que guarda los numeros sin los 0 en el siguiente formato 1,2,3,13.23
					
				}
				
				
				
			}
			
		}
		
		jtordenararchivo.setText(copia);
		
	}

}
