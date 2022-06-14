
package br.com.GerenciadorDeProdutos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.GerenciadorDeProdutos.factory.ConnectionFactory;
import br.com.GerenciadorDeProdutos.model.Produto;

public class ProdutoDAO {
	public void save(Produto produto) {
		String sql = "INSERT INTO produtos(descricao,validade,lote,preco) VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement psm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();

			psm = (PreparedStatement) conn.prepareStatement(sql);
			psm.setString(1, produto.getDescricao());
			psm.setDate(2, new Date(produto.getValidade().getTime()));
			psm.setString(3, produto.getLote());
			psm.setDouble(4, produto.getPreco());

			psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null) {
					psm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Produto> getProdutos() {
		String sql = "SELECT * FROM produtos";
		List<Produto> produtos = new ArrayList<Produto>();
		Connection conn = null;
		PreparedStatement psm = null;
		ResultSet rst = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();
			psm = (PreparedStatement) conn.prepareStatement(sql);
			rst = psm.executeQuery();

			while (rst.next()) {
				Produto produto = new Produto();

				produto.setCodigo(rst.getInt("codigo"));
				produto.setDescricao(rst.getString("descricao"));
				produto.setValidade(rst.getDate("validade"));
				produto.setLote(rst.getString("validade"));
				produto.setPreco(rst.getDouble("preco"));

				produtos.add(produto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (psm != null) {
					psm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return produtos;

	}

	public void update(Produto produto) {
		String sql = "UPDATE produtos SET descricao = ?, validade = ?, lote = ?, preco = ? " + "WHERE codigo = ?";
		Connection conn = null;
		PreparedStatement psm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			psm = (PreparedStatement) conn.prepareStatement(sql);

			psm.setString(1, produto.getDescricao());
			psm.setDate(2, new Date(produto.getValidade().getTime()));
			psm.setString(3, produto.getLote());
			psm.setDouble(4, produto.getPreco());

			psm.setInt(5, produto.getCodigo());

			psm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null) {
					psm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(int codigo) {
		String sql = "DELETE from produtos WHERE codigo = ?";
		Connection conn = null;
		PreparedStatement psm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			psm = (PreparedStatement) conn.prepareStatement(sql);
			psm.setInt(1, codigo);
			psm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if (psm != null) {
					psm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
}