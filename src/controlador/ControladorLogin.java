/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.PunteoDAO;
import modelo.PunteoVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmIntermedio;
import vista.FrmLogin;
import vista.FrmPrincipiante;

/**
 *
 * @author Usuario
 */
public class ControladorLogin implements ActionListener {

    FrmLogin vista = new FrmLogin();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    FrmAdministrador ad = new FrmAdministrador();
    FrmPrincipiante pri = new FrmPrincipiante();
    FrmIntermedio inte = new FrmIntermedio();
    FrmAvanzado ava = new FrmAvanzado();
    PunteoVO pvo = new PunteoVO();
    PunteoDAO pdao = new PunteoDAO();

    public ControladorLogin(FrmLogin vista, UsuarioVO uvo, UsuarioDAO udao, FrmAdministrador ad, FrmPrincipiante pri, FrmIntermedio inte, FrmAvanzado ava,PunteoVO pvo,PunteoDAO pdao) {
        this.vista = vista;
        this.uvo = uvo;
        this.udao = udao;
        this.ad = ad;
        this.pri = pri;
        this.inte = inte;
        this.ava = ava;
        this.pvo = pvo;
        this.pdao = pdao;
        
        vista.btnIngresar.addActionListener(this);
    }

    public void comprobar() {
        char p[] = vista.txtContraseña.getPassword();
        String contra = new String(p);
        if (vista.txtUsuario.getText().isEmpty() || contra.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar un usuario y una contraseña");
        } else {
            System.out.println(uvo.getId_tipo_usuario_fk());
            String user = vista.txtUsuario.getText();
            ArrayList<UsuarioVO> list;
            list = udao.validacion(uvo);
            //udao.validacion(user, contra);
            System.out.println(uvo.getId_tipo_usuario_fk());
            if (list.size() == 1) {
                //if (uvo.getId_tipo_usuario_fk() ==1) {
                JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                vista.dispose();
                ad.setVisible(true);
//                }else if(uvo.getId_tipo_usuario_fk() ==2){
//                     JOptionPane.showMessageDialog(null, "segunda ventana");
//                }else if(uvo.getId_tipo_usuario_fk() ==3){
//                     JOptionPane.showMessageDialog(null, "tercera ventana");
                //}
//            }else if (list.size()==2){
//                JOptionPane.showMessageDialog(null, "segunda ventana");
            } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado");
            }
        }
    }

    public void verificar() {
        try {
            //System.out.println(uvo.getId_tipo_usuario_fk());
            char p[] = vista.txtContraseña.getPassword();
            String contra = new String(p);
            uvo.setContraseña(contra);
            uvo.setUsuario(vista.txtUsuario.getText());
            udao.validacion(uvo);
            if (vista.txtUsuario.getText().isEmpty() || contra.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe de ingresar un usuario y una contraseña");
            } else {
                //uvo.getUsuario().equals(vista.txtUsuario.getText());
                //System.out.println(list);
                //System.out.println("+-+"+list.get(1));
                //int d = uvo.getId_tipo_usuario_fk();
                switch (udao.dato) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                        vista.dispose();
                        ad.setVisible(true);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                        vista.dispose();
                        pri.setVisible(true);
                        this.insertarPunteo();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                        vista.dispose();
                        inte.setVisible(true);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                        vista.dispose();
                        ava.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private void insertarPunteo() {
        try {
            pvo.setPunteo_score(100);
            pvo.setId_usuario_fk(udao.idnivel);
            pdao.insertar(pvo);
            JOptionPane.showMessageDialog(null, "Su Punteo Ahora es de 100 puntos\nSe restaran puntos por cada acierto fallido ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "punteo no ingresado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {
            //this.comprobar();
            this.verificar();
        }
    }
}
