import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1); // Multiplicative identity
    }
    
    public void add(int num) {
        if (num == 0) {
            // Reset prefix products whenever 0 appears
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            int lastProduct = prefix.get(prefix.size() - 1);
            prefix.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefix.size();
        // If k reaches or passes the last reset (0), product is 0
        if (k >= size) {
            return 0;
        }
        return prefix.get(size - 1) / prefix.get(size - 1 - k);
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */