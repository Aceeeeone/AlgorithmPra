package nql.graph;

/**
 * @author nql
 * @version 1.0
 * @date 2020/12/21 16:40
 */
public class hungarian {
    int[][] graph;
    int[] match;
    int len;
    boolean[] vis;

    public hungarian(int[][] graph) {
        this.graph = graph;
        this.len = graph.length;
        this.match = new int[len];
        this.vis = new boolean[len];

        for (int i = 0; i < len; i++) {
            match[i] = -1;
            vis[i] = false;
        }
    }

    boolean dfsfind(int p) {
        for (int i = 0; i < len; i++) {
            if (graph[p][i] == 1) {
                if (vis[i] == false) {
                    vis[i] = true;
                    if (match[i] == -1 || dfsfind(match[i])) {
                        match[p] = i;
                        match[i] = p;
                        System.out.println(p + "match" + i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void search() {
        for (int i = 0; i < len; i++) {
            if (match[i] == -1) {
                clearVis();
                System.out.println("开始顶点" + i + "的匹配");
                dfsfind(i);
            }
        }
        System.out.println();

        for (int i = 0; i < len; i++) {
            System.out.println(i + "------>" + match[i]);
        }
    }


    private void clearVis() {
        for (int i = 0; i < len; i++) {
            vis[i] = false;
        }
    }


    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0}};
        new hungarian(graph).search();
    }
}
