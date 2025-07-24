package gerenciamento_de_consultas_medicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

import gerenciamento_de_consultas_medicas.adapters.controllers.PacienteController;
import gerenciamento_de_consultas_medicas.adapters.db.InMemoryPacienteRepository;
import gerenciamento_de_consultas_medicas.casos_de_uso.input.CadastrarPacienteInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.CadastrarPacienteInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.MostrarPacienteInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.output.MostrarPacienteOutputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.PacienteRepository;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public class Main {
	public static void main(String[] args) {
		
		PacienteDTO paciente = gerarPaciente();
		
		PacienteRepository repo = new InMemoryPacienteRepository();
		CadastrarPacienteInputPort input = new CadastrarPacienteInteractor(repo);
		PacienteController controller = new PacienteController(input);
		MostrarPacienteOutputPort output = new MostrarPacienteInteractor();
		
		controller.cadastrar(paciente);
		
		output.mostrar(paciente);
		
	}
	
	private static PacienteDTO gerarPaciente() {
		PacienteDTO pacienteDto = new PacienteDTO();
		
		pacienteDto.setId(1L);
		pacienteDto.setNome("Gauter");
		pacienteDto.setCpf(new Random().nextLong(10000000000L, 99999999999L));
		pacienteDto.setData_de_nascimento(LocalDate.of(2004, 11, 30));
		pacienteDto.setTelefone("+55 (48) 99999-9999");
		
		return pacienteDto;
	}
}
