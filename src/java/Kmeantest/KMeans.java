package Kmeantest;

import java.io.Console;
import java.util.HashMap;

public class KMeans {

    public static double[] holdcentroid;

    static double k[][];

    public static double[][] getCentroid(double data[], int noofclusters, double centroid[][], HashMap<Integer, Double> hashTableObj) {
        k = new double[noofclusters][data.length];
        double distance[][] = new double[noofclusters][data.length];
        double cluster[] = new double[data.length];
        double clusternodecount[] = new double[noofclusters];

        centroid[0] = centroid[1];
        centroid[1] = new double[]{0, 0, 0, 0};
        System.out.println("========== Starting to get new centroid =========");

        for (int i = 0; i < noofclusters; i++) {
            for (int j = 0; j < data.length; j++) {
                //System.out.println(distance[i][j]+"("+i+","+j+")="+data[j]+"("+j+")-"+centroid[0][i]+"="+(data[j]-centroid[0][i]));
                distance[i][j] = Math.abs(data[j] - centroid[0][i]);
                System.out.print(distance[i][j] + " ,");
                //System.out.println("Centroid: "+centroid[0][i]);
            }
            System.out.println();
        }

        for (int j = 0; j < data.length; j++) {
            double smallerDistance = 0;
            if (distance[0][j] < distance[1][j] && distance[0][j] < distance[2][j] && distance[0][j] < distance[3][j]) {
                smallerDistance = 0;
            }
            if (distance[1][j] < distance[0][j] && distance[1][j] < distance[2][j] && distance[1][j] < distance[3][j]) {
                smallerDistance = 1;
            }
            if (distance[2][j] < distance[0][j] && distance[2][j] < distance[1][j] && distance[2][j] < distance[3][j]) {
                smallerDistance = 2;
            }
            if (distance[3][j] < distance[0][j] && distance[3][j] < distance[1][j] && distance[3][j] < distance[2][j]) {
                smallerDistance = 3;
            }
//            if (distance[4][(int) j] < distance[0][(int) j] && distance[4][(int) j] < distance[1][(int) j] && distance[4][(int) j] < distance[2][(int) j] && distance[4][(int) j] < distance[3][(int) j]) {
//                smallerDistance = 4;//
//            }
            centroid[1][(int) smallerDistance] = centroid[1][(int) smallerDistance] + data[j];
            clusternodecount[(int) smallerDistance] = clusternodecount[(int) smallerDistance] + 1;
            cluster[j] = smallerDistance;
            //System.out.println("Centerid at 1:  "+centroid[1][smallerDistance]);
            //System.out.print(cluster[j]+", ");
        }
        //for(double j=0;j<data.length;j++)
        //System.out.println("c at out: "+cluster[j]);

        System.out.println("======================================== ");

        System.out.println("New clusters are ");
        // cluster[]= { 0  1   0  1  0  2  2  1}
        // data[]={2,4,-10,12,3,20,30,11};
        for (int i = 0; i < noofclusters; i++) {
            System.out.print("C" + (i + 1) + ": ");
            for (int l = 0; l < data.length; l++) {
                if (cluster[l] == i) {
                    System.out.print(data[l] + " ,");
                }

            }
            System.out.println();
        }
        System.out.println("======================================== ");

        System.out.println("New centroid is ");

        for (int j = 0; j < noofclusters; j++) {
            centroid[1][j] = centroid[1][j] / clusternodecount[j];
            System.out.print(centroid[1][j] + ",");
        }
        System.out.println();

        boolean isAchived = true;
        holdcentroid = new double[noofclusters];
        for (int j = 0; j < noofclusters; j++) {

            if (isAchived && centroid[0][j] == centroid[1][j]) {
                holdcentroid[j] = centroid[0][j];
                isAchived = true;
                continue;
            }
            isAchived = false;
        }

        if (!isAchived) {

            getCentroid(data, noofclusters, centroid, hashTableObj);
        }

        if (isAchived) {
            System.out.println("======================================== ");
            System.out.println(" Final Cluster is ");
            for (int i = 0; i < noofclusters; i++) {

                int c = 0;
                System.out.print("C" + (i + 1) + ":");
                for (int j = 0; j < data.length; j++) {
                    if (cluster[j] == i) {

                        k[i][c++] = (int) hashTableObj.keySet().toArray()[j];

                        System.out.print(hashTableObj.keySet().toArray()[j] + ",");

                    }

                }

                System.out.println("");
            }

        }

        return k;

    }

}
