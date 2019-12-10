
package linearnn;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author metinozkan
 */
public class LinearNN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
         NeuralN ysa=new NeuralN();
         Scanner in =new Scanner (System.in);
         int select=0;
         
         do{
             System.out.println("1-Training network");
             System.out.println("2-Testing network");
             System.out.println("3-Exit");
             
             select=in.nextInt();
             
             switch(select){
                 case 1:ysa.Training();
                 System.out.println("Training");
                 break;
                 
                 case 2:
                     System.out.println("x:");
                     double x=in.nextDouble();
                     System.out.println("y:");
                     double y=in.nextDouble();
                     double []z=ysa.Test(x, y);
                     System.out.println("z:"+z[0]);
                     System.in.read();
                     break;
             }
         }while(select!=3);
    }
    }
    
