/*
 * Criar um projeto Java que implementa com a biblioteca FilaStrings para simular
 * um ambiente corporativo, comum, como agências bancárias que tem diversos com_
 * putadores e 1 impressora central. Nesses casos, a impressora tem uma fila de
 * impressões para que cada documento enviado comece e termine a impressão sem 
 * que documentos se misturem.
 * A aplicação deve ter uma classe no package controller, ImpressoraController que
 * tem os seguintes métodos:
 * -insereDocumento (Fila f, String documento):void, o documento no formato
 * ID_PC;Nome_Arquivo (Já validado antes do envio) deverá enfileirar os documentos
 * enviados.
 * -imprime (Fila f):void, que desenfilera um documento da fila, por vez, exibe
 * no console [#PC: ID_PC–Arquivo: Nome_Arquivo]. Cada impressão dura de 1 a 2
 * segundos usar Math.random() ou a classe Random e um Thread.sleep(tempo) para
 * simular o tempo de impressão. Exibir uma exceção caso não haja documento na 
 * fila de impressão.
 * Deve ter também uma classe Principal no packageview com operações usando
 * JOptionPane que permita ao usuário inserir e validar os documentos de entrada
 * e iniciar um procedimento de impressão. A aplicação deve rodar até uma opção
 * de saída ser selecionada pelo usuário.
 */

package controller;

import br.edu.fateczl.ingridcosme.filastr.Fila;

public class ImpressoraController {

	public ImpressoraController() {
		super();
	}

	public void validaDocumento (Fila f, String documento) {
		String[] docVet = documento.split(";");
		if(docVet.length == 2) {
			insereDocumento(f, documento);
		} else {
			System.out.println("Formato incorreto <<"+documento+">>.");;
		}
	}
	
	public void insereDocumento (Fila f, String documento) {
		f.insert(documento);
	}
	
	public void imprime (Fila f) throws Exception {
		if(f.isEmpty()) {
			throw new Exception("Não há documento para ser impresso!");
		} else {
			while(!f.isEmpty()) {
				String[] documento = (f.remove()).split(";");
				int tempo = (int)((Math.random() * 1001) + 1000);  //1 a 2 segundos
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("[#PC: "+documento[0]+" – Arquivo: "+documento[1]+"]");
			}
		}
	}
	
	 
}
