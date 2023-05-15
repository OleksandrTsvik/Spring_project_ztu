package ztu.education.spring_web_project.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Заміна web.xml: прописування DispatcherServlet
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * Прописуємо залежність на MyConfiguration (applicationContext)
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};
    }

    /**
     * Вказуємо на url '/'
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}