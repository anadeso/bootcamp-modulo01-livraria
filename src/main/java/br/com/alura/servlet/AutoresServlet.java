package br.com.alura.servlet;

import br.com.alura.dao.AutorDao;
import br.com.alura.modelo.Autor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {

    private AutorDao autorDao;

    public AutoresServlet() {
        this.autorDao = new AutorDao(new ConnectionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("autores", autorDao.listar());

        req.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            LocalDate data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String minic = req.getParameter("minic");

            Autor autor = new Autor(nome, email, data, minic);

            autorDao.cadastrar(autor);

            // Redirecionar a transacao
            resp.sendRedirect("autores");
        } catch (NumberFormatException e) {
            resp.sendRedirect("autores?erro=campo invalido!");
        }
    }
}
