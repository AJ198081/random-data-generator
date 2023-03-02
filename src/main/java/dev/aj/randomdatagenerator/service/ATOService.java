package dev.aj.randomdatagenerator.service;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

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

        for (int i = 0; i < randomElevenDigitArray.length; i++) {
            if (i == 0){
                sum += (randomElevenDigitArray[i] - 1) * weightageFactor[i];
                continue;
            }
            sum += randomElevenDigitArray[i] * weightageFactor[i];
        }
        return sum;
    }

    public boolean checkABNValidity(String abn) {
        char[] chars = abn.toCharArray();
        int sum = 0;
        
        for (int i = 0; i < chars.length; i++) {

            if (i == 0) {
                sum += (Character.getNumericValue(chars[i]) - 1) * weightageFactor[i];
                continue;
            }
            sum += Character.getNumericValue(chars[i]) * weightageFactor[i];
        }
        return sum % 89 == 0;
    }
}
