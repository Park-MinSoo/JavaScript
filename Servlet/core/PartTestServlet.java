﻿package core;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/part")
@MultipartConfig  
public class PartTestServlet extends HttpServlet {   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        Collection<Part> parts = request.getParts();	// 먼저 파트들을 뽑아낸다. @MultipartConfig를 하지 않았으면 getParts를 쓸 수 없다.
        System.out.println("========== 요청 받음 =========");
        for(Part part : parts) {        	
            System.out.print("name : ");
            System.out.println(part.getName());            
            System.out.println("[ 헤더 정보 ] ");
            for(String headerName : part.getHeaderNames()) {
                System.out.print(headerName + " : ");
                System.out.println(part.getHeader(headerName));
            }
            System.out.println("size : "+ part.getSize());
            String filename = part.getSubmittedFileName();	//실제 업로드된 파일 이름
            if (filename != null)
            	System.out.println("file name : "+filename);
            System.out.println("------------------------------------");
        }
    }
}


