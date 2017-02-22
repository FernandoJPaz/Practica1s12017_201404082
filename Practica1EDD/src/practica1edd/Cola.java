package practica1edd;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Cola {
   
    private Object[] cola;
    private int frente;
    private int fin;
    
    public Cola(int tamanio)
    {
        cola = new Object[tamanio];
        frente = fin = -1;
    }

    
    
    public boolean esVacia()
    {
        return frente == fin;
    }
    
    public boolean esLLena()
    {
        return fin == cola.length-1;
    }
    
     public  void insert(Object elemento)
    {
        if(esLLena())
            System.out.println("La cola esta llena, elimine datos!");
        else
            cola[++fin] = elemento;
        System.out.println("se inserto : "+ elemento);
        
        
    }
     
     public Object Desencolar()
    {
        if(esVacia())
        {
            System.out.println("La cola esta vacia, inserte datos!");
            return "Cola vacia";
        }
        else
            return cola[++frente];
    }
     
    
    public void print()
    {
        if(esVacia())
            System.out.println("La cola esta vacia!");
        else if(frente == -1)
        {
            for(int i = 0; i <= fin; i++)
            {
                System.out.println(cola[i]);
            }
        }
        else
        {
            for(int j = frente; j <= fin; j++)
            {
                System.out.println(cola[j]);
            }
        }
    }
    
    
    public void Graficar (){
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        String co="";
        
        
        try
        {
            //fichero = new FileWriter("C:\\Users\\Fernando\\Desktop\\LC.txt");
            fichero = new FileWriter("C:\\Users\\Fernando\\Documents\\NetBeansProjects\\Practica1EDD\\src\\Reportes\\cola.txt");
            
            pw = new PrintWriter(fichero);
            pw.append("digraph Cola{ \n");
            pw.append("\tnode [fontcolor=\"white\", height=0.5, color=\"black\"]\n");
            pw.append("[shape=box, style=filled, color=black]");
            pw.append("\tedge  [color=\"black\", dir=fordware]\n");
            pw.append("\trankdir=LR\n");
            
            
            if(esVacia())
            System.out.println("La cola esta vacia!");
            else if(frente == -1)
            {
                for(int i = 0; i <= fin; i++){
                System.out.println(cola[i]);
                co=cola[i].toString();
                pw.append(co+" ");
                //co="";
                }
            }
            else
            {
                co="";
            for(int j = frente; j <= fin; j++)
                {
                System.out.println(cola[j]);
                co=cola[j].toString();
                pw.append(co+" ");
                //co="";
                }
            }
            
            
            
            pw.append("\n}");
         
            
              
             
                String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
                
                String fileInputPath = "C:\\Users\\Fernando\\Documents\\NetBeansProjects\\Practica1EDD\\src\\Reportes\\cola.txt";
                String fileOutputPath = "C:\\Users\\Fernando\\Documents\\NetBeansProjects\\Practica1EDD\\src\\Reportes\\cola.png";
      
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
