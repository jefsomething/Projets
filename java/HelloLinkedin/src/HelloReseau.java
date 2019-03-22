public class HelloReseau {
	
	private static class Trainee{

    public
		  String name, firstname, position;
		  	
    public Trainee(String name, String firstname, String position) {
        this.name = name;
        this.firstname = firstname;
        this.position = position;
	}
    
	}

	public static void Annonce(){
		System.out.println("Hello, réseau!");
		System.out.println("étudiant en DUT info, je recherche une entreprise\npour un stage de fin d'étude du 23/06 au 01/09,");
		System.out.println("puis une alternance sur deux ans en DevOps !");
	}
    
	public static void main(String[] args) {
		Trainee jstutz = new Trainee("Joffrey", "Stutz", "Etudiant DUT informatique");
		Annonce();
	}

}

