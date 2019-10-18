package ua.edu.ucu.tempseries;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] tempArray;
    private int arrLen;

    public void isEmpty(){
        if (arrLen == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isValid(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < -273.0) {
                throw new InputMismatchException();
            }
        }
    }

    public TemperatureSeriesAnalysis() {
        this.tempArray = new double[] {0};
        arrLen = 0;

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        isValid(temperatureSeries);

        this.tempArray = temperatureSeries;
        arrLen = tempArray.length;

    }

    public double average() {
        isEmpty();

        float sum = 0;
        for (int i = 0; i < arrLen; i++) {
            sum += tempArray[i];
        }
        return sum / arrLen;

    }

    public double deviation() {
        isEmpty();
        double mean = average();

        float sum = 0;
        for (int i = 0; i < arrLen; i++) {

            sum +=  Math.pow(tempArray[i] - mean, 2);

        }
        return Math.sqrt((1.0 /arrLen) * sum);

    }

    public double min() {
        isEmpty();
        double minValue = Double.MAX_VALUE;
        for (int i = 0; i < arrLen; i ++){
            if (tempArray[i] < minValue) {
                minValue =  tempArray[i];
            }

        }
        return minValue;
    }

    public double max() {
        isEmpty();
        double maxValue = Double.MIN_VALUE;
        for (int i = 0; i < arrLen; i++) {
            if (tempArray[i] > maxValue) {
                maxValue = tempArray[i];
            }
        }
        return maxValue;
    }

    public double findTempClosestToZero() {
        isEmpty();
        double difference = Double.MAX_VALUE;
        for (int i = 0; i < arrLen; i++) {
            if (Math.abs(tempArray[i]) < Math.abs(difference)) {
                difference = tempArray[i];
            }
            else if (Math.abs(tempArray[i]) == Math.abs(difference)) {
                difference = Math.abs(tempArray[i]);
            }
        }
        return difference;
    }

    public double findTempClosestToValue(double tempValue) {
        isEmpty();
        double difference = Double.MAX_VALUE;
        for (int i = 0; i < arrLen; i++) {
            if (Math.abs(tempArray[i] - tempValue) < Math.abs(difference - tempValue)) {
                difference = tempArray[i];
            } else if (Math.abs(tempArray[i] - tempValue) == Math.abs(difference - tempValue)) {
                difference = Math.abs(tempArray[i]);
            }
        }
        return difference;
    }

    public double[] findTempsLessThen(double tempValue) {
        isEmpty();
        int j = 0;
        for (int i = 0; i < arrLen; i++) {
            if (tempArray[i] < tempValue) {
                j += 1;
            }
        }
        double[] result = new double[j];
        int f = 0;
        for (int i = 0; i < arrLen; i++) {
            if (tempArray[i] < tempValue) {
                result[f] = tempArray[i];
                f += 1;
            }
        }
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        isEmpty();
        int j = 0;
        for (int i = 0; i < arrLen; i++) {
            if (tempArray[i] > tempValue) {
                j += 1;
            }
        }
        double[] result = new double[j];
        int f = 0;
        for (int i = 0; i < arrLen; i++) {
            if (tempArray[i] > tempValue) {
                result[f] = tempArray[i];
                f += 1;
            }
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        isEmpty();
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        isValid(temps);
        int len = tempArray.length;
        if (temps.length + len > tempArray.length) {
            int newSize = Math.max(tempArray.length + temps.length, tempArray.length * 2);

            double[] newTemp = new double[newSize];
            System.arraycopy(tempArray,0, newTemp,0, tempArray.length);
            tempArray = newTemp;
            System.gc();
        }

        arrLen += temps.length;

        return arrLen;

        }
    }
