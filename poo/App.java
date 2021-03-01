package poo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App{

    public static void main (String args []){

        int flag = 1;
        
        Scanner input = new Scanner(System.in);

        Cliente cliente = new Cliente("-", "-", "-", 0.0);

        ArrayList<Cliente> clienteArray = new ArrayList<>();

        clienteArray.add(new Cliente("123","Marcelo","12/01",500.0));
        clienteArray.add(new Cliente("456","Augusto","31/02",200.0));
        
        do{

            try{

                System.out.println("\n--Sistema de Fluxo de Caixa-- \n\n*Menu principal\n\n"
                                    + "1 - Entrada/Saida\n"
                                    + "2 - Relatorios\n"
                                    + "0 - Finalizar\n");

                int menu = input.nextInt();

                switch(menu){

                    case 0:
                        System.out.println("\nSaindo...\n");
                        System.exit(0);

                    case 1:
                        System.out.println("\n*Cadastro de Entrada ou Saida\n\n"
                                            + "1 - Inclusao\n"
                                            + "2 - Alteracao\n"
                                            + "3 - Consulta\n"
                                            + "4 - Exclusao\n"
                                            + "0 - Retornar\n");
                    
                        int opcaoCadastro = input.nextInt();

                        if(opcaoCadastro == 1){
                            System.out.println("\n*Inclusao de Entrada ou Saida");

                            System.out.println("");
                            input.nextLine();
                        
                            System.out.println("Documento:\n");
                            String documento = input.nextLine();
                            cliente.setDocumento(documento);

                            System.out.println("\nDescricao:\n");
                            String descricao = input.nextLine();
                            cliente.setDescricao(descricao);

                            System.out.println("\nData de Operacao:\n");
                            String dataOperacao = input.nextLine();
                            cliente.setDataOperacao(dataOperacao);

                            System.out.println("\nValor:\n");
                            double valor = input.nextDouble();
                            cliente.setValor(valor);

                            System.out.println("");
                            input.nextLine();

                            System.out.println("Confirma Inclusao? Sim = S | Nao = N\n");
                            String confirmaInclusao = input.nextLine();

                            if(confirmaInclusao.equalsIgnoreCase("s")){
                                clienteArray.add(new Cliente(documento, descricao, dataOperacao, valor));
                                System.out.println("\nConfirmado!");
                            }else if(confirmaInclusao.equalsIgnoreCase("n")){
                                System.out.println("\nCancelado!");       
                            }
                        }else if(opcaoCadastro == 4){
                            System.out.println("");
                            input.nextLine();

                            System.out.println("\nDigite o numero do documento em que deseja excluir:\n");
                            String doc = input.nextLine();

                            if(cliente.getDocumento().contains(doc)){
                                System.out.println("\nConfirma Exclusao? Sim = S | Nao = N\n");
                                String confirmaExclusao = input.nextLine();

                                if(confirmaExclusao.equalsIgnoreCase("s")){
                                    for(int i = 0; i < clienteArray.size(); i++){
                                        cliente = clienteArray.get(i);
    
                                        if(cliente.getDocumento().equals(doc)){
                                        clienteArray.remove(i);
                                        System.out.println("\nRemovido com sucesso!\n");
                                        break;
                                        }
                                    }
                                }else if(confirmaExclusao.equalsIgnoreCase("n")){
                                    System.out.println("\nCancelado!");
                                }
                            }else{
                                System.out.println("\nErro, documento invalido!\n");
                            }
                        }else if(opcaoCadastro == 2){
                            System.out.println("");
                            input.nextLine();

                            System.out.println("\nDigite o documento em que deseja alterar:\n");
                            String documentoAlterar = input.nextLine();

                            System.out.println("\nDigite a descricao que deseja alterar:\n");
                            String descricaoAlterar = input.nextLine();

                            if(cliente.getDocumento().contains(documentoAlterar) && cliente.getDescricao().contains(descricaoAlterar)){
                                System.out.println("\nConfirma Alteracao? Sim = S | Nao = N\n");
                                String confirmaAlteracao = input.nextLine();

                                if(confirmaAlteracao.equalsIgnoreCase("s")){
                                    System.out.println("\nDigite o novo documento em que deseja inserir:\n");
                                    String novoDocumento = input.nextLine();

                                    System.out.println("\nDigite a nova descricao em que deseja inserir:\n");
                                    String novaDescricao = input.nextLine();

                                    for(int i = 0; i < clienteArray.size(); i++){
                                        cliente = clienteArray.get(i);

                                        if(cliente.getDocumento().equals(documentoAlterar) && cliente.getDescricao().equals(descricaoAlterar)){
                                            clienteArray.get(i).setDocumento(novoDocumento);
                                            clienteArray.get(i).setDescricao(novaDescricao);
                                            System.out.println("\nAlterado para " +novoDocumento+ " com sucesso! | Alterado para " +novaDescricao+ " com sucesso!\n");
                                        }
                                    }
                                }else if(confirmaAlteracao.equalsIgnoreCase("n")){
                                    System.out.println("\nCancelado!");
                                }   
                            }else{
                                System.out.println("\nErro, documento invalido!\n");
                            }
                        }else if(opcaoCadastro == 3){
                            System.out.println("");
                            input.nextLine();

                            System.out.println("\nDigite o documento da conta em que deseja consultar:\n");
                            String documentoConsultar = input.nextLine();

                            if(cliente.getDocumento().contains(documentoConsultar)){
                                for(int i = 0; i < clienteArray.size(); i++){
                                    cliente = clienteArray.get(i);

                                    if(cliente.getDocumento().equals(documentoConsultar)){
                                        System.out.println(clienteArray.get(i));  
                                    }
                                }
                            }else{
                                System.out.println("\nErro, documento invalido!\n");
                            }
                        }

                        break;

                    case 2:
                        System.out.println("\nRelatorios:\n\n"
                                            + "1 - Fechamento do caixa\n"
                                            + "2 - Balanco por periodo\n"
                                            + "0 - Retornar\n");
                        
                        int opcaoRelatorio = input.nextInt();

                        System.out.println("");
                        input.nextLine();

                        if(opcaoRelatorio == 1){
                            System.out.println("*Fechamento do caixa\n\n");
                            System.out.print("Informe a data: ");
                            String dataFechamento = input.nextLine();
                            System.out.print("\n*ARMAZENADOS:\n\nData: " +dataFechamento+ "\n");
                            System.out.println("\n" +clienteArray);
                            System.exit(0);
                        }else if(opcaoRelatorio == 2){
                            System.out.println("*Balanco\n\n");
                            System.out.print("Informe a data: ");
                            String balancoData = input.nextLine();
                            System.out.print("\n*Balanco final:\n\nData: " +balancoData+ "\n");
                            System.out.println("\nValor: " +cliente.getValor()+ "\n");//PROBLEMA...
                            System.exit(0);
                        }else if(opcaoRelatorio == 0){
                            System.out.println("\nVoltando...\n");
                        }else{
                            System.out.println("\nOpcao invalida!\n");
                        }

                        break;

                    default:
                        System.out.println("\nOpcao invalida...\n"); 
                }

            }catch (InputMismatchException errorException){
                System.err.println("\n*Nao e permitido inserir letras ou colocar (.) em vez de (,) no valor");
                input.nextLine();
            }

        }while(flag == 1);

        input.close();
    }
}