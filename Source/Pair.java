
public class Pair
{
    private String partner1, partner2;

    /**
     * Constructor for objects of class Pair
     */
    public Pair(String p1, String p2)
    {
        partner1 = p1;
        partner2 = p2;
    }
    public String getP1(){
        return partner1;
    }
    public String getP2(){
        return partner2;
    }
    public boolean equals(Pair p)
    {
        return (partner1.equals(p.getP1()) || partner2.equals(p.getP2()) || partner1.equals(p.getP2()) || partner2.equals(p.getP1()));
    }
    public String toString(){
        return "[" + partner1 + ", " + partner2 + "]";
    }
}