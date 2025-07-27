package gerenciamento_de_consultas_medicas.casos_de_uso.interactors;

import java.time.LocalDate;

import gerenciamento_de_consultas_medicas.casos_de_uso.input.AgendarConsultaInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.ConsultaRepository;
import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;
import gerenciamento_de_consultas_medicas.entities.Consulta;
import gerenciamento_de_consultas_medicas.entities.ConsultaStatus;
import gerenciamento_de_consultas_medicas.entities.Medico;
import gerenciamento_de_consultas_medicas.entities.Paciente;

public class AgendarConsultaInteractor implements AgendarConsultaInputPort{

	private final ConsultaRepository repo;
	
	public AgendarConsultaInteractor(ConsultaRepository repo) {
		this.repo = repo;
	}

	@Override
	public void agendar(MedicoDTO medicoDto, PacienteDTO pacienteDto, LocalDate date) {
		Consulta consulta = new Consulta();
		Medico medico = new Medico();
		Paciente paciente = new Paciente();
		
		medico.setId(medicoDto.getId());
		medico.setNome(medicoDto.getNome());
		medico.setEspecialidade(medicoDto.getEspecialidade());
		medico.setCrm(medicoDto.getCrm());
		
		paciente.setId(pacienteDto.getId());
		paciente.setNome(pacienteDto.getNome());
		paciente.setCpf(pacienteDto.getCpf());
		paciente.setData_De_nascimento(pacienteDto.getData_de_nascimento());
		paciente.setTelefone(pacienteDto.getTelefone());
		
		consulta.setData(date);
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setStatus(ConsultaStatus.CONFIRMADO);
		repo.save(consulta);
	}
	
}
