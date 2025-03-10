package servlets;

import collection.Storage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Student;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vote")
public class AddVoteServlet extends HttpServlet {
    private final Storage storage = Storage.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Students:</title></head>");
        out.println("<body>");

        String fNumber = request.getParameter("fNumber");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String speciality = request.getParameter("speciality");


        if (fNumber == null || fNumber.isEmpty() || name == null || name.isEmpty() || lastName == null || lastName.isEmpty()
                || speciality == null || speciality.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<p>All fields are required!</p>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            Student student = new Student(fNumber, name, lastName, speciality ) ;
            storage.addVote(student);
            out.println("<p>Student is added successfully!!!</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
