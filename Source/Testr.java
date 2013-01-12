import java.util.*;

public class Testr
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean done = false;
        ArrayList<String> entries = new ArrayList<String>();
        System.out.println("Input student names one at a time (with a new line inbetween), or press Q to finish");
        while(!done){
            String entry = in.nextLine();
            if(entry.equalsIgnoreCase("Q")){
                done = true;
            }else{
                entries.add(entry);
            }
        }
        String[] students = new String[entries.size()];
        for(int i=0; i<entries.size(); i++){
            students[i] = entries.get(i);
        }
        MakePairs creator = new MakePairs(students);
        Pair[][] pairs;
        //while(!done){
        try{
            creator.makeList(0);
            pairs = creator.getPairs();
            done = true;
        }catch(Exception e){
            pairs = new Pair[1][1];
        }
        //}
        for(Pair[] p : pairs){
            for(Pair pair : p){
                System.out.println(pair);
            }
            System.out.println("----");
        }
    }
}
