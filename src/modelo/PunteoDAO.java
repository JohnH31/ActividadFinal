/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PunteoDAO implements ConsultasPunteoDAO {
    public int punteo;
    public int idpunteo;
    @Override
    public void insertar(PunteoVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "INSERT INTO tbl_score (punteo_score, id_usuario_fk)VALUES ('"
                    + p.getPunteo_score() + "'," + p.getId_usuario_fk() + ");";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Insertar " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void actualizar(PunteoVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_score SET punteo_score = "
                    + p.getPunteo_score() + " WHERE id_score = "
                    + p.getId_score() + ";";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje nivel " + e.getMessage());
        }
    }

    @Override
    public void eliminar(PunteoVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_score WHERE id_score =" + p.getId_score() + ";";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Eliminar " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public ArrayList<PunteoVO> consultarTabla(int dato) {
        Conector c = new Conector();
        ArrayList<PunteoVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT id_score,punteo_score,id_usuario_fk FROM tbl_score WHERE id_usuario_fk = '" + dato +"';";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                PunteoVO pvo = new PunteoVO();
                pvo.setId_score(rs.getInt(1));
                idpunteo = pvo.getId_score();
                pvo.setPunteo_score(rs.getInt(2));
                punteo = pvo.getPunteo_score();
                pvo.setId_usuario_fk(rs.getInt(3));    
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos " + e.getMessage());
        }
        return info;
    }

}
