package com.oreilly.jbossnotebook.todo.servlet;

import java.util.*;
import com.oreilly.jbossnotebook.todo.ejb.*;

public class DebugBean
{
    private static boolean isDebug;

    public boolean getDebugMode() {
        return isDebug;
    }
    
    public void setDebugMode(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public String doNothing() {
        return null;
    }
}
