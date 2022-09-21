
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int bolsonaro=0;
		int lula=0;
		int ciro=0;
		int branco=0, nulo=0;
		int opcao, qntVotos=0;
		
		do {
			System.out.println("Eleições 2022");
			System.out.println("1 - Votar");
			System.out.println("2 - Encerrar");
			System.out.println("Escolha uma opção --> ");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				System.out.println("Digite título de eleitor: ");
				int titulo = scan.nextInt();
				
				System.out.println("Candidatos:");
				System.out.println("Bolsonaro - Código 22");
				System.out.println("Lula - Código 13");
				System.out.println("Ciro - Código 12");
				System.out.println("Branco - Código 1");
				System.out.println("Nulo - Código 0");
				System.out.println("Digite o código desejado: ");
				int voto = scan.nextInt();
				
				switch(voto) {
				case 22:
					bolsonaro++;
					break;
				case 13:
					lula++;
					break;
				case 12:
					ciro++;
					break;
				case 1:
					branco++;
					break;
				case 0:
					nulo++;
					break;
				}
				qntVotos++;
				System.out.println("Seu voto foi computado com sucesso.");
				
			} else if (opcao == 2) {
				if (qntVotos == 0){
					System.out.println("Programa encerrado.");
				} else {
					int outros  = branco + nulo;
					double porLula = calcularPorc(lula, qntVotos);
					double porCiro = calcularPorc(ciro, qntVotos);
					double porBolso = calcularPorc(bolsonaro, qntVotos);
					double porOutros = calcularPorc(outros, qntVotos);
					
					int segundoTurno = calcularVencedor(porLula, porCiro, porBolso, porOutros);
					
					if (segundoTurno == 1) {
						segundoTurno(porLula, porCiro, porBolso);
					}
				}
	
			} else {
				System.out.println("Opção inválida.");
			}
			
		} while (opcao!=2);
		
		scan.close();
	}
	
	public static double calcularPorc(int candidato, int totalVotos) {
		double porc = (candidato * 100) / totalVotos;
		return porc;
	}
	
	public static int calcularVencedor(double porLula, double porCiro, double porBolso, double porOutros) {
		int segundoTurno = 0;
		if (porBolso == 0 && porCiro == 0 || porLula >= 50 && porCiro < 50 && porBolso < 50){
            System.out.println("Votação encerrada!");
            if (porOutros > porLula) {
            	System.out.println("Haverá uma nova eleição com outros candidatos.");
            } else {
            	System.out.println("Lula foi o vencedor.");
            }
        } else if (porBolso == 0 && porLula == 0 || porCiro >= 50 && porLula < 50 && porBolso < 50){
            System.out.println("Votação encerrada!");
            if (porOutros > porCiro) {
            	System.out.println("Haverá uma nova eleição com outros candidatos.");
            } else {
            	System.out.println("Ciro foi o vencedor.");
            }
        } else if (porLula == 0 && porCiro == 0 || porBolso >= 50 && porLula < 50 && porCiro < 50){
            System.out.println("Votação encerrada!");
            if (porOutros > porBolso) {
            	System.out.println("Haverá uma nova eleição com outros candidatos.");
            } else {
            	System.out.println("Bolsonaro foi o vencedor.");
            }
        } else if (porBolso == porLula && porLula == porCiro) {
        	System.out.println("Empate nas eleições.");
        } else {
        	segundoTurno = 1;
        }
		
		return segundoTurno;
	}
	
	public static void segundoTurno(double porLula, double porCiro, double porBolso) {
		System.out.println("Segundo turno!");
		if (porLula > porBolso && porCiro > porBolso){
            System.out.println("Lula: " + porLula + "%");
            System.out.println("Ciro: " + porCiro + "%");
        } else if (porLula > porCiro && porBolso > porCiro){
            System.out.println("Lula: " + porLula + "%");
            System.out.println("Bolsonaro: " + porBolso + "%"); 
        } else if (porCiro > porLula && porBolso > porLula){
            System.out.println("Ciro: " + porCiro + "%");
            System.out.println("Bolsonaro: " + porBolso + "%"); 
        }
	}
}