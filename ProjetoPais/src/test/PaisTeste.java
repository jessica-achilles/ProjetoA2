package test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.PaisDAO;
import model.Pais;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PaisTeste {
	Pais pais, copia;
	static int id = 0;
	PaisDAO dao = new PaisDAO();

	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		System.out.println(dao.carregar(1));
	}
	
	@Test
	public void test02OutroVetor() {
		System.out.println("outro");
		Pais[] vetor = PaisDAO.outroVetor();
		for (Pais pais : vetor) {
			System.out.println(pais);
		}
	}

	@Test
	public void test03Carregar() {
		System.out.println("criar");
		Pais pais = new Pais(0, "Espanha", 46524943L, 504030.0);
		dao.criar(pais);
	}


}