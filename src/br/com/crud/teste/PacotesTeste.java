package br.com.crud.teste;

import br.com.crud.dao.PacotesDAO;
import br.com.crud.model.Pacotes;


public class PacotesTeste {

	public static void main(String[] args) {
		PacotesDAO pacotesDAO = new PacotesDAO();
		
	
		/*Pacotes pacote = new Pacotes();
		pacote.setIdPacotes(1);
		pacote.setOrigem("Bahia");
		pacote.setDestino("Natal");
		pacote.setPreço(800);
		pacote.setDataIda("19/09/2022");
		pacote.setDataVolta("30/09/2022");
		
		

		pacotesDAO.save(pacote);*/
		
		
		 /*Pacotes pacote = new Pacotes();
		    pacote.setIdPacotes(1);
			pacote.setOrigem("São Paulo");
			pacote.setDestino("Rio de Janeiro");
			pacote.setPreço(500);
			pacote.setDataIda("08/05/2022");
			pacote.setDataVolta("15/05/2022");
			
			
			
		pacotesDAO.update(pacote);*/
		
	
		// pacotesDAO.removeById(2);
		
		
		for (Pacotes a : pacotesDAO.getPacotes()) {
			System.out.println("Id: " + a.getIdPacotes()  + "\nOrigem: " + a.getOrigem() + "\nDestino: " + a.getDestino() + "\nPreço: R$ " + a.getPreço() + "\nData Ida: " + a.getDataIda() + "\nData Volta: " + a.getDataVolta());
		}
	}
}
