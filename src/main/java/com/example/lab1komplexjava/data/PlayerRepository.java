package com.example.lab1komplexjava.data;

import com.example.lab1komplexjava.business.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    Optional<Player> findById(int id);
    List<Player> findByName(String name);

}
