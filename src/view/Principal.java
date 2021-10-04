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

package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingridcosme.filastr.Fila;
import controller.ImpressoraController;

public class Principal {

	public static void main(String[] args) {
		ImpressoraController iCont = new ImpressoraController();
		Fila f = new Fila();
		
		String documento = "";
		
		int opc=0;
        do{
        	StringBuffer buffer = new StringBuffer();
        	buffer.append("Fila de Impressão\n");
        	buffer.append("O que você gostaria de fazer?");
        	buffer.append("\n------------------------------------------------");
        	buffer.append("\n1 - Inserir um documento na fila");
        	buffer.append("\n2 - Imprimir documentos da fila");
        	buffer.append("\n9 - Finalizar a aplicação");
        	String opcStr = JOptionPane.showInputDialog(buffer.toString());
        	opc = Integer.parseInt(opcStr);
        	
            switch(opc){
                case 1: documento = JOptionPane.showInputDialog("Insira um documento"
                		+ " no seguinte formato:"
                		+ "\n"
                		+ "\n    ID_PC;Nome_Arquivo");
                		iCont.validaDocumento(f, documento);
                        break;
                case 2: try {
							iCont.imprime(f);
						} catch (Exception e) {
							e.printStackTrace();
						}
                        break;
                case 9: System.out.print("\n\nAplicação Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
        while(opc != 9);
	}

}
