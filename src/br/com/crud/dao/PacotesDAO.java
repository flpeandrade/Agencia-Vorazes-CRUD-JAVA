package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Pacotes;

public class PacotesDAO {
	
	public void save(Pacotes pacote) {
		

		String sql = "INSERT INTO PacotesJava (Origem, Destino, Preço, DataIda, DataVolta, IdPacotes)" + "VALUES(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
			conn = ConnectionFactory.createConnectionSQLServer();

			
			pstm = conn.prepareStatement(sql);

			
			
			pstm.setString(1, pacote.getOrigem());

			
			pstm.setString(2, pacote.getDestino());
			
			pstm.setFloat(3, pacote.getPreço());
			
			pstm.setString(4, pacote.getDataIda());
			
			pstm.setString(5, pacote.getDataVolta());
			
			pstm.setInt(6, pacote.getIdPacotes());
			

			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {
		String sql = "DELETE FROM PacotesJava WHERE IdPacotes = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Pacotes pacote) {
		String sql = "UPDATE PacotesJava SET Origem = ?, Destino = ?, Preço = ?, DataIda = ?, DataVolta = ? WHERE IdPacotes = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
			conn = ConnectionFactory.createConnectionSQLServer();

			
			pstm = conn.prepareStatement(sql);

			
			pstm.setString(1, pacote.getOrigem());

			
			pstm.setString(2, pacote.getDestino());
			
			pstm.setFloat(3, pacote.getPreço());
			
			pstm.setString(4, pacote.getDataIda());
			
			pstm.setString(5, pacote.getDataVolta());
			
			pstm.setInt(6, pacote.getIdPacotes());


			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Pacotes> getPacotes() {

		String sql = "SELECT * FROM PacotesJava";

		List<Pacotes> pacotes = new ArrayList<Pacotes>();

		Connection conn = null;
		PreparedStatement pstm = null;

		
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			
			while (rset.next()) {
				Pacotes pacote = new Pacotes();

			
				pacote.setIdPacotes(rset.getInt("IdPacotes"));

				
				pacote.setOrigem(rset.getString("Origem"));

				
				pacote.setDestino(rset.getString("Destino"));
				
				pacote.setPreço(rset.getFloat("Preço"));
				
				pacote.setDataIda(rset.getString("DataIda"));
				
				pacote.setDataVolta(rset.getString("DataVolta"));
							

				
				pacotes.add(pacote);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pacotes;
	}
}
