package productweb.widgetstore.web;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import productweb.LaptopEntity.LaptopEntity;
import productweb.drinks.DrinkDAOImpl;
import productweb.drinks.DrinkDTO;
import productweb.drinks.GenericDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LaptopDetailsServlet extends HttpServlet {

    GenericDAO<DrinkDTO> drinkDAO;

    Session session;

    public LaptopDetailsServlet() {
        drinkDAO = new DrinkDAOImpl();
    }

    public void init() {
        session = HibernateUtils.buildSessionFactory().openSession();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String laptopId = request.getParameter("laptop-id");

        LaptopEntity laptopEntity = session.get(
                LaptopEntity.class,
                Long.parseLong(laptopId)
        );

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form action='' method='POST'>");
        out.println("<label>Enter Product (Laptop) ID: <input type='text' name='laptop-id'></input></label>");
        out.println("<input type='submit'> See details of this laptop</input>");

        out.println("<style>table, th, td { border: 1px solid black; border-collapse: collapse; } </style");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr><td>" + laptopId + "</td><td>" + laptopEntity.getName() + "</td><td>" +
                laptopEntity.getPrice() + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</form>");

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String laptopId = request.getParameter("laptop-id");
        PrintWriter out = response.getWriter();

        LaptopEntity laptopEntity = session.get(
                LaptopEntity.class,
                Long.parseLong(laptopId)
        );


        if (laptopEntity != null) {
            out.println("Found laptop: " + laptopEntity.getName() + " with price: " + laptopEntity.getPrice());
        } else {
            out.println("No laptop found for id: " + laptopId);
        }
    }

}
