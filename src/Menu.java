import java.util.Scanner;
import com.google.gson.*;

public class Menu extends ConsumoApi {
	Scanner leitura = new Scanner(System.in);
	ConsumoApi consumo = new ConsumoApi();
	
	int comando = 0;
	String lista = "===================================== "+
		  "\n Conversão de Moeda:" +
		  "\n\n 1. BRL para USD \r" +
		  " 2. USD para BRL \r" +
		  " 3. EUR para USD \r" +
		  " 4. USD para EUR \r" +
		  " 5. BRL para EUR \r" +
		  " 6. EUR para BRL \r" +
		  "=====================================";
	
	public void requisicao() throws Exception {
		System.out.println(lista);
		var busca = leitura.nextInt();
		comando = busca;
		switch (comando) {
		    case 1:
		    	moeda = "BRL";
		    	BagOfPrimitives BoP = ConsumoApi.obterDados("https://v6.exchangerate-api.com/v6/b7a5c8a11346972567e53f87/latest/"+moeda);
		    	System.out.println("O valor BRL em USD é equivalente a "+BoP.conversion_rates.get("USD").doubleValue()+" dolares");
		        break;
		    case 2:
		    	moeda = "USD";
		    	BagOfPrimitives BoP2 = ConsumoApi.obterDados("https://v6.exchangerate-api.com/v6/b7a5c8a11346972567e53f87/latest/"+moeda);
		    	System.out.println("O valor USD em BRL é equivalente a "+BoP2.conversion_rates.get("BRL").doubleValue()+" reais");
		        break;
		    case 3:
		    	moeda = "EUR";
		    	BagOfPrimitives BoP3 = ConsumoApi.obterDados("https://v6.exchangerate-api.com/v6/b7a5c8a11346972567e53f87/latest/"+moeda);
		    	System.out.println("O valor EUR em USD é equivalente a "+BoP3.conversion_rates.get("USD").doubleValue()+" dolares");
		        break;
		    case 4:
		    	moeda = "USD";
		    	BagOfPrimitives BoP4 = ConsumoApi.obterDados("https://v6.exchangerate-api.com/v6/b7a5c8a11346972567e53f87/latest/"+moeda);
		    	System.out.println("O valor USD em EUR é equivalente a "+BoP4.conversion_rates.get("EUR").doubleValue()+" euros");
		    	break;
		    case 5:
		    	moeda = "BRL";
		    	BagOfPrimitives BoP5 = ConsumoApi.obterDados("https://v6.exchangerate-api.com/v6/b7a5c8a11346972567e53f87/latest/"+moeda);
		    	System.out.println("O valor BRL em EUR é equivalente a "+BoP5.conversion_rates.get("EUR").doubleValue()+" euros");
		    	break;
		    case 6:
		    	moeda = "EUR";
		    	BagOfPrimitives BoP6 = ConsumoApi.obterDados("https://v6.exchangerate-api.com/v6/b7a5c8a11346972567e53f87/latest/"+moeda);
		    	System.out.println("O valor EUR em BRL é equivalente a "+BoP6.conversion_rates.get("BRL").doubleValue()+" reais");
		    	break;
		    default:
		    	System.out.println("~ Operação inválida ~");
		    	break;
		}
	}

}
