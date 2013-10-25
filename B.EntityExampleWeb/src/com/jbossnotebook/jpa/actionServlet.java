package com.jbossnotebook.jpa;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class actionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName="sampleds")
	private EntityManager em;
	
	@Resource
	UserTransaction utx;
	
    public actionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("op");

		System.out.println("Action is "+action);
		String forward = null;
		if (action == null) {
			forward = employeeList(request);
		}
		else if (action.equals("newEmployee")) {
			forward = newEmployee(request);
		}
		else if (action.equals("newDepartment")) {
			forward = newDepartment(request);
		}
		else if (action.equals("saveEmployee")) {
			forward = saveEmployee(request);
		}
		else if (action.equals("saveDepartment")) {
			forward = saveDepartment(request);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forward);
		dispatcher.forward(request,response);
	}

	private String newDepartment(HttpServletRequest request) {
		return "/newDepartment.jsp";
	}
	
	private String employeeList(HttpServletRequest request) {

		try {
			Query query = em.createQuery("FROM Employee");
			List <Employee>list = query.getResultList();
			request.setAttribute("employee", list);
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {

		}
		return "/listEmployees.jsp";
	}

	private String saveDepartment(HttpServletRequest request) {
		
		String depName=request.getParameter("depName");

		Department dep;

		try {
			dep = new Department();
			dep.setDepartmentName(depName);
			utx.begin();
			em.persist(dep);
			utx.commit();
		}
		catch (Exception e) {
			try {
				utx.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		finally {

		}
		return employeeList(request);
	}

	private String newEmployee(HttpServletRequest request) {

		try {
			Query query = em.createQuery("from Department ");
			List <Department>list = query.getResultList(); 
			request.setAttribute("departmentList",list);
		}	
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {

		}
		return "/newEmployee.jsp";

	}
	
	private String saveEmployee(HttpServletRequest request) {

		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		String departmentId=request.getParameter("departmentId");

		try {
			Query query = em.createQuery("from Department d where d.departmentId = :departmentId");
			query.setParameter("departmentId", new Integer(departmentId));
			Department dep = (Department) query.getSingleResult();
			
			Employee emp = new Employee();
			emp.setDepartment(dep);
			emp.setEmployeeName(name);
			emp.setEmployeeSalary(Integer.parseInt(salary));
			
			utx.begin();
			em.persist(emp);
			utx.commit();
		}	
		catch (Exception e) {
			try {
				utx.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		finally {

		}
		return employeeList(request);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
