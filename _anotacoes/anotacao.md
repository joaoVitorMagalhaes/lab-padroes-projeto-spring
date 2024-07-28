## GoF no Spring Framework

- **Singleton**: `@Bean` e `@Autowired`
    - Beans são instancias de classe java (ou objetos) que são gerenciados pelo Spring IoC container.
    - Por padrão os beans são singletons, ou seja, uma única instância é criada e compartilhada.
    - para mudar isso devos usar o `@Scope("prototype")`
- **Strategy**: `@Service` e `@Repository`
- **Facade**: construiremos uma API REST com o mesmo objetivo desse padrão, abstrair a complexidade das seguintes
  integrações:
    - **Integração com o serviço de CEP**: https://viacep.com.br/ (Feign)
    - **Spring Data JPA**: persistência de dados (h2)