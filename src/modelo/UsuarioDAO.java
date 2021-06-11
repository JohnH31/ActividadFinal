/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO implements ConsultasUsuarioDAO {

    public int dato;
    public int idnivel;
    public String nombre;
    public String apellido;

    @Override
    public void insertar(UsuarioVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "INSERT INTO tbl_usuario (nombre_usuario, apellido_usuario,edad_usuario,usuario,contraseña,id_estado_fk,id_tipo_usuario_fk)VALUES ('"
                    + a.getNombre_usuario() + "','" + a.getApellido_usuario() + "',"
                    + a.getEdad_usuario() + ",'" + a.getUsuario() + "','"
                    + a.getContraseña() + "'," + a.getId_estado_fk() + "," + a.getId_tipo_usuario_fk() + ");";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Insertar " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void actualizar(UsuarioVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_usuario SET nombre_usuario = '"
                    + a.getNombre_usuario() + "',apellido_usuario = '"
                    + a.getApellido_usuario() + "',edad_usuario ="
                    + a.getEdad_usuario() + ",usuario = '"
                    + a.getUsuario() + "',contraseña = '"
                    + a.getContraseña() + "',id_estado_fk = "
                    + a.getId_estado_fk() + ",id_tipo_usuario_fk = "
                    + a.getId_tipo_usuario_fk() + " WHERE id_usuario = "
                    + a.getId_usuario() + ";";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Actualizar " + e.getMessage());
        }
    }

    @Override
    public void eliminar(UsuarioVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_usuario WHERE id_usuario =" + a.getId_usuario() + ";";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Eliminar " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public ArrayList<UsuarioVO> consultarTabla() {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_usuario;";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                UsuarioVO pvo = new UsuarioVO();
                pvo.setId_usuario(rs.getInt(1));
                pvo.setNombre_usuario(rs.getString(2));
                pvo.setApellido_usuario(rs.getString(3));
                pvo.setEdad_usuario(rs.getInt(4));
                pvo.setUsuario(rs.getString(5));
                pvo.setContraseña(rs.getString(6));
                pvo.setId_estado_fk(rs.getInt(7));
                pvo.setId_tipo_usuario_fk(rs.getInt(8));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos " + e.getMessage());
        }
        return info;
    }

    @Override
    public ArrayList<UsuarioVO> validacion(UsuarioVO a) {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT usuario, id_usuario, id_tipo_usuario_fk, nombre_usuario, apellido_usuario  FROM tbl_usuario WHERE usuario = '" + a.getUsuario() + "' AND contraseña = '" + a.getContraseña() + "';";
            //String consulta = "SELECT usuario,contraseña,id_tipo_usuario_fk  FROM tbl_usuario WHERE usuario = '"+user+"' AND contraseña = '"+contra+"';";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                UsuarioVO pvo = new UsuarioVO();
                pvo.setUsuario(rs.getString(1));
                pvo.setId_usuario(rs.getInt(2));
                idnivel = pvo.getId_usuario();
                pvo.setId_tipo_usuario_fk(rs.getInt(3));
                dato = pvo.getId_tipo_usuario_fk();
                pvo.setNombre_usuario(rs.getString(4));
                nombre = pvo.getNombre_usuario();
                pvo.setApellido_usuario(rs.getString(5));
                apellido = pvo.getApellido_usuario();
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Usuario no existe");
            System.out.println("Mensaje Mostrar Datos " + e.getMessage());
        }
        return info;

    }

    @Override
    public void nivel(UsuarioVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_usuario SET id_tipo_usuario_fk = "
                    + a.getId_tipo_usuario_fk() + " WHERE id_usuario = "
                    + a.getId_usuario() + ";";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje nivel " + e.getMessage());
        }
    }
    
    public JasperViewer jv;
        //metodo para el reporte
    public void reporte(){
        Conector c = new Conector();
        try{
        c.conectar();
        //variable para encontrar el reporte
        JasperReport reporte;
        //Ruta del reporte
        
        String ruta = "D:\\seguiwey\\ActividadFinal\\src\\reportes\\ReporteUsuarios.jasper";
        //asignacion de ruta
        reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
        
        JasperPrint jp = JasperFillManager.fillReport(reporte, null,c.con);
        JasperViewer jv = new JasperViewer(jp,false);
        this.jv = jv;
                
        }catch (Exception e) {
            System.out.println("Mnesaje reporte"+e.getMessage());
        }
    }

}
