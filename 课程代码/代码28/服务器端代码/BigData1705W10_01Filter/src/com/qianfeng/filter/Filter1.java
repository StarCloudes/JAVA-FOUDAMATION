package com.qianfeng.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * ����������tomcat������������,���ٵ�
 * ������Ҳ��Ҫע��
 * 
 * ����������������:
 * Filter1()  ���췽��---һ��
 * init()     ��ʼ������--һ��
 * doFilter() �����ķ���(����)--���
 * destroy()  ����--һ��
 * 
 * ִ��˳��:Filter1()----init-----doFilter-----destroy
 */
public class Filter1 implements Filter {
	FilterConfig fconfig = null;
	//��ʼ������
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fconfig = filterConfig;//��ȡconfig����

	}

	//�����ķ���
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * ���ǰ���ͬһ���ͻ��˺ͷ�����֮����ڶ��������ʱ,��Ϊ��������
		 * ����ԭ��:����FilterChain��doFilter�������Ȼ���ת������Ĺ�����,������û�й�������,�ͻ���ת��������
		 * 
		 * �����ڶ��������ʱ,����Ҫ��������
		 * �ؼ�������web.xml�ļ�������
		 * 1.ע���˳������˹�������ִ�е�˳��
		 * 2.Ҫ����ͬһ������,���뱣֤�����ǹ����ķ�������·����һ�µ�.
		 */
		
		//chain.doFilter֮ǰ�������request
		System.out.println("Filter1:����ǰ");
		
		
		chain.doFilter(request, response);//����ʵ�ֹ��˵ķ���

		//chain.doFilter֮�������response
		System.out.println("Filter1:���˺�");
		
		//����Ҳ��ʵ�ֹ���--���ﲻ�ǹ�������
//		chain.doFilter(request, response);
//		System.out.println("Filter1:���˺��");
	}

	//���ٷ���
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
