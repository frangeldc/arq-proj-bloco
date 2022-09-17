package br.edu.infnet.apiendereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;

@Component
public class EnderecoLoader implements ApplicationRunner {

	@Autowired
	private EnderecoService enderecoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		String cep = "12345";

		Endereco endereco = new Endereco();

		try {
			// Endereco endereco = new Endereco();
			endereco.setBairro("bairro");
			endereco.setCep(cep);
			endereco.setComplemento("complemento");
			endereco.setId(11);
			endereco.setLocalidade("localidade");
			endereco.setLogradouro("logradouro");
			endereco.setUf("rj");

			// inclusao
			enderecoService.incluir(endereco);
			System.out.println("Sucesso inclusao endereco.");
		} catch (Exception e) {

			// obterPorCep
			Endereco enderecoBusca = enderecoService.obterPorCep(cep);
			System.out.println("Endereco recuperado atraves do cep [" + cep + "]");

			try {
				endereco.setCep("45233");
				// inclusao
				enderecoService.incluir(endereco);
			} catch (Exception e2) {
				System.out.println("Falha de inclusao endereco.");
			}

			// obeterLista
			for (Endereco end : enderecoService.obterLista()) {
				System.out.printf("%s - %s, %s %s - %s", end.getLogradouro(), end.getComplemento(), end.getBairro(),
						end.getLocalidade(), end.getUf());
				// exibir todos
			}

//			System.out.println("Endereço excluído através do cep ["+enderecoBusca.getCep()+"]");
//			enderecoService.excluir(enderecoBusca.getId());

		}
	}

}
