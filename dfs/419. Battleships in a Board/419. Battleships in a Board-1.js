/**
 * @param {character[][]} board
 * @return {number}
 */
var countBattleships = function(board) {
    let count = 0;
    for(let i = 0; i < board.length; i++) {
        for(let j = 0; j < board[0].length; j++) {
            if(board[i][j] === "X") {
                count++;
                dfs(board, i,j);
            }
        }
    }
    return count;
};

let dfs = (board, r, c) => {
    if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] === ".") {
        return;
    }
    board[r][c] = ".";
    dfs(board, r+1, c);
    dfs(board, r-1, c);
    dfs(board, r, c+1);
    dfs(board, r, c-1);
};