package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {	
	String result = "";	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
        HttpSession session = request.getSession();
        String msg = ""; 
        
        if(session.getAttribute("cnt") == null) 
    		session.setAttribute("cnt", new int[10]);
		int[] session_v = (int[])session.getAttribute("cnt");
		
	//	int num = Integer.parseInt(pid.replace("p", ""));
	//	System.out.println(num);
		
		
		switch (pid) {
		case "p001":
			session_v[0] += 1;
			break;
		case "p002":
			session_v[1] += 1;
			break;
		case "p003":
			session_v[2] += 1;
			break;
		case "p004":
			session_v[3] += 1;
			break;
		case "p005":
			session_v[4] += 1;
			break;
		case "p006":
			session_v[5] += 1;
			break;
		case "p007":
			session_v[6] += 1;
			break;
		case "p008":
			session_v[7] += 1;
			break;
		case "p009":
			session_v[8] += 1;
			break;
		case "p010":
			session_v[9] += 1;
			break;
		}	
		
		out.print("{");
		for(int i = 0; i < 9; i++) {
		result = ("\"" + "p00" + (i+1) + "\":" + session_v[i] +"," );
		out.print(result);	
		}
		out.print("\"" + "p010 \":" + session_v[9]);
		out.print("}");
		
        if(pid.equals("clear")) {
        	session = request.getSession(false);
        	if(session != null) {
	    		session.invalidate();
	    		msg = "상품이 모두 삭제되었습니다.";
	    	} 
        }
      out.print(msg);
      out.close();
  
	  LocalDateTime currentDate = LocalDateTime.now();
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
	  String textdate = currentDate.format(formatter);
      FileWriter writer = null;
      String path = "C:/logtest";
      File isDir = new File(path);
      if (!isDir.exists()) {
      	isDir.mkdir();
      }
      try  {
      	writer = new FileWriter("c:/logtest/mylog.txt",true);
          writer.write(textdate + " " + pid);
          writer.write("\r\n");
          out.print("{ \"pid\" : " + "\""+ pid + "\"}" );
          out.close();
      } catch (IOException ioe) {
          System.out.println("파일로 출력할 수 없습니다.");
      } finally {
          try {
          	if (writer != null)
          		writer.close();
          } catch (Exception e) {
          	System.out.println("파일을 닫는동안 오류 발생!!");
          }
      }
	}
}

