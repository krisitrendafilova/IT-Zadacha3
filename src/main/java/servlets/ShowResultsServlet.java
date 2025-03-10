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
import java.util.Comparator;
import java.util.List;

//
@WebServlet("/results")
public class ShowResultsServlet extends HttpServlet {

    private final Storage storage = Storage.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Students:</title></head>");
        out.println("<body>");

        List<Student> student = storage.getStudent();
        if (student.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("<p>List is empty!</p>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            student.sort(Comparator.comparing(Student::getVote).reversed());
            for (int i = 0; i < student.size(); i++) {
                Student st = student.get(i);
                out.println("<hr>");
                out.println("<p>Faculty number: " + st.getfNumber() + "</p>");
                out.println("<p>Name: " + st.getName() + "</p>");
                out.println("<p>Last name: " + st.getLastName() + "</p>");
                out.println("<p>Speciality: " + st.getSpeciality() + "</p>");
                out.println("<p>Vote: " + st.getVote() + "</p>");
                out.println("<hr>");
            }
        }
        out.println("</body>");
        out.println("</html>");
    }
}
