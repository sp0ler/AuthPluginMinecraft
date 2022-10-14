package ru.deevdenis.authenticationmc.Configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import ru.deevdenis.authenticationmc.Models.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static final String PROPERTY_DRIVER = "org.postgresql.Driver";
    private static final String PROPERTY_URL = "jdbc:postgresql://192.168.46.128:5432/maincraft";
    private static final String PROPERTY_USERNAME = "";
    private static final String PROPERTY_PASSWORD = "";
    private static final String PROPERTY_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, PROPERTY_DRIVER);
                settings.put(Environment.URL, PROPERTY_URL);
                settings.put(Environment.USER, PROPERTY_USERNAME);
                settings.put(Environment.PASS, PROPERTY_PASSWORD);
                settings.put(Environment.DIALECT, PROPERTY_DIALECT);

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
