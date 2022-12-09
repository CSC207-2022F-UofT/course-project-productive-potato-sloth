package screens.Calculator;

import entities.User;
import services.CurrentUserService;
import useCases.Calculator.HistogramPanel;
import useCases.Calculator.TotCalculator;

import java.awt.*;

import static useCases.Calculator.HistogramPanel.createAndShowGUI;

public class OutPutHistogram {
    public OutPutHistogram(){}
    public void produce_graph() {
        String unit = "day";
        CurrentUserService service = new CurrentUserService();

        HistogramPanel histogram = new HistogramPanel();

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI(1, 5, 10, 21, 4, 6, 10);
            }
        });

    }}

