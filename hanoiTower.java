import java.util.ArrayList;

public class hanoiTower {
    // public static void moveRing(ArrayList<Integer> from, ArrayList<Integer> buf, ArrayList<Integer> to,
    // int ring) {

    // }

    public static void main(String[] args) {
        int nDisks = 3;
        towerStep(nDisks, 'A', 'B', 'C');

    }
    
    public static void towerStep(int topN, char source, char destintaion, char buffer) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + source + " to " + destintaion);
            return;
        }     
        
        towerStep(topN - 1, source, buffer, destintaion);
        System.out.printf("Disk %s from %s to %s", topN, source, destintaion);
        System.out.println();
        towerStep(topN - 1, buffer, destintaion, source);
    }

    
}
