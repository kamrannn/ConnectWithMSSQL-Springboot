package com.app.snayallspringboot.repository;

import com.app.snayallspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(
            value = "SELECT * FROM t_user WHERE  id= ?1",
            nativeQuery = true)
    Optional<User> findUserbyId(Integer id);

}
