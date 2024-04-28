import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RingsAndRods {
    public static int countPoints(String rings) {
        HashMap<Integer, Set<Character>> temp = new HashMap<>();
        int out = 0;

        for(int i=0; i<rings.length(); i=i+2){
            int index = Character.getNumericValue(rings.charAt(i+1));
            char ch = rings.charAt(i);
            Set<Character> colors = new HashSet<>();
            if(temp.containsKey(index)){
                colors = temp.get(index);
                if (colors.size()==3){
                    continue;
                }
                colors.add(ch);
                if(colors.size()==3){
                    out++;
                }
            }else{
                colors.add(ch);
                temp.put(index, colors);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(countPoints("B0R0G0R9R0B0G0"));
    }
}
