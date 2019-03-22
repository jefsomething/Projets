package business;
import java.sql.*;
public class Connexion {
	
	
	/* on evite de laisser ses credendials sur github ... 
	 * à terme, cette classe est remplacée avec un pattern DAO 
	 */
	public Connection creeConnexion() {
		
		String url = "jdbc:mysql://<ip>:<port>/<db>"; 
				String login = "mylogin";			
				String passwd = "mypassword";		
				
		Connection maConnexion = null;
		
		try {
			maConnexion = DriverManager.getConnection(url, login, passwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}

	public void selectAll() {
		Connection laConnexion ;
		Statement requete;
		ResultSet res;
		
	
		try {
			laConnexion = creeConnexion();
			requete = laConnexion.createStatement();
			res = requete.executeQuery("SELECT id, nom, tarif, stock, tva FROM Produit");
				
			while (res.next()) {
				int id = res.getInt(1);
				System.out.print("ID : " + id);
				
				String nom = res.getString("nom");
				System.out.print(" PRODUIT : "+nom);
				
				Double tarif = res.getDouble("tarif");
				System.out.print(" PRIX : "+tarif);
				
				int stock = res.getInt(4);
				System.out.print(" STOCK : "+stock);
		
				int tva = res.getInt(5);
				System.out.print(" TVA : "+tva);
				
				System.out.println();

		}

		if (res != null)
			res.close();

		if (requete != null)
			requete.close();
	
		if (laConnexion != null)
			laConnexion.close();
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}
	}

	
	public void insertProduct(String nom, double tarif, int stock, double tva) {
		Connection laConnexion ;
	
		try {
			laConnexion = creeConnexion();
			PreparedStatement q
			= laConnexion.prepareStatement(
					"INSERT INTO Produit (nom, tarif, stock, tva)"
					+ "VALUES (?, ?, ?, ?)" );
			
			q.setString(1, nom);
			q.setDouble(2, tarif);
			q.setInt(3, stock);
			q.setDouble(4, tva);
						
			if (q != null)
				q.close();
		
			if (laConnexion != null)
				laConnexion.close();
			
		} catch (SQLException sqle) {
				System.out.println("Pb dans INSERT " + sqle.getMessage());
			}
	}
}
