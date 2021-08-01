package Modelo;

public class Proveedor {
    private int idproveedor;
    private String nomprov;
    public Proveedor(int idproveedor, String nomprov) {
        this.idproveedor = idproveedor;
        this.nomprov = nomprov;
    }
    public Proveedor() {   }
    public int getIdproveedor() {  return idproveedor;    }
    public void setIdproveedor(int idproveedor) {        this.idproveedor = idproveedor;    }
    public String getNomprov() {        return nomprov;    }
    public void setNomprov(String nomprov) {        this.nomprov = nomprov;    }

}
