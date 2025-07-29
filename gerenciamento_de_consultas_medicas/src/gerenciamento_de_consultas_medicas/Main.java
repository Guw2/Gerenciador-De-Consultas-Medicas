package gerenciamento_de_consultas_medicas;

import java.time.LocalDate;
import java.util.Random;

import gerenciamento_de_consultas_medicas.adapters.controllers.PacienteController;
import gerenciamento_de_consultas_medicas.adapters.db.InMemoryConsultaRepository;
import gerenciamento_de_consultas_medicas.adapters.db.InMemoryMedicoRepository;
import gerenciamento_de_consultas_medicas.adapters.db.InMemoryPacienteRepository;
import gerenciamento_de_consultas_medicas.casos_de_uso.input.AgendarConsultaInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.input.CadastrarMedicoInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.input.CadastrarPacienteInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.input.CancelarConsultaInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.AgendarConsultaInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.CadastrarMedicoInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.CadastrarPacienteInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.CancelarConsultaInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.ListarConsultasDoPacienteInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.interactors.MostrarPacienteInteractor;
import gerenciamento_de_consultas_medicas.casos_de_uso.output.ListarConsultasDoPacienteOutputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.output.MostrarPacienteOutputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.ConsultaRepository;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.MedicoRepository;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.PacienteRepository;
import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;
import gerenciamento_de_consultas_medicas.entities.MedicoEspecialidade;

public class Main {
	public static void main(String[] args) {
		
		PacienteDTO paciente = gerarPaciente();
		
		PacienteRepository paciente_repo = new InMemoryPacienteRepository();
		CadastrarPacienteInputPort cadastrar_paciente = new CadastrarPacienteInteractor(paciente_repo);
		PacienteController pacienteController = new PacienteController(cadastrar_paciente);
		MostrarPacienteOutputPort mostrar_paciente = new MostrarPacienteInteractor();
		
		// -----
		
		MedicoDTO medico = gerarMedico();
		
		MedicoRepository medico_repo = new InMemoryMedicoRepository();
		CadastrarMedicoInputPort cadastrar_medico = new CadastrarMedicoInteractor(medico_repo);
		cadastrar_medico.cadastrar(medico);
		
		// -----
		
		ConsultaRepository consulta_repo = new InMemoryConsultaRepository();
		AgendarConsultaInputPort agendar_consulta = new AgendarConsultaInteractor(consulta_repo);
		agendar_consulta.agendar(medico, paciente, LocalDate.of(2025, 10, 05));
		ListarConsultasDoPacienteOutputPort listar_consultas = new ListarConsultasDoPacienteInteractor(consulta_repo);
		
		CancelarConsultaInputPort cancelar_consulta = new CancelarConsultaInteractor(consulta_repo);
		cancelar_consulta.cancelar(1L);
		
		listar_consultas.listar(paciente, true);
		
	}
	
	private static MedicoDTO gerarMedico() {
		MedicoDTO medicoDto = new MedicoDTO();
		
		medicoDto.setId(1L);
		medicoDto.setNome("Kris");
		medicoDto.setCrm("543210/RJ");
		medicoDto.setEspecialidade(MedicoEspecialidade.PSIQUIATRA);
		
		return medicoDto;
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
