package gerenciamento_de_consultas_medicas.casos_de_uso.output;

import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;

public interface MostrarMedicoOutputPort {
	
	void mostrar(MedicoDTO medicoDto);

}
