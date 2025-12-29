package amazon;
import java.util.*;

class OrderProcessing {

  public static int minDeliveryTime(int n, List<Integer> orderCityList) {
    int m = orderCityList.size();
    int[] count = new int[n + 1];

    // Count orders for each city
    for (int city : orderCityList) {
      count[city]++;
    }

    int left = (int) Math.ceil((double) m / n); // minimum days possible
    int right = 2 * m; // worst case: every order takes 2 days
    int ans = right;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (canDeliver(mid, count, n)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  private static boolean canDeliver(int days, int[] count, int n) {
    long spareCapacity = 0;

    for (int c = 1; c < count.length; c++) {
      int orders = count[c];
      if (orders > days) {
        // Extra orders must go to other centers (2 days each)
        int extra = orders - days;
        spareCapacity -= extra;
      } else {
        // This center has spare slots
        spareCapacity += (days - orders) / 2;
      }
    }

    return spareCapacity >= 0;
  }

  public static void main(String[] args) {
    int n = 3;
    List<Integer> orderCityList = Arrays.asList(1, 1, 3, 1, 1);
    System.out.println(minDeliveryTime(n, orderCityList));
  }
}
