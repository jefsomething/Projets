package business;

public class Principal {

	/*
	 * consignes du TD4:
	— Définir les classes Produit, Tva, Achat
	— Ecrire un programme principal qui permet :
	1. l’ajout/modification/suppression logique des produits et des taux de tva ;
	2. l’affichage et le tri des produits et des taux de tva ;
	3. l’enregistrement d’un achat ;
	4. le réapprovisionnement d’un produit.
	 */
	
	public static void main(String[] args) {
		
		
		
		Connexion bdd = new Connexion();

		Tva t1 = new Tva(.2, "TVAinformatique");
		
		double t = t1.getTaux() * 100;
		
		String nom = "nexus5x";
		Double tarif = 350.75;
		int stock = 30;
		Produit nexus5x = new Produit(nom, tarif, stock, t );
		//	bdd.insertProduct(nom, tarif, stock, t);

		nom = "pixel3";
		tarif = 850.;
		stock = 30;		
		Produit pixel3 = new Produit(nom, tarif, stock, t );
		//	bdd.insertProduct(nom, tarif, stock, t);

		nom = "batterie nexus5x";
		tarif = 29.99;
		stock = 5;			
		Produit batterieNx = new Produit(nom, tarif, stock, t );
		//	bdd.insertProduct(nom, tarif, stock, t);

		// un client passe une commande c1, on instancie un objet de la classe Achat()
		Achat c1 = new Achat();

		c1.ajoutAchat(nexus5x, 1);
		c1.ajoutAchat(batterieNx, 1);
			
		System.out.println("[debug] in main call method: bdd.selectAllProduct()");
		bdd.selectAll();
		
		
	
	}

}
