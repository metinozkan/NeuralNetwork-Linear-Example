
package linearnn;

import java.io.File;

/**
 * @author metinozkan
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.Perceptron;

/**
 *
 * @author metinozkan
 */
public class NeuralN {
  
    private static final File file = new File("Data.txt");
    
    public void Training() throws FileNotFoundException{
        NeuralNetwork neuralN=new Perceptron (2,1);
        neuralN.learn(eDataSet());
        neuralN.save("trainedN.nnet");
        System.out.println("training completed");
    }
    


     public DataSet eDataSet() throws FileNotFoundException{
    
            
            Scanner read =new Scanner (file);
            DataSet training =new DataSet(2,1);
            while (read.hasNextDouble()){
                DataSetRow row =new DataSetRow(new double []{read.nextDouble(),read.nextDouble()},new double [] {read.nextDouble()});
                training.add(row);
            }
            read.close();
            return training;
    
        }
     
     
     public double[] Test (double x,double y){
         
         NeuralNetwork neuralN=NeuralNetwork.createFromFile("trainedN.nnet");
         neuralN.setInput(x,y);
         neuralN.calculate();
         return neuralN.getOutput();
     }
    
}

