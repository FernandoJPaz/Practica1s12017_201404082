/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1edd;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Fernando
 */
public class ListaSimpleDPalabras {
    
    // Puntero que indica el inicio de la lista 
    private NodoLS inicio;
    // Puntero que indica el final de la lista o el ultimo nodo.
    private NodoLS ultimo;
    // Variable para registrar el tamaño de la lista.
    private int tamanio;
    
    public void Lista(){
        inicio = null;
        ultimo = null;
        tamanio = 0;
    }
    
    /**
     * Consulta si la lista esta vacia.
     * @return true si el primer nodo (inicio), no apunta a otro nodo.
     */
    public boolean esVacia(){
        return inicio == null;
    }
    
    /**
     * Agrega un nuevo nodo al final de la lista circular.
     * @param valor a agregar.
     */
    
     public void agregarAlFinal(String valor){
        // Define un nuevo nodo.
        NodoLS nuevo = new NodoLS();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        System.out.println("agregaste : "+valor );
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            // De igual forma el ultimo nodo sera el nuevo.
            ultimo = nuevo;
            // Y el puntero del ultimo debe apuntar al primero.
            ultimo.setSiguiente(inicio);
        // Caso contrario el nodo se agrega al final de la lista.
        } else{
            // Apuntamos con el ultimo nodo de la lista al nuevo.
            ultimo.setSiguiente(nuevo);
            // Apuntamos con el nuevo nodo al inicio de la lista.
            nuevo.setSiguiente(inicio);
            // Como ahora como el nuevo nodo es el ultimo se actualiza
            // la variable ultimo.
            ultimo = nuevo;
        }
        // Incrementa el contador de tamaño de la lista
        tamanio++;
    }
    
    
    
    public void listar(){
        System.out.println("PRUEBA");
         // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            NodoLS aux = inicio;
            NodoLS a = ultimo;
            // Posicion de los elementos de la lista.
            int i = 0;
            System.out.print("-> ");
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getValor() + " ]" + " ->  ");
                tamanio++;
                
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                
                i++;
            }while(aux != inicio);
        }
    }
          
    public void Graficar(){
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\Fernando\\Desktop\\LS.txt");
            
            pw = new PrintWriter(fichero);
            pw.append("digraph listaCircular{ \n");
            pw.append("\tnode [fontcolor=\"white\", height=0.5, color=\"black\"]\n");
            pw.append("[shape=box, style=filled, color=black]");
            pw.append("\tedge  [color=\"black\", dir=fordware]\n");
            pw.append("\trankdir=LR\n");
            
            
            // Verifica si la lista contiene elementoa.
            if (!esVacia()) {
            // Crea una copia de la lista.
            NodoLS aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            System.out.print("-> ");
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getValor() + " ]" + " ->  ");
                
                if (i==0) {
                     pw.append( aux.getValor());
                }
                
                if (aux.getSiguiente()!= null && i!=0) {
                    pw.append("->"+aux.getValor());
                }
                               
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                               
                // Incrementa el contador de la posión.
                
                i++;
            }while(aux != inicio);
            
                
            
                if (aux == aux.getSiguiente()) {
                    aux=null;
                }
            
                
            }
            
            pw.append("\n}");
         
            
              
             
                String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
                
                String fileInputPath = "C:\\Users\\Fernando\\Desktop\\LS.txt";
                String fileOutputPath = "C:\\Users\\Fernando\\Desktop\\LS.png";
      
                String tParam = "-Tpng";
                String tOParam = "-o";
                
                
                String[] cmd = new String[5];
                cmd[0] = dotPath;
                cmd[1] = tParam;
                cmd[2] = fileInputPath;
                cmd[3] = tOParam;
                cmd[4] = fileOutputPath;

                Runtime rt = Runtime.getRuntime();

                rt.exec( cmd );

          
                   
                    
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
               
              fichero.close();
             
 
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        
    
    }      
          
}
