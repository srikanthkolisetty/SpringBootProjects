package in.ineuron.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import in.ineuron.businessObject.StudentBusiness;
import in.ineuron.model.Student;

public class IDaoImpl implements IDao {

	Configuration con;
	SessionFactory factory;
	Session session;
	Transaction transaction;

	public int totalNoOfRecords() {

		con = new Configuration();
		con.configure();
		factory = con.buildSessionFactory();
		if (factory != null) {
			session = factory.openSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					NativeQuery query = session.getNamedNativeQuery("hello");
					return ((BigInteger)query.uniqueResult()).intValue() == 0 ? 0 : ((BigInteger)query.uniqueResult()).intValue();
				}
				transaction.commit();
				session.close();
				factory.close();
			}
		}

		return 0;
	}

	@Override
	public List<StudentBusiness> fetchData(int startPos, int pageSize) throws HibernateException{
		// TODO Auto-generated method stub
		con = new Configuration();
		con.configure();
		factory = con.buildSessionFactory();
		if (factory != null) {
			session = factory.openSession();
			if (session != null) {
				try {
					transaction = session.beginTransaction();
					if (transaction != null) {
						Query query = session.getNamedQuery("hql");
						query.setFirstResult(startPos);
						query.setMaxResults(pageSize);
						List<Student> list=query.getResultList();
						List<StudentBusiness>ab = new ArrayList();
						list.forEach(row->
						{
							StudentBusiness std=new StudentBusiness();
							std.setAge(row.getAge());
							std.setCourse(row.getCourse());
							std.setName(row.getName());
							ab.add(std);
						});
						return ab;
					}
					transaction.commit();
				} catch (HibernateException e) {
					e.printStackTrace();
					transaction.rollback();
					throw e;
				} finally {
					session.close();
				//	factory.close();
				}

			}
		}

		return null;
	}

}
