package org.tao.aitest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tao.aitest.dto.entity.UserLogin;

import java.util.Optional;

@Repository
public interface UserLoginRep extends JpaRepository<UserLoginRep, Long> {

    Optional<UserLogin> findByUserId(String uuid);

    @Query("UPDATE Order o SET o.status = :status, o.version = o.version + 1 " +
            "WHERE o.id = :id AND o.version = :version")
    int updateStatusWithVersion(@Param("id") Long id);

}
