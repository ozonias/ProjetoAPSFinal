package modelo.cliente;


import modelo.lojaVariedades.Pessoa;

public class Cliente extends Pessoa{
   
	public Cliente(String nome,String end, String telefone ){
		this.nome = nome;
		this.end = end;
		this.telefone = telefone;	
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return telefone;
	}

	public void setTel(String tel) {
		this.telefone = tel;
	}

	public String getEnd() {
		return end;
	}
	
        public void setEnd(String end){
            this.end=end;
        }

    public Cliente() {
    }
}
