package algorithms;

import java.util.ArrayList;

public class RecursiveImpl extends EditDistanceAlgorithm {

    public int solve(String initial, String target) {
        return solveRecursive(initial,target,initial.length()-1,target.length()-1);
    }
    
    public int solveRecursive(String initial, String target, int inIndex, int tarIndex) {
    	if(inIndex ==-1) {
    		return tarIndex+1;
    	}
    	if(tarIndex ==-1) {
    		return inIndex+1;
    	}
    	int replaceCount = 0;
    	if(initial.charAt(inIndex)==target.charAt(tarIndex)) {
    		return solveRecursive(initial,target,inIndex-1,tarIndex-1);
    	} else {
    		replaceCount = 1;   		
    	}
    	return Math.min(Math.min(solveRecursive(initial,target,inIndex,tarIndex-1)+1,solveRecursive(initial,target,inIndex-1,tarIndex)+1),solveRecursive(initial,target,inIndex-1,tarIndex-1)+replaceCount);
    }
}
