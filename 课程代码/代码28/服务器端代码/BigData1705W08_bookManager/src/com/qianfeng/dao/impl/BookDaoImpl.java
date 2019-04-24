package com.qianfeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qianfeng.dao.BookDao;
import com.qianfeng.domain.Book;
import com.qianfeng.domain.SearchBook;
import com.qianfeng.util.C3P0Util;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> findAllBooks() throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
	 	
	    return 	qRunner.query("select * from book", new BeanListHandler<Book>(Book.class));
		
	}

	@Override
	public int addBook(Book book) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		return qRunner.update("insert into book values(?,?,?,?,?,?,?)",book.getId(),book.getName(),book.getPrice(),
				book.getPnum(),book.getCategory(),book.getDescription(),book.getImg_url());
	}
	
	//根据id查一本书
	@Override
	public Book findBookById(String id) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		return qRunner.query("select * from book where id=?", new BeanHandler<Book>(Book.class),id);
	}
	
	//根据id修改一本书
	@Override
	public int updateBookByid(Book book) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		return qRunner.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?"
				+ "",book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
	}
	
	//根据id删除一本书
	@Override
	public int delBookByid(String id) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		return qRunner.update("delete from book where id=?",id);
	}
	
	//根据ids删除多本书
	@Override
	public int[] delBooksByIds(String[] ids) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		
		//创建二维数组
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{ids[i]};
		}
		
		return qRunner.batch("delete from book where id=?", params);
	}
	
	//多条件查询
	@Override
	public List<Book> searchBook(SearchBook sBook) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from book where 1=1";
		List<Object> list = new ArrayList<Object>();
		//trim()的作用:去除两边的空格
		if (!sBook.getId().trim().equals("")) {
			sql += " and id like ?";
			list.add("%"+sBook.getId().trim()+"%");
		}
		
		if (!sBook.getName().trim().equals("")) {
			sql += " and name like ?";
			list.add("%"+sBook.getName().trim()+"%");
		}
		
		if (!sBook.getCategory().equals("")) {
			sql += " and category=?";
			list.add(sBook.getCategory());
		}
		if (!sBook.getMaxprice().trim().equals("")) {
			sql += " and price < ?";
			list.add(Integer.parseInt(sBook.getMaxprice().trim()));
		}
		if (!sBook.getMinprice().trim().equals("")) {
			sql += " and price > ?";
			list.add(Integer.parseInt(sBook.getMinprice().trim()));
		}
		
																		//这里要的是可变参数,所以将list转化成数组
		return qRunner.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}
	
	//查询所有书籍的数量
	@Override
	public int getCount() throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
	    long num = (Long)qRunner.query("select count(*) from book", new ScalarHandler(1));//默认从1开始取值
		return (int)num;
	}
	
	//查询每页的书籍信息
	@Override
	public List<Book> findBookByPage(int currentPage, int pageSize) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		return qRunner.query("select * from book  limit ?,?",new BeanListHandler<Book>(Book.class),
				(currentPage-1)*pageSize,pageSize);
	}
}
