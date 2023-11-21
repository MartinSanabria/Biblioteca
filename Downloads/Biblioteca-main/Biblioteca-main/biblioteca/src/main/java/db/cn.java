/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Path;
import java.nio.file.Paths;

/**@author reqp*/
public class cn {
    private Connection con;
    public cn() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
            
            if (con != null) {
                // Verificar si la base de datos existe y crearla si es necesario
                if (!databaseExists()) {
                    createDatabase();
                }
            } else {
                System.err.println("La conexión es nula. No se pudo conectar a la base de datos.");
            }
            
        }catch (Exception e){
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection() {
        return con;
    }
    
     private boolean databaseExists() {
        try {
            System.out.println("Vamos aqui");
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE biblioteca");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void createDatabase() {
        try {
            Statement stmt = con.createStatement();
            System.out.println("COmenzando la creacion");
            // Ruta al archivo .sql (ajustada para reflejar la estructura del proyecto)
            Path path1 = Paths.get("C:\\Users\\PC\\Downloads\\Biblioteca-main\\Biblioteca-main\\biblioteca\\src\\main\\java\\db\\cn.java");
            Path path2 = Paths.get("C:\\Users\\PC\\Downloads\\Biblioteca-main\\Biblioteca-main\\biblioteca\\src\\main\\webapp\\Assets\\database.sql");
             Path relativePath = path1.relativize(path2);
        
            // Imprime la ruta relativa entre ambos path
            System.out.println("Ruta relativa: " + relativePath);
            String archivoSQL = "C:\\Users\\PC\\Downloads\\Biblioteca-main\\Biblioteca-main\\biblioteca\\src\\main\\webapp\\Assets\\database.sql";

            // Lee el archivo .sql con el script de creación de la base de datos
            BufferedReader br = new BufferedReader(new FileReader(archivoSQL));
            StringBuilder sb = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }

            br.close();

            // Ejecuta el script SQL para crear la base de datos
            String[] instruccionesSQL = sb.toString().split(";");

            for (String sql : instruccionesSQL) {
                stmt.addBatch(sql);
            }

            stmt.executeBatch();
        } catch (Exception e) {
            System.err.println("Error al crear la base de datos: " + e);
        }
    }
}

