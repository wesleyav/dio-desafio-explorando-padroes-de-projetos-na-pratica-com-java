package com.github.wesleyav.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wesleyav.gof.model.Cliente;
import com.github.wesleyav.gof.model.Endereco;
import com.github.wesleyav.gof.repository.ClienteRepository;
import com.github.wesleyav.gof.repository.EnderecoRepository;
import com.github.wesleyav.gof.service.ClienteService;
import com.github.wesleyav.gof.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();

	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);

	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBase = clienteRepository.findById(id);
		if (clienteBase.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
