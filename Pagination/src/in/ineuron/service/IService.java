package in.ineuron.service;

import java.util.List;

import org.hibernate.HibernateException;

import in.ineuron.businessObject.StudentBusiness;
import in.ineuron.model.Student;

public interface IService {
	
		int totalNoOfRecords();
		int pageCount(int pageSize,int totalNoOfRecords);
		int getPosition(int pageSize,int pageNo);
		List<StudentBusiness> fetchData(int startPos,int pageSize) throws HibernateException;
}
