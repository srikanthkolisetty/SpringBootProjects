package in.ineuron.dao;

import java.util.List;

import org.hibernate.HibernateException;

import in.ineuron.businessObject.StudentBusiness;
import in.ineuron.model.Student;

public interface IDao {
	
	int totalNoOfRecords();
	List<StudentBusiness> fetchData(int startPos,int pageSize) throws HibernateException;
}
