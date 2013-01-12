import java.util.*;

public class MakePairs
{
    private Pair[][] pairs;
    private String[] students;
    private ArrayList<Pair> firstPossible;
    private ArrayList<Pair> possible;
    public MakePairs(String[] studentsFirst)
    {
        int len = studentsFirst.length/2;
        if(len*2!=studentsFirst.length) students = new String[studentsFirst.length+1];
        else students = new String[studentsFirst.length];
        for(int ind = 0; ind<studentsFirst.length; ind++){
            students[ind] = studentsFirst[ind];
        }
        if(len*2!=studentsFirst.length){
            students[students.length-1] = "none";
        }
        pairs = new Pair[students.length-1][students.length/2];
        for(String s : students) System.out.println("student: " + s);
        firstPossible = new ArrayList<Pair>();
        for(int k=0; k<students.length; k++){
            for(int j=0; j<=k; j++){
                if(k!=j){
                    firstPossible.add(new Pair(students[k], students[j]));
                }
            }
        }
        /*for(Pair pr : firstPossible){
            System.out.println(pr);
        }*/
    }
    public Pair[][] getPairs(){
        return pairs;
    }
    public void makeList(int i) throws Exception{
        Random g = new Random();
        possible = new ArrayList<Pair>();
        possible.addAll(firstPossible);
        try{
            for(int h=0; h<students.length/2; h++){
                boolean worked = false;
                while(!worked){
                    //System.out.println("----");
                    worked = true;
                    int index;
                    if(possible.size()!=0){
                        index = g.nextInt(possible.size());
                    }else{
                        index = 0;
                    }
                    //System.out.println("index: " + index);
                    for(int l=0; l<h; l++){
                        if(pairs[i][l].equals(possible.get(index))){
                            //System.out.println("failure");
                            worked = false;
                        }
                    }
                    if(!worked){
                        //System.out.println("false");
                        possible.remove(index);
                        continue;
                    }
                    //System.out.println("true");
                    pairs[i][h] = possible.get(index);
                    //System.out.println("index: " + index);
                    possible.remove(index);
                    firstPossible.remove(pairs[i][h]);
                    //System.out.println("pair: " + pairs[i][h]);
                    for(Pair pr : firstPossible){
                        //System.out.println("left: " + pr);
                    }
                }
            }
            //System.out.println("success: " + i);
            if(i<students.length-2){
                makeList(i+1);
            }
        }catch(Exception e){
            //System.out.println("failed: " + i);
            if(i>0){
                for(Pair p : pairs[i]){
                    if(p!=null){
                        //System.out.println("p: " + p);
                        firstPossible.add(p);
                    }
                }
                for(Pair p : pairs[i-1]){
                    if(p!=null){
                        //System.out.println("p: " + p);
                        firstPossible.add(p);
                    }
                }
                pairs[i] = new Pair[students.length/2];
                makeList(i-1);
            }else{
                Exception ex = new Exception("failed");
                throw ex;
            }
        }
    }
}