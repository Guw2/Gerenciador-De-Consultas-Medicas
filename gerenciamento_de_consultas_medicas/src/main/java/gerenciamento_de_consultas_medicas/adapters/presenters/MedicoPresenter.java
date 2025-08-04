package gerenciamento_de_consultas_medicas.adapters.presenters;

import gerenciamento_de_consultas_medicas.casos_de_uso.output.MostrarMedicoOutputPort;
import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;

public class MedicoPresenter {
	
	private final MostrarMedicoOutputPort output;

	public MedicoPresenter(MostrarMedicoOutputPort output) {
		this.output = output;
	}

	public void mostrar(MedicoDTO medicoDto) {
		output.mostrar(medicoDto);
	}
	
}
