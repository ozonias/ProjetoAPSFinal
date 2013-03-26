package modelo.gerentes;


import modelo.exception.ClienteInvalidoException;
import java.util.LinkedList;
import java.util.List;
import modelo.cliente.Cliente;
import modelo.cliente.ClienteFisico;
import modelo.cliente.ClienteJuridico;


public class GerenteCliente {

	private List<ClienteFisico> clienteFisico = new LinkedList<ClienteFisico>();
	private List<ClienteJuridico> clienteJuridico = new LinkedList<ClienteJuridico>();
  

	public void cadastrarClienteFisico(ClienteFisico c){
		
		if(c==null){
			throw new ClienteInvalidoException("Cliente Físico Inválido");
		}
		if(c.getCpf().contains ("^[a-Z]")){
			throw new  ClienteInvalidoException("CPF Inválido");
		}
		if(c.getCpf().length()==0){
			throw new ClienteInvalidoException ("CPF Vazio");
		}
		if(c.getNome().length()==0){
			throw new ClienteInvalidoException ("Nome Vazio");
		}
		if (c.getNome()==null){
			throw new ClienteInvalidoException ("Nome Vazio");
		}
		if (c.getCpf()==null){
			throw new ClienteInvalidoException ("CPF Vazio");
		}
		clienteFisico.add(c);
	}
	
	public void cadastrarClienteJuridico(ClienteJuridico c){
		
		if(c==null){
			throw new ClienteInvalidoException("Cliente Jurídico Inválido");
		}
		if(c.getCnpj().contains ("^[a-Z]")){
			throw new  ClienteInvalidoException("CNPJ Inválido");
		}
		if(c.getCnpj().length()==0){
			throw new ClienteInvalidoException ("CNPJ Vazio");
		}
		if(c.getNome().length()==0){
			throw new ClienteInvalidoException ("Nome Vazio");
		}
		if (c.getNome()==null){
			throw new ClienteInvalidoException ("Nome Vazio");
		}
		if (c.getCnpj()==null){
			throw new ClienteInvalidoException ("CNPJ Vazio");
		}
		clienteJuridico.add(c);
	}
	
	public void cancelarCadastroClienteFisico(String cpf){
		clienteFisico.remove(this.pesquisarClienteFisico(cpf));
	}
  
	public void cancelarCadastroClienteJuridico(String cnpj){
		clienteJuridico.remove(this.pesquisarClienteJuridico(cnpj));
	}


	public Cliente pesquisarClienteFisico(String cpf){
		if(cpf.contains ("^[a-Z]")){
			throw new  ClienteInvalidoException("CPF Inválido");
		}
		for(ClienteFisico ve: clienteFisico){
			if(ve.getCpf().equals(cpf))
                return ve;
            }
        		return null;
	}
	
	public Cliente pesquisarClienteJuridico(String cnpj){
		if(cnpj.contains ("^[a-Z]")){
			throw new  ClienteInvalidoException("CNPJ Inválido");
		}
		for(ClienteJuridico ve: clienteJuridico){
                if(ve.getCnpj().equals(cnpj))
                return ve;
    }
          return null;
	}

	public List <ClienteFisico> ListaDeClientesFisicos(){
		for (int i = 0; i < clienteFisico.size(); i++) {
			return clienteFisico;
		}
	return null;
    
    }
	
	public List <ClienteJuridico> ListaDeClientesJuridicos(){
		for (int i = 0; i < clienteJuridico.size(); i++) {
			return clienteJuridico;
		}
	return null;
    
      }  
}
