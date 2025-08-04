package gerenciamento_de_consultas_medicas.casos_de_uso.input;

import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public interface CadastrarPacienteInputPort {
	
	void cadastrar(PacienteDTO pacienteDto);

}
