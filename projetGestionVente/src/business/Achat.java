package business;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Achat {
	
	/*
	 Les achats sont enregistrés à une date et une heure précise, 
	 pour chaque produit de l’achat 
	 - on saisit une quantité
	 - on garde trace du tarif (pour garder un historique fiable des achats).
	

	// [p1|p2| ...|pn]
	// [q1|q2| ...|qn]
	p1 renvoie à q1, etc. 
	-> on cree un hashmap les Achats :
	*/
	
	// date et heure stockees avec LocalDateTime, (import java.time.LocalDateTime;)
	private LocalDateTime dateHeure;
	
	// 		
	private HashMap<Produit, Integer> lesAchats;
	
	
	public Achat() {
		this.lesAchats = new HashMap<>();
	}
	
	//ajouter des achats -------------------------------
	public void ajoutAchat(Produit p, int quantite) {
		if (quantite <= p.getStock()) {
						 
			if (this.lesAchats.get(p) == null) {
				this.lesAchats.put(p, quantite);
				
				p.setStock( p.getStock() - quantite ); 
			}
			else this.lesAchats.put(p, quantite += quantite);
		}
	}
	
	//supprimer des achats -----------------------------
	public void supprimeAchat(Produit p, int quantite) {
		this.lesAchats.put(p,  quantite);
		if (this.lesAchats.get(p) != null) {
			 this.lesAchats.put(p, quantite -= quantite);
		}
	}

	
	
}


	
	
	
