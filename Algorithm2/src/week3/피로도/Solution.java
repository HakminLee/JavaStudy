package week3.피로도;

public class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons){
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(k, visited, n,dungeons,0);
        return answer;
    }
    //
    public void backtrack(int cur_k, boolean[] visited, int n, int[][] dungeons,int cnt){
        //basacase
        if(cnt > answer){
            answer = cnt;
        }

        //recursive call
        for(int i=0; i<n; i++) {
            if(cur_k >= dungeons[i][0] && !visited[i]){
                visited[i] = true; //넣기
                backtrack(cur_k,visited, n,dungeons,cnt+1);
                visited[i] = false;

            }
        }
    }

    public static void main(String[] args) {
        }
    }

