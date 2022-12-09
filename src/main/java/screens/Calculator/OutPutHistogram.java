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
        User user = service.getCurrentUser();
        TotCalculator calc = new TotCalculator();
        int monday = calc.rawTime(user, unit);
        int tuseday = calc.rawTime(user, unit);
        int wednesday = calc.rawTime(user, unit);
        int thursday = calc.rawTime(user, unit);
        int friday = calc.rawTime(user, unit);
        int saturday = calc.rawTime(user, unit);
        int sunday = calc.rawTime(user, unit);
        HistogramPanel histogram = new HistogramPanel();
//            EventQueue.invokeLater(new Runnable()
//            {
//                public void run()
//                {
//                    createAndShowGUI(monday, tuseday, wednesday, thursday, friday, saturday, sunday);
//                }
//            });
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI(1, 5, 10, 21, 4, 6, 10);
            }
        });

    }}

