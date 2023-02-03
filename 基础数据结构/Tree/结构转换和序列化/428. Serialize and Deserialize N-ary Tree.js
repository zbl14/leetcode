/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

class Codec {
  constructor() {}

  /**
   * @param {Node|null} root
   * @return {string}
   */
  // Encodes a tree to a single string.
  serialize = function (root) {
    let res = new Array();
    this.dfsSerialize(root, res);
    return res.join(",");
  };

  dfsSerialize = function (root, array) {
    if (root === null) return;
    array.push(root.val);
    array.push(root.children.length);
    for (const child of root.children) this.dfsSerialize(child, array);
  };

  /**
   * @param {string} data
   * @return {Node|null}
   */
  // Decodes your encoded data to tree.
  deserialize = function (data) {
    if (data === "") return null;
    let q = data.split(",");
    return this.dfsDeserialize(q);
  };

  dfsDeserialize = function (q) {
    const root = new Node(parseInt(q.shift()), new Array());
    const size = parseInt(q.shift());
    for (let i = 0; i < size; i++) {
      root.children.push(this.dfsDeserialize(q));
    }
    return root;
  };
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
