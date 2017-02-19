/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1edd;

/**
 *
 * @author Fernando
 */
public class NodoCabecera {
    
    
    NodoCabecera siguiente;
    NodoCabecera anterior, abajo, arriba;
    Object valor;
    int posx, posy;
    
    public NodoCabecera( Object val, int px, int py){
        this.valor=val;
        this.posx=px;
        this.posy=py;
        this.abajo=null;
        this.arriba=null;
        this.anterior=null;
        this.siguiente=null;
    }
    public Object obtenerValor()
    {
        return valor;
    }
    public Object obtenerPx()
    {
        return valor;
    }
    public Object obtenerPy()
    {
        return valor;
    }
    
    public void enlazarSiguiente(NodoCabecera sig)
    {
        siguiente= sig;
    }
    public void enlazarAnterior(NodoCabecera ant)
    {
        anterior= ant;
    }
    public void enlazarArriba(NodoCabecera arr)
    {
        arriba= arr;
    }
    public void enlazarAbajo(NodoCabecera abj)
    {
        abajo= abj;
    }
    
    public NodoCabecera obtenerSiguiente()
    {
        return siguiente;
    }
    public NodoCabecera obtenerAnterior()
    {
        return anterior;
    }
    public NodoCabecera obtenerArriba()
    {
        return arriba;
    }
    public NodoCabecera obtenerAbajo()
    {
        return abajo;
    }
}
