package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text){

		if(text.equals(""))
			return 0;

		if(text.contains("\n"))
			text = text.replace("\n" , ",");

		throwExceptionIfNegative(text);
		text = removeBigNumbers(text);
		
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
    String[] negatives = splitText(text);
    if (text.contains("-")) {
        throw new IllegalArgumentException("Negative numbers not allowed: "); 
        //+ extractNegativeNumbers(negatives)
    	}

    }

    private static String removeBigNumbers(String text){

		StringBuilder newnumber = new StringBuilder();
		String[] oldnumber = splitText(text);
		for(String numb : oldnumber){
		    if (toInt(numb) < 1000){
		    	newnumber.append(numb);
		    	newnumber.append(",");}
			}
		return newnumber.toString();
	}
}