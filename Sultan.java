import java.util.ArrayList;
import java.util.Collections;

public class Sultan {
	public int max = 0;
	
	public Sultan(int k, int num){
		ArrayList<Integer> girls = new ArrayList<Integer>();
		for(int i=1; i<=num; i++)
		    girls.add(i);
		
		Collections.shuffle(girls);
		
		for(int i=0; i<k; i++)
			if(girls.get(i) > max){
				max = girls.get(i);
			}
		
		for(int i=k; i<girls.size(); i++){
			if(girls.get(i) > max){
				max = girls.get(i);
				break;
			}
			else if(i == girls.size()-1)
				max = girls.get(girls.size()-1);
		}
	}
		
	
	public static void main(String[] args) {
		double[] probs = new double[100];
		int[] count = new int[100];
		for(int i=1; i<count.length; i++){
			for(int j=0; j<200000; j++){
				Sultan s = new Sultan(i, 100);
				if(s.max == 100)
					count[i]++;
			}
		}
		
		for(int i=1; i<probs.length; i++){
			probs[i] = count[i]/200000.0;
			System.out.println("Probability of "+i+" is: "+probs[i]);
		}
	}
}
