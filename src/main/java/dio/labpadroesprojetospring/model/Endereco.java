package dio.labpadroesprojetospring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ENDERECO")
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
}
