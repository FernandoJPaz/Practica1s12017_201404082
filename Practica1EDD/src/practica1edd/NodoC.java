package practica1edd;

public class NodoC {
    // Variable en la cual se va a guardar el valor.
    private String valor;
    // Variable para enlazar los nodos.
    private NodoC siguiente;
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void NodoC(){
        this.valor = "";
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    } 
    
}
