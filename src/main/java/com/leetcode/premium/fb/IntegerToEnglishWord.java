package com.leetcode.premium.fb;

public class IntegerToEnglishWord {

    String[] ones = {
            "", "One", "Two", "Three", "Four","Five","Six",
            "Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
            "Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"Twenty","Thirty","Fourty","Fifty","Sixty","Sevent","Eighty","Ninety"};
    String hundred = "Hundred";

    String thousand = "Thousand";
    String million = "Million";
    String billion = "Billion";

    String[] denom = {"", thousand, million, billion};

    //23
    //2,147,483,647
    //1,234,567,891
    public String numberToWords(int num) {

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0 && i < denom.length){
            int rem = num % 1000;
            convertToString(sb, rem);
            sb.append(denom[i]);
            sb.append(" ");
            num = num/1000;
            i++;
        }
        return sb.toString().trim();
    }

    private void convertToString(StringBuilder sb, int rem){
        while(rem > 0){
            if(rem >= 100){
                sb.append(ones[rem/100]);
                sb.append(" ");
                sb.append(hundred);
                sb.append(" ");
                rem = rem % 100;
            }
            else if (rem < 20){
                sb.append(ones[rem]);
                rem = 0;
            }else{
                sb.append(tens[(rem/10)-2]);
                sb.append(" ");
                rem = rem%10;
            }
        }
    }
}
