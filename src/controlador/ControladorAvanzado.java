/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Avanzado;
import modelo.PunteoDAO;
import modelo.PunteoVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAvanzado;

/**
 *
 * @author Usuario
 */
public class ControladorAvanzado implements ActionListener {

    FrmAvanzado vista = new FrmAvanzado();
    Avanzado ava = new Avanzado();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    PunteoVO pvo = new PunteoVO();
    PunteoDAO pdao = new PunteoDAO();

    public ControladorAvanzado(FrmAvanzado vista, Avanzado ava, UsuarioVO uvo, UsuarioDAO udao, PunteoVO pvo, PunteoDAO pdao) {
        this.vista = vista;
        this.ava = ava;
        this.udao = udao;
        this.uvo = uvo;
        this.pvo = pvo;
        this.pdao = pdao;

        vista.btnIniciar.addActionListener(this);
        vista.btnResultadosA.addActionListener(this);
    }

    public void aleatoriosAva() {
        ava.setNum1(ava.obtenerAleatorio());
        System.out.println(ava.getNum1());
        vista.txtAdivinanza.setText("");
        ava.intentos = 0;
    }

    public void cargarPalabras() {
        vista.jlbPalabra1.setText("Home");//casa
        vista.txtAdivinanza1.setText("");
        vista.jlbPalabra2.setText("Run");//correr
        vista.txtAdivinanza3.setText("");
        vista.jlbPalabra3.setText("Watch");//mirar
        vista.txtAdivinanza2.setText("");
    }

    public void resultadosAva() {
        try {
            ava.setValor(Integer.parseInt(vista.txtAdivinanza.getText()));
            if (ava.intentos == 3) {
                JOptionPane.showMessageDialog(null, "Se realizaron 3 intentos, se genera otro numero para intentar");
                this.aleatoriosAva();
            } else {
                if (ava.getNum1() == ava.getValor()) {
                    ava.aciertos += 1;
                    ava.intentos += 1;
                    vista.jlbintentos.setText(String.valueOf(ava.intentos));
                    vista.jlbAciertos.setText(String.valueOf(ava.aciertos));

                } else {
                    ava.fallas += 1;
                    ava.intentos += 1;
                    vista.jlbintentos.setText(String.valueOf(ava.intentos));
                    vista.jlbfallas.setText(String.valueOf(ava.fallas));
                }
            }

            //palabra 1
            ava.setRespuesta(vista.txtAdivinanza1.getText());
            if (ava.getRespuesta().equals("casa")) {
                ava.aciertos1 += 1;
                ava.intentos1 += 1;
                vista.jlbintentos1.setText(String.valueOf(ava.intentos1));
                vista.jlbAciertos1.setText(String.valueOf(ava.aciertos1));

            } else {
                ava.fallas1 += 1;
                ava.intentos1 += 1;
                vista.jlbintentos1.setText(String.valueOf(ava.intentos1));
                vista.jlbfallas1.setText(String.valueOf(ava.fallas1));
            }
            //palabra 2
            ava.setRespuesta(vista.txtAdivinanza2.getText());
            if (ava.getRespuesta().equals("correr")) {
                ava.aciertos2 += 1;
                ava.intentos2 += 1;
                vista.jlbintentos2.setText(String.valueOf(ava.intentos2));
                vista.jlbAciertos2.setText(String.valueOf(ava.aciertos2));

            } else {
                ava.fallas2 += 1;
                ava.intentos2 += 1;
                vista.jlbintentos2.setText(String.valueOf(ava.intentos2));
                vista.jlbfallas2.setText(String.valueOf(ava.fallas2));
            }
            //palabra 3
            ava.setRespuesta(vista.txtAdivinanza3.getText());
            if (ava.getRespuesta().equals("mirar")) {
                ava.aciertos3 += 1;
                ava.intentos3 += 1;
                vista.jlbintentos3.setText(String.valueOf(ava.intentos3));
                vista.jlbAciertos3.setText(String.valueOf(ava.aciertos3));

            } else {
                ava.fallas3 += 1;
                ava.intentos3 += 1;
                vista.jlbintentos3.setText(String.valueOf(ava.intentos3));
                vista.jlbfallas3.setText(String.valueOf(ava.fallas3));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe presionar el boton Empezar para Calcular Respuestas");
        }
    }

    public void aciertos() {
        try {
            if (ava.aciertos > 0) {
                if (ava.aciertos1 > 0) {
                    if (ava.aciertos2 > 0) {
                        if (ava.aciertos3 > 0) {
                            pdao.consultarTabla(udao.idnivel);
                            pvo.setId_score(pdao.idpunteo);
                            pvo.setPunteo_score(pdao.punteo);
                            pdao.actualizar(pvo);
                            JOptionPane.showMessageDialog(null, "Juego finalizado");
                            this.modificarNivel();
                            this.punteo();
                            this.archivo();
                            vista.dispose();
                        } else {
                            //JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
                        }
                    } else {
                        //JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Tiene que acertar todas para pasar de nivel");
        }
    }

    public void modificarNivel() {
        try {
            udao.dato -= 2;
            uvo.setId_usuario(udao.idnivel);
            uvo.setId_tipo_usuario_fk(udao.dato);
            udao.nivel(uvo);
            //JOptionPane.showMessageDialog(null, "nivel modificado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nivel no modificado");
        }
    }

    public void punteo() {
        try {
            switch (ava.fallas) {
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
            switch (ava.fallas1) {
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
            switch (ava.fallas2) {
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
            switch (ava.fallas3) {
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

    public void archivo() {
        FileWriter fw;
        PrintWriter pw;
        try {
            //Si se va ejecutar asegure de colocar la ruta donde quiere que se cree el Archivo
            fw = new FileWriter("D:\\seguiwey\\ActividadFinal\\"+udao.nombre+".txt", true);
            pw = new PrintWriter(fw);
            //lo que pide al principio
            pw.println("Felicidades usted ha ganado el juego");
            pw.println("Nombre: " + udao.nombre);
            pw.println("Apellido: " + udao.apellido);
            pw.println("Punteo total: " + pdao.punteo);
            fw.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        //Lectura de un archivo de texto
        //File - encuentra el archivo en la ruta indicada
        File archivo;
        //FileReader - valida el archivo y lo apertura
        FileReader fr;
        //BufferedReader - lee la informaciÃ³n del archivo hasta encontrar vacÃ­o
        BufferedReader br;
        try {
            archivo = new File("D:\\seguiwey\\ActividadFinal\\"+udao.nombre+".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String lineas;
            while ((lineas = br.readLine()) != null) {
                System.out.println(lineas);
            }

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIniciar) {
            this.aleatoriosAva();
            this.cargarPalabras();
        }
        if (e.getSource() == vista.btnResultadosA) {

            this.resultadosAva();
            this.aciertos();
        }
    }

}
