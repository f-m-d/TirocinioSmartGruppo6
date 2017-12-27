package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Azienda;
import bean.Studente;

import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;



@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public RegistrazioneControl() {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userType = request.getParameter("type");

		if(userType == "Studente"){
			
			String matricola = request.getParameter("matricola");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String password = request.getParameter("password");
			String codiceFiscale = request.getParameter("codiceFiscale");
			String email = request.getParameter("email");
			String dataNascita = request.getParameter("dataNascita");
			String luogoNascita = request.getParameter("luogoNascita");
			
			Studente user = new Studente();

			user.setMatricola(matricola);
			user.setNome(nome);
			user.setCognome(cognome);
			user.setPassword(password);
			user.setCodiceFiscale(codiceFiscale);
			user.setEmail(email);
			user.setDataNascita(dataNascita);
			user.setLuogoNascita(luogoNascita);
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			
			boolean userRegistered = studenteDao.registerUser(user);

			if(userRegistered){
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			else{
				PrintWriter out = response.getWriter();

				out.println("Registrazione non riuscita. Riprova!");
				request.getRequestDispatcher("registrazione.jsp").forward(request, response);
			}
		}
		
		else if(userType == "Azienda"){
			
			String nomeAzienda = request.getParameter("nomeAzienda");
			String partitaIva = request.getParameter("partitaIva");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String sede = request.getParameter("sede");
			String telefono = request.getParameter("telefono");
			
			Azienda user = new Azienda();
			
			user.setNomeAzienda(nomeAzienda);
			user.setP_iva(partitaIva);
			user.setEmail(email);
			user.setPassword(password);
			user.setSede(sede);
			user.setTelefono(telefono);
			
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			
			boolean userRegistered = aziendaDao.registerUser(user);
			
			if(userRegistered){
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			else{
				PrintWriter out = response.getWriter();

				out.println("Registrazione non riuscita. Riprova!!");
				request.getRequestDispatcher("registrazione.jsp").forward(request, response);
			}
			
		}

	}

}
