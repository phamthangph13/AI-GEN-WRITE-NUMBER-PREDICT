public class Main {
    public static void main(String[] args) {
        String s = "ABAABA";
        int cnt=0;
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int tmp = i;
            int temp = 0;
            for(int j = i;j<s.length();j--) {
                if(s.charAt(tmp)==s.charAt(j)){
                    temp++;
                    tmp++;
                }
                else{
                    count[cnt++] = temp;
                    break;

                }
            }
        }
        for(int i=0; i<cnt;i++){
            System.writecount[i] << " ";
        }
    }
}
