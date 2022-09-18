
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class List extends HttpServlet {

    ArrayList<Person> list = new ArrayList<Person>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        resp.setContentType("text/html;charset=utf-8");
        if (list.size() == 0) {
            try {
                list.add(new Person(1, "Mr A - Update", "Female", f.parse("2016-12-02")));
                list.add(new Person(2, "Mr B - Update", "Female", f.parse("2016-12-09")));
                list.add(new Person(5, "Mr B - Update", "Female", f.parse("2016-12-07")));
            } catch (ParseException ex) {
                Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        resp.getWriter().write(createHTML(list));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        int id = Integer.parseInt(req.getParameter("txtId"));
        String name = req.getParameter("txtName");
        String gender = req.getParameter("txtGender");
        String DOB = req.getParameter("txtDOB");
        resp.setContentType("text/html;charset=utf-8");
        try {
            Person p = new Person(id, name, gender, f.parse(DOB));
            if (!isExisted(p)) {
                list.add(p);
            } else {
                resp.getWriter().println("<body><script>alert('This id has already existed');window.location.href = \"add.jsp\";</script></body>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(req, resp);
    }

    public static String createHTML(ArrayList<Person> list) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String out = "";
        out += "<style>\n"
                + "            table {\n"
                + "                width: 50%;\n"
                + "            }\n"
                + "            \n"
                + "            table, th, td {\n"
                + "                border: 1px solid black\n"
                + "            }\n"
                + "        </style>\n"
                + "<table>\n"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Name</th>\n"
                + "                <th>Gender</th>\n"
                + "                <th>DOB</th>\n"
                + "            </tr>";
        for (Person item : list) {
            out += "<tr>\n"
                    + "                <td>" + item.getId() + "</td>\n"
                    + "                <td>" + item.getName() + "</td>\n"
                    + "                <td>" + item.getGender() + "</td>\n"
                    + "                <td>" + f.format(item.getDOB()) + "</td>\n"
                    + "            </tr>\n";
        }
        out += "</table>\n"
                + "        <a href=\"add.jsp\">Create</a>";
        return out;
    }

    public boolean isExisted(Person p) {
        for (Person item : list) {
            if (item.getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }
}
