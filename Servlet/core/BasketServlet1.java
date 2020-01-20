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

@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
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

