/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface ConsultasPunteoDAO {
    public void insertar(PunteoVO p);
    public void actualizar(PunteoVO p);
    public void eliminar(PunteoVO p);
    public ArrayList<PunteoVO> consultarTabla(int dato);
}
