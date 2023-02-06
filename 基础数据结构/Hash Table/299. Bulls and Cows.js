/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
var getHint = function (secret, guess) {
  let bulls = 0,
    cows = 0;
  let secretMap = new Map(),
    guessMap = new Map();
  for (let i = 0; i < secret.length; i++) {
    if (secret[i] === guess[i]) {
      bulls++;
    } else {
      secretMap.set(secret[i], secretMap.get(secret[i]) + 1 || 1);
      guessMap.set(guess[i], guessMap.get(guess[i]) + 1 || 1);
    }
  }
  for (let key of guessMap.keys()) {
    if (secretMap.has(key)) {
      cows += Math.min(secretMap.get(key), guessMap.get(key));
    }
  }
  return `${bulls}A${cows}B`;
};
