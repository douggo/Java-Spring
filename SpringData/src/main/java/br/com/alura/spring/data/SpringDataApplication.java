package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CargoService;
import br.com.alura.spring.data.service.FuncionarioService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatorioService;
import br.com.alura.spring.data.service.UnidadeService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Scanner scanner = new Scanner(System.in);
	private Boolean isSystemRunning = true;

	private final CargoService cargoService;
	private final UnidadeService unidadeService;
	private final FuncionarioService funcionarioService;
	private final RelatorioService relatorioService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	public SpringDataApplication(
		CargoService cargoService, 
		UnidadeService unidadeService, 
		FuncionarioService funcionarioService,
		RelatorioService relatorioService,
		RelatorioFuncionarioDinamico relatorioFuncionarioDinamico
	)
	{
		this.cargoService = cargoService;
		this.unidadeService = unidadeService;
		this.funcionarioService = funcionarioService;
		this.relatorioService = relatorioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		while(isSystemRunning) {
			imprimeOpcoes(scanner);
		}
	}

	private void imprimeOpcoes(Scanner scanner) {
		limpaConsole();
		System.out.println("Qual ação você deseja realizar?");
		System.out.println("0 - SAIR");
		System.out.println("1 - CARGO");
		System.out.println("2 - UNIDADE");
		System.out.println("3 - FUNCIONÁRIO");
		System.out.println("4 - RELATÓRIOS");
		System.out.println("5 - RELATÓRIOS DINÂMICOS");
		processaAcao();
	}

	private void processaAcao() {
		switch(scanner.nextInt()) {
			case 1:
				this.cargoService.startService(scanner);
			break;
			case 2:
				this.unidadeService.startService(scanner);
			break;
			case 3:
				this.funcionarioService.startService(scanner);
			break;
			case 4:
				this.relatorioService.startService(scanner);
			break;
			case 5:
				this.relatorioFuncionarioDinamico.startService(scanner);
			break;
			case 0:
			default:
				this.isSystemRunning = false;
			break;
		}
	}

	private void limpaConsole() {
        System.out.print("\033[H\033[2J");
    }

}