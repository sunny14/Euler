package com.faina.euler17;


//TODO: casting (int-long-Biginteger-float-double-BigDecimal)
//TODO: write class description about why create this class instead of keeping a map in a Main class, why is it more OOP
public class BritishNumbersParser {

    private static final String THOUSAND_POSTFIX = "thousand";
    private static final String HUNDRED_POSTFIX = "hundred";

    //TODO: Optional??
    private String stringValue = null;

    String getStringValue() {
        return stringValue;
    }

    BritishNumbersParser(Integer number)  {

        assert (number < 10000);

        StringBuilder sb = new StringBuilder();

        boolean resThousands = constructThousands(number, sb);
        boolean resHundreds = constructHundreds(number, sb);
        if ( (resThousands || resHundreds) && (getTens(number) > 0 || getNums(number) > 0 ) )  {
            sb.append("and");
        }
        constructTens(number, sb);

        this.stringValue = sb.toString();

    }


    private boolean constructThousands(int number, StringBuilder sb)    {

        boolean isThousands = false;

        int thousands = number/1000;
        if (thousands > 0)  {

            sb.append(NUMBERS.fromInt(thousands))
                    .append(THOUSAND_POSTFIX);
            isThousands = true;
        }

        return isThousands;

    }

    private boolean constructHundreds(int number, StringBuilder sb)    {

        boolean isHundreds = false;

        int hundreds = (number % 1000)/100;
        if (hundreds > 0)  {

            sb.append(NUMBERS.fromInt(hundreds))
                    .append(HUNDRED_POSTFIX);
            isHundreds = true;
        }

        return isHundreds;
    }


    private void constructTens(int number, StringBuilder sb)    {

        int tens = getTens(number);
        if (tens == 1)  {
            //search by 2 last symbols
            sb.append(NUMBERS.fromInt(number % 100));
        }
        else    {
            if (tens > 1) {
                sb.append(NUMBERS.fromInt(tens*10));
            }

            int nums = getNums(number);
            if (nums > 0) {
                sb.append(NUMBERS.fromInt(nums));
            }
        }
    }

    private int getNums(int number) {
        return number % 10;
    }

    private int getTens(int number) {
        return (number % 100) / 10;
    }


    //TODO: understand this: The static methods valueOf() and values() are created at compile time and do not appear in source code.
    private enum NUMBERS   {
        ONE (1), TWO(2), THREE(3), FOUR(4),
        FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), ELEVEN(11), TWELVE(12), THIRTEEN(13), FOURTEEN(14),
        FIFTEEN(15), SIXTEEN(16), SEVENTEEN(17), EIGHTEEN(18), NINETEEN(19),
        TWENTY(20), THIRTY(30), FORTY(40), FIFTY(50), SIXTY(60), SEVENTY(70), EIGHTY(80), NINETY(90);

        private Integer value;

        NUMBERS (Integer value) {
            this.value = value;
        }

        static String fromInt(Integer numInt)  {
            for( NUMBERS num: values() )    {
                if (num.value.equals(numInt))    {
                    return num.name();
                }
            }

            //TODO: return optional or throw exception
            return null;
        }

    }

}


