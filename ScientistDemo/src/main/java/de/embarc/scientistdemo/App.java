package de.embarc.scientistdemo;

import com.github.rawls238.scientist4j.*;

import io.dropwizard.metrics5.ConsoleReporter;
import io.dropwizard.metrics5.MetricRegistry;

import java.util.function.Supplier;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{        
    public static void main( String[] args )
    {
        System.out.println("Starting Scientist Demo!" );

        // Setup Scientist Experiment
        Experiment<Integer> experiment = new Experiment<Integer>("ComplicatedCalculation", true);

        // Instatiate dummy calculation classes for comparison
        ComplicatedCalculation calc = new ComplicatedCalculation();
        ComplicatedCalculationV2 calcV2 = new ComplicatedCalculationV2();

        // Setup reporting for some basic metrics
        MetricRegistry metricRegistry = experiment.getMetrics(null);
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
            .convertRatesTo(TimeUnit.MILLISECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();

        reporter.start(2, TimeUnit.SECONDS);;

        for (Integer i = 0; i < 10; i++)
        {
            Integer randomInput = new Random().nextInt(4);

            Supplier<Integer> calcCodePath = () -> calc.getResult(randomInput);
            Supplier<Integer> calcV2CodePath = () -> calcV2.getResult(randomInput);

            try {
                Integer experimentResult = experiment.runAsync(calcCodePath, calcV2CodePath);
                System.out.println("Random num is: " + randomInput + " Result: " + experimentResult);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        reporter.stop();
        reporter.report();
    
    }
}
