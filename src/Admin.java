import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Created by erickchali on 10/9/14.
 */
public class Admin extends JFrame implements ActionListener {

    //componentes principales
    String tipoArchivo;
    String leyenda;
    JTabbedPane tabs;
    JButton cerrarSesion;
    JLabel sesion, rol;
    JPanel reporte, producto, venta, empleado;
    //componentes tab reportes
    //componentes tab producto
    JLabel lblCodigoProducto,lblNombreProducto,lblPrecioProducto,lblCantidadProducto;
    JTextField txtCodigoProducto,txtNombreProducto,txtPrecioProducto,txtCantidadProducto;
    JButton btnProductoAgregar, btnProductoModificar, btnProductoEliminar;
    JRadioButton rbAgregarProducto,rbModificarProducto,rbEliminarProducto;
    ButtonGroup bgProducto;
    //componentes tab venta
    //componentes tab empleados
    JButton btnEmpleadosAgregar,btnEmpleadosModificar,btnEmpleadosEliminar;
    JLabel lblIngUsuario,lblIngClave,lblIngRol,lblIngNombre,lblIngFoto,lblIngEdad,lblIngPhone,lblIngAddress,lblIngFechaIngreso;
    JTextField txtIngUsuario,txtIngClave,txtIngNombre,txtIngFoto,txtIngEdad,txtIngPhone,txtIngAddress,txtIngFechaIngreso;
    JComboBox<String> cbRolEmpleado;
    JRadioButton rbAgregarEmpleado,rbModificarEmpleado,rbEliminarEmpleado;
    ButtonGroup bgEmpleado;
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
        crearModuloEmpleado();
        crearModuloProducto();
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
    public void crearModuloProducto() {
        bgProducto = new ButtonGroup();
        rbAgregarProducto = new JRadioButton("Agreagar");
        rbAgregarProducto.addActionListener(this);
        rbModificarProducto = new JRadioButton("Modificar");
        rbModificarProducto.addActionListener(this);
        rbEliminarProducto = new JRadioButton("Eliminar");
        rbEliminarProducto.addActionListener(this);
        bgProducto.add(rbAgregarProducto);
        bgProducto.add(rbModificarProducto);
        bgProducto.add(rbEliminarProducto);

        lblCodigoProducto = new JLabel("Codigo");
        lblCodigoProducto.setPreferredSize(new Dimension(680, 25));
        lblNombreProducto = new JLabel("Nombre");
        lblNombreProducto.setPreferredSize(new Dimension(680, 25));
        lblPrecioProducto = new JLabel("Precio");
        lblPrecioProducto.setPreferredSize(new Dimension(680, 25));
        lblCantidadProducto = new JLabel("Precio");
        lblCantidadProducto.setPreferredSize(new Dimension(680, 25));

        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setPreferredSize(new Dimension(680,25));
        txtNombreProducto = new JTextField();
        txtNombreProducto.setPreferredSize(new Dimension(680,25));
        txtPrecioProducto = new JTextField();
        txtPrecioProducto.setPreferredSize(new Dimension(680,25));
        txtCantidadProducto = new JTextField();
        txtCantidadProducto.setPreferredSize(new Dimension(680, 25));

        btnProductoAgregar = new JButton("Agregar");
        btnProductoAgregar.addActionListener(this);
        btnProductoModificar = new JButton("Modificar");
        btnProductoModificar.addActionListener(this);
        btnProductoEliminar = new JButton("Eliminar");
        btnProductoEliminar.addActionListener(this);

        producto.add(rbAgregarProducto);
        producto.add(rbModificarProducto);
        producto.add(rbEliminarProducto);
        producto.add(lblCodigoProducto);
        producto.add(txtCodigoProducto);
        producto.add(lblNombreProducto);
        producto.add(txtNombreProducto);
        producto.add(lblPrecioProducto);
        producto.add(txtPrecioProducto);
        producto.add(lblCantidadProducto);
        producto.add(txtCantidadProducto);
        producto.add(btnProductoAgregar);
        producto.add(btnProductoModificar);
        producto.add(btnProductoEliminar);

    }
    public void crearModuloEmpleado(){
        String[] roles = new String[] {"1","2"};
        bgEmpleado =  new ButtonGroup();
        rbAgregarEmpleado = new JRadioButton("Agreagar");
        rbAgregarEmpleado.addActionListener(this);
        rbModificarEmpleado = new JRadioButton("Modificar");
        rbModificarEmpleado.addActionListener(this);
        rbEliminarEmpleado = new JRadioButton("Eliminar");
        rbEliminarEmpleado.addActionListener(this);
        bgEmpleado.add(rbAgregarEmpleado);
        bgEmpleado.add(rbModificarEmpleado);
        bgEmpleado.add(rbEliminarEmpleado);

        lblIngUsuario =  new JLabel("Usuario");
        lblIngUsuario.setPreferredSize(new Dimension(680, 25));
        lblIngClave =  new JLabel("Clave");
        lblIngClave.setPreferredSize(new Dimension(680,25));
        lblIngRol =  new JLabel("Rol del empleado");
        lblIngRol.setPreferredSize(new Dimension(680,25));
        lblIngNombre =  new JLabel("Nombre");
        lblIngNombre.setPreferredSize(new Dimension(680,25));
        lblIngFoto =  new JLabel("Foto");
        lblIngFoto.setPreferredSize(new Dimension(680,25));
        lblIngEdad =  new JLabel("Edad");
        lblIngEdad.setPreferredSize(new Dimension(680,25));
        lblIngPhone =  new JLabel("Telefono");
        lblIngPhone.setPreferredSize(new Dimension(680,25));
        lblIngAddress =  new JLabel("Direccion");
        lblIngAddress.setPreferredSize(new Dimension(680,25));
        lblIngFechaIngreso =  new JLabel("Fecha Inicio dd/mm/aaaa");
        lblIngFechaIngreso.setPreferredSize(new Dimension(680,25));
        btnEmpleadosAgregar = new JButton("Agregar");
        btnEmpleadosAgregar.addActionListener(this);
        btnEmpleadosModificar = new JButton("Modificar");
        btnEmpleadosModificar.addActionListener(this);
        btnEmpleadosEliminar = new JButton("Eliminar");
        btnEmpleadosEliminar.addActionListener(this);

        txtIngUsuario = new JTextField();
        txtIngUsuario.setPreferredSize(new Dimension(680,25));
        txtIngClave = new JTextField();
        txtIngClave.setPreferredSize(new Dimension(680,25));
        txtIngNombre = new JTextField();
        txtIngNombre.setPreferredSize(new Dimension(680,25));
        txtIngFoto = new JTextField();
        txtIngFoto.setPreferredSize(new Dimension(680,25));
        txtIngEdad = new JTextField();
        txtIngEdad.setPreferredSize(new Dimension(680,25));
        txtIngPhone = new JTextField();
        txtIngPhone.setPreferredSize(new Dimension(680,25));
        txtIngAddress = new JTextField();
        txtIngAddress.setPreferredSize(new Dimension(680,25));
        txtIngFechaIngreso = new JTextField();
        txtIngFechaIngreso.setPreferredSize(new Dimension(680,25));
        cbRolEmpleado = new JComboBox<String>(roles);
        cbRolEmpleado.setPreferredSize(new Dimension(680,25));

        empleado.add(rbAgregarEmpleado);
        empleado.add(rbModificarEmpleado);
        empleado.add(rbEliminarEmpleado);
        empleado.add(lblIngUsuario);
        empleado.add(txtIngUsuario);
        empleado.add(lblIngClave);
        empleado.add(txtIngClave);
        empleado.add(lblIngRol);
        empleado.add(cbRolEmpleado);
        empleado.add(lblIngNombre);
        empleado.add(txtIngNombre);
        empleado.add(lblIngFoto);
        empleado.add(txtIngFoto);
        empleado.add(lblIngEdad);
        empleado.add(txtIngEdad);
        empleado.add(lblIngPhone);
        empleado.add(txtIngPhone);
        empleado.add(lblIngAddress);
        empleado.add(txtIngAddress);
        empleado.add(lblIngFechaIngreso);
        empleado.add(txtIngFechaIngreso);
        empleado.add(btnEmpleadosAgregar);
        empleado.add(btnEmpleadosModificar);
        empleado.add(btnEmpleadosEliminar);
    }
    public void recibirUsuario(String usuario){
        this.leyenda = usuario.toUpperCase();
    }
    @Override
    public void actionPerformed(ActionEvent boton) {
        if(boton.getSource()==btnProductoAgregar){
            String nombreArchivo = "Producto.csv";
            File archivo = new File(nombreArchivo);
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
