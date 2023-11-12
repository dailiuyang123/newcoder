package ClassicExam.dfs;

public class LC200_岛屿数量 {

    public int numIslands(char[][] grid) {
        //定义一个表示岛屿数量的变量
        int count = 0;
        //这个两层for循环是用来遍历整张二维表格中所有的陆地
        //其中 i 表示行，j 表示列
        for(int i = 0; i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                //取出所有的陆地
                if(grid[i][j] == '1'){
                    //深度递归，遍历所有的陆地
                    dfs(grid,i,j);
                    //用来统计有多少岛屿，岛屿是由多个陆地组成的，概念不一样
                    count++;
                }
            }
        }
        //返回岛屿的数量
        return count;
    }
    public void dfs(char[][] grid,int i, int j){
        //防止 i 和 j 越界，也就是防止超出岛屿（上下左右）的范围。特别注意当遍历到海洋的时候也退出循环
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') {
            return;
        }
        //将遍历过的陆地改为海洋，防止重复遍历
        grid[i][j]='0';
        //右
        dfs(grid,i,j+1);
        //左
        dfs(grid,i,j-1);
        //上，
        dfs(grid,i+1,j);
        //下
        dfs(grid,i-1,j);

    }



}
