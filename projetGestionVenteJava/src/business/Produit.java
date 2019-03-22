package business;

public class Produit{
	
	//Un produit a un identifiant, un nom, un tarif, un stock et un taux de tva
	private int id ;
	private String nom ;
	private double tarif ;
	private int stock ;
	private double tva;
		
	public Produit(String nom, double tarif, int stock, double tva ){
		//this.id = id;
		this.nom = nom;
		this.tarif = tarif;
		this.stock = stock;
		this.tva = tva;
	}

	@Override
	public String toString()
		{ return nom + " " + tarif + " " + stock + " " + tva; }
	
	//	public void setId(int id)
	//		{ this.id = id; }
	
	public void setNom(String nom){ 
		if(nom == null || nom.trim().length() == 0) {
			throw new IllegalArgumentException ("erreur : le nom est vide.\n");
		}
		this.nom = nom;
	}
	
	public void setTarif(double tarif){ 
		if (tarif<=0) {throw new IllegalArgumentException ("erreur : le tarif ne peut être nul ou inférieur à 0.\n");}
		this.tarif = tarif;
	}
	
	public void setStock(int stock){ 
		if (stock<=0) {throw new IllegalArgumentException ("erreur : le stock ne peut être nul ou inférieur à 0.\n");}
		this.stock = stock;
	}
	
	public void setTva(double tva){
		if (tva<=0 || tva>1) {throw new IllegalArgumentException ("erreur : le taux de tva doit être comprise entre 0 et 1.\n");}
		this.tva = tva ;
	}

	
	public int getId()
		{ return this.id ; }
	
	public String getNom()
		{ return this.nom ; }
	
	public double getTarif()
		{ return this.tarif ; }
	
	public int getStock()
		{ return this.stock ; }
	
	public double getTva()
		{ return this.tva ; }
	
	public void appro(Produit p) {
		if (p.getStock() == 0) p.setStock(200);
	
	}
	
}
