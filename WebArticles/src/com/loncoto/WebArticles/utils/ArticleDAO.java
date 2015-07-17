package com.loncoto.WebArticles.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.WebArticles.beans.Article;

public class ArticleDAO {
	
	public static final String FIND_BY_ID_SQL = "select * from `article` where `id` =?";
	public static final String FIND_ALL_SQL = "select * from `article`";
	public static final String FIND_ALL_SQL_ORDER="select * from `article` where `id` = ? order by ?";
	public static final String UPDATE_ONE_SQL = "update `article` set `libelle`=?, `prix`=?, `poids`=? where `id`=?";
	public static final String INSERT_ONE_SQL = "insert into `article` (`libelle`, `prix`, `poids`) values (?, ?, ?)";
	public static final String DELETE_ONE_SQL = "delete from `article` where `id` = ?";
	
	private Connection base;
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteOneStatement;
	private PreparedStatement findAllSortStatement;
	
	public ArticleDAO(Connection base) {
		this.base = base;
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			//findAllSortStatement = base.prepareStatement(FIND_ALL_SQL_ORDER);
			findByIDStatement = base.prepareStatement(FIND_BY_ID_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Article findByID(int id) {
		Article c = null;
		try {
			findByIDStatement.clearParameters();
			// remplace ? par l'id en paramètre
			findByIDStatement.setInt(1, id);

			ResultSet rs = findByIDStatement.executeQuery();
			if (rs.next()) {
				c = new Article(rs.getInt("id"), rs.getString("libelle"),
						rs.getDouble("prix"), rs.getDouble("poids"));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public List<Article> findAll() {
		ArrayList<Article> data = new ArrayList<Article>();
		ResultSet rs = null;
		try {
			// je nettoie les paramètre précédents
			findAllStatement.clearParameters();
			// j'execute la requete
			rs = findAllStatement.executeQuery();
			while (rs.next()) {
				data.add(new Article(rs.getInt("id"), rs.getString("libelle"), rs
						.getDouble("prix"), rs.getDouble("poids")));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fermeture resulset
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// on renvoie la liste des clients
		return data;
	}
	
	public int save(Article a) {
		if (a.getId() > 0) {
			//update
			try {
				updateOneStatement.clearParameters();
				
				updateOneStatement.setString(1, a.getLibelle());
				updateOneStatement.setDouble(2, a.getPrix());
				updateOneStatement.setDouble(3, a.getPoids());
				updateOneStatement.setInt(4, a.getId());
				
				return updateOneStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			//insert
			try {
				insertOneStatement.clearParameters();
				
				insertOneStatement.setString(1, a.getLibelle());
				insertOneStatement.setDouble(2, a.getPrix());
				insertOneStatement.setDouble(3, a.getPoids());
				
				return insertOneStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int delete(int id){
		try {
			deleteOneStatement.clearParameters();
			deleteOneStatement.setInt(1, id);
			
			return deleteOneStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
