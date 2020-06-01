package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crypto.Cryptography;
import model.Usuario;
import service.UsuarioService;

public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");
		// senha criptografada: "paiseseinformacoes"
		Cryptography crypto = new Cryptography();
		senha = crypto.crypto(senha);
		Usuario usuario = new Usuario();
		usuario.setUsername(nome);
		usuario.setPassword(senha);
		System.out.println(senha);
		UsuarioService service = new UsuarioService();
		
		if(service.validar(usuario)){
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou "+usuario);
		} else {
			System.out.println("Nao Logou "+usuario);
			throw new ServletException("Usuario/Senha invalidos");
		}
		response.sendRedirect("index.jsp");
	}

}
