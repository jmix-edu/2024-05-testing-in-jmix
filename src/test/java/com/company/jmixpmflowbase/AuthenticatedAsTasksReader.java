package com.company.jmixpmflowbase;

import com.company.jmixpmflowbase.entity.User;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.security.SystemAuthenticator;
import io.jmix.flowui.testassist.UiTestAuthenticator;
import org.springframework.context.ApplicationContext;

public class AuthenticatedAsTasksReader implements UiTestAuthenticator {


    @Override
    public void setupAuthentication(ApplicationContext context) {
        User dev2 = context.getBean(UnconstrainedDataManager.class).loadValue("select u from User u where u.username = :username", User.class)
                .parameter("username", "dev2").one();
        context.getBean(SystemAuthenticator.class).begin(dev2.getUsername());
    }

    @Override
    public void removeAuthentication(ApplicationContext context) {
        context.getBean(SystemAuthenticator.class).end();
    }
}
