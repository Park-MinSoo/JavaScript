package core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" })
public class ResponseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String filename = "";
		String contentType = "";
		if (uri.endsWith("getHTML")) {	// getHTML로 URI가 끝나면~
			filename = "c:/testcontent/sample.html";	
			contentType = "text/html; charset=utf-8";	// 클라이언트에게 text/html 처럼 어떤형식으로 응답이 가는지 확실하게 알려주어야 한다.
		} else if (uri.endsWith("getXML")) { // getXML로 URI가 끝나면~
			filename = "c:/testcontent/sample.xml";	
			contentType = "application/xml; charset=utf-8";
		} else if (uri.endsWith("getJSON")) { // getJSON로 URI가 끝나면~
			filename = "c:/testcontent/sample.json";	
			contentType = "text/json; charset=utf-8";
		} else {
			filename = "c:/testcontent/trans_duke.png";	
			contentType = "image/png";
		}
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);	
		response.setContentType(contentType);	// 항상 setContentType을 먼저 해야한다. 
		if(contentType.startsWith("image")) {
			byte[] content = new byte[(int)f.length()];
			ServletOutputStream sos = response.getOutputStream();
			fis.read(content);
			sos.write(content);			
			sos.close();
		} else {
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");	// 이미 열어진건 byte straem이기에 인풋스트림으로 변환해 주고 있다.
			BufferedReader br = new BufferedReader(isr);
			PrintWriter out = response.getWriter();
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}
