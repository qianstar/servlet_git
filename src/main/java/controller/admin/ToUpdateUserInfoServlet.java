package controller.admin;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToUpdateUserInfoServlet",urlPatterns = "/userUpdateServlet")
public class ToUpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //将参数分装到User对象中
        User user=new User();
        user.setId(Integer.parseInt(userid));
        user.setUserName(username);
        user.setUserPassword(password);

        //将分装好的参数传给UserDao的UserInfoById(User,user)
        UserDao userDao=new UserDao();
        int row = userDao.updateUserInfoById(user);
        if (row>0){
            req.getRequestDispatcher("/resources/admin/default.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("error.jsp").forward(req,resp);

        }
    }
}
