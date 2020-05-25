package model;

import java.sql.Connection;
import java.sql.PreparedStatement;


import entidad.Jugador;
import util.MysqlDBConexion;

public class JugadorModel {
	public int insertaJugador(Jugador obj){
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = MysqlDBConexion.getConexion();
			String sql ="insert into jugador values(null,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getAlias());
			pstm.setString(3, obj.getPais());
			pstm.setString(4, obj.getJuego());
			pstm.setInt(5, obj.getExperiencia());
			
			//La variable contiene el número de registros en la BD
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		
		return salida;
	}

}
