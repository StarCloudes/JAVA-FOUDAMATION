package com.qianfeng.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.qianfeng.domain.Book;
import com.qianfeng.service.BookService;
import com.qianfeng.service.impl.BookServiceImpl;

public class AddBookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//��Ϊ��ͼƬ,���Բ����ֽ���������������
		Map<String, String[]> map = new HashMap<String, String[]>();
		
		//�жϵ�ǰ�ı���enctype���������Ƿ���multipart/form-data
		boolean isMul = ServletFileUpload.isMultipartContent(request);
		if (!isMul) {
			throw new RuntimeException("��ǰ�ı���enctype�������Ͳ���multipart/form-data");
		}
		
		//1.������������
		DiskFileItemFactory  factory = new DiskFileItemFactory();
		//2.ʹ�ù������������ϴ��ļ��Ķ���--��Ʒ
		ServletFileUpload upload =  new ServletFileUpload(factory);
		//3.�����ύ�����ı�����--����
		try {
			//���������ݷ�����list,����Ԫ����FileItem����,��ÿһ����ֵ�Զ���Ӧһ��FileItem����--������
			List<FileItem> items =  upload.parseRequest(request);
			//����list
			for (FileItem fileItem : items) {
				//������ͨ��������
				if (fileItem.isFormField()) {
					processFormField(fileItem,map);
				}else {//������ı���������(ͼƬ)
					processFileField(fileItem,map);
				}	
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//��ȡ������
		Book book = new Book();
		try {
			BeanUtils.populate(book, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��ȡ�����һ�������ַ�����Ϊ���id��
		String myid = UUID.randomUUID().toString();
		book.setId(myid);
		
		BookService bService = new BookServiceImpl();
		int num = bService.addBook(book);
		if (num>0) {//��ӳɹ�
			response.sendRedirect(request.getContextPath()+"/ShowBooksServlet");
		}else {//���ʧ��
			System.out.println("�������ҳ��");
		}
		
	}
    //������ͨ��������
	public static void processFormField(FileItem fileItem,Map<String, String[]> map) {
		String name = fileItem.getFieldName();//��ȡ���������������
		String value = null;
		try {
			value = fileItem.getString("utf-8");//����ָ������,��ȡ�����������ֵ
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"   "+value);
		
		map.put(name, new String[]{value});
	}
	//�����ļ�������
	public static void  processFileField(FileItem fileItem,Map<String, String[]> map) {
		/*
		 * ͼƬ�Ĵ�Ÿ�·��
		 * 1.����ڱ��ص�ĳ��λ��:���ڷ������޷�ֱ�Ӷ�ȡ���ؾ���·��,����Ҫ�������Ҫ������������Դ
		 * 2.����ڷ��ʷ������ĸ�Ŀ¼��:�ŷ�������,����ֱ��ͨ������������,����û���ڵ�ǰӦ�õ��ڲ�,���Ը���Ӧ�õ�ʱ��,���ݲ��ᱻɾ��
		 * 3.����WEB-INF��:���������,����޷�ֱ�Ӳ鿴,���԰�ȫ�Ը�,��������Ӧ�õĸ������ݻᱻɾ��.
		 */
   	
   	// D:\apache-tomcat-7.0.52\webapps/upload/120.jpg
   	//1.��ȡȫ·����ǰ�벿��
   	String storeDirecty = "D:\\javawork\\.metadata\\.me_tcat7\\webapps\\upload";
   	
   	File readfile = new File(storeDirecty);
   	
   	if (!readfile.exists()) {
			readfile.mkdirs();//��·���ϵ������ļ��д�������
		}
   	
   	//2.��ȡ��벿��·��
   	//>ȡ�ļ�������--���ܴ�·��
   	String name =  fileItem.getName();//ȡ�ļ�������
   	name = FilenameUtils.getName(name);//ֻҪ����
   	
   	//����ͬ�����ļ��ķ���---���ڵ�ͼƬ����
   	name = UUID.randomUUID().toString()+"_"+name;
   	
   	//�������ļ���(��ΪͼƬ����Ŀ¼)  D:/apache-tomcat-7.0.52/webapps/upload/   a/b/saotiwqoigjwqoj_120.jpg
   	String substr = getChildDirectory(readfile, name);
   	
   	//��ȡ�洢�ļ���ȫ·��
   	File newfile = new File(readfile,substr+File.separator+name);
   	
   	//����·���������ݿ�
   	String sub11 = substr+File.separator+name;
   	map.put(fileItem.getFieldName(), new String[]{sub11});
   	
   	try {
			fileItem.write(newfile);//ֱ�ӽ��ļ�д�뵱ǰ��Ŀ¼����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
   //���ݹ�ϣ��ֵ��ȡ��Ŀ¼
   public static String getChildDirectory(File file,String name) {
		//��ȡ��ϣ��ֵ   FA4C67788
   	int has = name.hashCode();
   	String hasStr = Integer.toHexString(has);
   	String subString = hasStr.charAt(0)+File.separator+hasStr.charAt(1);//   F/A
   	
   	//������ʵ��·��
       File temp =	new File(file,subString);
       if (!temp.exists()) {
			temp.mkdirs();
		}
       
       return subString;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
