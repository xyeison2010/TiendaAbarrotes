
package Modelo;


public class Producto {
    private int idproducto;
    private String nomprod;
    private int idprov;
    private int idcat;
    private String cantxunid;
    private double precio;
    private int unidexis;

    public Producto() {
    }

    public Producto(int idproducto, String nomprod, int idprov, int idcat, String cantxunid, double precio, int unidexis) {
        this.idproducto = idproducto;
        this.nomprod = nomprod;
        this.idprov = idprov;
        this.idcat = idcat;
        this.cantxunid = cantxunid;
        this.precio = precio;
        this.unidexis = unidexis;
    }

    public int getUnidexis() {
        return unidexis;
    }

    public void setUnidexis(int unidexis) {
        this.unidexis = unidexis;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getCantxunid() {
        return cantxunid;
    }

    public void setCantxunid(String cantxunid) {
        this.cantxunid = cantxunid;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
