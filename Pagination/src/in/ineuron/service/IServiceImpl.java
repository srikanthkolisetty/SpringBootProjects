package in.ineuron.service;

import java.util.List;

import org.hibernate.HibernateException;

import in.ineuron.businessObject.StudentBusiness;
import in.ineuron.dao.IDao;
import in.ineuron.dao.IDaoImpl;

public class IServiceImpl implements IService {

	private IDao IDaoImpl = new IDaoImpl();

	@Override
	public int totalNoOfRecords() {

		return IDaoImpl.totalNoOfRecords();
	}

	@Override
	public int pageCount(int pageSize, int totalNoOfRecords) {
	
		int pageCount=totalNoOfRecords/pageSize;
		if(totalNoOfRecords%pageSize !=0)
		{
			pageCount++;
		}
		return pageCount;
	}

	@Override
	public int getPosition(int pageSize,int pageNo) {
			
		return pageNo*pageSize-pageSize; 
	}

	@Override
	public List<StudentBusiness> fetchData(int startPos, int pageSize) throws HibernateException {

		
		return IDaoImpl.fetchData(startPos,pageSize);
	}

}
