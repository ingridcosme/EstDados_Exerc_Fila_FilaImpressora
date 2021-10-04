/*
 * Criar um projeto Java que implementa com a biblioteca FilaStrings para simular
 * um ambiente corporativo, comum, como ag�ncias banc�rias que tem diversos com_
 * putadores e 1 impressora central. Nesses casos, a impressora tem uma fila de
 * impress�es para que cada documento enviado comece e termine a impress�o sem 
 * que documentos se misturem.
 * A aplica��o deve ter uma classe no package controller, ImpressoraController que
 * tem os seguintes m�todos:
 * -insereDocumento (Fila f, String documento):void, o documento no formato
 * ID_PC;Nome_Arquivo (J� validado antes do envio) dever� enfileirar os documentos
 * enviados.
 * -imprime (Fila f):void, que desenfilera um documento da fila, por vez, exibe
 * no console [#PC: ID_PC�Arquivo: Nome_Arquivo]. Cada impress�o dura de 1 a 2
 * segundos usar Math.random() ou a classe Random e um Thread.sleep(tempo) para
 * simular o tempo de impress�o. Exibir uma exce��o caso n�o haja documento na 
 * fila de impress�o.
 * Deve ter tamb�m uma classe Principal no packageview com opera��es usando
 * JOptionPane que permita ao usu�rio inserir e validar os documentos de entrada
 * e iniciar um procedimento de impress�o. A aplica��o deve rodar at� uma op��o
 * de sa�da ser selecionada pelo usu�rio.
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
			throw new Exception("N�o h� documento para ser impresso!");
		} else {
			while(!f.isEmpty()) {
				String[] documento = (f.remove()).split(";");
				int tempo = (int)((Math.random() * 1001) + 1000);  //1 a 2 segundos
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("[#PC: "+documento[0]+" � Arquivo: "+documento[1]+"]");
			}
		}
	}
	
	 
}
