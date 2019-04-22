package com.classroom.homework19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//模拟字符缓冲流

public class Demo5 {
	public static void main(String[] args) throws IOException {
		MyBufferReader myBufferReader = new MyBufferReader(new FileReader("text4.txt"));

		String data = null;
		while ((data = myBufferReader.readLine()) != null) {
			System.out.println(data);
		}
	}
}

class MyBufferReader extends Reader {
	Reader reader;

	public MyBufferReader(Reader reader) {
		this.reader = reader;
	}

	public String readLine() throws IOException {
		StringBuffer sBuffer = new StringBuffer();
		int num;
		while ((num = this.reader.read()) != -1) {
			if (num == '\n') {
				return sBuffer.toString();
			} else {
				sBuffer.append((char) num);
			}
		}
		if (sBuffer.length() == 0) {
			return null;
		}
		return sBuffer.toString();
	}

	@Override
	public void close() throws IOException {
		this.reader.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
