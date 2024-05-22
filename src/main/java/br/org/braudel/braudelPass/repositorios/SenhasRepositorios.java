package br.org.braudel.braudelPass.repositorios;

import br.org.braudel.braudelPass.models.Senhas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SenhasRepositorios extends JpaRepository<Senhas, Long> {

    @Query("SELECT s FROM Senhas s WHERE s.identificacao ILIKE %:nome%")
    List<Senhas> buscarSenhas(String nome);

}
