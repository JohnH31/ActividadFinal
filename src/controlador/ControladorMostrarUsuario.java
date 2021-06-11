/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmMostrarUsuario;

/**
 *
 * @author Usuario
 */
public class ControladorMostrarUsuario implements ActionListener, MouseListener, WindowListener {

    FrmAdministrador ad = new FrmAdministrador();
    FrmMostrarUsuario vista = new FrmMostrarUsuario();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();

    public ControladorMostrarUsuario(FrmAdministrador ad, UsuarioVO uvo, UsuarioDAO udao, FrmMostrarUsuario vista) {
        this.ad = ad;
        this.uvo = uvo;
        this.udao = udao;
        this.vista = vista;

        vista.addWindowListener(this);
        ad.btnMostrar.addActionListener(this);
        vista.tblMostrarUsuarios.addMouseListener(this);
    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del Usuario");
        m.addColumn("Apellido del Usuario");
        m.addColumn("Edad del Usuario");
        m.addColumn("Usuario");
        m.addColumn("Contraseña");
        m.addColumn("Id Estado");
        m.addColumn("Id tipo de usuario");
        for (UsuarioVO uvo : udao.consultarTabla()) {
            m.addRow(new Object[]{uvo.getId_usuario(), uvo.getNombre_usuario(), uvo.getApellido_usuario(), uvo.getEdad_usuario(), uvo.getUsuario(), uvo.getContraseña(), uvo.getId_estado_fk(), uvo.getId_tipo_usuario_fk()});

        }
        vista.tblMostrarUsuarios.setModel(m);
    }

    private void datos() {
        int row;
        row = vista.tblMostrarUsuarios.getSelectedRow();
        uvo.setId_usuario(Integer.parseInt(vista.tblMostrarUsuarios.getValueAt(row, 0).toString()));
        ad.txtNombre.setText(String.valueOf(vista.tblMostrarUsuarios.getValueAt(row, 1)));
        ad.txtApellido.setText(String.valueOf(vista.tblMostrarUsuarios.getValueAt(row, 2)));
        ad.txtEdad.setText(String.valueOf(vista.tblMostrarUsuarios.getValueAt(row, 3)));
        ad.txtUsuario.setText(String.valueOf(vista.tblMostrarUsuarios.getValueAt(row, 4)));
        ad.txtContraseño.setText(String.valueOf(vista.tblMostrarUsuarios.getValueAt(row, 5)));
        uvo.setId_estado_fk((int) vista.tblMostrarUsuarios.getValueAt(row, 6));
        uvo.setId_tipo_usuario_fk((int) vista.tblMostrarUsuarios.getValueAt(row, 7));
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ad.btnMostrar) {
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.datos();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
