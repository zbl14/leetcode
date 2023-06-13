/**
 * @param {number[][]} heights
 * @return {number[][]}
 */
var pacificAtlantic = function(heights) {
    let res = [];
    
    //set matrix, set all false
    const pacific = Array(heights.length).fill().map(() => Array(heights[0].length).fill(false));
    const atlantic = Array(heights.length).fill().map(() => Array(heights[0].length).fill(false));
    
    // start from left and right
    for(let row = 0; row < heights.length; row++) {
        dfs(row, 0, -Infinity, pacific);
        dfs(row, heights[0].length - 1, -Infinity, atlantic);
    }
    
    // start from top and bottom
    for(let col = 0; col < heights[0].length; col++) {
        dfs(0, col, -Infinity, pacific);
        dfs(heights.length - 1, col, -Infinity, atlantic);
    }
    
    for(let i = 0; i < heights.length; i++){
        for(let j = 0; j < heights[0].length; j++) {
            if(pacific[i][j] && atlantic[i][j]) {
                res.push([i, j]);
            }
        }
    }
    return res;

    function dfs (row, col, prev, ocean) {
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || heights[row][col] < prev || ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        dfs(row+1, col, heights[row][col], ocean);
        dfs(row-1, col, heights[row][col], ocean);
        dfs(row, col+1, heights[row][col], ocean);
        dfs(row, col-1, heights[row][col], ocean);
    }
};