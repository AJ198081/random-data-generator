package dev.aj.randomdatagenerator.service;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class ATOService {

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


}
