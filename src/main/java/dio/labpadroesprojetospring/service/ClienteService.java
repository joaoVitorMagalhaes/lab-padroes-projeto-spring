package dio.labpadroesprojetospring.service;

import dio.labpadroesprojetospring.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> findAll();
    Cliente findById(Long id);
    void save(Cliente cliente);
    void update(Long id, Cliente cliente);
    void delete(Long id);
}