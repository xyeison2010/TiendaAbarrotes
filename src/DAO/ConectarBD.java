
package DAO;
//librerias
import Formatos.Mensajes;
import java.sql.*;

public class ConectarBD {
    public Connection cn; // objeto que tiene la conexion a la BD
    public ConectarBD(){
         try{
             //1. Driver de Conexion
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             //2. Hacemos la conexion
             cn = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=pedidos","leo","leo");
          // Mensajes.MD("Conexion a BD OK!!!");
         }catch(Exception e){
            Mensajes.MD("Error en conexion "+e);
         }
    }
    
}
