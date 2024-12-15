/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cancerdetection;

import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author User
 */
public class CancerDetection {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        try {
            // Load dataset
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("C:\\Project\\ergophile\\DataSets for ML\\cancer_risk.arff"); 
            Instances dataset = source.getDataSet();

            // Set the class index (target variable)
            if (dataset.classIndex() == -1) {
                dataset.setClassIndex(dataset.numAttributes() - 1); // Last column as target
            }

            // Create and configure the classifier (Decision Tree)
            Classifier classifier = new J48(); // Weka's J48 decision tree
            classifier.buildClassifier(dataset);

            // Perform evaluation
            Evaluation eval = new Evaluation(dataset);
            eval.crossValidateModel(classifier, dataset, 10, new Random(1)); // 10-fold cross-validation

            // Output evaluation metrics
            System.out.println("=== Evaluation Summary ===");
            System.out.println(eval.toSummaryString());
            System.out.println("=== Confusion Matrix ===");
            System.out.println(eval.toMatrixString());
            System.out.println("=== Classifier Model ===");
            System.out.println(classifier);

            // Use the trained model for prediction
            // Predict for a new sample location
            // Create an instance with values: location_id, latitude, longitude, traffic_volume, weather
            Instance newInstance = new Instance(9); // attributes
            newInstance.setDataset(dataset); // Attach to dataset to inherit attribute structure
            newInstance.setValue(0, 101); 
            newInstance.setValue(1, 27);
            newInstance.setValue(2, "male"); 
            newInstance.setValue(3, "no"); 
            newInstance.setValue(4, "none");
            newInstance.setValue(5, "no");
            newInstance.setValue(6, "healthy");
            newInstance.setValue(7, "moderate");
            newInstance.setValue(8, "low");
            

            // Get class probabilities
            double[] probabilities = classifier.distributionForInstance(newInstance);

            // Print class probabilities
            System.out.println("=== Predicted Probabilities for Classes ===");
            for (int i = 0; i < probabilities.length; i++) {
                System.out.println(dataset.classAttribute().value(i) + ": " + probabilities[i]);
            }

            // Output the most likely class
            int predictedClassIndex = (int) classifier.classifyInstance(newInstance);
            String predictedClass = dataset.classAttribute().value(predictedClassIndex);
            System.out.println("Predicted Class: " + predictedClass);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
