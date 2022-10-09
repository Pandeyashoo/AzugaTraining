import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.BufferedReader;
import org.apache.log4j.Logger;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class linechart extends JFrame {
    public static List<String> lines = new ArrayList<String>();
    public static List<String> title = new ArrayList<String>();
    public static List<Integer> price = new ArrayList<Integer>();
    public static final Logger logger=Logger.getLogger(linechart.class);

    private static final long serialVersionUID = 1L;

    public linechart(String title) {
        super(title);
        logger.info("In linechart constructor");
        // Create dataset
        DefaultCategoryDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Score of team", // Chart title
                "City", // X-Axis Label
                "Score", // Y-Axis Label
                dataset
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultCategoryDataset createDataset() {
        logger.info("In create dataset");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 10; i < 20; i++) {
            dataset.addValue(price.get(i), " ", title.get(i));
        }
        return dataset;


    }

    public static void main(String[] args) {
        String[] data;
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/azuga/desktop/basket.csv"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
              //  System.out.println(currentLine);
            }
        } catch (IOException e) {
            logger.error("Error "+ e.getMessage());
            e.printStackTrace();
        }
        if(lines.size()<30)
            logger.warn("Too less data");
        for (int i = 1; i < lines.size(); i++) {
                data = lines.get(i).split(",");
                //   System.out.println(lines.get(i));
                //   System.out.println(data[4] + "," + data[9]);
                // Integer rn = Integer.parseInt(data[8].replaceAll(" ",""));
                Integer pr = Integer.parseInt(data[9].replaceAll(" ", ""));
                title.add(data[4]);
                price.add(pr);
            }
        linechart chart = new linechart("Score of Each team");
        chart.pack();
        // RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible(true);
    }
}