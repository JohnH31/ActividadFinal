/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.EstadoDAO;
import modelo.EstadoVO;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;

/**
 *
 * @author Usuario
 */
public class ControladorIngresarUsuario implements ActionListener {

    FrmAdministrador ad = new FrmAdministrador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();

    public ControladorIngresarUsuario(FrmAdministrador ad, UsuarioVO uvo, UsuarioDAO udao) {
        this.ad = ad;
        this.uvo = uvo;
        this.udao = udao;

        ad.btnAgregar.addActionListener(this);
        ad.btnReporte.addActionListener(this);

    }

    private void insertarUsuario() {
        try {
            uvo.setNombre_usuario(ad.txtNombre.getText());
            uvo.setApellido_usuario(ad.txtApellido.getText());
            uvo.setEdad_usuario(Integer.parseInt(ad.txtEdad.getText()));
            uvo.setUsuario(ad.txtUsuario.getText());
            uvo.setContraseña(ad.txtContraseño.getText());
            uvo.setId_estado_fk(Integer.parseInt(ad.cbxEstado.getSelectedItem().toString()));
            uvo.setId_tipo_usuario_fk(Integer.parseInt(ad.cbxTipoUsuario.getSelectedItem().toString()));
            udao.insertar(uvo);
            ad.txtNombre.setText("");
            ad.txtApellido.setText("");
            ad.txtEdad.setText("");
            ad.txtUsuario.setText("");
            ad.txtContraseño.setText("");
            ad.cbxEstado.setSelectedIndex(0);
            ad.cbxTipoUsuario.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Registro Ingresado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Datos para guardar registro!");
        }
    }

    public void cargarEstado(int buscar) {
        EstadoDAO edao = new EstadoDAO();
        int index = 1;
        ad.cbxEstado.removeAllItems();
        ad.cbxEstado.addItem("Seleccione Estado");
        for (EstadoVO evo : edao.consultarTabla()) {
            ad.cbxEstado.addItem(String.valueOf(evo.getId_estado()));
            //vista.cbxLibroAutor.addItem(lvo.getNombre_libro());
            if (evo.getId_estado() == buscar) {
                ad.cbxEstado.setSelectedIndex(index);
            }
            index++;
        }
    }

    public void cargarTipoUsuario(int buscar) {
        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        int index = 1;
        ad.cbxTipoUsuario.removeAllItems();
        ad.cbxTipoUsuario.addItem("Seleccione Estado");
        for (TipoUsuarioVO tuvo : tudao.consultarTabla()) {
            ad.cbxTipoUsuario.addItem(String.valueOf(tuvo.getId_tipo_usuario()));
            //vista.cbxLibroAutor.addItem(lvo.getNombre_libro());
            if (tuvo.getId_tipo_usuario() == buscar) {
                ad.cbxTipoUsuario.setSelectedIndex(index);
            }
            index++;
        }
    }

    private void reporte() {
        try {
            udao.reporte();
            udao.jv.setDefaultCloseOperation(ad.DISPOSE_ON_CLOSE);
            udao.jv.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte No generado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ad.btnAgregar) {
            this.insertarUsuario();
        }
        if (e.getSource() == ad.btnReporte) {
            this.reporte();
        }
    }

}
