//
package Modelo;


public class Categoria {
    private int codigo; //codigo viene ser idcategoria
    private String nombre;
    private String descr;
    public Categoria(){}
    public Categoria(int codigo, String nombre, String descr) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descr = descr;
    }

    public int getCodigo() {       return codigo;    }
    public void setCodigo(int codigo) {        this.codigo = codigo;    }
    public String getNombre() {        return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getDescr() {        return descr;    }
    public void setDescr(String descr) {        this.descr = descr;    }
    
}
