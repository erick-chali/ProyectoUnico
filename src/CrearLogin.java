/**
 * Created by erickchali on 10/9/14.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Created by erickchali on 10/9/14.
 */
public class CrearLogin extends JFrame implements ActionListener {
    String linea = "";
    File db;
    JTextField usuario;
    JLabel u,c;
    JButton login;
    JPasswordField pass;

    public CrearLogin(){
        super("Login");

        this.setLayout(new FlowLayout());

        u = new JLabel("Usuario");
        c = new JLabel("Clave");

        usuario = new JTextField();
        usuario.setPreferredSize(new Dimension(275,25));

        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(275,25));

        login = new JButton("Login");
        login.addActionListener(this);

        this.add(u);
        this.add(usuario);
        this.add(c);
        this.add(pass);
        this.add(login);
    }
    public void tipoEmpleado(String usuario, String contra){
        String nombreArchivo = "DB.csv";
        File archivo = new File(nombreArchivo);

        try{
            Scanner ingresoDatos = new Scanner(archivo);
            while(ingresoDatos.hasNext()){
                String data = ingresoDatos.next();
                String[] valores = data.split(",");
                if(valores[1].equals(usuario)&&valores[2].equals(contra)){
                    if(valores[3].equals("1")){
                        System.out.println("Admin");
                        for(int x = 0 ; x<=8 ; x++){
                            linea =linea + valores[x] + " ";
                        }
                        System.out.println(linea);
                        Admin a = new Admin();
                        a.recibirUsuario(valores[1]);
                        a.setSize(700,750);
                        a.setLocationRelativeTo(null);
                        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        a.setResizable(false);
                        a.setVisible(true);
                        this.dispose();
                    }else{
                        System.out.println("User");
                        User u = new User();
//                        u.setLocationRelativeTo(null);
//                        u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                        u.setSize(700,750);
//                        u.setResizable(false);
//                        u.setVisible(true);
//                        this.dispose();
                    }
                }else{
//                    JOptionPane.showMessageDialog(null,"El usuario o clave incorrectos");
                }
            }
            ingresoDatos.close();
        }catch(Exception e){
            System.out.println("No hay archivo");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            char [] password;
            String usr="",clave="";
            usr = usuario.getText().toString();
            password = pass.getPassword();
            for(int x=0;x<password.length;x++){
                clave += password[x];
            }
            if(usr.equals("")||clave.equals("")){
                JOptionPane.showMessageDialog(this, "Debe llenar ambos campos");
            }else{
                tipoEmpleado(usr,clave);
            }

        }
    }
}

