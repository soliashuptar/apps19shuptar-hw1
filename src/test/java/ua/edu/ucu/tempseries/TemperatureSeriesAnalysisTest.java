package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

//    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

//    @Ignore
    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = { 9.0, 2.0, 5.0, 4.0, 12.0, 7.0, 8.0, 11.0, 9.0, 3.0, 7.0, 4.0, 12.0, 5.0,
                4.0, 10.0, 9.0, 6.0, 9.0, 4.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = 2.9832867780352594;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);

//        assertEquals();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Test(expected = InputMismatchException.class)
    public void testMin() {
      double[] temperatureSeries = { 2.5, 3.0, 8.7, 100.0, -780.0};
      TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

      double expValue = -780.0;
      double realValue = seriesAnalysis.min();
      assertEquals(expValue, realValue, 0.00001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {2.5, 3.0, 8.7, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expValue = 100.0;
        double realValue = seriesAnalysis.max();
        assertEquals(expValue, realValue, 0.00001);
    }

    @Test
    public void testfindTempClosestToZero() {
        double[] temperatureSeries = {2.5, 3.0, 8.7, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expValue = 2.5;
        double realValue = seriesAnalysis.findTempClosestToZero();
        assertEquals(expValue, realValue, 0.00001);
    }

    @Test
    public void testfindTempClosestToZeroTwoValues() {
        double[] temperatureSeries = {-2.5, 2.5, 3.0, 8.7, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expValue = 2.5;
        double realValue = seriesAnalysis.findTempClosestToZero();
        assertEquals(expValue, realValue, 0.00001);
    }

    @Test
    public void testfindTempClosestToValue() {
        double[] temperatureSeries = {-2.5, 2.5, 3.0, 8.7, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expValue = -2.5;
        double realValue = seriesAnalysis.findTempClosestToValue(-1.0);
        assertEquals(expValue, realValue, 0.00001);
    }

    @Test
    public void testfindTempClosestToValue2() {
        double[] temperatureSeries = {-3.5, 3.5, 3.0, 8.7, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expValue = 3.5;
        double realValue = seriesAnalysis.findTempClosestToValue(3.4);
        assertEquals(expValue, realValue, 0.00001);
    }

    @Test
    public void testfindTempClosestToValueTwoValues() {
        double[] temperatureSeries = {-0.5, 0.5, 3.0, 8.7, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expValue = 0.5;
        double realValue = seriesAnalysis.findTempClosestToValue( 0.0);
        assertEquals(expValue, realValue, 0.00001);
    }

    @Test
    public void testfindTempsLessThen() {
        double[] temperatureSeries = {-0.5, 0.5, 3.0, 8.7, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double[] expValue = {-0.5, 0.5, 3.0, 8.7};
        double[] realValue = seriesAnalysis.findTempsLessThen(50.0);
        assertArrayEquals(expValue, realValue, 0.00001);
    }

    @Test
    public  void testfindTempsGreaterThen() {
        double[] temperatureSeries = {-0.5, 0.5, 3.0, 8.7, 49.9, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double[] expValue = {49.9, 100.0};
        double[] realValue = seriesAnalysis.findTempsGreaterThen(49.8);
        assertArrayEquals(expValue, realValue, 0.00001);
    }
    @Test
    public void testTempSummaryStatistics() {
        double[] temperatureSeries = {-0.5, 0.5, 3.0, 8.7, 49.9, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

//        {-0.5, 0.5, 3.0, 8.7, 49.9, 100.0, -780.0}

        TempSummaryStatistics expValue = new TempSummaryStatistics(seriesAnalysis.average(), seriesAnalysis.deviation(),
                seriesAnalysis.min(), seriesAnalysis.max());

        TempSummaryStatistics realValue = seriesAnalysis.summaryStatistics();
//        assertEquals(expValue);
//        assertArrayEquals(expValue, realValue);
        assertEquals(expValue.getClass(), realValue.getClass());
    }


    @Test
    public void testTempSummaryStatisticsWithValues() {
        double[] temperatureSeries = {-0.5, 0.5, 3.0, 8.7, 49.9, 100.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

//        {-0.5, 0.5, 3.0, 8.7, 49.9, 100.0, -780.0}

        TempSummaryStatistics expValue = new TempSummaryStatistics(seriesAnalysis.average(), seriesAnalysis.deviation(),
                seriesAnalysis.min(), seriesAnalysis.max());

        TempSummaryStatistics realValue = seriesAnalysis.summaryStatistics();
        double[] arr1 = {expValue.avgTemp, expValue.devTemp, expValue.minTemp,
                expValue.maxTemp};
        double[] arr2 = {realValue.avgTemp, realValue.devTemp, realValue.minTemp,
                realValue.maxTemp};

        assertArrayEquals(arr1, arr2, 0.00001);

    }

    @Test
    public void testaddTemps() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
//        3.0, -5.0, 1.0, 5.0 , 4.5, 3.0 , -2.0
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 7;

        double actualResult = seriesAnalysis.addTemps(4.5, 3.0 , -2.0);

        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test
    public void testaddTempsWithEmptyArray() {
//        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        double expResult = 3;

        double actualResult = seriesAnalysis.addTemps(4.5, 3.0 , -2.0);

        assertEquals(expResult, actualResult, 0.00001);


    }




}
