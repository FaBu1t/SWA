package de.hsos.swa.pizza4me.control;

import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

import de.hsos.swa.pizza4me.entity.Security.UserLogin;
import io.quarkus.runtime.StartupEvent;

public class CreateInitialSecEntities {
    @Transactional

    public void loadUsers(@Observes StartupEvent evt) {
        // UserLogin.deleteAll();
        UserLogin.add("login", "login", "KundIn");
    }

}
