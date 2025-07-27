package gerenciamento_de_consultas_medicas.casos_de_uso.input;

import java.time.LocalDate;

import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public interface AgendarConsultaInputPort {

	void agendar(MedicoDTO medico, PacienteDTO paciente, LocalDate date);
	
}
