package prac.javabrains.database.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import prac.javabrains.database.model.Circle;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

@Repository
public class HibernateDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public int getCircleCount() {
		String queryStr="SELECT COUNT(*) FROM Circle";
		Session session=this.getSessionFactory().openSession();
		Query query= session.createQuery(queryStr);
		int ans=((Long)query.uniqueResult()).intValue();
		session.close();
		return ans;
		
	}
	
	public String getCircleName(int circleID) {
		String queryStr="SELECT name FROM Circle WHERE ID=:circleID";
		Session session=this.getSessionFactory().openSession();
		Query query= session.createQuery(queryStr);
		query.setParameter("circleID",circleID);
		String ans=(String)query.uniqueResult();
		session.close();
		return ans;
	}
	
	public Circle getCircleForId(int circleID) {
		String queryStr="FROM Circle WHERE ID=:circleID";
		Session session=this.getSessionFactory().openSession();
		Query query= session.createQuery(queryStr);
		query.setParameter("circleID",circleID);
		List<Circle> circleList=(List<Circle>)query.list();
		Circle ans=new Circle();;
		if(circleList.size()>0) {
			ans= circleList.get(0);
		}
		session.close();
		return ans;
	}
	
	public List<Circle> getAllCircles(){
		String queryStr="FROM Circle";
		Session session=this.getSessionFactory().openSession();
		Query query=session.createQuery(queryStr);
		List<Circle> ans=(List<Circle>)query.list();
		session.close();
		return ans;
	}
	
	public boolean insertCircle(Circle circle) {
		Session session=this.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(circle);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e) {
			session.close();
			e.printStackTrace();
		}
		return false;
	}
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
