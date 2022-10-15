package crud;

import model.Endereco;
import model.Permissoao;
import model.Pessoa;
import model.Partida;
import model.PacotePartida;
import model.ItensCompra;
import model.Compra;

import dao.EnderecoDAO;
import dao.PermissaoDAO;
import dao.PessoaDAO;
import dao.PartidaDAO;
import dao.PacotePartidaDAO;
import dao.ItensCompraDAO;
import dao.CompraDAO;
import dao.ReiniciaTabelaDAO;

public class Console {

	public static void main(String[] args) {

		Endereco end = new Endereco("Rua das Moças", "21", "Bonitesa", "Diamantina", "MG");
		//EnderecoDAO endDao = new EnderecoDAO();
		//endDao.save(end);
		
		Permissoao perm = new Permissoao("ADM");
		//PermissaoDAO permDao = new PermissaoDAO();
		//permDao.save(perm);
		
		end.setIdEndereco(1);
		perm.setIdPermissao(1);
		
		Pessoa pess = new Pessoa("0733", "Maia", "12/08/1985", 'F', "maia@maia", "35325258", end, perm);
		PessoaDAO peDao = new PessoaDAO();
		peDao.save(pess);
		
		peDao.getPessoaList();
		for(Pessoa pess2 : peDao.getPessoaList()){
			System.out.println(pess2.getCpf());
			System.out.println(pess2.getNomePessoa());
		}
		
		/**
		Endereco end2 = new Endereco("Rua das Velhas", "71", "Feiura", "Cubatão", "SP");
		endDao2.update(end2);
		Endereco end3 = endDao.getEnderecoById(1);
		System.out.println(end3.getLogradouro());
		System.out.println(end3.getBairro());
	
		endDao.deleteById(1);
		
		/**
		Partida part = new Partida(1, "12/06/1998", "Brasileirão", "Flamengo", "BotaFogo");

		Compra comp = new Compra(1, "01/01/2022", 0, pe);
		
		int quant=0;

		for (int i = 3; i>0; i--) {
			
			PacotePartida pacote = new PacotePartida(i, "FlamentoxBotaFogo", "12/05/2001", "15/04/2022", 100.00, part);
			ItensCompra itCompra = new ItensCompra(i, pacote, 1);
			
			quant++;
			comp.acidionaItem(itCompra);
			

		}
		
		comp.valorTotal();
		comp.setQuantidadePacotes(quant);

		System.out.println(comp.toString());**/

	}

}
