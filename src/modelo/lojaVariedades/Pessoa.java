package modelo.lojaVariedades;


import java.io.Serializable;

public abstract class Pessoa{

  protected String nome ="";
  protected String cpf="";
  protected String telefone="";
  protected String end="";

  public String getCpf() {
    return cpf;
  }

  public String getEndereco() {
    return end;
  }

  public String getNome() {
    return nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setEndereco(String endereco) {
    this.end = endereco;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
