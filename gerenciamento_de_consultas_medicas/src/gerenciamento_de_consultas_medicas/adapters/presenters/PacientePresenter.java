package gerenciamento_de_consultas_medicas.adapters.presenters;

import gerenciamento_de_consultas_medicas.casos_de_uso.output.MostrarPacienteOutputPort;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public class PacientePresenter {

	private final MostrarPacienteOutputPort output;
	
	public PacientePresenter(MostrarPacienteOutputPort output) {
		this.output = output;
	}

	public void mostrar(PacienteDTO pacienteDto) {
		output.mostrar(pacienteDto);
	}
	
}
