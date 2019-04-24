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
		
		//判断当前的表单的enctype属性类型是否是multipart/form-data
		boolean isMul = ServletFileUpload.isMultipartContent(request);
		if (!isMul) {
			throw new RuntimeException("当前的表单的enctype属性类型不是multipart/form-data");
		}
		
		//1.创建工厂对象
		DiskFileItemFactory  factory = new DiskFileItemFactory();
		//2.使用工厂创建用于上传文件的对象--产品
		ServletFileUpload upload =  new ServletFileUpload(factory);
		//3.处理提交过来的表单数据--解析
		try {
			//解析后将数据放入了list,他的元素是FileItem对象,而每一个键值对都对应一个FileItem对象--数据项
			List<FileItem> items =  upload.parseRequest(request);
			//遍历list
			for (FileItem fileItem : items) {
				//处理普通的数据项
				if (fileItem.isFormField()) {
					processFormField(fileItem);
				}else {//处理非文本的数据项(图片)
					processFileField(fileItem);
				}	
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     //处理普通的数据项
	public static void processFormField(FileItem fileItem) {
		String name = fileItem.getFieldName();//获取的是数据项的名字
		String value = null;
		try {
			value = fileItem.getString("utf-8");//可以指定编码,获取的是数据项的值
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"   "+value);
	}
	//处理文件数据项
	public static void  processFileField(FileItem fileItem) {
		/*
		 * 图片的存放个路径
		 * 1.存放在本地的某个位置:由于服务器无法直接读取本地绝对路径,所以要想访问需要借助其他的资源
		 * 2.存放在访问服务器的根目录下:放服务器上,可以直接通过服务器访问,并且没有在当前应用的内部,所以更新应用的时候,内容不会被删除
		 * 3.放在WEB-INF下:这里的内容,外界无法直接查看,所以安全性高,但是随着应用的更新内容会被删除.
		 */
    	
    	// D:\apache-tomcat-7.0.52\webapps/upload/120.jpg
    	//1.获取全路径的前半部分
    	String storeDirecty = "D:\\javawork\\.metadata\\.me_tcat7\\webapps\\upload";
    	
    	File readfile = new File(storeDirecty);
    	
    	if (!readfile.exists()) {
			readfile.mkdirs();//将路径上的所有文件夹创建出来
		}
    	
    	//2.获取后半部分路径
    	//>取文件的名字--可能带路径
    	String name =  fileItem.getName();//取文件的名字
    	name = FilenameUtils.getName(name);//只要名字
    	
    	//处理同名的文件的方法---现在的图片名字
    	name = UUID.randomUUID().toString()+"_"+name;
    	
    	//创建子文件夹(作为图片的子目录)  D:/apache-tomcat-7.0.52/webapps/upload/   a/b/saotiwqoigjwqoj_120.jpg
    	String substr = getChildDirectory(readfile, name);
    	
    	//获取存储文件的全路径
    	File newfile = new File(readfile,substr+File.separator+name);
    	
    	try {
			fileItem.write(newfile);//直接将文件写入当前的目录下面
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    //根据哈希码值获取子目录
    public static String getChildDirectory(File file,String name) {
		//获取哈希码值   FA4C67788
    	int has = name.hashCode();
    	String hasStr = Integer.toHexString(has);
    	String subString = hasStr.charAt(0)+File.separator+hasStr.charAt(1);//   F/A
    	
    	//生成真实的路径
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
