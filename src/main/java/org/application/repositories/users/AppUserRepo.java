package org.application.repositories.users;

import org.application.models.users.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
}
