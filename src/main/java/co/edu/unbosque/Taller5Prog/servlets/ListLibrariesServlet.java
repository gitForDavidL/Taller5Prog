package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.LibraryService;
import co.edu.unbosque.Taller5Prog.servlets.pojos.LibraryPOJO;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listLibrariesServlet", value = "/list-libraries")
public class ListLibrariesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        LibraryService libraryService = new LibraryService();
        List<LibraryPOJO> libraries =  libraryService.listLibraries();

        String librariesJsonString = new Gson().toJson(libraries);

        PrintWriter out = response.getWriter();
        out.print(librariesJsonString);
        out.flush();

    }

}
