import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by erickchali on 10/9/14.
 */
public class Admin extends JFrame implements ActionListener {

    //componentes principales
    String leyenda;
    JTabbedPane tabs;
    JButton cerrarSesion;
    JLabel sesion, rol;
    JPanel reporte, producto, venta, empleado;
    //componentes tab reportes
    //componentes tab producto
    //componentes tab venta
    //componentes tab empleados
    JButton btnEmpleadosAgregar,btnEmpleadosModificar,btnEmpleadosEliminar;
    JLabel lblIngUsuario;
    JLabel ingu,ingc,ingni,ingn,ingf,inge,ingt,ingd,ingfe;
    public Admin(){
        super("Administradores");
        this.setLayout(new FlowLayout());
        iniciarComponentes();
        //Agregando componenetes a las pestañas
        tabs.add("Reporte", reporte);
        tabs.add("Producto", producto);
        tabs.add("Venta", venta);
        tabs.add("Empleados", empleado);

        //agregando a la ventana principal.
        this.add(rol);
        this.add(cerrarSesion);
        this.add(tabs);
    }

    public void iniciarComponentes() {
        crearPantallaPrincipal();
    }

    public void crearPantallaPrincipal() {
        tabs = new JTabbedPane();

        cerrarSesion = new JButton("Cerrar sesion");
        rol =  new JLabel("MODULO DE ADMINISTRADOR");
        rol.setHorizontalAlignment(SwingConstants.CENTER);
        rol.setPreferredSize(new Dimension(680,25));
        reporte =  new JPanel();
        reporte.setPreferredSize(new Dimension(680,600));
        reporte.setLayout(new FlowLayout());
        producto =  new JPanel();
        producto.setPreferredSize(new Dimension(680,600));
        producto.setLayout(new FlowLayout());
        venta =  new JPanel();
        venta.setPreferredSize(new Dimension(680,600));
        venta.setLayout(new FlowLayout());
        empleado =  new JPanel();
        empleado.setPreferredSize(new Dimension(680, 600));
        empleado.setLayout(new FlowLayout());
    }

    public void recibirUsuario(String usuario){
        this.leyenda = usuario.toUpperCase();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
