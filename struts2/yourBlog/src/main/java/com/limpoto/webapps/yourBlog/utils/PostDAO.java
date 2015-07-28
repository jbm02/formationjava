package com.limpoto.webapps.yourBlog.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.limpoto.webapps.yourBlog.beans.Post;

public class PostDAO {

	@SuppressWarnings("unused")
	private Connection base;

	public static final String FIND_ALL_SQL = "select * from `post`";
	public static final String FIND_BY_ID_SQL = "select * from `post` where `id`=?";
	public static final String UPDATE_ONE_SQL = "update `post` set `titre`=?, `corps`=?, `dateCreation`=? where `id`=?";
	public static final String INSERT_ONE_SQL = "insert into `post` (`titre`, `corps`, `dateCreation`) values (?,?,?)";
	public static final String DELETE_ONE_SQL = "delete from `post` where `id`=?";

	private PreparedStatement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteOneStatement;

	public PostDAO(Connection base) {
		this.base = base;
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findByIDStatement = base.prepareStatement(FIND_BY_ID_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Post> findAll() {
		ArrayList<Post> data = new ArrayList<Post>();
		ResultSet rs = null;
		try {
			// Nettoie les parametres précédents
			findAllStatement.clearParameters();
			// Execute la requete
			rs = findAllStatement.executeQuery();
			while (rs.next()) {
				data.add(new Post(rs.getInt("id"), rs.getString("titre"), rs
						.getString("corps"), rs.getDate("dateCreation")));

			}
			// Ferme le resultset
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public Post findByID(int id) {
		Post p = null;
		ResultSet rs = null;
		try {
			// Nettoie les parametres précédents
			findByIDStatement.clearParameters();
			// Remplace le premier point d'interogation par l'id en parametre
			findByIDStatement.setInt(1, id);
			// Execute la requete
			rs = findByIDStatement.executeQuery();

			if (rs.next()) {
				p = new Post(rs.getInt("id"), rs.getString("titre"),
						rs.getString("corps"), rs.getDate("dateCreation"));
			}
			// Ferme le resultset
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public int save(Post p) {
		if (p.getId() > 0) {
			// c'est un update
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, p.getTitre());
				updateOneStatement.setString(2, p.getCorps());
				updateOneStatement.setDate(3, new java.sql.Date(p
						.getDateCreation().getTime()));
				updateOneStatement.setInt(4, p.getId());
				return updateOneStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// c'est un insert
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, p.getTitre());
				insertOneStatement.setString(2, p.getCorps());
				insertOneStatement.setDate(3, new java.sql.Date(p
						.getDateCreation().getTime()));
				return insertOneStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int delete(int id) {
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
