
package DAO;

import Modelo.Producto;


public interface ImplementarCrudProd {
    public void Create(Producto p);
    public Producto Read(int codprod);
    public void Update(Producto p);
    public void Delete(int codprod);
    
}
