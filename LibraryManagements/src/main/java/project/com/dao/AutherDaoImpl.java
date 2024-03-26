package project.com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import project.com.model.Auther;
import project.com.utility.HibernateUtil;

public class AutherDaoImpl implements AutherDao{

	@Override
	public Auther addAuther(Auther auther) {
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			session.save(auther);
			session.getTransaction().commit();
			return  auther;
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
	public Auther getAutherById(int autherId) {
		Auther author = null;
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			author = (Auther) session.get(Auther.class, autherId);
			session.save(autherId);
			session.getTransaction().commit();
			return  author;
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
	public Auther getAutherByName(String autherName) {
		Auther author = null;
		try (Session session = HibernateUtil.getSession()) {
			//Begin Transaction
			session.beginTransaction();
			author = (Auther) session.get(Auther.class, autherName);
			session.save(autherName);
			session.getTransaction().commit();
			return  author;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
