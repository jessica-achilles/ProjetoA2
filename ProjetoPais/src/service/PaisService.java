package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
	  PaisDAO dao = new PaisDAO();
	
	@SuppressWarnings({ "rawtypes" })
	public ArrayList getPaisMaisHab() {
		return PaisDAO.buscaPaisMaisHab();	
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getPaisMenor() {
		return PaisDAO.buscaPaisMenor();	
	}
	
	
	public int criar(Pais pais) {
		return dao.criar(pais);
	}
	
	public Pais carregar(int id){
		return dao.carregar(id);
	}
	
	public void atualizar(Pais pais){
		dao.atualizar(pais);
	}
	
	public void excluir(int id){
		dao.excluir(id);
		}

}