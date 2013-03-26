package modelo.cliente;

public class ClienteFisico extends Cliente {

	String cpf;

	public ClienteFisico(String nome, String cpf, String tel) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = tel;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "ClienteFisico: " + "nome= " + nome + " " + "cpf=" + cpf + " "
				+ "telefone" + telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteFisico other = (ClienteFisico) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
