import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 * Created by erickchali on 10/9/14.
 */
public class Conexiones {
    Admin a = new Admin();
    public Conexiones(){
        String nombreArchivo = a.tipoArchivo;
        File archivo = new File(nombreArchivo);
        if (a.tipoArchivo.equals("Producto")){
            try{
                Scanner ingresoDatos = new Scanner(archivo);
                while(ingresoDatos.hasNext()){
                    String data = ingresoDatos.next();
                    String[] valores = data.split(",");
                    System.out.println(valores[0]+" "+valores[1]+" "+valores[2]+" "+valores[3]+" "+valores[4]);
                }
                ingresoDatos.close();
            }catch(Exception e){
                System.out.println("No hay archivo");
            }
        }

    }
}
