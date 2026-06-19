/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer,Employee> map=new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        return dfs(id);
    }

    int dfs(int id){
        Employee emp=map.get(id);
        int total=emp.importance ;
        for(int subordinate:emp.subordinates){
            total+=dfs(subordinate);
        }
        return total;
    }
}