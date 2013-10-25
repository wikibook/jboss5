package com.oreilly.jbossnotebook.todo.servlet;

import org.jboss.security.SecurityAssociation;
import java.security.Principal;

public class UserBean
{


    public String getName() {
        return user();
    }
    // need setter?

    public static String user() {
        Principal p = SecurityAssociation.getPrincipal();
        
        return (p == null) ? "anonymous" : p.getName();
    }
}
