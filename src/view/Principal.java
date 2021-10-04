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
        	buffer.append("Fila de Impress�o\n");
        	buffer.append("O que voc� gostaria de fazer?");
        	buffer.append("\n------------------------------------------------");
        	buffer.append("\n1 - Inserir um documento na fila");
        	buffer.append("\n2 - Imprimir documentos da fila");
        	buffer.append("\n9 - Finalizar a aplica��o");
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
                case 9: System.out.print("\n\nAplica��o Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        }
        while(opc != 9);
	}

}
