package project.com.dao;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import project.com.model.Books;
import project.com.utility.HibernateUtil;

public class BookDaoImpl implements BookDao{
static Scanner sc=new Scanner(System.in);
static Books book=new Books();
	public Books addBook(Books books) {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			session.save(books);
			session.getTransaction().commit();
			session.close();
			return  books;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Books> getAllBooks() {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			//execute HQL query to retrieve all students data
			Query<Books> query=session.createQuery("FROM Books");
			List<Books> bookList=query.list();
			return bookList;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Books getBook(long bookId) {
		try (Session session = HibernateUtil.getSession()) {
			
			Books book = (Books) session.get(Books.class, bookId);
			return book;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Books updateBook(long bookId, Books updateBook) {
		try (Session session = HibernateUtil.getSession()) {
			Books book=session.get(Books.class, bookId);
			session.beginTransaction();
			book.setBookId(bookId);
			book.setTitle(updateBook.getTitle());
			book.setAuther(updateBook.getAuther());
			book.setPublicationYear(updateBook.getPublicationYear());
			book.setGener(updateBook.getGener());
			return  book;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String deleteBook(long bookId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Books book=session.get(Books.class, bookId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete? if yes type y");
				String status=sc.next();
				if(status.equalsIgnoreCase("y"))
				{
					session.delete(book);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(book);//data will remove from session Cache
					message="Object is deleted";
					
				}else
				{
					message="User wants to retain this object!!";
				}
				
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;
	}
}


