package practica1edd;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class LeerArchivo {
        Menu m = new Menu();
       
    
public  void CargarXml(String nombre){
    
    ListaSimpleDPalabras Dic = new ListaSimpleDPalabras();


          
    //Se crea un SAXBuilder para poder parsear el archivo
    SAXBuilder builder = new SAXBuilder();
    
    
    //File xmlFile = new File( "C:\\Users\\Fernando\\Desktop\\Archivo.xml" );
    File xmlFile = new File(nombre);     
    try
    {
        
        //Se crea el documento a traves del archivo
        Document document = (Document) builder.build( xmlFile );
 
        //Se obtiene la raiz 'scrabble'
        Element rootNode = document.getRootElement();
 
        //Se obtiene la lista de hijos de la raiz 'scrabble'
        List list = rootNode.getChildren( "dobles" );
        List listdimension = rootNode.getChildren("dimension");
        List listTriples = rootNode.getChildren("triples");
        List listdiccionario = rootNode.getChildren("diccionario");
        
        /* --------------- LEER DIMENSION ----------------*/
        for (int q = 0; q < listdimension.size(); q++) {
         Element D = (Element)listdimension.get( q );
         String Dim = D.getTextTrim();
         
         System.out.println( "DIMENSION " +Dim );
                System.out.println( "*******************************" );
        }
         
        
        /* --------------- LEER DOBLES ----------------*/ 
        //Se recorre la lista de hijos de 'dobles'
        for ( int a = 0; a < list.size(); a++ )
        {
            //Se obtiene el elemento 'dobles'
            Element tabla = (Element) list.get(a);

            //Se obtiene la lista de hijos del tag 'dobles'
            List lista_campos = tabla.getChildren();
 
 
            //Se recorre la lista de casilla
            for ( int b = 0; b < lista_campos.size(); b++ )
            {
                //Se obtiene el elemento 'casilla'
                Element campo = (Element)lista_campos.get( b );
         
                //Se obtienen los valores que estan entre los tags '<casilla></casilla>'
                //Se obtiene el valor que esta entre los tags '<x></x>'
                String Etiquetax = campo.getChildTextTrim("x");
 
                //Se obtiene el valor que esta entre los tags '<y></y>'
                String Etiquetay = campo.getChildTextTrim("y");
 
                System.out.println( "DOBLES " );
                System.out.println( "\t"+Etiquetax+"\t"+Etiquetay+"\t\t");
               
            }
        }
        System.out.println( "*******************************" );
        
        /* --------------- LEER TRIPLES ----------------*/
        
        //Se recorre la lista de hijos de 'triples'
        for ( int i = 0; i < listTriples.size(); i++ )
        {
            //Se obtiene el elemento 'triples'
            Element triple = (Element) listTriples.get(i);

            //Se obtiene la lista de hijos del tag 'triples'
            List lista_campos = triple.getChildren();
 
 
            //Se recorre la lista de casilla
            for ( int j = 0; j < lista_campos.size(); j++ )
            {
                //Se obtiene el elemento 'casilla'
                Element campo = (Element)lista_campos.get( j );
         
                //Se obtienen los valores que estan entre los tags '<casilla></casilla>'
                //Se obtiene el valor que esta entre los tags '<x></x>'
                String Etiquetax = campo.getChildTextTrim("x");
 
                //Se obtiene el valor que esta entre los tags '<y></y>'
                String Etiquetay = campo.getChildTextTrim("y");
 
                System.out.println( "TRIPLES " );
                System.out.println( "\t"+Etiquetax+"\t"+Etiquetay+"\t\t");
               
            }
        }
        System.out.println( "*******************************" );
        
        
 
           
           
        /* --------------- LEER DICCIONARIO ----------------*/
        
        //Se recorre la lista de hijos de 'dobles'
        for ( int z = 0; z < listdiccionario.size(); z++ )
        {
            //Se obtiene el elemento 'dobles'
            Element diccionario = (Element) listdiccionario.get(z);

            //Se obtiene la lista de hijos del tag 'dobles'
            List lista_palabras = diccionario.getChildren();
            
            
           for (int q = 0; q < lista_palabras.size(); q++) {
                Element P = (Element)lista_palabras.get( q );
                String pal = P.getTextTrim();
         
                System.out.println( "PALABRAS " +pal );
                Dic.agregarAlFinal(pal);
                
                
            }
            
        }
        
        
        Dic.Graficar();
            
            
        
    }catch ( IOException io ) {
        System.out.println( io.getMessage() );
    }catch ( JDOMException jdomex ) {
        System.out.println( jdomex.getMessage() );
    }
    
    
    
    
}


    
}
