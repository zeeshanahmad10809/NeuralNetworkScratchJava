package NeuralNet;

import java.util.concurrent.TransferQueue;

public class MainClassCharacters {

    public static int TRAINING_SAMPLES = 56;
    public static int EPOCHS = 3000;
    public static double LEARNING_RATE = 1E-4;
    public static int INPUT_NODES = 100;
    public static int OUTPUT_NODES = 14;

    public static void main(String[] args) {

        double[][][] input = new double[TRAINING_SAMPLES][1][INPUT_NODES];
        double[][][] output = new double[TRAINING_SAMPLES][1][OUTPUT_NODES];
        input = Datasets.loadCharacterData(TRAINING_SAMPLES, 100).get("X");
        output = Datasets.loadCharacterData(TRAINING_SAMPLES, 100).get("Y");

        //int size = input.length;

        Model model = new Model(200);//seed value will be used to generate random initial values of weights...
        model.Add(new Layer(INPUT_NODES));
        model.Add(new Layer(150));
        //model.Add(new Layer(150));
        model.Add(new Layer(OUTPUT_NODES));
        model.Train(input, output, LEARNING_RATE, EPOCHS);
        for(int i=0; i<input.length; i++){
            model.Test(input[i], output[i], i+1);
        }






    }


}
