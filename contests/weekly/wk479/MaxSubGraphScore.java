import java.util.ArrayList;
import java.util.List;

public class MaxSubGraphScore {
     List<List<Integer>> list;
    int n;
    int[] scoresOfIndividualNodes;
    int[] maxScoreFromSubtree;
    int[] finalAnswers;

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        this.n = n;
        this.list = new ArrayList<>();
        this.maxScoreFromSubtree = new int[n];
        this.finalAnswers = new int[n];
        this.scoresOfIndividualNodes = new int[n];

        for (int i = 0; i < n; i++) {
            scoresOfIndividualNodes[i] = (good[i] == 1) ? 1 : -1;
        }

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int nodeU = edge[0]; // Access the first element
            int nodeV = edge[1]; // Access the second element
            list.get(nodeU).add(nodeV);
            list.get(nodeV).add(nodeU);
        }
        calculateDownwardScores(0, -1);
        calculateUpwardScores(0, -1, 0);

        return finalAnswers;
    }

    private void calculateDownwardScores(int current, int parent) {
        int bestPathSoFar = scoresOfIndividualNodes[current];

        for (int neighbor : list.get(current)) {
            if (neighbor != parent) {
                calculateDownwardScores(neighbor, current);
                if (maxScoreFromSubtree[neighbor] > 0) {
                    bestPathSoFar += maxScoreFromSubtree[neighbor];
                }
            }
        }
        maxScoreFromSubtree[current] = bestPathSoFar;
    }

    private void calculateUpwardScores(int current, int parent, int scoreFromParentSide) {
        int totalScoreForCurrent = maxScoreFromSubtree[current];
        if (scoreFromParentSide > 0) {
            totalScoreForCurrent += scoreFromParentSide;
        }
        finalAnswers[current] = totalScoreForCurrent;

        for (int neighbor : list.get(current)) {
            if (neighbor != parent) {
                int contributionOfNeighborBranch = (maxScoreFromSubtree[neighbor] > 0) ? maxScoreFromSubtree[neighbor] : 0;
                int scoreExcludingNeighborBranch = totalScoreForCurrent - contributionOfNeighborBranch;
                calculateUpwardScores(neighbor, current, scoreExcludingNeighborBranch);
            }
        }
    }
}
