package com.qianfeng.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class Upload2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
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
					processFormField(fileItem);
				}else {//������ı���������(ͼƬ)
					processFileField(fileItem);
				}	
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     //������ͨ��������
	public static void processFormField(FileItem fileItem) {
		String name = fileItem.getFieldName();//��ȡ���������������
		String value = null;
		try {
			value = fileItem.getString("utf-8");//����ָ������,��ȡ�����������ֵ
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"   "+value);
	}
	//�����ļ�������
	public static void  processFileField(FileItem fileItem) {
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
