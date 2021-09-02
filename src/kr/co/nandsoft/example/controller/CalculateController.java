package kr.co.nandsoft.example.controller;
import com.sun.xml.fastinfoset.util.CharArray;
import kr.co.nandsoft.example.service.Calculator;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * @see <p>화면에서 요청 받은 Request 를 처리 하여 분기, Controller Layer</p>
 */
public class CalculateController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(); //세션 생성

        String button = request.getParameter("button"); //request 파라미터를 가져옴
        String buffer = request.getParameter("buffer"); //화면에 표출하기 위한 buffer
        List<String> list; // list를 생성

        if (request.getAttribute("list") == null) { // list가 없다면 만들어고 request set
            list = new LinkedList<>();
            request.setAttribute("list", list);
        }

        else {
            list = (List<String>) request.getAttribute("list");
        }

        if (button.equals("del")) {
            int index_value = list.size();
            list.remove(index_value-1);
        }
        else if (button.equals("c")) {
            list.clear();
        }
        else {
            list.add(buffer); // 화면에 똑같이 표출하기 위해 add
            list.add(button); // 실제 계산을 위한 list에 add
        }

        String s = String.join("", list); // String으로 " 없이 형변환
        request.setAttribute("calcified", s);

        System.out.println(list);

        if (list.indexOf("=") != -1) { // button 값이 "="일 때 계산 메소드 호출
            list.remove("=");
            request.setAttribute("temp", Calculator.Calc(list));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
