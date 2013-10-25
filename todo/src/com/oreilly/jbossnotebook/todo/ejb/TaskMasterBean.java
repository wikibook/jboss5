package com.oreilly.jbossnotebook.todo.ejb;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.naming.NamingException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

/**
 * @ejb.bean name="TaskMaster"
 *           type="Stateless"
 *           view-type="local"
 * 
 * @ejb.ejb-ref  ejb-name="Task" 
 *               view-type="local"
 *               ref-name="ejb/TaskLocal"
 *
 * @ejb.ejb-ref ejb-name="Comment" 
 *              view-type="local"
 *              ref-name="ejb/CommentLocal"
 * 
 * @ejb.permission unchecked="true"
 */
public abstract class TaskMasterBean
    implements SessionBean 
{  
    /**  
     * Returns a set of Task (VO) objects
     * @ejb.interface-method
     */
    public Collection getTasksForUser(String user) 
    {
        Collection results = null;

        try {
            TaskLocalHome home = TaskUtil.getLocalHome();

            results = new ArrayList();
            Iterator it_tasks = home.findTasksForUser(user).iterator();
            while (it_tasks.hasNext()) {
                TaskLocal local = (TaskLocal) it_tasks.next();
                results.add(local.getTask());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    /**
     * @ejb.interface-method
     */
    public TaskLocal createTask(String user, String name)
    {
        try {
            TaskLocalHome home = TaskUtil.getLocalHome();
            TaskLocal     task = home.create(user, name);
            return task;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    private TaskLocal findTaskLocalById(String id) {
        try {
            TaskLocalHome home = TaskUtil.getLocalHome();
            return  home.findByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @ejb.interface-method
     */
    public Task findTaskById(String id) {
        return findTaskLocalById(id).getTask();
    }



    /**
     * @ejb.interface-method
     */
    public void comment(String id, String comment, Date date)
    {
        try {
            TaskLocal        task = findTaskLocalById(id);
            CommentLocalHome home = CommentUtil.getLocalHome();

            System.out.println("Creating: " + home.create(comment, date, task));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * @ejb.interface-method
     */
    public void completeTask(String id) 
    {
        try {
            TaskLocal task = findTaskLocalById(id);
            task.setCompletedDate(new Date());
            System.out.println("Completed: " + id);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
