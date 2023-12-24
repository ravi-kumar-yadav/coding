class Solution {
    public int romanToInt(String s) {
        HashMap <Character, Integer> hm = new HashMap<Character, Integer>();

        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int len = s.length();
        char curr_char;
        char next_char;
        int curr_val;
        int next_val;

        int result = 0;

        for(int i=0; i<len;){
            curr_char = s.charAt(i);

            if(i!=len-1){
                next_char = s.charAt(i+1);

                curr_val = hm.get(curr_char);
                next_val = hm.get(next_char);

                if (curr_val >= next_val){
                    result += curr_val;
                    i = i+1;
                } else {
                    result += (next_val - curr_val);
                    i = i+2;
                }
            } else {
                curr_val = hm.get(curr_char);
                result += curr_val;
                i = i+1;
            }
        }

        return result;
    }
}
