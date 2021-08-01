
package Modelo;

import java.util.ArrayList;

public class ListaProveedores {
    ArrayList<Proveedor> lista;
    public ListaProveedores(){
        lista = new ArrayList();
    }
    public void AgregarProveedor(Proveedor p){ lista.add(p); }
    public Proveedor RecuperarProveedor(int pos){  return lista.get(pos); }
    
}
