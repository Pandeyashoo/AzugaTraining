import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
public class barchart extends JFrame {
    private static final long serialVersionUID = 1L;

    public static List<String> lines = new ArrayList<String>();
    public static List<String> title = new ArrayList<String>();
    public static List<Integer> price = new ArrayList<Integer>();
    public static final Logger logger=Logger.getLogger(barchart.class);

    public barchart(String title) {
        super(title);
        logger.info("In barchart constructor");
        // Create dataset
        CategoryDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Score of teams", //Chart Title
                "team", // Category axis
                "score", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public CategoryDataset createDataset() {
        logger.info("In createDateset");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 10; i++) {
            dataset.addValue(price.get(i),title.get(i),"");
        }
        return dataset;
    }

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        String[] data;
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/azuga/desktop/basket.csv"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
               // System.out.println(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error " +e.getMessage());
        }
        if(lines.size()<25){
            logger.warn("more size");
        }
            for (int i = 1; i < lines.size(); i++) {
                data = lines.get(i).split(",");
              //  System.out.println(lines.get(i));
             //   System.out.println(data[4] + "," + data[9]);
                Integer pr = Integer.parseInt(data[9].replaceAll(" ", ""));
                title.add(data[4]);
                price.add(pr);
            }

        barchart chart = new barchart("Bar chart");
        chart.pack();
        chart.setVisible(true);
    }
}
