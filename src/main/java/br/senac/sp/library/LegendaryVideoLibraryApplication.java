package br.senac.sp.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.senac.sp.security.tokens", "br.senac.sp.library"})
public class LegendaryVideoLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegendaryVideoLibraryApplication.class, args);
	}

}
