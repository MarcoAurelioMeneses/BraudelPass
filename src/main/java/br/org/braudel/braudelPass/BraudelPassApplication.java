package br.org.braudel.braudelPass;

import br.org.braudel.braudelPass.principal.Principal;
import br.org.braudel.braudelPass.repositorios.SenhasRepositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BraudelPassApplication implements CommandLineRunner {
	@Autowired
	private SenhasRepositorios repositorio;


	public static void main(String[] args) {
		SpringApplication.run(BraudelPassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repositorio);
		principal.ExibirMenu();

	}
}
