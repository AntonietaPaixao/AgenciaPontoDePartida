package br.com.pontodepartida.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pontodepartida.model.Pessoa;
import br.com.pontodepartida.model.UserDetailsImpl;
import br.com.pontodepartida.repository.PessoaRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Pessoa pessoa = pessoaRepository.findByemail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		return pessoa;
	}

}
