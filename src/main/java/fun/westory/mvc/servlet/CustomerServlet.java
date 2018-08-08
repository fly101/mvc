package fun.westory.mvc.servlet;

import fun.westory.mvc.dao.CriteriaCustomer;
import fun.westory.mvc.dao.CustomerDAO;
import fun.westory.mvc.dao.impl.CustomerDaoImpl;
import fun.westory.mvc.pojo.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "*.do")
public class CustomerServlet extends HttpServlet {

    private CustomerDAO customerDAO = new CustomerDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String realPath = servletPath.substring(1, servletPath.length() - 3);
        try {
            Method method = getClass().getDeclaredMethod(realPath,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }


    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取模糊查询的请求参数
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        //把请求参数封装为一个 CriteriaCustomer 对象
        CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);

        //1. 调用 CustomerDAO 的 getForListWithCriteriaCustomer() 得到 Customer 的集合
        List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);

        //2. 把 Customer 的集合放入 request 中
        request.setAttribute("customers", customers);

        //3. 转发页面到 index.jsp(不能使用重定向)
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = 0;

        try {
            id = Integer.parseInt(idStr);
            customerDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("query.do");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取表单参数: name, address, phone
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        //2. 检验 name 是否已经被占用:

        //2.1 调用 CustomerDAO 的 getCountWithName(String name) 获取 name 在数据库中是否存在
        long count = customerDAO.getCountWithName(name);

        //2.2 若返回值大于 0, 则响应 newcustomer.jsp 页面:
        //通过转发的方式来响应 newcustomer.jsp
        if(count > 0){
            //2.2.1 要求再 newcustomer.jsp 页面显示一个错误消息: 用户名 name 已经被占用, 请重新选择!
            //在 request 中放入一个属性 message: 用户名 name 已经被占用, 请重新选择!,
            //在页面上通过 request.getAttribute("message") 的方式来显示
            request.setAttribute("message", "用户名" + name + "已经被占用, 请重新选择!");

            //2.2.2 newcustomer.jsp 的表单值可以回显.
            //通过 value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"
            //来进行回显
            //2.2.3 结束方法: return
            request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
            return;
        }

        //3. 若验证通过, 则把表单参数封装为一个 Customer 对象 customer
        Customer customer = new Customer(name, address, phone);

        //4. 调用 CustomerDAO 的  save(Customer customer) 执行保存操作
        customerDAO.save(customer);

        //5. 重定向到 success.jsp 页面: 使用重定向可以避免出现表单的重复提交问题.
        response.sendRedirect("success.jsp");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPath = "/error.jsp";
        String idStr = request.getParameter("id");
        try {
            Customer customer = customerDAO.get(Integer.parseInt(idStr));
            if (customer != null) {
                forwardPath = "/updatecustomer.jsp";
                request.setAttribute("customer",customer);
            }
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher(forwardPath).forward(request,response);

    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String oldName = request.getParameter("oldName");

        if (!oldName.equalsIgnoreCase(name)) {
            long count = customerDAO.getCountWithName(name);
            if(count>0){
                request.setAttribute("message","用户名"+name+"已经被占用！");
                request.getRequestDispatcher("/updatecustomer.jsp").forward(request,response);
                return;
            }
        }
        Customer customer = new Customer(name, address, phone);
        customer.setId(Integer.parseInt(id));
        customerDAO.update(customer);
        response.sendRedirect("query.do");
    }
}
