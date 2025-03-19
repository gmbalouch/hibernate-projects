package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.Employee;
import com.provider.FactoryProvider;

import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAllEmployees() {
        Transaction transaction = null;
        List<Employee> employees = null;

        try (Session session = FactoryProvider.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            employees = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return employees;
    }
    
    public boolean saveEmp(Employee emp) {
    	Transaction transaction = null;
        boolean isSaved = false;

        try (Session session = FactoryProvider.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(emp);  // Save employee object
            transaction.commit();
            
            isSaved = true;  // Mark success

        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
            isSaved = false;  // Mark failure
        }
        return isSaved;
    }
    
    public Employee getById(int emp_id) {
    	try(Session session=FactoryProvider.getSessionFactory().openSession()){
    		Employee emp=session.get(Employee.class, emp_id);
    		
    		return emp;
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
   
	public boolean updateEmp(int emp_id, Employee newEmployee) {
    	Transaction transaction=null;
    	try(Session session=FactoryProvider.getSessionFactory().openSession()){
    		 transaction=session.beginTransaction();
    	
    		Employee oldEmployee=session.get(Employee.class, emp_id);
    		if(oldEmployee!=null) {
    			oldEmployee.setName(newEmployee.getName());
    			oldEmployee.setAddress(newEmployee.getAddress());
    			oldEmployee.setEmail(newEmployee.getEmail());
    			oldEmployee.setGender(newEmployee.getGender());
    			oldEmployee.setMobile_no(newEmployee.getMobile_no());
    			
    			session.merge(oldEmployee);
    			transaction.commit();
    			return true;
    		}
    		
    	}catch(Exception e) {
    		if (transaction != null) {
                transaction.rollback(); // Rollback on failure
            }
            e.printStackTrace();
    	}
    	return false;
    }

	public boolean deleteEmp(int emp_id) {
		Transaction transaction=null;
    	try(Session session=FactoryProvider.getSessionFactory().openSession()){
    		 transaction=session.beginTransaction();
    		 Employee employee=session.get(Employee.class, emp_id);
    		 
    		 if(employee !=null) {
    			 session.remove(employee);
    		 }
    		 transaction.commit();
    	}
		return true;
	}	
}

