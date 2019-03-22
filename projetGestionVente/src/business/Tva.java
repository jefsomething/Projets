package business;

public class Tva {

	//une tva a un identidiant, un taux ]0,1] et un libellé
	private int idTVA;
	private double taux;
	private String lib;
	
	public Tva(double taux, String lib) {
		idTVA = 0;
		this.setTaux(taux) ;
		this.setLib(lib);
	}
	
	@Override
	public String toString()
		{ return idTVA + " " + taux + " " + lib; }
	
	
/*	public void setIdTva(int id)
		{}
*/		
	public void setTaux(double taux){
		if(taux <= 0 || taux >1){
			throw new IllegalArgumentException ("erreur: le taux doit être compris entre 0 et 1.");
		}
		this.taux = taux; 
	}
	
	public void setLib(String lib){
		if(lib == null || lib.trim().length() == 0){
			throw new IllegalArgumentException ("erreur: le libellé est vide.");
		}
		this.lib = lib;
	}
	

	public int getIdTva() 
		{ return idTVA ; }
	
	public double getTaux()
		{ return taux;}
	
	public String getLib() 
		{ return lib;}
	
}
