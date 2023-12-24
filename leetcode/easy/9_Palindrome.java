class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        } else if (x < 0) {
            return false;
        } else {
            int old_num = x;
            int rev_num = 0;

            while (old_num>0){
                rev_num = (rev_num * 10) + (old_num%10);
                old_num /= 10;
            }

            if (rev_num == x){
                return true;
            } else {
                return false;
            }
        }
    }
}
