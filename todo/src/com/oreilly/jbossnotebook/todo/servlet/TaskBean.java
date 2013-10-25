package com.oreilly.jbossnotebook.todo.servlet;

import java.util.*;
import com.oreilly.jbossnotebook.todo.ejb.*;

import javax.faces.context.FacesContext;

public class TaskBean
{
    private static final String CURR_TASK = "currentTask";

    private String commentText;

    public Collection getTasks() {
        try {
            TaskMasterLocalHome home   = TaskMasterUtil.getLocalHome();
            TaskMasterLocal     master = home.create();
            
            Collection c = master.getTasksForUser(UserBean.user());
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String viewTask() {
        Task task = (Task) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("task");
        setCurrentTask(task);

        return "taskView";
    }

    
    public void setCurrentTask(Task task) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(CURR_TASK, task);
    }

    public Task getCurrentTask() {
        return (Task) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(CURR_TASK);
    }


    public String complete() {
        Task task = (Task) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("task");
        setCurrentTask(task);
        return completeCurrent();
    }

    public String completeCurrent() {
        try {
            TaskMasterLocalHome home   = TaskMasterUtil.getLocalHome();
            TaskMasterLocal     master = home.create();

            String id = getCurrentTask().getId();
            master.completeTask(id);
            setCurrentTask(master.findTaskById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }


    public void setComment(String comment) {
        commentText = comment;
    }
    public String getComment() {
        return commentText;
    }

    public String addComment() {
        // System.out.println("Adding a comment: " + commentText);
        try {
            TaskMasterLocalHome home   = TaskMasterUtil.getLocalHome();
            TaskMasterLocal     master = home.create();
            
            String id = getCurrentTask().getId();
            master.comment(id, getComment(), new Date());

            setCurrentTask(master.findTaskById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
