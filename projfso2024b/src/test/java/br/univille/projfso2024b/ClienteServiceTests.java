package br.univille.projfso2024b;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.service.ClienteService;

@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@ContextConfiguration
public class ClienteServiceTests {

    @Autowired
    private ClienteService service;

    @Test
    void getAllClientesEmptyList(){
        var listClientes = service.getAll();
        assertEquals(listClientes.size(), 0);
    }

    @Test
	void saveCliente() {
        var newCliente = new Cliente();
        newCliente.setNome("Zezinho");
        newCliente.setEndereco("Rua lalalal 100");
        service.save(newCliente);
        assertNotEquals(newCliente.getId(), 0);
	}

    @Test
    void saveNewClientCheckFindAll(){
        var newCliente = new Cliente();
        newCliente.setNome("Zezinho");
        newCliente.setEndereco("Rua lalalal 100");
        service.save(newCliente);

        var listClientes = service.getAll();
        assertEquals(listClientes.size(), 1);
        assertEquals(listClientes.get(0).getNome(), "Zezinho");
    }

    

}
