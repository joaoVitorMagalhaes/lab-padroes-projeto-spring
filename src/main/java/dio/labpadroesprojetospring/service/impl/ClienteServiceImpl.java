package dio.labpadroesprojetospring.service.impl;

import dio.labpadroesprojetospring.model.Cliente;
import dio.labpadroesprojetospring.model.Endereco;
import dio.labpadroesprojetospring.repository.ClienteRepository;
import dio.labpadroesprojetospring.repository.EnderecoRepository;
import dio.labpadroesprojetospring.service.ClienteService;
import dio.labpadroesprojetospring.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseGet(Cliente::new);
    }

    @Override
    public void save(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = fetchEndereco(cep);
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void update(Long id, Cliente novoCliente) {
        clienteRepository.findById(id).ifPresent(cliente -> {
            BeanUtils.copyProperties(novoCliente, cliente, "id");
            save(cliente);
        });
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    private Endereco fetchEndereco(String cep) {
        return enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.buscaEnderecoPor(cep);
            return enderecoRepository.save(novoEndereco);
        });
    }
}
