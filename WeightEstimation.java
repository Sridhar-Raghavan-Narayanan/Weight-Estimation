package Basic_Java;
import java.util.*;

public class WeightEstimation {
		public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
			//constants declarations
			double payloadWeight =160.0, crewWeight =160.0, fuelToWeightRatio =0.15, emptyRatioNoPowPlt =0,
					emptyRatioWithPowPlt =0.63,  powToWeightRatio =0.1875, powerPltWeight =0,
					fuelWeight =0, RelDen=0.588, SFC, overallWeight, power;

			int i = 1;
			int size=1;
			char ch='y';
			double[] TotWeight =new double[size];
			
			while(ch=='y') {//loop for continuation user choice
				while(i>0) {//iterative loop
					if(i!=1) {
						//overall weight calculations
						overallWeight =(payloadWeight + crewWeight + fuelWeight + powerPltWeight)/(1- emptyRatioNoPowPlt);
						System.out.println("Overall Weight in"+i+"Iteration: "+ overallWeight);
						//power calculation
						TotWeight=instAtLast(TotWeight, overallWeight);
						power= powToWeightRatio * overallWeight *1.2;
						System.out.println("Approx. Power: "+power+" hp");
						//getting user inputs
						System.out.println("Enter the new power plant weight in kg:");
						powerPltWeight =scan.nextDouble();
						System.out.println("Enter the Correct engine power in hp:");
						power=scan.nextDouble();
						System.out.println("Enter the new SFC in lb/hp-hr:");
						SFC=scan.nextDouble();
						//fuel weight and ratio calculations
						fuelWeight =((power*Math.pow(RelDen, 1.2)*1500*SFC*1.2)/260)*0.454;
						System.out.println("Fuel Weight: "+ fuelWeight);
						fuelToWeightRatio = fuelWeight / overallWeight;
						emptyRatioNoPowPlt = emptyRatioWithPowPlt -(powerPltWeight / overallWeight);
						System.out.println("Fuel Ratio: "+ fuelToWeightRatio +
								"\nEmpty Weight Ratio (Without power plant): "+ emptyRatioNoPowPlt);

						i++;
						System.out.println("Do you wanna continue...press y...");
						ch=scan.next().charAt(0);

					} else {
						//overall weight calculations
						overallWeight =(payloadWeight + crewWeight)/(1- emptyRatioWithPowPlt - fuelToWeightRatio);
						System.out.println("Overall weight:"+ overallWeight +" kg");
						//power calculation
						TotWeight=instAtLast(TotWeight, overallWeight);
						power= powToWeightRatio * overallWeight *1.2;
						System.out.println("Approx. Power: "+power+" hp");
						//getting user inputs
						System.out.println("Enter the new power plant weight in kg:");
						powerPltWeight =scan.nextDouble();
						System.out.println("Enter the Correct engine power in hp:");
						power=scan.nextDouble();
						System.out.println("Enter the new SFC in lb/hp-hr:");
						SFC=scan.nextDouble();
						//fuel weight and ratio calculations
						fuelWeight =((power*Math.pow(RelDen, 1.2)*1500*SFC*1.2)/260)*0.454;
						System.out.println("Fuel Weight: "+ fuelWeight);
						fuelToWeightRatio = fuelWeight / overallWeight;
						emptyRatioNoPowPlt = emptyRatioWithPowPlt -(powerPltWeight / overallWeight);
						System.out.println("Fuel Ratio: "+ fuelToWeightRatio +
								"\nEmpty Weight Ratio (Without power plant): "+ emptyRatioNoPowPlt);

						i++;
					}
				}
			}
			scan.close();
			int size1=TotWeight.length;
			for(int x=0;x<size1;x++) {
				System.out.println("Iteration number:"+(x+1)+"Overall Weight: "+TotWeight[x]);

			}
		}
		public static double[] instAtLast(double[] arr, double val) {
			int size=arr.length;
			size++;
			double[] arr1;
			arr1= Arrays.copyOf(arr, size);
			arr1[size-1]=val;
			return arr1;
		}
	}

