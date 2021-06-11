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
public class EstadoDAO implements ConsultasEstadoDAO {

    @Override
    public ArrayList<EstadoVO> consultarTabla() {
            Conector c = new Conector();
        ArrayList<EstadoVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_estado;";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                EstadoVO pvo = new EstadoVO();
                pvo.setId_estado(rs.getInt(1));
                pvo.setNombre_estado(rs.getString(2));
                pvo.setDescripcion_estado(rs.getString(3));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos " + e.getMessage());
        }
        return info;
    }
    
}
