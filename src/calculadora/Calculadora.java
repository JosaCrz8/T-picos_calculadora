/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author JOSAFAT
 */
//importamos librerias 
import java.awt.*;//
import java.awt.event.ActionEvent;//accion del evento
import java.awt.event.ActionListener;
import javax.swing.*;//para los componentes

//importamos las librerias que creamos de las operaciones
import OperacionesBasicas.OperacionSuma;
import OperacionesBasicas.OperacionResta;
import OperacionesBasicas.OperacionDivision;
import OperacionesBasicas.OperacionMultiplicacion;

public class Calculadora extends JFrame implements ActionListener {
    //declaramos los nombre de los componentes 
  private JButton botonsuma,botonresta,botonnmulti,botondivision,botonlimpiar,botonsalir;
 private JTextField txtnumero1,txtnumero2,txtResultado;
 JLabel lblnumero1,lblnumero2,lblresultado;
  
 
 //constructor de la clase
 public Calculadora(){
  
      super("Calculadora");//titulo de la ventana
      
      setSize(480,350);//tamaño de la ventana
      setLocationRelativeTo(null);//Centrar ventana
      setResizable(false);//para poder maximizar o minimizar la ventana
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar ventana
      //cargo milamina o el panel
       MiLamina();//agregamos el metodo
 }
 
 
 //creamos un metodo para el contenedor y para los componentes
 public void MiLamina(){
   
      Container contenedor = getContentPane();
     // contenedor.setLayout( new FlowLayout());
      contenedor.setLayout(null);
      contenedor.setBackground(Color.yellow);//color de fondo
      
      //creamos la etiqueta numero 1
      lblnumero1 = new JLabel("Numero 1");
      lblnumero1.setBounds(50, 60, 100, 20);//posicion y tamaño de la etiqueta
      contenedor.add(lblnumero1);//agregamos la etiqueta al contenedor
       
     //creamos el campo de texto de numero 1
      txtnumero1 = new JTextField();
      txtnumero1.setBounds(120, 60, 200, 20);//posicion y tamaño del campo de texto
      contenedor.add(txtnumero1);//agregamos el campo al contenedor
      
        //creamos la etiqueta numero 2
      lblnumero2 = new JLabel("Numero 2");
      lblnumero2.setBounds(50, 90, 100, 20);//posicion y tamaño de la etiqueta
      contenedor.add(lblnumero2);//agregamos la etiqueta al contenedor
      
       //creamos el campo de texto de numero 2
      txtnumero2 = new JTextField();
      txtnumero2.setBounds(120, 90, 200, 20);//posicion y tamaño del campo de texto
      contenedor.add(txtnumero2);//agregamos el campo de texto al contenedor
      
        //creamos la etiqueta resultado
      lblresultado = new JLabel("Resultados");
      lblresultado.setBounds(50, 120, 100, 20);//posicion y tamaño de la etiqueta
      contenedor.add(lblresultado);//agregamos la etiqueta al contenedor
      
       //creamos el campo de texto de resultados
      txtResultado = new JTextField();
       txtResultado.setBounds(120, 120, 200, 20);//posicion y tamaño del campo de texto
      contenedor.add(txtResultado);//agregamos el campo al contenedor
      
      //creamos el boton suma
      botonsuma = new JButton("Suma");
       botonsuma.setBounds(20, 180, 80, 30);
       botonsuma.setBackground(Color.MAGENTA);
      contenedor.add(botonsuma);
      botonsuma.addActionListener(this);//para generar evento al dar clic
      
       //creamos el boton resta
      botonresta = new JButton("Resta");
      botonresta.setBounds(120, 180, 80, 30);
      botonresta.setBackground(Color.LIGHT_GRAY);
      contenedor.add(botonresta);
      botonresta.addActionListener(this);
      
       //creamos el boton multiplicacion
      botonnmulti = new JButton("Multiplicacion");
      botonnmulti.setBounds(220, 180, 120, 30);
      botonnmulti.setBackground(Color.PINK);
      contenedor.add(botonnmulti);
      botonnmulti.addActionListener(this);
      
       //creamos el boton division
     botondivision = new JButton("Division");
     botondivision.setBounds(350, 180, 80, 30);
     botondivision.setBackground(Color.CYAN);
     contenedor.add(botondivision);
     botondivision.addActionListener(this);
     
      
       //creamos el boton limpiar
      botonlimpiar = new JButton("Limpiar");
      botonlimpiar.setBounds(150, 250, 80, 30);
      botonlimpiar.setBackground(Color.green);
      contenedor.add(botonlimpiar);
      botonlimpiar.addActionListener(this);
      
       //creamos el boton salir
      botonsalir=new JButton("Salir");
      botonsalir.setBackground(Color.red);
      botonsalir.setBounds(250, 250, 80, 30);
      contenedor.add(botonsalir);
      botonsalir.addActionListener(this);
 }
  
  //metodo para el accion del evento
 public void actionPerformed(ActionEvent e) {
     //instanciamos las clases de nuestro librerias de operacioness
      //OperacionSuma s = new OperacionSuma();
        OperacionResta r = new OperacionResta();
        OperacionMultiplicacion m= new OperacionMultiplicacion();
        OperacionDivision d= new OperacionDivision();
        
     int  num1,num2,resu;
     String resultado;
        if (e.getSource()==botonsuma) {
         if(txtnumero1.getText().equals("") || txtnumero2.getText().equals(""))
         {
          JOptionPane.showMessageDialog(null, "Los datos están Incompletos",
          "Error",JOptionPane.ERROR_MESSAGE); 
         }
         else{
          //num1 = Integer.parseInt(s.suma(valor1.getText()));
          num1=Integer.parseInt(txtnumero1.getText());
          num2=Integer.parseInt(txtnumero2.getText());
          
          resu=OperacionSuma.suma(num1,num2);
         
          resultado=String.valueOf(resu);
          txtResultado.setText(resultado);
         }          
        }
        if (e.getSource()==botonresta) {
         if(txtnumero1.getText().equals("") ||txtnumero2.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Los datos están Incompletos",
          "Error",JOptionPane.ERROR_MESSAGE); 
         }
         else{
           num1=Integer.parseInt(txtnumero1.getText());
          num2=Integer.parseInt(txtnumero2.getText());
           resu=r.resta(num1,num2);
          resultado=String.valueOf(resu);
          txtResultado.setText(resultado);
         }          
        } 
        if (e.getSource()==botonnmulti) {
         if(txtnumero1.getText().equals("") || txtnumero2.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Los datos están Incompletos",
          "Error",JOptionPane.ERROR_MESSAGE); 
         }
         else{
         num1=Integer.parseInt(txtnumero1.getText());
          num2=Integer.parseInt(txtnumero2.getText());
           resu=m.multiplicacion(num1,num2);
          resultado=String.valueOf(resu);
          txtResultado.setText(resultado);
         }          
        }
        if (e.getSource()==botondivision) {
         if(txtnumero1.getText().equals("") || txtnumero2.getText().equals(""))
         {
          JOptionPane.showMessageDialog(null, "Los datos están Incompletos",
          "Error",JOptionPane.ERROR_MESSAGE);
         }
         
         else{
          num1=Integer.parseInt(txtnumero1.getText());
          num2=Integer.parseInt(txtnumero2.getText());
          resu=d.division(num1,num2);
           resultado=String.valueOf(resu);
           txtResultado.setText(resultado);
          
           
         }  
        }
        //funcion del boton limpiar
        if (e.getSource()==botonlimpiar){
         txtnumero1.setText("");
            txtnumero2.setText("");
           txtResultado.setText("");
       } 
        //funcion del boton salir
        if(e.getSource()==botonsalir)
        {
         System.exit(0);   
        }
    }
 
     //el metodo principal
    public static void main(String[] args) {
      
      Calculadora calc = new Calculadora();//Instanciamos la clase que creamos
      calc.setVisible(true);//lo hacemos visible
    }
      
  
    
}