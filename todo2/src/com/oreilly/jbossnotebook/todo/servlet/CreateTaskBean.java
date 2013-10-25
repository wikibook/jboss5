package com.oreilly.jbossnotebook.todo.servlet;

import java.util.*;
import com.oreilly.jbossnotebook.todo.ejb.*;

public class CreateTaskBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String create() {
        try {
            TaskMasterLocalHome home   = TaskMasterUtil.getLocalHome();
            TaskMasterLocal     master = home.create();
            
            System.out.println("Created: " + master.createTask(UserBean.user(), name));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
