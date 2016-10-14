package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text){

		if(text.equals(""))
			return 0;

		if(text.contains("\n"))
			text = text.replace("\n" , ",");

		throwExceptionIfNegative(text);
		text = BigNumbers(text);
		
		return sum(splitText(text));
	}

	private static String[] splitText(String text){
	    return text.split(",");
	}

	private static int sum(String[] text){
 	    int total = 0;
        for(String number : text){
		    total += toInt(number);
		}
		return total;
    }

    private static int toInt(String number){
		return Integer.parseInt(number);
	}

	//Þarf að útfæra að hann sýni hvaða tölur eru negatívar
	private static void throwExceptionIfNegative(String text) {
    String negatives = "";
    if (text.contains("-")) {
        negatives = extractNegativeNumbers(text);
        throw new IllegalArgumentException("Negative numbers not allowed: " + negatives); 
    	}

    }
   private static String extractNegativeNumbers(String negatives){
    	String [] arr = splitText(negatives);
    	String negativeNumbers = "";
    	for(String numb : arr){
    		if(toInt(numb) < 0){
    			negativeNumbers += numb + ",";
    		}
    	}

    	return negativeNumbers;
    }

    private static String BigNumbers(String text){

		StringBuilder newnumber = new StringBuilder();
		String[] oldnumber = splitText(text);
		for(String numb : oldnumber){
		    if (toInt(numb) < 1000){
		    	newnumber.append(numb);
		    	newnumber.append(",");
		    }
		}
		return newnumber.toString();
	}
}