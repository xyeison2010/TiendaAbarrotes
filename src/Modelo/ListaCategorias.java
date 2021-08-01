
package Modelo;

import java.util.ArrayList;


public class ListaCategorias {
    ArrayList<Categoria> lista;
    public ListaCategorias(){
        lista=new ArrayList();
    }
    public void AgregarCategoria(Categoria c){ lista.add(c); }
    public Categoria RecuperarCategoria(int pos){ return lista.get(pos); }
}
