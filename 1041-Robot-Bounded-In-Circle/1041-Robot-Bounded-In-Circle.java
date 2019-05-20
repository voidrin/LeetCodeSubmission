class Solution {
    
    public int returnDirection(int curV, char c) {
        // north 1
        // east 2
        // south 3
        // west 4
        int nextV = curV;
        switch(c) {
            case 'L': {
                nextV = (curV == 1) ? 4 : (curV - 1);
                break;
            }
            case 'R': {
                nextV = (curV == 4) ? 1 : (curV + 1);
                break;
            }
            default: {
                break;
            }
        }
        return nextV;
    }
    
    public int[] nextPoint(int curV, int[] curP) {
        int nextP[] = new int[2];
        nextP = curP;
        switch(curV) {
            case 1: {
                nextP[1] += 1;
                break;
            }
            case 2: {
                nextP[0] += 1;
                break;    
            }
            case 3: {
                nextP[1] -= 1;
                break;
            }
            case 4: {
                nextP[0] -= 1;
                break;
            }
            default: {
                break;
            }
        }
        return nextP;
    }
    
    public boolean isRobotBounded(String instructions) {
        int currentV = 1;
        int currentP[] = {0, 0}; 
        char next;
        
        for(int i = 0; i < instructions.length() ; ++i) {
            next = instructions.charAt(i);
            currentV = returnDirection(currentV, next);
            if (next == 'G') {
                currentP = nextPoint(currentV, currentP);
            }
        }
        return (currentV != 1) || (currentP[0] == 0 && currentP[1] == 0);
    }
}