import javax.swing.*;

/**
 * Created by erickchali on 10/9/14.
 */
public class Inicar {

    public static void main(String[] args){

        CrearLogin cl = new CrearLogin();
        cl.setSize(300,200);
        cl.setLocationRelativeTo(null);
        cl.setResizable(false);
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }
}
