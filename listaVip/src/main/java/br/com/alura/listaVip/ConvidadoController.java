package br.com.alura.listaVip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listaVip.Repository.ConvidadoRepository;
import br.com.alura.listaVip.model.Convidado;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository convidadoRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/listaconvidados")
	public String listaConvidados(Model model) {

		Iterable<Convidado> convidados = convidadoRepository.findAll();
		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome,
						 @RequestParam("email") String email,
						 @RequestParam("telefone") String telefone, Model model) {
		
		Convidado novoConvidado = new Convidado(nome,email,telefone);
		convidadoRepository.save(novoConvidado);
		
		Iterable<Convidado> convidados = convidadoRepository.findAll();
		model.addAttribute("convidados", convidados);
		
		//obterConvidadoPor(nome);
		
		return "listaconvidados";
	}
	
	private void obterConvidadoPor(String nome) {
		
		List<Convidado> lista = convidadoRepository.findByNome(nome);
		for (Convidado convidado : lista) {
			System.out.println(convidado.getNome());
		}
		
		
	}
}