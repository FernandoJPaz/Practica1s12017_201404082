package practica1edd;

/**
 *
 * @author Fernando
 */
import java.io.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static practica1edd.LeerArchivo.dimension;
public class Matriz {
    
    
    
    
    File f;
    FileWriter w;
    BufferedWriter bw;
    PrintWriter wr;    
    JLabel[][] textos;
    NodoCabecera cabecera;

    int sizex;
    int sizey;
    Object nombre;   
    
    public Matriz(){
        cabecera=new NodoCabecera("Matriz",-1,-1);
        sizex=0;
        sizey=0;
        nombre=cabecera.valor;
    } 
    
    public void addNodo(Object obj, int x, int y){
        boolean existe=false;
        boolean existex=false;
        NodoCabecera nuevoX=new NodoCabecera("X:",x,-1);
        NodoCabecera nuevoY=new NodoCabecera("Y:",-1,y);
        NodoCabecera nuevo=new NodoCabecera(obj,x,y);
        NodoCabecera tfila=cabecera;
        NodoCabecera tcolumna=cabecera;
        if(sizex<nuevo.posx && sizey<nuevo.posy)
        {
            while(tfila.siguiente!=null)
            {
                tfila=tfila.siguiente;
            }
            while(tcolumna.abajo!=null)
            {
                tcolumna=tcolumna.abajo;
            }
        }else if(sizex-1<nuevo.posx)
        {
            while(tfila.siguiente!=null && nuevo.posx>=tfila.obtenerSiguiente().posx)
            {
                tfila=tfila.siguiente;
            }
            while(tcolumna.abajo!=null && nuevo.posy>=tcolumna.obtenerAbajo().posy)
            {
                tcolumna=tcolumna.abajo;
            }
            while(tcolumna.siguiente!=null && tcolumna.posy==nuevo.posy)
            {
                tcolumna=tcolumna.siguiente;
            }
        }else if(sizey-1<nuevo.posy)
        {
            while(tfila.siguiente!=null && nuevo.posx>=tfila.obtenerSiguiente().posx)
            {
                tfila=tfila.siguiente;
            }
            while(tfila.abajo!=null && tfila.posx==nuevo.posx )
            {
                tfila=tfila.abajo;
            }
            while(tcolumna.abajo!=null && nuevo.posy>=tcolumna.obtenerAbajo().posy)
            {
                tcolumna=tcolumna.abajo;
            }
        }else{
            
            while(nuevo.posx>tfila.posx && nuevo.posx<nuevo.posy)
            {
                tfila=tfila.siguiente;
                if(nuevo.posx==tfila.posx)
                {
                    existex=true;
                }
            }
            while(tfila.obtenerSiguiente()!=null && nuevo.posx>=tfila.obtenerSiguiente().posx)
            {
                tfila=tfila.siguiente;
                if(nuevo.posx==tfila.posx)
                {
                    existex=true;
                }
            }
            while(tfila.abajo!=null && nuevo.posy>tfila.obtenerAbajo().posy)
            {
                tfila=tfila.abajo;
            }
            while(nuevo.posy>tcolumna.posy && nuevo.posy<nuevo.posx)
            {
                tcolumna=tcolumna.abajo;
                if(existex==true && nuevo.posy==tcolumna.posy)
                {
                    existe=true;
                }
            }
            while(tcolumna.obtenerAbajo()!=null && nuevo.posy>=tcolumna.obtenerAbajo().posy)
            {
                tcolumna=tcolumna.abajo;
                if(existex==true && nuevo.posy==tcolumna.posy)
                {
                    existe=true;
                }
            }
            while(tcolumna.siguiente!=null && nuevo.posx>tcolumna.obtenerSiguiente().posx)
            {
                tcolumna=tcolumna.siguiente;
            }
        }
        if(existe==true)
        {
            System.out.println("Nodo invalido en posicion: ("+ nuevo.posx+","+nuevo.posy +") que contiene: " + nuevo.valor.toString());
        }else if(tfila.posx<nuevo.posx && tcolumna.posy<nuevo.posy){
            if(tfila.obtenerSiguiente()!=null)
            {
                tfila.obtenerSiguiente().enlazarAnterior(nuevoX);
                nuevoX.enlazarSiguiente(tfila.obtenerSiguiente());
            }
            if(tcolumna.obtenerAbajo()!=null)
            {
                tcolumna.obtenerAbajo().enlazarArriba(nuevoY);
                nuevoY.enlazarAbajo(tcolumna.obtenerAbajo());
            }
            tfila.enlazarSiguiente(nuevoX);
            tfila.obtenerSiguiente().enlazarAnterior(tfila);
            tfila= nuevoX;
            
            tcolumna.enlazarAbajo(nuevoY);
            tcolumna.obtenerAbajo().enlazarArriba(tcolumna);
            tcolumna=nuevoY;
            nuevo.enlazarArriba(tfila);
            nuevo.enlazarAnterior(tcolumna);
            tfila.enlazarAbajo(nuevo);
            tcolumna.enlazarSiguiente(nuevo);
            sizex++;
            sizey++;
        }else if(tfila.posx<nuevo.posx){
            if(tfila.obtenerSiguiente()!=null)
            {
                tfila.obtenerSiguiente().enlazarAnterior(nuevoX);
                nuevoX.enlazarSiguiente(tfila.obtenerSiguiente());
            }
            tfila.enlazarSiguiente(nuevoX);
            tfila.obtenerSiguiente().enlazarAnterior(tfila);
            tfila= nuevoX;
            nuevo.enlazarAnterior(tcolumna);
            nuevo.enlazarArriba(tfila);
            if(tcolumna.obtenerSiguiente()!=null)
            {
                nuevo.enlazarSiguiente(tcolumna.obtenerSiguiente());
                tcolumna.obtenerSiguiente().enlazarAnterior(nuevo);
            }
            tfila.enlazarAbajo(nuevo);
            tcolumna.enlazarSiguiente(nuevo);
            sizex++;
        }else if(tcolumna.posy<nuevo.posy) {
            if(tcolumna.obtenerAbajo()!=null)
            {
                tcolumna.obtenerAbajo().enlazarArriba(nuevoY);
                nuevoY.enlazarAbajo(tcolumna.obtenerAbajo());
            }
            tcolumna.enlazarAbajo(nuevoY);
            tcolumna.obtenerAbajo().enlazarArriba(tcolumna);
            tcolumna=nuevoY;
            nuevo.enlazarAnterior(tcolumna);
            nuevo.enlazarArriba(tfila);
            if(tfila.obtenerAbajo()!=null)
            {
                nuevo.enlazarAbajo(tfila.obtenerAbajo());
                tfila.obtenerAbajo().enlazarArriba(nuevo);
            }
            tfila.enlazarAbajo(nuevo);
            tcolumna.enlazarSiguiente(nuevo);
            sizey++;
        }else{
            nuevo.enlazarAnterior(tcolumna);
            nuevo.enlazarArriba(tfila);
            if(tfila.obtenerAbajo()!=null)
            {
                nuevo.enlazarAbajo(tfila.obtenerAbajo());
                tfila.obtenerAbajo().enlazarArriba(nuevo);
            }
            if(tcolumna.obtenerSiguiente()!=null)
            {
                nuevo.enlazarSiguiente(tcolumna.obtenerSiguiente());
                tcolumna.obtenerSiguiente().enlazarAnterior(nuevo);
            }
            tfila.enlazarAbajo(nuevo);
            tcolumna.enlazarSiguiente(nuevo);
        }
    }
 
    public void linealizarFilas(){
        System.out.println("POR FILAS");
        NodoCabecera faux=cabecera;
        NodoCabecera caux=cabecera;
        while(caux!=null){
            while(faux!=null){
                System.out.print("<--(" + faux.posx +","+ faux.posy +"): "+ faux.valor.toString() +"-->");
                faux=faux.siguiente;
            }
            System.out.println("^");
            caux=caux.abajo;
            faux=caux;
        }
        System.out.println("FIN POR FILAS");
    }
    
    public void linealizarColumnas(){
        Juego jue = new Juego();
        celda celda;
        JButton boton ;
        System.out.println("POR COLUMNAS");
        NodoCabecera faux=cabecera;
        NodoCabecera caux=cabecera;
        while(faux!=null){
            while(caux!=null){
                
                //System.out.print("<--(" + caux.posx +","+ caux.posy +"): "+ caux.valor.toString() +"-->");
                  celda=(celda) caux.valor;
                  boton=celda.getBoton();
                  boton.setBounds(celda.getPosx()*25, celda.getPosy()*25, 25, 25);
                  jue.add(boton);
                
                caux=caux.abajo;
            }
            System.out.println("^");
            faux=faux.siguiente;
            caux=faux;
        }
        jue.show();
        System.out.println("FIN POR COLUMNAS");
    }
    
    public void LlenarMatriz() {

        dimension =10;
        celda celda;
        for (int i = 0; i < dimension; i++) {
            for (int k = 0; k < dimension; k++) {
                celda = new celda();
                celda.setBoton(new JButton());
                celda.setPosx(i);
                celda.setPosy(k);

                celda.setValor(1);

                addNodo(celda, i, k);
            }
        }
    }
    
    public void graphMat2(){
         
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
                        
//            fichero = new FileWriter("C:\\Users\\Fernando\\Desktop\\MatrizOrtogonal.txt");
              fichero = new FileWriter("C:\\Users\\Fernando\\Documents\\NetBeansProjects\\Practica1EDD\\src\\Reportes\\MatrizOrtogonal.txt");
            pw = new PrintWriter(fichero);
            pw.append("Digraph G { \n");
            pw.append("Subgraph cluster_0{style= \"filled\"; fillcolor= \"#F3E2A9\"; label = \"MATRIZ\"; rankdir=LR;\n");
            pw.append("node [shape=rect color=blue style=\"filled\" fillcolor=\"#F2F2F2\"]; \n");
       

            NodoCabecera faux=cabecera;
            NodoCabecera caux=cabecera;
            while(caux!=null){
                while(faux!=null){
                    pw.append("nodo" + (faux.posx+1) + (faux.posy+1)+" [label=\" " +faux.valor.toString() + " /n ("+faux.posx+faux.posy+") /n\"];\n");
                    faux=faux.siguiente;
                }
                caux=caux.abajo;
                faux=caux;
            }
            faux=cabecera;
            caux=cabecera;
            while(caux!=null){
                pw.append("rank=same{");
                while(faux.siguiente!=null){
                    pw.append("nodo" + (faux.posx+1) + (faux.posy+1)+" -> "+"nodo" + (faux.siguiente.posx+1) + (faux.siguiente.posy+1)+";\n");
                    pw.append("nodo" + (faux.siguiente.posx+1) + (faux.siguiente.posy+1)+" -> "+"nodo" + (faux.posx+1) + (faux.posy+1)+";\n");
                    
                    faux=faux.siguiente;
                }
                pw.append("}");
                faux=cabecera;
                while(faux.siguiente!=null){
                    if(faux.abajo!=null)
                    {
                        pw.append("nodo" + (faux.posx+1) + (faux.posy+1)+" -> "+"nodo" + (faux.abajo.posx+1) + (faux.abajo.posy+1)+";\n");
                        pw.append("nodo" + (faux.abajo.posx+1) + (faux.abajo.posy+1)+" -> "+"nodo" + (faux.posx+1) + (faux.posy+1)+";\n");
                    }
                    faux=faux.siguiente;
                }
                if(faux.abajo!=null)
                {
                    pw.append("nodo" + (faux.posx+1) + (faux.posy+1)+" -> "+"nodo" + (faux.abajo.posx+1) + (faux.abajo.posy+1)+";\n");
                    pw.append("nodo" + (faux.abajo.posx+1) + (faux.abajo.posy+1)+" -> "+"nodo" + (faux.posx+1) + (faux.posy+1)+";\n");
                }
                caux=caux.abajo;
                faux=caux;
            }
            pw.append("}");
            pw.append("}");
            pw.close();
          
            System.out.println("FIN POR FILAS");
            
            
                String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
                
                String fileInputPath = "C:\\Users\\Fernando\\Documents\\NetBeansProjects\\Practica1EDD\\src\\Reportes\\MatrizOrtogonal.txt";
                String fileOutputPath = "C:\\Users\\Fernando\\Documents\\NetBeansProjects\\Practica1EDD\\src\\Reportes\\MatrizOrtogonal.png";
      
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
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "ha sucedido un error "+e);
        }
    }
          
  
 
    
    
    
}
