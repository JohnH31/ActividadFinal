/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.IntermedioPreguntas;
import modelo.PunteoDAO;
import modelo.PunteoVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAvanzado;
import vista.FrmIntermedio;

/**
 *
 * @author Usuario
 */
public class ControladorIntermedio implements ActionListener {

    FrmIntermedio vista = new FrmIntermedio();
    IntermedioPreguntas ip = new IntermedioPreguntas();
    FrmAvanzado avan = new FrmAvanzado();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    PunteoVO pvo = new PunteoVO();
    PunteoDAO pdao = new PunteoDAO();

    public ControladorIntermedio(FrmIntermedio vista, IntermedioPreguntas ip, FrmAvanzado avan, UsuarioVO uvo, UsuarioDAO udao,PunteoVO pvo, PunteoDAO pdao) {
        this.vista = vista;
        this.ip = ip;
        this.avan = avan;
        this.udao = udao;
        this.uvo = uvo;
        this.pvo = pvo;
        this.pdao = pdao;

        vista.btnActivar.addActionListener(this);
        vista.btnComprobarI.addActionListener(this);
        vista.btnNivelI.addActionListener(this);
    }

    public void respuestas() {
        try {
            //pregunta1
            ip.setPregunta(vista.cbxPregunta1.getSelectedItem().toString());
            if (ip.getPregunta().equals(ip.respuesta1)) {
                ip.aciertos += 1;
                ip.intentos += 1;
                vista.jlbintentos.setText(String.valueOf(ip.intentos));
                vista.jlbAciertos.setText(String.valueOf(ip.aciertos));
            } else {
                ip.fallas += 1;
                ip.intentos += 1;
                vista.jlbintentos.setText(String.valueOf(ip.intentos));
                vista.jlbfallas.setText(String.valueOf(ip.fallas));
            }
            //pregunta2
            ip.setPregunta(vista.cbxPregunta2.getSelectedItem().toString());
            if (ip.getPregunta().equals(ip.respuesta2)) {
                ip.aciertos1 += 1;
                ip.intentos1 += 1;
                vista.jlbintentos1.setText(String.valueOf(ip.intentos1));
                vista.jlbAciertos1.setText(String.valueOf(ip.aciertos1));
            } else {
                ip.fallas1 += 1;
                ip.intentos1 += 1;
                vista.jlbintentos1.setText(String.valueOf(ip.intentos1));
                vista.jlbfallas1.setText(String.valueOf(ip.fallas1));
            }
            //pregunta3
            ip.setPregunta(vista.cbxPregunta3.getSelectedItem().toString());
            if (ip.getPregunta().equals(ip.respuesta3)) {
                ip.aciertos2 += 1;
                ip.intentos2 += 1;
                vista.jlbintentos2.setText(String.valueOf(ip.intentos2));
                vista.jlbAciertos2.setText(String.valueOf(ip.aciertos2));
            } else {
                ip.fallas2 += 1;
                ip.intentos2 += 1;
                vista.jlbintentos2.setText(String.valueOf(ip.intentos2));
                vista.jlbfallas2.setText(String.valueOf(ip.fallas2));
            }
            //pregunta4
            ip.setPregunta(vista.cbxPregunta4.getSelectedItem().toString());
            if (ip.getPregunta().equals(ip.respuesta4)) {
                ip.aciertos3 += 1;
                ip.intentos3 += 1;
                vista.jlbintentos3.setText(String.valueOf(ip.intentos3));
                vista.jlbAciertos3.setText(String.valueOf(ip.aciertos3));
            } else {
                ip.fallas3 += 1;
                ip.intentos3 += 1;
                vista.jlbintentos3.setText(String.valueOf(ip.intentos3));
                vista.jlbfallas3.setText(String.valueOf(ip.fallas3));
            }
            //pregunta5
            ip.setPregunta(vista.cbxPregunta5.getSelectedItem().toString());
            if (ip.getPregunta().equals(ip.respuesta5)) {
                ip.aciertos4 += 1;
                ip.intentos4 += 1;
                vista.jlbintentos4.setText(String.valueOf(ip.intentos4));
                vista.jlbAciertos4.setText(String.valueOf(ip.aciertos4));
            } else {
                ip.fallas4 += 1;
                ip.intentos4 += 1;
                vista.jlbintentos4.setText(String.valueOf(ip.intentos4));
                vista.jlbfallas4.setText(String.valueOf(ip.fallas4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe presionar el boton Empezar para Calcular Respuestas");
        }
    }

    public void cargarRespuestas() {
        //combo1
        vista.cbxPregunta1.removeAllItems();
        vista.cbxPregunta1.addItem("Seleccione su Respuesta");
        vista.cbxPregunta1.addItem("Ceiba");
        vista.cbxPregunta1.addItem("Hormigo"); //correcto
        vista.cbxPregunta1.addItem("Chicozapote");
        //combo2
        vista.cbxPregunta2.removeAllItems();
        vista.cbxPregunta2.addItem("Seleccione su Respuesta");
        vista.cbxPregunta2.addItem("Lic. Carlos O. Zachrisson");
        vista.cbxPregunta2.addItem("General Jose Maria Orellana");//correcto
        vista.cbxPregunta2.addItem("General Justo Rufino Barrios");
        //combo3
        vista.cbxPregunta3.removeAllItems();
        vista.cbxPregunta3.addItem("Seleccione su Respuesta");
        vista.cbxPregunta3.addItem("Francisco Perez de Anton");
        vista.cbxPregunta3.addItem("Jose Ernesto Monzon");
        vista.cbxPregunta3.addItem("Francisco Perez Muñoz");//correcto
        //combo4
        vista.cbxPregunta4.removeAllItems();
        vista.cbxPregunta4.addItem("Seleccione su Respuesta");
        vista.cbxPregunta4.addItem("Justo Rufino Barrios");//correcto
        vista.cbxPregunta4.addItem("Jose Maria Reyna Barrios");
        vista.cbxPregunta4.addItem("Miguel Garcia Granados");
        //combo5
        vista.cbxPregunta5.removeAllItems();
        vista.cbxPregunta5.addItem("Seleccione su Respuesta");
        vista.cbxPregunta5.addItem("Tecun Uman");//correcto
        vista.cbxPregunta5.addItem("Kaibil Balam");
        vista.cbxPregunta5.addItem("Atanasio Tzul");
    }
 
    public void aciertos() {
        try {
            if (ip.aciertos > 0) {
                if (ip.aciertos1 > 0) {
                    if (ip.aciertos2 > 0) {
                        if (ip.aciertos3 > 0) {
                           if (ip.aciertos4 > 0) {
                           vista.dispose();
                            avan.setVisible(true);
                            avan.setLocationRelativeTo(null);
                            this.modificarNivel();
                            this.punteo();
                        } else {
                            JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
                        }
                        } else {
                            JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
        }
    }

    public void modificarNivel() {
        try {
            udao.dato += 1;
            uvo.setId_usuario(udao.idnivel);
            uvo.setId_tipo_usuario_fk(udao.dato);
            udao.nivel(uvo);
            JOptionPane.showMessageDialog(null, "Felicidades Pasaste de Nivel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nivel no modificado");
        }
    }
    
     public void punteo(){
        try{
        switch (ip.fallas) {
                    case 0:
                        
                        break;
                    case 1:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 3);
                        pdao.actualizar(pvo);                       
                        break;
                    case 2:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 5);
                        pdao.actualizar(pvo);   
                        break;
                    default:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 7);
                        pdao.actualizar(pvo);  
                        break;
                }
        switch (ip.fallas1) {
                    case 0:
                        
                        break;
                    case 1:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 3);
                        pdao.actualizar(pvo);                       
                        break;
                    case 2:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 5);
                        pdao.actualizar(pvo);   
                        break;
                    default:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 7);
                        pdao.actualizar(pvo);  
                        break;
                }
        switch (ip.fallas2) {
                    case 0:
                        
                        break;
                    case 1:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 3);
                        pdao.actualizar(pvo);                       
                        break;
                    case 2:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 5);
                        pdao.actualizar(pvo);   
                        break;
                    default:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 7);
                        pdao.actualizar(pvo);  
                        break;
                }
        switch (ip.fallas3) {
                    case 0:
                        
                        break;
                    case 1:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 3);
                        pdao.actualizar(pvo);                       
                        break;
                    case 2:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 5);
                        pdao.actualizar(pvo);   
                        break;
                    default:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 7);
                        pdao.actualizar(pvo);  
                        break;
                }
        switch (ip.fallas4) {
                    case 0:
                        
                        break;
                    case 1:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 3);
                        pdao.actualizar(pvo);                       
                        break;
                    case 2:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 5);
                        pdao.actualizar(pvo);   
                        break;
                    default:
                        pdao.consultarTabla(udao.idnivel);
                        pvo.setId_score(pdao.idpunteo);
                        pvo.setPunteo_score(pdao.punteo - 7);
                        pdao.actualizar(pvo);  
                        break;
                }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "punteo no ingresado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnActivar) {
            this.cargarRespuestas();
        }
        if (e.getSource() == vista.btnComprobarI) {
            this.respuestas();
        }
        if (e.getSource() == vista.btnNivelI) {
            this.aciertos();
        }
    }
}
