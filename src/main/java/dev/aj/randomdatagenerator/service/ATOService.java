package dev.aj.randomdatagenerator.service;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ATOService {

    private static final int[] weightageFactor = {10, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    public String generateValidABN() {

        String validAbn = null;

        while (validAbn == null) {

            int[] randomElevenDigitArray = new int[11];

            for (int i = 0; i < 11; i++) {
                if (i == 0) {
                    randomElevenDigitArray[i] = RandomUtils.nextInt(2, 9);
                } else {
                    randomElevenDigitArray[i] = RandomUtils.nextInt(0, 9);
                }
            }

            int checkSumWeightage = getCheckSumWeightage(randomElevenDigitArray);

            if (checkSumWeightage % 89 == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i : randomElevenDigitArray) {
                    sb.append(String.valueOf(i));
                }
                validAbn = sb.toString();
            }
        }
        return validAbn;
    }

    private static int getCheckSumWeightage(int[] randomElevenDigitArray) {
        int sum = 0;

       /* randomElevenDigitArray[0] = randomElevenDigitArray[0] - 1;

        for (int i = 0; i < randomElevenDigitArray.length; i++) {
            sum += randomElevenDigitArray[i] * weightageFactor[i];
        }*/



        sum += (randomElevenDigitArray[0] - 1) * 10
                + randomElevenDigitArray[1] * 1
                + randomElevenDigitArray[2] * 3
                + randomElevenDigitArray[3] * 5
                + randomElevenDigitArray[4] * 7
                + randomElevenDigitArray[5] * 9
                + randomElevenDigitArray[6] * 11
                + randomElevenDigitArray[7] * 13
                + randomElevenDigitArray[8] * 15
                + randomElevenDigitArray[9] * 17
                + randomElevenDigitArray[10] * 19;
        return sum;
    }

    public boolean checkABNValidity(String abn) {

        char[] chars = abn.toCharArray();

        int[] abnIntArray = new int[11];

        int sum = 0;
        
        for (int i = 0; i < chars.length; i++) {

            sum += (Character.getNumericValue(chars[0]) - 1) * 10
                    + Character.getNumericValue(chars[2]) * 3
                    + Character.getNumericValue(chars[1]) * 1
                    + Character.getNumericValue(chars[3]) * 5
                    + Character.getNumericValue(chars[4]) * 7
                    + Character.getNumericValue(chars[5]) * 9
                    + Character.getNumericValue(chars[6]) * 11
                    + Character.getNumericValue(chars[7]) * 13
                    + Character.getNumericValue(chars[8]) * 15
                    + Character.getNumericValue(chars[9]) * 17
                    + Character.getNumericValue(chars[10]) * 19;
            
            abnIntArray[i] = (int) chars[i];

        }



        return sum % 89 == 0;

    }


}
