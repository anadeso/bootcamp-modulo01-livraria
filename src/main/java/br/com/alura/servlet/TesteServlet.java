package br.com.alura.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        resp.getWriter().println("Oi " +nome + "!");
    }

}
