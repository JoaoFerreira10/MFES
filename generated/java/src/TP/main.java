package TP;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sistema sistema= new Sistema("sys");		
		User us= new User("Luis");	
		Sector sector = new Sector("dei");
		Card card = new Card();
		

		//cria um ponto de acesso para o sector dei
		
		//Associar cartao a utilizador
		sistema.cardToUser(card, us);
		
		sistema.createGroup_User("estudantes");
		sistema.createGroup_Sector("feup");
		
		sistema.userToGroupUser("estudantes", us);
		sistema.sectorToGroupSector("feup", sector);
		
		//Object accessType = null;
		Rules rules = new Rules("<deny>", "estudantes", "feup");
		

		sistema.accessRuleToAccessPoint(sistema.createAccessPoint(sector), rules);
		sistema.accessRequest(card, sistema.createAccessPoint(sector));

		 System.out.println(sistema);
		 System.out.println("Acesso ao dei: "+sistema.accessRequest(card, sistema.createAccessPoint(sector)));

	}

}
