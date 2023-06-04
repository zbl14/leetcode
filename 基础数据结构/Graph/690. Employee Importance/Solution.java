/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// bfs
// class Solution {
//     public int getImportance(List<Employee> employees, int id) {
//         Map<Integer, Pair<Integer, List<Integer>>> adj = new HashMap<>();
//         for(int i = 0; i < employees.size(); i++){
//             adj.put(employees.get(i).id, new Pair<>(employees.get(i).importance, employees.get(i).subordinates));
//         }
//         int res = 0;
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(id);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 int cur = q.poll();
//                 res += adj.get(cur).getKey();
//                 for(int sub : adj.get(cur).getValue()){
//                     q.offer(sub);
//                 }
//             }
//         }
//         return res;
//     }
// }

// bfs, imporve map structure
// class Solution {
//     public int getImportance(List<Employee> employees, int id) {
//         Map<Integer, Employee> map = new HashMap<>();
//         for(Employee e : employees){
//             map.put(e.id, e);
//         }
//         int res = 0;
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(id);
//         while(!q.isEmpty()){
//             int curId = q.poll();
//             Employee curEmployee = map.get(curId);
//             res += curEmployee.importance;
//             for(int sub : curEmployee.subordinates){
//                 q.offer(sub);
//             }
//         }
//         return res;
//     }
// }

// dfs
class Solution {
  Map<Integer, Employee> emap;

  public int getImportance(List<Employee> employees, int queryid) {
    emap = new HashMap();
    for (Employee e : employees)
      emap.put(e.id, e);
    return dfs(queryid);
  }

  public int dfs(int eid) {
    Employee employee = emap.get(eid);
    int ans = employee.importance;
    for (Integer subid : employee.subordinates)
      ans += dfs(subid);
    return ans;
  }
}