package gerenciamento_de_consultas_medicas.casos_de_uso.interactors;

import java.util.NoSuchElementException;

import gerenciamento_de_consultas_medicas.casos_de_uso.input.CancelarConsultaInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.ConsultaRepository;
import gerenciamento_de_consultas_medicas.entities.Consulta;
import gerenciamento_de_consultas_medicas.entities.ConsultaStatus;

public class CancelarConsultaInteractor implements CancelarConsultaInputPort{

	private final ConsultaRepository repo;
	
	public CancelarConsultaInteractor(ConsultaRepository repo) {
		this.repo = repo;
	}

	@Override
	public void cancelar(Long id) {
		try {
			Consulta consulta = repo.findById(id).get();
			consulta.setStatus(ConsultaStatus.CANCELADO);
			repo.save(consulta);			
		}catch(NoSuchElementException e) {
			System.out.println("Erro no cancelamento: Não existe uma consulta com o ID " + id + ".");
		}
	}

}
