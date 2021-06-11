/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.PunteoDAO;
import modelo.PunteoVO;
import modelo.Suma;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmIntermedio;
import vista.FrmPrincipiante;

/**
 *
 * @author Usuario
 */
public class ControladorPrincipiante implements ActionListener {

    FrmPrincipiante prin = new FrmPrincipiante();
    FrmIntermedio inte = new FrmIntermedio();
    Suma sum = new Suma();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    PunteoVO pvo = new PunteoVO();
    PunteoDAO pdao = new PunteoDAO();

    public ControladorPrincipiante(FrmPrincipiante prin, Suma sum, FrmIntermedio inte, UsuarioVO uvo, UsuarioDAO udao, PunteoVO pvo, PunteoDAO pdao) {
        this.prin = prin;
        this.sum = sum;
        this.inte = inte;
        this.udao = udao;
        this.uvo = uvo;
        this.pvo = pvo;
        this.pdao = pdao;

        prin.btnActivar.addActionListener(this);
        prin.btnResultadosP.addActionListener(this);
        prin.btnNivelP.addActionListener(this);
    }

    public void aleatorios() {
        //suma1
        sum.setNum1(sum.obtenerAleatorio1());
        sum.setNum2(sum.obtenerAleatorio2());
        prin.jlbSuma1.setText(String.valueOf(sum.getNum1()));
        prin.jlbSuma2.setText(String.valueOf(sum.getNum2()));
        //suma2
        sum.setNum3(sum.obtenerAleatorio3());
        sum.setNum4(sum.obtenerAleatorio4());
        prin.jlbNo1.setText(String.valueOf(sum.getNum3()));
        prin.jlbNo2.setText(String.valueOf(sum.getNum4()));
        //Multiplicacion
        sum.setNum5(sum.obtenerAleatorio5());
        sum.setNum6(sum.obtenerAleatorio6());
        prin.jlbNo3.setText(String.valueOf(sum.getNum5()));
        prin.jlbNo4.setText(String.valueOf(sum.getNum6()));
        //Divicion
        sum.setNum7(sum.obtenerAleatorio7());
        sum.setNum8(sum.obtenerAleatorio8());
        prin.jlbNo5.setText(String.valueOf(sum.getNum7()));
        prin.jlbNo6.setText(String.valueOf(sum.getNum8()));
        //Resta1
        sum.setNum9(sum.obtenerAleatorio9());
        sum.setNum10(sum.obtenerAleatorio10());
        prin.jlbNo7.setText(String.valueOf(sum.getNum9()));
        prin.jlbNo8.setText(String.valueOf(sum.getNum10()));
        //Resta2
        sum.setNum11(sum.obtenerAleatorio11());
        sum.setNum12(sum.obtenerAleatorio12());
        prin.jlbNo9.setText(String.valueOf(sum.getNum11()));
        prin.jlbNo10.setText(String.valueOf(sum.getNum12()));
    }

    public void resultadosSumasRestas() {
        try {
            //suma1
            sum.setValores(Integer.parseInt(prin.txtSuma2.getText()));
            sum.setRespuesta(Integer.parseInt(prin.jlbSuma1.getText()) + Integer.parseInt(prin.jlbSuma2.getText()));
            System.out.println(sum.getRespuesta());
            if (sum.getRespuesta() == sum.getValores()) {
                sum.aciertos += 1;
                sum.intentos += 1;
                prin.jlbintentos.setText(String.valueOf(sum.intentos));
                prin.jlbAciertos.setText(String.valueOf(sum.aciertos));
            } else {
                sum.fallas += 1;
                sum.intentos += 1;
                prin.jlbintentos.setText(String.valueOf(sum.intentos));
                prin.jlbfallas.setText(String.valueOf(sum.fallas));
            }
            //Suma2
            sum.setValores(Integer.parseInt(prin.txtResultado2.getText()));
            sum.setRespuesta(Integer.parseInt(prin.jlbNo1.getText()) + Integer.parseInt(prin.jlbNo2.getText()));
            System.out.println(sum.getRespuesta());
            if (sum.getRespuesta() == sum.getValores()) {
                sum.aciertos1 += 1;
                sum.intentos1 += 1;
                prin.jlbintentos1.setText(String.valueOf(sum.intentos1));
                prin.jlbAciertos1.setText(String.valueOf(sum.aciertos1));
            } else {
                sum.fallas1 += 1;
                sum.intentos1 += 1;
                prin.jlbintentos1.setText(String.valueOf(sum.intentos1));
                prin.jlbfallas1.setText(String.valueOf(sum.fallas1));
            }
            //resta1
            sum.setValores(Integer.parseInt(prin.txtResta1.getText()));
            sum.setRespuesta(Integer.parseInt(prin.jlbNo7.getText()) - Integer.parseInt(prin.jlbNo8.getText()));
            System.out.println(sum.getRespuesta());
            if (sum.getRespuesta() == sum.getValores()) {
                sum.aciertos4 += 1;
                sum.intentos4 += 1;
                prin.jlbintentos4.setText(String.valueOf(sum.intentos4));
                prin.jlbAciertos4.setText(String.valueOf(sum.aciertos4));
            } else {
                sum.fallas4 += 1;
                sum.intentos4 += 1;
                prin.jlbintentos4.setText(String.valueOf(sum.intentos4));
                prin.jlbfallas4.setText(String.valueOf(sum.fallas4));
            }
            //resta2
            sum.setValores(Integer.parseInt(prin.txtResta2.getText()));
            sum.setRespuesta(Integer.parseInt(prin.jlbNo9.getText()) - Integer.parseInt(prin.jlbNo10.getText()));
            System.out.println(sum.getRespuesta());
            if (sum.getRespuesta() == sum.getValores()) {
                sum.aciertos5 += 1;
                sum.intentos5 += 1;
                prin.jlbintentos5.setText(String.valueOf(sum.intentos5));
                prin.jlbAciertos5.setText(String.valueOf(sum.aciertos5));
            } else {
                sum.fallas5 += 1;
                sum.intentos5 += 1;
                prin.jlbintentos5.setText(String.valueOf(sum.intentos5));
                prin.jlbfallas5.setText(String.valueOf(sum.fallas5));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe presionar el boton Empezar para Calcular Respuestas");
        }

    }

    public void resultadosMulDiv() {
        try {
            //multiplicacion
            sum.setValores(Integer.parseInt(prin.txtResultado3.getText()));
            sum.setRespuesta(Integer.parseInt(prin.jlbNo3.getText()) * Integer.parseInt(prin.jlbNo4.getText()));
            System.out.println(sum.getRespuesta());
            if (sum.getRespuesta() == sum.getValores()) {
                sum.aciertos2 += 1;
                sum.intentos2 += 1;
                prin.jlbintentos2.setText(String.valueOf(sum.intentos2));
                prin.jlbAciertos2.setText(String.valueOf(sum.aciertos2));
            } else {
                sum.fallas2 += 1;
                sum.intentos2 += 1;
                prin.jlbintentos2.setText(String.valueOf(sum.intentos2));
                prin.jlbfallas2.setText(String.valueOf(sum.fallas2));
            }
            //divicion
            sum.setValores(Integer.parseInt(prin.txtResultado4.getText()));
            sum.setRespuesta(Integer.parseInt(prin.jlbNo5.getText()) / Integer.parseInt(prin.jlbNo6.getText()));
            System.out.println(sum.getRespuesta());
            if (sum.getRespuesta() == sum.getValores()) {
                sum.aciertos3 += 1;
                sum.intentos3 += 1;
                prin.jlbintentos3.setText(String.valueOf(sum.intentos3));
                prin.jlbAciertos3.setText(String.valueOf(sum.aciertos3));
            } else {
                sum.fallas3 += 1;
                sum.intentos3 += 1;
                prin.jlbintentos3.setText(String.valueOf(sum.intentos3));
                prin.jlbfallas3.setText(String.valueOf(sum.fallas3));
            }
        } catch (Exception e) {
            
        }

    }

    public void aciertos() {
        try {
            if (sum.aciertos > 0) {
                if (sum.aciertos1 > 0) {
                    if (sum.aciertos2 > 0) {
                        if (sum.aciertos3 > 0) {
                            if (sum.aciertos4 > 0) {
                                if (sum.aciertos5 > 0) {
                                    inte.setVisible(true);
                                    inte.setLocationRelativeTo(null);
                                    prin.dispose();
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

    public void punteo() {
        try {
            switch (sum.fallas) {
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
            switch (sum.fallas1) {
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
            switch (sum.fallas2) {
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
            switch (sum.fallas3) {
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
            switch (sum.fallas4) {
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
            switch (sum.fallas5) {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "punteo no ingresado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prin.btnActivar) {
            this.aleatorios();
        }
        if (e.getSource() == prin.btnResultadosP) {
            this.resultadosSumasRestas();
            this.resultadosMulDiv();
        }
        if (e.getSource() == prin.btnNivelP) {
            this.aciertos();
        }
    }

}
