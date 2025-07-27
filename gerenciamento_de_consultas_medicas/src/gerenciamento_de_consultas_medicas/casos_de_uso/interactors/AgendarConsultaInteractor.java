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
import gerenciamento_de_consultas_medicas.mappers.MedicoMapper;
import gerenciamento_de_consultas_medicas.mappers.PacienteMapper;

public class AgendarConsultaInteractor implements AgendarConsultaInputPort{

	private final ConsultaRepository repo;
	private final MedicoMapper medicoMapper = new MedicoMapper();
	private final PacienteMapper pacienteMapper = new PacienteMapper();
	
	public AgendarConsultaInteractor(ConsultaRepository repo) {
		this.repo = repo;
	}

	@Override
	public void agendar(MedicoDTO medicoDto, PacienteDTO pacienteDto, LocalDate date) {
		Consulta consulta = new Consulta();
		Medico medico = new Medico();
		Paciente paciente = new Paciente();
		
		medicoMapper.map(medico, medicoDto);
		pacienteMapper.map(paciente, pacienteDto);
		
		consulta.setData(date);
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setStatus(ConsultaStatus.CONFIRMADO);
		repo.save(consulta);
	}
	
}
