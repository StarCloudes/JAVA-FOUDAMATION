package com.qianfeng.test;

public class Test {
	/*
	 * ��ϰ:
	 * 1.request
	 * 	>�����е�һЩ���÷���
	 * 	>post�µ����Ĵ���(tomcat7)  tomcat8��post��ʱ��Ҳ��Ҫʹ��setCharacterEnCoding���ñ���
	 * 	>��������ȡ�����ݵķ���
	 * 		>�ַ���
	 * 		.getParameter(��ǩ������)   ��ȡһ����ǩ��ֵ
	 * 		.getParameterValues(��ǩ������)    ��ȡһ��name��Ӧ�Ķ��ֵ
	 * 		.getParameterNames()     ��ȡ���еı�ǩ��
	 * 		.getParameterMap()      ��ȡ���еı�ǩ����ֵ,���map
	 * 		>�ֽ���
	 * 		getInputstream()    ͼƬ���ϴ�
	 * >get�µ����Ĵ���   �ٱ����ٽ���
	 * >�ض���������ת��
	 * 		�ض���     sendRedirect()    ---   response
	 * 		����ת��   getRequestDispatcher()  ----  request
	 *      request:�������
	 * 2.cookie--�Ự����
	 * 	>�����﷨     
	 * 		ֻ�ܽ����ַ���
	 * 		�ͻ��˼���
	 * 		���ֵ4kb
	 *      �Լ�ֵ�Եķ�ʽ��ֵ
	 *      ͨ��getMaxage��Ǵ��ʱ��
	 *      ͨ��getpath����·��
	 *      requestͨ��getCookies()��ȡ�ͻ��˴���������cookie����
	 *      responseͨ��addCookie()��cookie������ӵ��ͻ���
	 * 3.session--�Ự����
	 * 		�������˼���
	 * 		�������
	 * 		���Դ洢������ֵ
	 * 		�Լ�ֵ�Եķ�ʽ��ֵ
	 * 		ÿһ���������Ӧһ��session,һ��session��һ��sessionid
	 *      session  ���ǿ����ֶ� ���ô��ʱ��  ����  setMaxInactiveInterval(interval) ��λ��
	 * 4.���ﳵ
	 */
    
}
