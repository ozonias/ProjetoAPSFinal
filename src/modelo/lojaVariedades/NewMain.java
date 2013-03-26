/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.lojaVariedades;

import modelo.exception.Exceptions;
import modelo.estoque.Produto;
import modelo.cliente.ClienteJuridico;
import modelo.cliente.ClienteFisico;
import modelo.funcionario.Funcionario;
import modelo.gerentes.GerenteEstoque;

public class NewMain {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exceptions, Exceptions {
    // TODO code application logic here
    Funcionario fun = new Funcionario ();
    Produto p = new Produto();
    Fachada f = new Fachada();
    p.setNome("arroz");
    p.setPreco("2,00");
    p.setSetor("comida");
    f.addProdutoEstoque(p);
    fun.setNome("maria");
    fun.setCpf("0101");
    fun.setEndereco("Aurora");
    f.addFuncionario(fun);
    
    ClienteFisico cf = new ClienteFisico("maria", "01", "12345");
    ClienteFisico cf2 = new ClienteFisico("TOINHA", "0111", "12345111");
    f.cadastrarClienteFisico(cf);
    f.cadastrarClienteFisico(cf2);
    ClienteJuridico cj = new ClienteJuridico("joana", "0123", "rua do cabaré", "323232");
    ClienteJuridico cj2 = new ClienteJuridico("joanasss", "0ssss123", "rua do cabarssssé", "32sss3232");
    
    f.cadastrarClienteJuridico(cj);
    f.cadastrarClienteJuridico(cj2);
   //System.out.println (f.pesquisarProduto("arroz"));
  // f.removerProduto("arroz");
  // System.out.println (f.pesquisarProduto("arroz"));
   //System.out.println (f.pesquisarFuncionario("maria")); 
   //System.out.println(f.pesquisarClienteFisico("01"));
   //System.out.println(f.pesquisarClienteJuridico("0123"));
   System.out.println(f.ListaDeClientesFisicos());
   System.out.println(f.ListaDeClientesJuridicos());
   
   
GerenteEstoque g = new GerenteEstoque ();
g.addproduto(p);
   }
    
  }
