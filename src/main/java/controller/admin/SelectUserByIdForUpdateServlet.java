package controller.admin;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectUserByIdForUpdateServlet",urlPatterns = "/selectUserByIdForUpdate")
public class SelectUserByIdForUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String id = req.getParameter("userid");
        UserDao dao=new UserDao();
        User user = dao.selectUserInfoById(id);
        //将user对象绑定到HttpSercletRequest对象
        req.setAttribute("u",user);
        req.getRequestDispatcher("/resources/admin/userupdate.jsp").forward(req,resp);


    }
}
