package gerenciamento_de_consultas_medicas.casos_de_uso.output;

import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public interface MostrarPacienteOutputPort {
	
	void mostrar(PacienteDTO pacienteDto);
	
}
