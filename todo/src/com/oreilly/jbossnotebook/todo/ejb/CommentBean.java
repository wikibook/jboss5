package com.oreilly.jbossnotebook.todo.ejb;

import java.util.Date;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;


/**
 * Entity bean representing a blog entry.
 * 
 * @ejb.bean name="Comment"
 *           type="CMP"
 *           cmp-version="2.x"
 *           view-type="local"
 *           primkey-field="id"
 *           reentrant="false"
 *
 * @ejb.finder signature="java.util.Collection findAll()"
 *             query="SELECT OBJECT(c) FROM Comment AS c"
 *
 * @ejb.value-object name="Comment"
 * 
 * @ejb.permission unchecked="true"
 */
public abstract class CommentBean 
    implements EntityBean 
{
    /** @ejb.create-method */
    public String ejbCreate(String comment, Date date, TaskLocal task) 
        throws CreateException 
    {
        setId(TaskUtil.generateGUID(this));
        setCommentText(comment);
        setDate(date);
                                             
        return null;
    }

    public void ejbPostCreate(String comment, Date date, TaskLocal task)
    {
        setTask(task);
    }

    /**
     * @ejb.pk-field
     * @ejb.persistence
     * @ejb.interface-method
     */
    abstract public String getId();
    abstract public void setId(String id);
  
    /**
     * @ejb.persistence
     * @ejb.interface-method
     */ 
    public abstract String getCommentText();    
    /** @ejb.interface-method */
    public abstract void setCommentText(String text);


    /**
     * @ejb.persistence
     * @ejb.interface-method
     */ 
    public abstract Date getDate();    
    /** @ejb.interface-method */
    public abstract void setDate(Date date);
  
    /**
     * @ejb.interface-method
     * 
     * @ejb.relation name="task-comment"
     *               role-name="comment-belongs-to-task"
     *               cascade-delete="yes"
     */
    public abstract TaskLocal getTask();
    
    /** @ejb.interface-method */
    public abstract void setTask(TaskLocal topic);

    /** @ejb.interface-method */
    public abstract Comment getComment();
    /** @ejb.interface-method */
    public abstract void    setComment(Comment comment);


}
