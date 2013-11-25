package view;

import java.util.Calendar;
import java.util.InputMismatchException;

import javax.swing.JDialog;



public class VerificadorCamposFormulario 
{
	public static boolean cpfEhValido(String CPF)
	{
		// considera-se erro CPFs formados por uma sequencia de numeros iguais 
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") 
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") 
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") 
				|| CPF.equals("99999999999") || (CPF.length() != 11))
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "CPF invalido. Por favor, digite um CPF valido");
			return(false);
		}
		char dig10, dig11; 
		int sm, r, num, peso; 
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try
		{
			//Calculo do 1o digito verificador
			sm = 0;
			peso = 10;
			for(int i = 0; i < 9; i++)
			{
				// converte o i-esimo caractere do CPF em um numero: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posicao de '0' na tabela ASCII) 
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso - 1;		
			}
			r = 11 - (sm % 11); 
			if ((r == 10) || (r == 11))
			{
				dig10 = '0'; 
			}
				
			else 
			{
				dig10 = (char)(r + 48); // converte no respectivo caractere numerico
			}
			// Calculo do 2o. Digito Verificador 
			sm = 0; 
			peso = 11; 
			for(int i=0; i<10; i++) 
			{
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11); 
			if ((r == 10) || (r == 11))
			{
				dig11 = '0'; 
			}
				
			else 
			{
				dig11 = (char)(r + 48);
			}
			
			// Verifica se os digitos calculados conferem com os digitos informados. 
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
			{
				return(true);
			}
			else
			{
				DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
				autoDiS.showMessageDialog(null, "CPF invalido. Por favor, digite um CPF valido");
				return(false);
			}
				 
		} 
		catch(InputMismatchException erro)
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "CPF invalido. Por favor, digite um CPF valido");
			return(false);
		}
			
	}
	
	/*usado em numero do endereco ou quantidade de convidados ou quantidade de item em festa*/
	public static boolean campoNumericoDeValorAte11EhValido(String valorCampo, String nomeCampo)
	{
		if(valorCampo.length() == 0)
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "campo importante nao preenchido:" + nomeCampo);
        	return false;
		}
		else if(stringEhNumerica(valorCampo) == false)
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "valor invalido para "+ nomeCampo +", por favor digite um valor valido");
        	return false;
		}
		else
		{
			int campoEmInt = Integer.parseInt(valorCampo);
			if(campoEmInt < 0 || valorCampo.length() > 11)
			{
				DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
				autoDiS.showMessageDialog(null, "valor invalido para "+ nomeCampo +", por favor digite um valor valido");
	        	return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	
	
	public static boolean dataEhValida(Calendar data)
	{
		try
		{
			 String dataString = data.get(Calendar.DAY_OF_MONTH) + "/" + 
                     (data.get(Calendar.MONTH) + 1) 
                       + "/" + data.get(Calendar.YEAR);
			 return true;
		}
		catch(Exception e)
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "alguma data eh invalida, por favor informe apenas datas validas");
        	return false;
		}
	}
	
	/*as mesmas regras valem para rua, bairro, cidade, nome ou cep*/
	public static boolean campoComAte25CaracteresEhValido(String valorCampo, String queCampoEhEsse)
	{
		if(valorCampo.length() == 0)
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "campo importante nao preenchido:" + queCampoEhEsse);
        	return false;
		}
		else if(queCampoEhEsse.length() > 45 || (stringEhNumerica(valorCampo) == true && queCampoEhEsse != "cep") 
				|| (stringEhNumerica(valorCampo) == false && queCampoEhEsse == "cep"))
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, queCampoEhEsse + " invalido, por favor informe um valor valido");
        	return false;
		}
		else
		{
			return true;
		}
	}
	
	
	
	public static boolean stringEhNumerica(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
	
	public static boolean precoEhValido(String precoEmString)
	{
		if(precoEmString.length() == 0)
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "por favor, informe um preco");
			return false;
		}
		else if(stringEhNumerica(precoEmString) == false || Double.valueOf(precoEmString) < 0)
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "preco invalido, por favor informe outro preco");
			return false;
		}
		else
		{
			return true;
		}
	}
	 
	public static boolean nomeEhValido(String valorDoNome, String nomeDoCampo)
	{
		if(valorDoNome.length() == 0 || valorDoNome.length() > 45 )
    	{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "campo " + nomeDoCampo +  " deve ter entre 1 e 45 caracteres. digite um " + nomeDoCampo + " valido");
    		return false;
    	}
		else
		{
			return true;
		}
	}
	
	public static boolean telefoneEhValido(String numeroTelefone)
	{
		if(numeroTelefone.matches("\\(\\d{2}\\)\\d{4}-\\d{4}"))
		{
			//cobre os seguintes testes: (00) 0000 0000, (00)-0000-0000 (00).0000.0000
			return true;
		}
		else
		{
			DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
			autoDiS.showMessageDialog(null, "numero de telefone invalido. Por favor, digite um telefone valido");
			return false;
		}
	}

}
