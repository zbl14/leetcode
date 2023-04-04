function letterCombinations(digits: string): string[] {
  const button: { [key: string]: string } = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "pqrs",
    "8": "tuv",
    "9": "wxyz",
  };
  const res: string[] = [];
  if (digits === "") return res;

  const backtracking = function (curStr: string, index: number) {
    if (curStr.length === digits.length) {
      res.push(curStr);
      return;
    }
    const curLetters = button[digits[index]];
    for (let i = 0; i < curLetters.length; i++) {
      backtracking(curStr + curLetters[i], index + 1);
    }
  };

  backtracking("", 0);
  return res;
}
