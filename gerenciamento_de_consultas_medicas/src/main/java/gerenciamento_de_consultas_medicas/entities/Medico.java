package gerenciamento_de_consultas_medicas.entities;

import java.util.Objects;

public class Medico {

	private Long id;
	private String nome;
	private String crm;
	private MedicoEspecialidade especialidade;
	
	public Medico() {}
	
	public Medico(Long id, String nome, String crm, MedicoEspecialidade especialidade) {
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public MedicoEspecialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(MedicoEspecialidade especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + ", crm=" + crm + ", especialidade=" + especialidade
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(crm, especialidade, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(crm, other.crm) && especialidade == other.especialidade
				&& Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
}
