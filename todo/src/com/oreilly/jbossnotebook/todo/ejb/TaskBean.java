

package com.oreilly.jbossnotebook.todo.ejb;

import java.util.Date;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;

import org.apache.log4j.Logger;

/**
 * Entity bean representing a blog entry.
 * 
 * @ejb.bean name="Task"
 *           type="CMP"
 *           cmp-version="2.x"
 *           view-type="local"
 *           primkey-field="id"
 *           reentrant="false"
 *
 * @ejb.finder signature="java.util.Collection findAll()"
 *             query="SELECT OBJECT(t) FROM Task AS t"
 * 
 * @ejb.finder signature="java.util.Collection findTasksForUser(java.lang.String user)"
 *             query="SELECT OBJECT(t) FROM Task AS t WHERE t.user = ?1" 
 *
 * @ejb.value-object name="Task" 
 *
 * @ejb.permission unchecked="true"

 * @xx-ejb.permission role-name="User"
 */

public abstract class TaskBean 
    implements EntityBean 
{
    Logger logger =  Logger.getLogger(TaskBean.class);
  
    /** @ejb.create-method */
    public String ejbCreate(String user, String name)  
        throws CreateException 
    {
        System.out.println("GENKEY!");
        setId(TaskUtil.generateGUID(this));
        setName(name);
        setUser(user);
        setStartedDate(new Date()); 
        logger.debug("creating task " + getId() + " for user " + user);
        return null;
    }
  
    public void ejbPostCreate(String name, String user) 
        throws CreateException
    {
    }



    //    /**
    //     * @ejb.persistence
    //     * @ejb.interface-method
    //     */
    //    public abstract int getPriority();
    //    
    //    /** @ejb.interface-method */
    //    public abstract void setPriority(int priority);

  
    /**
     * @ejb.pk-field
     * @ejb.persistence
     * @ejb.interface-method
     */
    public abstract String getId(); 
    public abstract void setId(String id);

    /**
     * @ejb.persistence
     * @ejb.interface-method
     */ 
    public abstract String getName();    
    /** @ejb.interface-method */
    public abstract void setName(String name);
  
    /**
     * @ejb.persistence
     * @ejb.interface-method
     */
    public abstract String getUser();
    
    /** @ejb.interface-method */
    public abstract void setUser(String topic);

    /**
     * @ejb.persistence
     * @ejb.interface-method
     */ 
    public abstract Date getStartedDate();    
    /** @ejb.interface-method */
    public abstract void setStartedDate(Date date);


    /**
     * @ejb.persistence
     * @ejb.interface-method
     */ 
    public abstract Date getCompletedDate();    
    /** @ejb.interface-method */
    public abstract void setCompletedDate(Date date);



    /**
     * @ejb.interface-method
     * 
     * @ejb.relation name="task-comment"
     *               role-name="task-has-comments"
     * @ejb.value-object aggregate="com.oreilly.jbossnotebook.todo.ejb.Comment"
     *                   aggregate-name="Comment"
     *                   members="com.oreilly.jbossnotebook.todo.ejb.CommentLocal"
     *                   members-name="Comments"
     *                   relation="external"
     *                   type="java.util.Set"
     * 
     */
    public abstract Set getComments();
    
    /** @ejb.interface-method */
    public abstract void setComments(Set comments);


    /** @ejb.interface-method */
    public abstract Task getTask();
    /** @ejb.interface-method */
    public abstract void setTask(Task task);
}
