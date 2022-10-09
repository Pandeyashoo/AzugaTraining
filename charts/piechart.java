import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import org.json.*;
import java.util.ArrayList;
import java.lang.String;
import org.apache.log4j.Logger;
public class piechart extends JFrame{

    public static List<String> lines = new ArrayList<String>();
    public static List<String> home_team = new ArrayList<String>();
    public static List<Integer> score = new ArrayList<Integer>();
    public static final Logger logger=Logger.getLogger(piechart.class);
    public piechart (String title){
        super(title);
        logger.info("In piechart constructor");
        // Create dataset
        PieDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createPieChart(
                "Basketball ",
                dataset,
                true,
                true,
                false);
        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                " {0} score : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
    public PieDataset createDataset() {
        DefaultPieDataset dataset=new DefaultPieDataset();
        for(int i=0;i<10;i++) {
            dataset.setValue(home_team.get(i),score.get(i));
        }
        return dataset;
    }
    public static void main(String[] args)  throws IOException, InterruptedException, JSONException{

        SwingUtilities.invokeLater(() -> {
            piechart example = new piechart("Pie Chart");

            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });


        String[] data;
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/azuga/desktop/basket.csv"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error "+e.getMessage());
        }
        if(lines.size()>25){
            logger.warn("you are entering too much data");
        }
        for (int i = 1; i < lines.size(); i++) {
            data = lines.get(i).split(",");
            int pr = Integer.parseInt(data[9].replaceAll(" ",""));
            score.add(pr);
            home_team.add(data[4]);
        }
    }
}
