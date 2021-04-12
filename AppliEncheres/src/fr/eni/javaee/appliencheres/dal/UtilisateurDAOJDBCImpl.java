package fr.eni.javaee.appliencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import fr.eni.javaee.appliencheres.bo.Utilisateurs;

public class UtilisateurDAOJDBCImpl implements UtilisateurDAO {


	private static final String INSERT_UTILISATEUR="INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) values(?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_UTILISATEUR="UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
	private static final String SELECT_BY_ID_UTILISATEUR="SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, vill FROM utilisateurs WHERE no_utilisateur=?";
	private static final String DELETE_UTILISATEUR="DELETE FROM utilisateurs WHERE no_utilisateur=?";

	@Override
	public void insert(Utilisateurs utilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			cnx.setAutoCommit(false);
			try(PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS)){
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCode_postal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMot_de_passe());
				pstmt.execute();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					utilisateur.setNo_utilisateur(rs.getInt(1));
				}	
				cnx.commit();
			}catch (Exception ex) {
				cnx.rollback();
			}
		}catch (Exception ex) {
			throw new DALException(ex);
		}
	}


	public void update(Utilisateurs utilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			cnx.setAutoCommit(false);
			try(PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR)){
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCode_postal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMot_de_passe());
				pstmt.executeUpdate();
				cnx.commit();

			}catch (Exception ex) {
				cnx.rollback();

			}
		}
		catch(Exception ex)
		{
			throw new DALException(ex);
		}

	}
	
	public Utilisateurs selectById(int id) throws DALException {
		Utilisateurs user= null;
		ResultSet rs = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
				try(PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID_UTILISATEUR)){
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					user= new Utilisateurs(rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),
							rs.getString("telephone"),rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"));
				}

			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		catch(Exception ex)
		{
			throw new DALException(ex);
		}
		return user;

	}
	
	
	public void delete(int id) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
				try(PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR)){
				pstmt.setInt(1, id);;
				pstmt.executeUpdate();

			}catch (Exception ex) {
				cnx.rollback();
			}
		}
		catch(Exception ex)
		{
			throw new DALException(ex);
		}

	}
	
	
}











