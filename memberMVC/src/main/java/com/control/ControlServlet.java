package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"*.do"},
    initParams = {
        @WebInitParam(name="propertyConfig", value="command.properties")
    }
)
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> map = new HashMap<String, Object>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        String propertyConfig = config.getInitParameter("propertyConfig");
        System.out.println("propertyConfig = " + propertyConfig);

        String realFolder = config.getServletContext().getRealPath("/WEB-INF");
        String realPath = realFolder + "/" + propertyConfig;
        System.out.println("realPath = " + realPath);

        FileInputStream fin = null;
        Properties properties = new Properties();

        try {
            fin = new FileInputStream(realPath);
            properties.load(fin);
            System.out.println("properties = " + properties);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        Iterator it = properties.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key = " + key);

            String className = properties.getProperty(key);
            System.out.println("className = " + className);

            try {
                Class<?> classType = Class.forName(className);
                Object ob = classType.getDeclaredConstructor().newInstance();

                System.out.println("ob = " + ob);

                map.put(key, ob);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }

            System.out.println();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---------------------------");
        if (request.getMethod().equals("POST")) {
            request.setCharacterEncoding("UTF-8");
        }

        String category = request.getServletPath();
        System.out.println("category = " + category);

        CommandProcess com = (CommandProcess) map.get(category);

        if (com != null) {
            String view = null;
            try {
                view = com.requestPro(request, response);
                System.out.println("view : "+view);
            } catch (Throwable e) {
                e.printStackTrace();
            }

            if (view != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                if (dispatcher != null) {
                    dispatcher.forward(request, response);
                } else {
                    System.err.println("Error: RequestDispatcher is null for view - " + view);
                    // 예외 처리 또는 다른 대응 방법 추가
                }
            } else {
                System.err.println("Error: View is null for category - " + category);
                // 예외 처리 또는 다른 대응 방법 추가
            }
        } else {
            System.err.println("Error: CommandProcess is null for category - " + category);
            // 예외 처리 또는 다른 대응 방법 추가
        }
    }
}
