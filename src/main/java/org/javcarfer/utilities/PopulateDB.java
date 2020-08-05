package org.javcarfer.utilities;

import org.javcarfer.App;
import org.javcarfer.security.users.Authority;
import org.javcarfer.security.users.UserAccount;
import org.springframework.boot.SpringApplication;

public class PopulateDB {
    public static void main(String[] args) {
        ApplicationContext populationContext;
        DatabaseUtil databaseUtil;

        databaseUtil = null;

        try {
            System.out.printf("Populating DB");
            System.out.printf("--------------------%n%n");

            System.out.printf("Initialising persistence context `%s'...%n", PersistenceSystem.DBName);
            databaseUtil = new DatabaseUtil();

            System.out.printf("Creating database `%s' (%s)...%n", databaseUtil.getDatabaseName(), databaseUtil.getDatabaseDialectName());
            databaseUtil.recreateDatabase();

            System.out.printf("Reading configuration file `%s'...%n", "PopulateDatabase.xml");
            populationContext = new ClassPathXmlApplicationContext("classpath:populateDatabase.xml");

            System.out.printf("Persisting %d entities...%n%n", populationContext.getBeanDefinitionCount());
            databaseUtil.openTransaction();
            for (Entry<String, Object> entry : populationContext.getBeansWithAnnotation(Entity.class).entrySet()) {
                String beanName;
                DomainEntity entity;

                beanName = entry.getKey();
                entity = (DomainEntity) entry.getValue();
                System.out.printf("> %s: %s", beanName, entity.getClass().getName());
                databaseUtil.persist(entity);
                System.out.printf(" -> id = %d, version = %d%n", entity.getId(), entity.getVersion());
            }
            databaseUtil.commitTransaction();
        } catch (Throwable oops) {
            System.out.flush();
            System.err.printf("%n%s%n", oops.getLocalizedMessage());
            oops.printStackTrace(System.err);
        } finally {
            if (databaseUtil != null)
                databaseUtil.close();
        }




        Authority authority=new Authority();
        authority.setAuthority("USER");
        UserAccount u1=new UserAccount();
        u1.addAuthority(authority);
        u1.setUsername("user1");
        u1.setPassword("user1");

    }
}
